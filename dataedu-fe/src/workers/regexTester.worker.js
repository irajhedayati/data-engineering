import { testRegex } from '../utils/regexTester.mjs'

self.onmessage = ({ data }) => {
  try {
    self.postMessage(testRegex(data.pattern, data.flags, data.text))
  } catch (error) {
    self.postMessage({ error: error.message })
  }
}
