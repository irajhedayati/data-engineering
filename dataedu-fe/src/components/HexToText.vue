<template>
  <form class="row g-3" @submit.prevent>
    <div class="col-md-6">
      <label class="form-label" for="hexInput">Hex code</label>
      <textarea
        id="hexInput"
        v-model="input"
        class="form-control font-monospace"
        :class="{ 'is-invalid': conversion.error }"
        :aria-invalid="Boolean(conversion.error)"
        aria-describedby="hexHelp hexError"
        placeholder="48 65 6c 6c 6f"
        rows="6"
        spellcheck="false"></textarea>
      <div id="hexHelp" class="form-text">
        Enter UTF-8 bytes as continuous hex or separated by spaces or newlines. Optional 0x prefixes are supported.
      </div>
      <div id="hexError" class="invalid-feedback" aria-live="polite">{{ conversion.error }}</div>
    </div>
    <div class="col-md-6">
      <label class="form-label" for="hexTextOutput">Decoded text</label>
      <textarea
        id="hexTextOutput"
        :value="conversion.text"
        class="form-control"
        placeholder="Decoded text appears here"
        rows="6"
        readonly></textarea>
    </div>
    <div class="col-12">
      <button type="button" class="btn btn-outline-secondary" :disabled="!input" @click="input = ''">Clear</button>
    </div>
  </form>
</template>

<script>
export default {
  name: 'HexToText',
  data () {
    return { input: '' }
  },
  computed: {
    conversion () {
      const input = this.input.trim()
      if (!input) return { text: '', error: '' }

      const chunks = input.split(/\s+/).map(chunk => chunk.replace(/^0x/i, ''))
      if (chunks.some(chunk => !/^[0-9a-f]+$/i.test(chunk))) {
        return { text: '', error: 'Use only hexadecimal digits (0–9 and A–F), with optional 0x prefixes and whitespace.' }
      }
      if (chunks.some(chunk => chunk.length % 2 !== 0)) {
        return { text: '', error: 'Each byte needs two hex digits. Check for an incomplete byte.' }
      }

      const hex = chunks.join('')
      const bytes = new Uint8Array(hex.length / 2)
      for (let i = 0; i < bytes.length; i++) {
        bytes[i] = parseInt(hex.slice(i * 2, i * 2 + 2), 16)
      }
      try {
        return { text: new TextDecoder('utf-8', { fatal: true }).decode(bytes), error: '' }
      } catch {
        return { text: '', error: 'These bytes are not valid UTF-8 text.' }
      }
    }
  }
}
</script>
