// Run in a worker: even a single RegExp.exec call can take unbounded time.
export function testRegex (pattern, flags, text, limit = 500) {
  const regex = new RegExp(pattern, flags)
  const matches = []
  let match
  while ((match = regex.exec(text)) !== null) {
    if (matches.length === limit) return { matches, truncated: true }
    matches.push({
      value: match[0],
      index: match.index,
      groups: Array.from(match).slice(1),
      namedGroups: match.groups ? { ...match.groups } : {}
    })
    if (!regex.global) break
    if (match[0] === '') {
      // Advance by a complete code point in Unicode mode, including surrogate pairs.
      const index = regex.lastIndex
      regex.lastIndex += (regex.unicode || regex.unicodeSets) && text.codePointAt(index) > 0xffff ? 2 : 1
    }
  }
  return { matches, truncated: false }
}
