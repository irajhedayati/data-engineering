<template>
  <div>
    <ul id="myTab" class="nav nav-tabs" role="tablist">
      <li v-for="(tab, i) in tabs" :key="i" class="nav-item" role="presentation">
        <button :id="tab.id" :aria-controls="tab.normalizedName" :aria-selected="tab.isActive"
                class="nav-link" :class="{ 'active': tab.isActive }" :data-bs-target="tab.href"
                data-bs-toggle="tab" role="tab" type="button" @click="selectTab(tab)">{{ tab.name }}
        </button>
      </li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'IrajTabs',
  data () {
    return { tabs: [] }
  },
  created () {

  },
  methods: {
    selectTab (selectedTab) {
      this.tabs.forEach(tab => {
        tab.isActive = (tab.name === selectedTab.name)
      })
    }
  }
}
</script>

<style scoped>

</style>
