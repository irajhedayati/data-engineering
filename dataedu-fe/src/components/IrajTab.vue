<template>
  <div v-show="isActive" :id="normalizedName" :aria-labelledby="id" class="tab-pane fade show active" role="tabpanel">
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: 'IrajTab',
  props: {
    name: { required: true },
    selected: { default: false }
  },
  data () {
    return {
      isActive: false
    }
  },
  computed: {
    href () {
      return '#' + this.normalizedName
    },
    id () {
      return this.normalizedName + '-tab'
    },
    normalizedName () {
      return this.name.toLowerCase().replace(/ /g, '-')
    }
  },
  mounted () {
    this.isActive = this.selected
  },
  created () {
    this.$parent.tabs.push(this)
  }
}
</script>

<style scoped>

</style>
