<template>
  <form>
    <div class="row">
      <label class="col-4 col-form-label" for="memoryOverheadFactor">
        <code>spark.driver.cores</code>
      </label>
      <div class="col-2">
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="cores" id="cores4" v-model="cores" value="4">
          <label class="form-check-label" for="cores4">4</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="cores" id="cores8" v-model="cores" value="8">
          <label class="form-check-label" for="cores8">8</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="cores" id="cores16" v-model="cores" value="16">
          <label class="form-check-label" for="cores16">16</label>
        </div>
      </div>
      <small id="cores" class="form-text text-muted">
        The number of cores (vCPUs) to allocate to the Spark driver.
      </small>
    </div>
    <div class="row">
      <div class="col-4">
        <div class="row-cols-1">
          <code>spark.driver.memory</code>: {{ formatBytes(memory * 1024 * 1024) }}
        </div>
        <div class="row-cols-1">
          <code>spark.driver.memoryOverhead</code>: {{ formatBytes(memory * 1024 * 1024 * 0.1) }}
        </div>
        <div class="row-cols-1">
          <strong>Total driver memory</strong> {{ formatBytes(memory * 1.1 * 1024 * 1024) }}
        </div>
      </div>
      <div class="col-1">{{ formatBytes(min * 1024 * 1024) }}</div>
      <div class="col-4">
        <label for="memory" class="form-label">Driver memory range</label>
        <input type="range" class="form-range" :min="min" :max="max" step="8" id="memory" v-model="memory">
      </div>
      <div class="col-1">{{ formatBytes(max * 1024 * 1024) }}</div>
      <small id="cores" class="form-text text-muted">
        Total driver memory per driver core, including driver memory overhead, which must be between 1024m and
        7424m for the Standard compute tier (24576m for the Premium compute tier).
        <code>spark.driver.memoryOverhead</code>
        10% of driver memory, except for PySpark batch workloads, which default to 40% of driver memory
      </small>
    </div>
  </form>
</template>
<script>
export default {
  data () {
    return {
      cores: 4,
      memory: 4 * 1024
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
    min () {
      return this.cores * 1024 / 1.1
    },
    max () {
      return this.cores * 7424 / 1.1
    }
  }
}
</script>
