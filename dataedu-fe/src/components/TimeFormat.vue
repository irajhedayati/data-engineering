<template>
  <div class="row mb3"><h2>Epoch</h2></div>
  <div class="row mb3">
    <div class="col-4">
      <div class="input-group mb-3">
        <span id="basic-addon1" class="input-group-text">Current epoch (ms)</span>
        <input v-model="currentTime" aria-label="input" class="form-control text-end" type="text">
        <button id="button-addon2" v-clipboard="currentTime" class="btn btn-outline-secondary" type="button">
          <i class="bi bi-copy"></i>
        </button>
      </div>
      <div class="input-group mb-3">
        <span id="basic-addon1" class="input-group-text">Current epoch (s)</span>
        <input v-model="currentTimeS" aria-label="input" class="form-control text-end" type="text">
        <button id="button-addon2" v-clipboard="currentTimeS" class="btn btn-outline-secondary" type="button">
          <i class="bi bi-copy"></i>
        </button>
      </div>
    </div>
    <div class="col-5">
      <div class="input-group mb-3">
        <span id="basic-addon1" class="input-group-text">ISO 8601 UTC</span>
        <input v-model="currentIso" aria-label="input" class="form-control" type="text">
        <button id="button-addon2" v-clipboard="currentIso" class="btn btn-outline-secondary" type="button">
          <i class="bi bi-copy"></i>
        </button>
      </div>
      <div class="input-group mb-3">
        <span id="basic-addon1" class="input-group-text">Locale ({{ locale }})</span>
        <input v-model="currentLocal" aria-label="input" class="form-control" type="text">
        <button id="button-addon2" v-clipboard="currentLocal" class="btn btn-outline-secondary" type="button">
          <i class="bi bi-copy"></i>
        </button>
      </div>
      <div class="input-group mb-3">
        <span id="basic-addon1" class="input-group-text">RFC 7231 UTC</span>
        <input v-model="currentRFC" aria-label="input" class="form-control" type="text">
        <button id="button-addon2" v-clipboard="currentRFC" class="btn btn-outline-secondary" type="button">
          <i class="bi bi-copy"></i>
        </button>
      </div>
    </div>
  </div>
  <div class="row mb3"><h2>Date</h2></div>
  <div class="row mb3">
    <div class="col-6">
      <div class="row mb3">
        <div class="input-group mb-3">
          <span id="basic-addon1" class="input-group-text">Input</span>
          <input v-model="input"
                 aria-label="input"
                 class="form-control"
                 type="text"
                 placeholder="Date time value to parse">
          <button id="button-addon2" class="btn btn-outline-secondary" type="button" @click="convert">
            <i class="bi bi-arrow-bar-right"></i>
          </button>
        </div>
      </div>
      <div class="row mb3">
        <div class="input-group mb-3">
          <span id="basic-addon1" class="input-group-text">Format</span>
          <input :value="format.join('')"
                 aria-label="uuid-v4"
                 class="form-control"
                 disabled
                 type="text"
                 placeholder="Use the right side to build format">
          <button id="button-addon2" class="btn btn-outline-secondary" type="button" @click="handleFormatClear">
            <i class="bi bi-eraser"></i>
          </button>
        </div>
      </div>
      <div class="row mb3">
        <div class="input-group mb-3">
          <span id="basic-addon1" class="input-group-text">Epoch seconds</span>
          <input :value="epochSeconds" aria-label="uuid-v4" class="form-control" disabled type="text">
          <button id="button-addon2" v-clipboard="epochSeconds" class="btn btn-outline-secondary" type="button">
            <i class="bi bi-copy"></i>
          </button>
        </div>
      </div>
    </div>
    <div class="col-6">
      <div class="row mb3"><h3>Format builder</h3></div>
      <hr />
      <div class="row mb3"><h3>Delimiter</h3></div>
      <div class="row mb3">
        <div class="col-1">
          <button id="del-hyphen" type="button" class="btn btn-outline-secondary" @click="() => this.format.push('-')">
            -
          </button></div>
        <div class="col-1">
          <button id="del-under" type="button" class="btn btn-outline-secondary" @click="() => this.format.push('_')">
            _
          </button></div>
        <div class="col-1">
          <button id="del-colon" type="button" class="btn btn-outline-secondary" @click="() => this.format.push(':')">
            :
          </button></div>
      </div>
      <hr />
      <div class="row mb3"><h3>Date components</h3></div>
      <div class="row mb3">
        <div class="col mb-3">
          <div class="form-check">
            <input class="form-check-input"
                   type="checkbox"
                   value=""
                   id="checkYear"
                   v-model="yearIsChecked"
                   :disabled="yearIsChecked"
                   @change="handleYear">
            <label class="form-check-label" for="checkYear">Year</label>
          </div>
        </div>
      </div>
      <div class="row mb3">
        <div class="col mb-3">
          <div class="form-check">
            <input class="form-check-input"
                   type="checkbox"
                   value=""
                   id="checkMonth"
                   v-model="monthIsChecked"
                   :disabled="monthIsChecked"
                   @change="handleMonth">
            <label class="form-check-label" for="checkMonth">Month</label>
          </div>
        </div>
      </div>
      <div class="row mb3">
        <div class="col mb-3">
          <div class="form-check">
            <input class="form-check-input"
                   type="checkbox"
                   value=""
                   id="checkDay"
                   v-model="dayIsChecked"
                   :disabled="dayIsChecked"
                   @change="handleDay">
            <label class="form-check-label" for="checkDay">Day</label>
          </div>
        </div>
      </div>
      <div class="row mb3">
        <div class="col mb-3">
          <div class="form-check">
            <input class="form-check-input"
                   type="checkbox"
                   value=""
                   id="checkHour"
                   v-model="hourIsChecked"
                   :disabled="hourIsChecked"
                   @change="handleHour">
            <label class="form-check-label" for="checkHour">Hour</label>
          </div>
        </div>
      </div>
      <div class="row mb3">
        <div class="col mb-3">
          <div class="form-check">
            <input class="form-check-input"
                   type="checkbox"
                   value=""
                   id="checkMinute"
                   v-model="minuteIsChecked"
                   :disabled="minuteIsChecked"
                   @change="handleMinute">
            <label class="form-check-label" for="checkMinute">Minute</label>
          </div>
        </div>
      </div>
      <div class="row mb3">
        <div class="col mb-3">
          <div class="form-check">
            <input class="form-check-input"
                   type="checkbox"
                   value=""
                   id="checkSecond"
                   v-model="secondIsChecked"
                   :disabled="secondIsChecked"
                   @change="handleSecond">
            <label class="form-check-label" for="checkSecond">Second</label>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import moment from 'moment'

export default {
  data () {
    return {
      input: '',
      format: [],
      yearIsChecked: false,
      monthIsChecked: false,
      dayIsChecked: false,
      hourIsChecked: false,
      minuteIsChecked: false,
      secondIsChecked: false,
      epochSeconds: 0,
      currentTime: Date.now(),
      currentTimeS: Math.floor(Date.now() / 1000),
      currentIso: new Date().toISOString(),
      currentLocal: new Date().toLocaleString(),
      currentRFC: new Date().toUTCString(),
      locale: this.getLang()
    }
  },
  created () {
    setInterval(this.getNow, 5000)
  },
  methods: {
    getNow () {
      this.currentTime = Date.now()
      this.currentTimeS = Math.floor(this.currentTime / 1000)
      this.currentIso = new Date().toISOString()
      this.currentLocal = new Date().toLocaleString()
      this.currentRFC = new Date().toUTCString()
    },
    handleFormatClear () {
      this.format = []
      this.yearIsChecked = false
      this.monthIsChecked = false
      this.dayIsChecked = false
      this.hourIsChecked = false
      this.minuteIsChecked = false
      this.secondIsChecked = false
    },
    handleYear () {
      if (this.yearIsChecked) this.format.push('YYYY')
    },
    handleMonth () {
      if (this.monthIsChecked) this.format.push('MM')
    },
    handleDay () {
      if (this.dayIsChecked) this.format.push('DD')
    },
    handleHour () {
      if (this.hourIsChecked) this.format.push('HH')
    },
    handleMinute () {
      if (this.minuteIsChecked) this.format.push('mm')
    },
    handleSecond () {
      if (this.secondIsChecked) this.format.push('ss')
    },
    convert () {
      this.epochSeconds = moment(this.input, this.format.join('')).unix()
    },
    getLang () {
      return (navigator.languages !== undefined) ? navigator.languages[0] : navigator.language
    }
  }
}
</script>
