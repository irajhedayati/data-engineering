<template>
  <banner caption="A set of useful tools" title="General Tools"/>
  <section class="wrapper">
    <div class="inner">
      <div class="container">
        <div class="row mb-4">
          <h1>Calculate the number of partitions for a Kafka topic</h1>
        </div>
        <div class="row mb-4">
          <form>
            <div class="row mb-3">
              <label class="col-sm-2 col-form-label" for="rate">Input rate</label>
              <div class="col-sm-2">
                <input id="rate" v-model="rate" class="form-control" name="rate" type="number">
              </div>
              <div class="col-sm-2">
                <select id="unit" v-model="unit" class="form-select" name="unit">
                  <option value="1">per second</option>
                  <option value="60">per minute</option>
                  <option value="3600">per hour</option>
                  <option value="86400">per day</option>
                </select>
              </div>
              <label class="col-sm-2 col-form-label" for="rate">Message size (KB)</label>
              <div class="col-sm-2">
                <input id="rate" v-model="messageSizeKB" class="form-control" name="rate" type="number">
              </div>
            </div>
            <div class="row mb-3">
              <label class="col-sm-4 col-form-label" for="partitions">The estimated number of partitions</label>
              <div class="col-sm-6">
                <input id="partitions" v-model="noPartitions" class="form-control" name="partitions" readonly
                       type="number">
              </div>
            </div>
          </form>
        </div>
        <hr />
        <div class="row mb-4">
          <h1>Spark</h1>
          <h2>Calculate Spark executor memory</h2>
          <spark-executor-memory />
          <h2>Dataproc Serverless</h2>
          <dataproc-serverless />
        </div>
        <hr>
        <div class="row mb-4">
          <h1>Naming conversion from one casing to another</h1>
        </div>
        <div class="row mb-4"><casing-conversion /></div>
        <hr />
        <div class="row mb-4">
          <h1>UUID</h1>
        </div>
        <div class="row mb-4"><uuid-generator /></div>
        <hr />
        <div class="row mb-4">
          <h1>Time</h1>
          <time-format />
        </div>
        <hr />
        <div class="row mb-4">
          <h1>WinSCP Password Decoder</h1>
          <win-scp-decoder />
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import Banner from '@/components/Banner.vue'
import CasingConversion from '@/components/CasingConversion.vue'
import UuidGenerator from '@/components/UuidGenerator.vue'
import TimeFormat from '@/components/TimeFormat.vue'
import SparkExecutorMemory from '@/components/SparkExecutorMemory.vue'
import DataprocServerless from '@/components/DataprocServerless.vue'
import WinScpDecoder from '@/components/WinSCPDecoder.vue'

export default {
  data () {
    return {
      unit: 1,
      rate: 0,
      messageSizeKB: 1
    }
  },
  computed: {
    noPartitions () {
      return Math.ceil(this.rate * this.unit * this.messageSizeKB / 1024)
    }
  },
  components: { WinScpDecoder, DataprocServerless, SparkExecutorMemory, TimeFormat, UuidGenerator, CasingConversion, Banner }
}
</script>
