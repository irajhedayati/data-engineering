<template>
  <form>
    <div class="row">
      <label class="col-4 col-form-label" for="memory">
        <code>spark.executor.memory</code>
      </label>
      <div class="col-2">
        <div class="input-group">
          <input id="memory"
                 v-model="sparkExecutorMemory"
                 class="form-control"
                 name="memory"
                 type="number">
          <div class="input-group-append">
            <div class="input-group-text">MB</div>
          </div>
        </div>
      </div>
      <small id="memoryHelp" class="form-text text-muted">Amount of memory to use per executor process.</small>
    </div>
    <div class="row">
      <label class="col-4 col-form-label" for="memoryOverheadFactor">
        <code>spark.executor.memoryOverheadFactor</code>
      </label>
      <div class="col-2">
        <div class="input-group">
          <input id="memoryOverheadFactor"
                 v-model="memoryOverheadFactor"
                 class="form-control"
                 name="memoryOverheadFactor"
                 type="number">
          <div class="input-group-append">
            <div class="input-group-text">% {{ this.memoryOverheadFactor * 100}}</div>
          </div>
        </div>
      </div>
      <small id="memoryOverheadFactorHelp" class="form-text text-muted">
        Fraction of executor memory to be allocated as additional non-heap memory per executor process.
        This is memory that accounts for things like VM overheads, interned strings, other native overheads, etc.
        This value is ignored if spark.executor.memoryOverhead is set directly.
      </small>
    </div>
    <div class="row">
      <label class="col-4 col-form-label" for="memoryOverhead">
        <code>spark.executor.memoryOverhead</code>
      </label>
      <div class="col-2">
        <div class="input-group">
          <input id="memoryOverhead" :value="memoryOverhead" class="form-control" name="memoryOverhead">
          <div class="input-group-append"><div class="input-group-text">MB</div></div>
        </div>
      </div>
      <small id="memoryOverheadHelp" class="form-text text-muted">
        Amount of additional memory to be allocated per executor process, in MiB unless otherwise specified.
        This is memory that accounts for things like VM overheads, interned strings, other native overheads, etc.
      </small>
    </div>
  </form>
</template>

<script>
export default {
  name: 'SparkExecutorMemory',
  data () {
    return {
      memoryOverheadFactor: 0.1,
      sparkExecutorMemory: 0
    }
  },
  methods: {
    formatBytes (bytes, decimals = 2) {
      if (!+bytes) return '0 Bytes'

      const k = 1024
      const dm = decimals < 0 ? 0 : decimals
      const sizes = ['Bytes', 'KiB', 'MiB', 'GiB', 'TiB', 'PiB', 'EiB', 'ZiB', 'YiB']

      const i = Math.floor(Math.log(bytes) / Math.log(k))

      return `${parseFloat((bytes / Math.pow(k, i)).toFixed(dm))} ${sizes[i]}`
    }
  },
  computed: {
    memoryOverhead: function () {
      return Math.max(384, this.sparkExecutorMemory * this.memoryOverheadFactor)
    },
    memoryOverheadBytes: function () {
      return this.formatBytes(this.memoryOverhead)
    }
  }
}
</script>
