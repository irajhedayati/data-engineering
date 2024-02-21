<template>
  <!--  v1-->
<!--  <div class="row mb3">-->
<!--    <div class="col-6">-->
<!--      <div class="input-group mb-3">-->
<!--        <span id="basic-addon1" class="input-group-text">UUID v1 (timestamp)</span>-->
<!--        <input :value="v1" aria-label="uuid-v1" class="form-control" disabled type="text">-->
<!--        <button id="button-addon2" class="btn btn-outline-secondary" type="button" @click="refreshUuidV1()">-->
<!--          <i class="bi bi-arrow-clockwise"></i>-->
<!--        </button>-->
<!--        <button id="button-addon2" v-clipboard="v1" class="btn btn-outline-secondary" type="button">-->
<!--          <i class="bi bi-copy"></i>-->
<!--        </button>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
  <!--  v3-->
<!--  <div class="row mb3">-->
<!--    <div class="col-6">-->
<!--      <div class="input-group mb-3">-->
<!--        <span id="basic-addon1" class="input-group-text">UUID v3 (namespace w/ MD5) </span>-->
<!--        <input :value="v3" aria-label="uuid-v3" class="form-control" disabled type="text">-->
<!--        <button id="button-addon2" class="btn btn-outline-secondary" type="button" @click="refreshUuidV3()">-->
<!--          <i class="bi bi-arrow-clockwise"></i>-->
<!--        </button>-->
<!--        <button id="button-addon2" v-clipboard="v3" class="btn btn-outline-secondary" type="button">-->
<!--          <i class="bi bi-copy"></i>-->
<!--        </button>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
  <!--  v4-->
  <div class="row mb3">
    <div class="col-6">
      <div class="input-group mb-3">
        <span id="basic-addon1" class="input-group-text">UUID v4 (random)</span>
        <input :value="v4" aria-label="uuid-v4" class="form-control" disabled type="text">
        <button id="button-addon2" class="btn btn-outline-secondary" type="button" @click="refreshUuidV4()">
          <i class="bi bi-arrow-clockwise"></i>
        </button>
        <button id="button-addon2" v-clipboard="v4" class="btn btn-outline-secondary" type="button">
          <i class="bi bi-copy"></i>
        </button>
      </div>
    </div>
  </div>
  <!--  v5-->
<!--  <div class="row mb3">-->
<!--    <div class="col-6">-->
<!--      <div class="input-group mb-3">-->
<!--        <span id="basic-addon1" class="input-group-text">UUID v5 (namespace w/ SHA-1) </span>-->
<!--        <input :value="v5"-->
<!--               aria-label="uuid-v4"-->
<!--               class="form-control"-->
<!--               disabled-->
<!--               type="text">-->
<!--        <button id="button-addon2" class="btn btn-outline-secondary" type="button" @click="refreshUuidV5()">-->
<!--          <i class="bi bi-arrow-clockwise"></i>-->
<!--        </button>-->
<!--        <button id="button-addon2" v-clipboard="v5" class="btn btn-outline-secondary" type="button">-->
<!--          <i class="bi bi-copy"></i>-->
<!--        </button>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
</template>

<script>
import { v1 as uuidV1, v3 as uuidV3, v4 as uuidV4, v5 as uuidV5 } from 'uuid'

export default {
  data () {
    return {
      v1: '',
      v3: '',
      v4: '',
      v5: ''
    }
  },
  methods: {
    refreshUuidV1 () {
      this.v1 = uuidV1()
    },
    refreshUuidV3 () {
      this.v3 = uuidV3()
    },
    refreshUuidV4 () {
      this.v4 = uuidV4()
    },
    refreshUuidV5 () {
      this.v5 = uuidV5()
    }
  },
  mounted () {
    // this.refreshUuidV1()
    // this.refreshUuidV3()
    this.refreshUuidV4()
    // this.refreshUuidV5()
  }
}
</script>
