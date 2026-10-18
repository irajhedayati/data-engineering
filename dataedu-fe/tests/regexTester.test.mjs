import test from 'node:test'
import assert from 'node:assert/strict'
import { testRegex } from '@/utils/regexTester.mjs'

test('global matching preserves offsets and optional named captures', () => {
  const { matches } = testRegex('(?<word>[a-z]+)([0-9]+)?', 'g', 'abc12 def')
  assert.deepEqual(matches.map(m => [m.index, m.value]), [[0, 'abc12'], [6, 'def']])
  assert.deepEqual(matches[1].groups, ['def', undefined])
  assert.deepEqual(matches[0].namedGroups, { word: 'abc' })
})
test('non-global matching returns only the first match', () => {
  assert.equal(testRegex('a', '', 'aaa').matches.length, 1)
})
test('zero-length Unicode matches advance over entire surrogate pairs', () => {
  assert.deepEqual(testRegex('(?:)', 'gu', '😀x').matches.map(m => m.index), [0, 2, 3])
})
test('sticky matching stops at the first gap', () => {
  assert.deepEqual(testRegex('a', 'gy', 'aa a').matches.map(m => m.index), [0, 1])
})
test('case, multiline, and dot-all flags work', () => {
  assert.equal(testRegex('^a.b$', 'ims', 'X\nA\nb\nY').matches[0].value, 'A\nb')
})
test('invalid patterns produce an error and no-match results stay empty', () => {
  assert.throws(() => testRegex('[', '', ''), SyntaxError)
  assert.deepEqual(testRegex('z', 'g', 'abc').matches, [])
})
test('results are capped only when an extra match exists', () => {
  assert.equal(testRegex('a', 'g', 'aa', 2).truncated, false)
  assert.equal(testRegex('a', 'g', 'aaa', 2).truncated, true)
  assert.equal(testRegex('a', 'g', 'aaa', 2).matches.length, 2)
})
