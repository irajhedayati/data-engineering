<template>
  <div class="alert alert-info" role="alert">
    How to get information:
    <ul>
      <li>Open your windows registry (you can do this by hitting <code>Win + R</code> and entering regedit)</li>
      <li>Navigate to <code>[HKEY_CURRENT_USER\Software\Martin Prikryl\WinSCP 2\Sessions]</code> to get the hostname,
        username and encrypted password</li>
    </ul>
  </div>
  <div class="alert alert-primary" role="alert">
    Disclaimer: the code is a translation from https://github.com/anoopengineer/winscppasswd
  </div>
  <form>
    <input type="text" class="form-control" placeholder="Encoded Password" v-model="encodedPassword">
    <input type="text" class="form-control" placeholder="Host" aria-label="Host" v-model="host">
    <input type="text" class="form-control" placeholder="Username" aria-label="Username" v-model="userName">
    <input type="text" class="form-control" placeholder="Decoded Password" :value="decodedPassword">
  </form>
</template>
<script>
const PW_MAGIC = 0xA3
const PW_FLAG = 0xFF

export default {
  name: 'WinScpDecoder',
  data () {
    return {
      encodedPassword: null,
      host: null,
      userName: null
    }
  },
  computed: {
    decodedPassword () {
      if (!this.encodedPassword) {
        return null
      }
      const key = this.userName + this.host
      let passBytes = []
      for (let i = 0; i < this.encodedPassword.length; i++) {
        const val = parseInt(this.encodedPassword[i], 16)
        passBytes.push(val)
      }

      let [flag, remainingBytes] = this.decNextChar(passBytes)
      passBytes = remainingBytes

      let length = 0
      if (flag === PW_FLAG) {
        [, remainingBytes] = this.decNextChar(passBytes)
        passBytes = remainingBytes;
        [length, remainingBytes] = this.decNextChar(passBytes)
        passBytes = remainingBytes
      } else {
        length = flag
      }

      const [toBeDeleted, remainingBytes2] = this.decNextChar(passBytes)
      passBytes = remainingBytes2
      passBytes = passBytes.slice(toBeDeleted * 2)

      let clearPass = ''
      for (let i = 0; i < length; i++) {
        const [val, remainingBytes3] = this.decNextChar(passBytes)
        passBytes = remainingBytes3
        clearPass += String.fromCharCode(val)
      }

      if (flag === PW_FLAG) {
        clearPass = clearPass.substring(key.length)
      }
      return clearPass
    }
  },
  methods: {
    decrypt () {
      const key = this.userName + this.host
      let passBytes = []
      for (let i = 0; i < this.encodedPassword.length; i++) {
        const val = parseInt(this.encodedPassword[i], 16)
        passBytes.push(val)
      }

      let [flag, remainingBytes] = this.decNextChar(passBytes)
      passBytes = remainingBytes

      let length = 0
      if (flag === PW_FLAG) {
        [, remainingBytes] = this.decNextChar(passBytes)
        passBytes = remainingBytes;
        [length, remainingBytes] = this.decNextChar(passBytes)
        passBytes = remainingBytes
      } else {
        length = flag
      }

      const [toBeDeleted, remainingBytes2] = this.decNextChar(passBytes)
      passBytes = remainingBytes2
      passBytes = passBytes.slice(toBeDeleted * 2)

      let clearPass = ''
      for (let i = 0; i < length; i++) {
        const [val, remainingBytes3] = this.decNextChar(passBytes)
        passBytes = remainingBytes3
        clearPass += String.fromCharCode(val)
      }

      if (flag === PW_FLAG) {
        clearPass = clearPass.substring(key.length)
      }
      return clearPass
    },
    decNextChar (passBytes) {
      if (passBytes.length <= 0) {
        return [0, passBytes]
      }
      const a = passBytes[0]
      const b = passBytes[1]
      const remainingBytes = passBytes.slice(2)
      // Bitwise operations in JavaScript are performed on 32-bit integers.
      // To emulate the 8-bit behavior of Go's byte type, we use & 0xff.
      const result = (~(((a << 4) + b) ^ PW_MAGIC)) & 0xff
      return [result, remainingBytes]
    }
  }
}
</script>
