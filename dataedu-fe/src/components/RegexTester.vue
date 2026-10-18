<template>
  <div class="regex-tester">
    <div class="d-flex flex-wrap align-items-center justify-content-between gap-2 mb-3">
      <span class="badge text-bg-light border">JavaScript RegExp</span>
      <span class="small text-muted">Runs locally in your browser</span>
    </div>
    <label class="form-label" for="regex-pattern">Regular expression</label>
    <div class="input-group mb-2">
      <span class="input-group-text font-monospace" aria-hidden="true">/</span>
      <input id="regex-pattern" v-model="pattern" class="form-control font-monospace" spellcheck="false" autocomplete="off" :aria-invalid="Boolean(error)" aria-describedby="regex-help regex-status" placeholder="Enter a pattern" />
      <span class="input-group-text font-monospace" aria-hidden="true">/{{ flags }}</span>
    </div>
    <p id="regex-help" class="small text-muted">Enter the pattern without surrounding slashes. Match positions are zero-based UTF-16 offsets.</p>
    <fieldset class="mb-3">
      <legend class="form-label fs-6">Flags</legend>
      <div class="d-flex flex-wrap gap-3">
        <label v-for="flag in flagOptions" :key="flag.value" class="flag-option" :title="flag.description">
          <input v-model="selectedFlags" type="checkbox" :value="flag.value" class="form-check-input" />
          <span><code>{{ flag.value }}</code> {{ flag.label }}</span>
        </label>
      </div>
    </fieldset>
    <div class="d-flex flex-wrap align-items-center justify-content-between gap-2 mb-2">
      <label class="form-label mb-0" for="regex-text">Test text</label>
      <button class="btn btn-sm btn-outline-secondary" type="button" @click="loadExample">Load example</button>
    </div>
    <textarea id="regex-text" v-model="text" class="form-control font-monospace" rows="6" spellcheck="false" placeholder="Paste text to test against your expression"></textarea>
    <p id="regex-status" class="mt-3 mb-3" :class="error ? 'text-danger' : 'text-muted'" role="status" aria-live="polite">{{ status }}</p>
    <template v-if="!error && !busy && pattern">
      <div class="d-flex align-items-center justify-content-between gap-2 mb-2">
        <h4 class="h6 mb-0">Match preview</h4>
        <span class="small text-muted">Highlighted matches · │ empty match</span>
      </div>
      <pre class="match-preview" aria-label="Text with highlighted matches"><template v-for="(part, index) in preview" :key="index"><mark v-if="part.matched" :class="{ 'empty-match': !part.value }" :title="`Match at position ${part.index}`">{{ part.value || '│' }}</mark><template v-else>{{ part.value }}</template></template></pre>
      <details v-if="matches.length" class="match-details" open>
        <summary class="fw-semibold">Match details &amp; capture groups</summary>
        <ol class="match-list">
          <li v-for="(match, index) in matches" :key="index">
            <div class="d-flex flex-wrap gap-2 align-items-baseline"><strong class="small">Match {{ index + 1 }}</strong><span class="small text-muted">Position {{ match.index }}–{{ match.index + match.value.length }}</span></div>
            <code class="match-value">{{ displayValue(match.value) }}</code>
            <dl v-if="match.groups.length" class="capture-list">
              <template v-for="(group, groupIndex) in match.groups" :key="groupIndex"><dt>Group {{ groupIndex + 1 }}</dt><dd><code>{{ displayValue(group) }}</code></dd></template>
              <template v-for="(group, name) in match.namedGroups" :key="name"><dt>{{ name }}</dt><dd><code>{{ displayValue(group) }}</code></dd></template>
            </dl>
          </li>
        </ol>
      </details>
    </template>
  </div>
</template>

<script setup>
import { computed, onBeforeUnmount, ref, watch } from 'vue'

const examplePattern = String.raw`(?<name>[A-Za-z]+):\s*(\d+)`
const exampleText = 'Apples: 12\nOranges: 8\nPears: 24'
const pattern = ref(examplePattern)
const text = ref(exampleText)
const selectedFlags = ref(['g'])
const flagOptions = [
  { value: 'g', label: 'Global', description: 'Find all matches' },
  { value: 'i', label: 'Ignore case', description: 'Match without case sensitivity' },
  { value: 'm', label: 'Multiline', description: 'Let ^ and $ match line boundaries' },
  { value: 's', label: 'Dot all', description: 'Let . match line breaks' },
  { value: 'u', label: 'Unicode', description: 'Treat Unicode code points as characters' },
  { value: 'y', label: 'Sticky', description: 'Match only at the current position, starting at zero' }
]
const flags = computed(() => flagOptions.filter(flag => selectedFlags.value.includes(flag.value)).map(flag => flag.value).join(''))
const matches = ref([])
const error = ref('')
const busy = ref(false)
const truncated = ref(false)
let worker
let debounce
let deadline
let generation = 0

function stop () {
  clearTimeout(debounce)
  clearTimeout(deadline)
  worker?.terminate()
  worker = undefined
}

watch([pattern, flags, text], () => {
  stop()
  const current = ++generation
  matches.value = []
  error.value = ''
  truncated.value = false
  busy.value = false
  if (!pattern.value) return
  if (text.value.length > 100000 || pattern.value.length > 10000) {
    error.value = 'Use up to 100,000 characters of test text and a pattern up to 10,000 characters.'
    return
  }
  busy.value = true
  debounce = setTimeout(() => {
    try {
      worker = new Worker(new URL('../workers/regexTester.worker.js', import.meta.url))
      worker.onmessage = ({ data }) => {
        if (current !== generation) return
        stop()
        busy.value = false
        error.value = data.error || ''
        matches.value = data.matches || []
        truncated.value = Boolean(data.truncated)
      }
      worker.onerror = () => {
        if (current !== generation) return
        stop()
        busy.value = false
        error.value = 'The tester could not run. Try again or reload the page.'
      }
      deadline = setTimeout(() => {
        if (current !== generation) return
        stop()
        busy.value = false
        error.value = 'This expression took too long. Simplify the pattern or shorten the test text.'
      }, 1500)
      worker.postMessage({ pattern: pattern.value, flags: flags.value, text: text.value })
    } catch {
      stop()
      busy.value = false
      error.value = 'The tester could not start. Your browser must support Web Workers.'
    }
  }, 200)
}, { immediate: true })

onBeforeUnmount(() => { generation++; stop() })
const status = computed(() => {
  if (error.value) return error.value
  if (!pattern.value) return 'Enter a regular expression to get started.'
  if (busy.value) return 'Testing expression…'
  if (truncated.value) return 'Showing the first 500 matches. Narrow the pattern to see fewer results.'
  if (!matches.value.length) return 'No matches found.'
  return `${matches.value.length} match${matches.value.length === 1 ? '' : 'es'} found${flags.value.includes('g') ? '.' : ' · Enable Global to find all matches.'}`
})
const preview = computed(() => {
  const parts = []
  let cursor = 0
  for (const match of matches.value) {
    if (match.index > cursor) parts.push({ value: text.value.slice(cursor, match.index) })
    parts.push({ value: match.value, matched: true, index: match.index })
    cursor = match.index + match.value.length
  }
  parts.push({ value: text.value.slice(cursor) })
  return parts
})
function displayValue (value) { return value === undefined ? '(not matched)' : value === '' ? '(empty match)' : value }
function loadExample () { pattern.value = examplePattern; text.value = exampleText; selectedFlags.value = ['g'] }
</script>

<style scoped>
.flag-option { display: inline-flex; align-items: center; gap: .45rem; font-size: .85rem; cursor: pointer; }
.flag-option input { margin-top: 0; }
.match-preview { white-space: pre-wrap; overflow-wrap: anywhere; max-height: 24rem; overflow: auto; padding: 1rem; background: #f7f7f4; border: 1px solid var(--bs-border-color); border-radius: .75rem; min-height: 5rem; }
.match-preview mark { background: #dde8c9; color: #24351b; padding: 0; outline: 1px solid #b5c99a; }
.match-preview .empty-match { background: #f6dfae; color: #6c4600; }
.match-details { border-top: 1px solid var(--bs-border-color); padding-top: 1rem; }
.match-details summary { cursor: pointer; }
.match-list { list-style: none; padding: 0; margin: .75rem 0 0; max-height: 24rem; overflow: auto; }
.match-list > li { padding: .75rem 0; border-bottom: 1px solid var(--bs-border-color); }
.match-value, .capture-list code { white-space: pre-wrap; overflow-wrap: anywhere; color: #3e4935; }
.capture-list { display: grid; grid-template-columns: minmax(4rem, auto) minmax(0, 1fr); gap: .2rem 1rem; font-size: .8rem; margin: .5rem 0 0; }
.capture-list dt { overflow-wrap: anywhere; }
.capture-list dd { margin: 0; }
</style>
