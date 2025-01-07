<template>
  <!--  v4-->
  <div class="row-cols-1 mb3">
    <div class="input-group mb-3">
      <span id="basic-addon1" class="input-group-text">UUID v4 (random)</span>
      <input :value="v4Value" aria-label="uuid-v4" class="form-control" disabled type="text">
      <button id="button-addon2" class="btn btn-outline-secondary" type="button" @click="refreshUuidV4()">
        <i class="bi bi-arrow-clockwise"></i>
      </button>
      <button id="button-addon2" v-clipboard="v4Value" class="btn btn-outline-secondary" type="button">
        <i class="bi bi-copy"></i>
      </button>
    </div>
  </div>
  <!--  KSUID -->
  <div class="row-cols-1 mb3">
    <div class="input-group mb-3 has-validation">
      <span id="basic-addon1" class="input-group-text">KSUID w/ random payload</span>
      <span id="basic-addon1" class="input-group-text"><i class="bi bi-at" /></span>
      <button id="button-addon2" class="btn btn-outline-secondary" type="button" @click="setTimeToNow()">
        Now
      </button>
      <input v-model="dateTimeStr" aria-label="uuid-v4" class="form-control" :class="dateTimeStrIsValid" type="text" required>
      <input :value="ksuidValue" aria-label="ksuid" class="form-control" disabled type="text">
      <button id="button-addon2" v-clipboard="ksuidValue" class="btn btn-outline-secondary" type="button" >
        <i class="bi bi-copy" />
      </button>
      <div class="invalid-feedback">Invalid date-time; use ISO format e.g. 2025-01-07T18:43:31.144Z</div>
    </div>
  </div>
</template>

<script>
import { v4 as uuidV4 } from 'uuid'
// import KSUID from 'ksuid'
import { generate } from 'xksuid'

export default {
  data () {
    return {
      v4Value: '',
      dateTimeStr: new Date().toISOString()
    }
  },
  computed: {
    dateTime () {
      return new Date(this.dateTimeStr)
    },
    ksuidValue () {
      return generate(false, this.dateTime.getTime())
    },
    dateTimeStrIsValid () {
      return isNaN(Date.parse(this.dateTimeStr)) ? 'is-invalid' : ''
    }
  },
  methods: {
    refreshUuidV4 () {
      this.v4Value = uuidV4()
    },
    setTimeToNow () {
      this.dateTimeStr = new Date().toISOString()
    }
  },
  mounted () {
    this.refreshUuidV4()
    this.setTimeToNow()
    this.refreshUuidV4()
  }
}
</script>
