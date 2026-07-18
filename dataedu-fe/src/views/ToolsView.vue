<template>
  <Banner caption="A set of useful tools" title="General Tools" />

  <section class="wrapper tools-wrapper">
    <div class="inner">
      <div class="container">
        <div class="row align-items-end g-3 mb-4 tools-heading">
          <div class="col-lg-7">
            <h2 class="mb-2">Data Engineering Tools</h2>
            <p class="text-muted mb-0">Kafka, Spark, naming, identifiers, time, and password helpers in one place.</p>
          </div>
          <div class="col-lg-5">
            <label class="form-label visually-hidden" for="toolSearch">Search tools</label>
            <div class="input-group">
              <span class="input-group-text"><i class="bi bi-search" aria-hidden="true"></i></span>
              <input
                id="toolSearch"
                v-model.trim="searchQuery"
                class="form-control"
                placeholder="Search tools"
                type="search"
                aria-label="Search tools">
            </div>
          </div>
        </div>

        <div class="row g-2 mb-4" aria-label="Tool categories">
          <div v-for="category in categories" :key="category.id" class="col-auto">
            <button
              type="button"
              class="btn category-button"
              :class="selectedCategory === category.id ? 'btn-primary' : 'btn-outline-primary'"
              @click="selectCategory(category.id)">
              <i :class="category.icon" aria-hidden="true"></i>
              <span>{{ category.label }}</span>
              <span class="badge rounded-pill" :class="selectedCategory === category.id ? 'text-bg-light' : 'text-bg-primary'">
                {{ categoryCount(category.id) }}
              </span>
            </button>
          </div>
        </div>

        <div class="row g-4">
          <aside class="col-lg-3">
            <nav class="list-group tools-nav" aria-label="Tools navigation">
              <button
                v-for="tool in filteredTools"
                :key="tool.id"
                type="button"
                class="list-group-item list-group-item-action d-flex align-items-center gap-2"
                :class="{ active: activeTool === tool.id }"
                @click="openTool(tool.id)">
                <i :class="tool.icon" aria-hidden="true"></i>
                <span>{{ tool.title }}</span>
              </button>
            </nav>
          </aside>

          <div class="col-lg-9">
            <section class="row g-3 mb-4" aria-label="Tool directory">
              <div v-for="tool in filteredTools" :key="tool.id" class="col-md-6 col-xl-4">
                <button
                  type="button"
                  class="tool-card"
                  :class="{ active: activeTool === tool.id }"
                  @click="openTool(tool.id)">
                  <span class="tool-card-icon"><i :class="tool.icon" aria-hidden="true"></i></span>
                  <span class="tool-card-copy">
                    <strong>{{ tool.title }}</strong>
                    <small>{{ tool.summary }}</small>
                  </span>
                </button>
              </div>
            </section>

            <div v-if="filteredTools.length === 0" class="empty-state mb-4" role="status">
              <i class="bi bi-search" aria-hidden="true"></i>
              <h3>No tools found</h3>
              <p class="text-muted">Try another search or category.</p>
              <button type="button" class="btn btn-primary" @click="clearFilters">Clear filters</button>
            </div>

            <article
              v-if="isToolVisible('kafka-partitions')"
              id="kafka-partitions"
              class="tool-section"
              tabindex="-1">
              <div class="card">
                <div class="card-header bg-white">
                  <div class="d-flex align-items-start gap-3">
                    <span class="section-icon"><i class="bi bi-diagram-3" aria-hidden="true"></i></span>
                    <div>
                      <h3 class="h4 mb-1">Kafka Partitions Calculator</h3>
                      <p class="text-muted mb-0">Estimate partitions from input rate and message size.</p>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <form class="row g-3 align-items-end" @submit.prevent>
                    <div class="col-md-4">
                      <label class="form-label" for="inputRate">Input rate</label>
                      <input id="inputRate" v-model.number="rate" class="form-control" name="inputRate" type="number">
                    </div>
                    <div class="col-md-4">
                      <label class="form-label" for="inputUnit">Rate unit</label>
                      <select id="inputUnit" v-model.number="unit" class="form-select" name="inputUnit">
                        <option value="1">per second</option>
                        <option value="60">per minute</option>
                        <option value="3600">per hour</option>
                        <option value="86400">per day</option>
                      </select>
                    </div>
                    <div class="col-md-4">
                      <label class="form-label" for="messageSizeKB">Message size</label>
                      <div class="input-group">
                        <input
                          id="messageSizeKB"
                          v-model.number="messageSizeKB"
                          class="form-control"
                          name="messageSizeKB"
                          type="number">
                        <span class="input-group-text">KB</span>
                      </div>
                    </div>
                    <div class="col-12">
                      <div class="partition-result">
                        <div>
                          <span class="text-muted">Estimated partitions</span>
                          <strong>{{ noPartitions }}</strong>
                        </div>
                        <small class="text-muted">
                          Based on {{ rate || 0 }} messages {{ selectedUnitLabel }} and {{ messageSizeKB || 0 }} KB messages.
                        </small>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </article>

            <article
              v-if="isToolVisible('spark-executor-memory')"
              id="spark-executor-memory"
              class="tool-section"
              tabindex="-1">
              <div class="card">
                <div class="card-header bg-white">
                  <div class="d-flex align-items-start gap-3">
                    <span class="section-icon"><i class="bi bi-star" aria-hidden="true"></i></span>
                    <div>
                      <h3 class="h4 mb-1">Spark Executor Memory</h3>
                      <p class="text-muted mb-0">Calculate Spark executor memory overhead from executor memory and overhead factor.</p>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <spark-executor-memory />
                </div>
              </div>
            </article>

            <article
              v-if="isToolVisible('dataproc-serverless')"
              id="dataproc-serverless"
              class="tool-section"
              tabindex="-1">
              <div class="card">
                <div class="card-header bg-white">
                  <div class="d-flex align-items-start gap-3">
                    <span class="section-icon"><i class="bi bi-cloud" aria-hidden="true"></i></span>
                    <div>
                      <h3 class="h4 mb-1">Dataproc Serverless</h3>
                      <p class="text-muted mb-0">Check driver memory ranges for Dataproc Serverless Spark workloads.</p>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <dataproc-serverless />
                </div>
              </div>
            </article>

            <article
              v-if="isToolVisible('casing-conversion')"
              id="casing-conversion"
              class="tool-section"
              tabindex="-1">
              <div class="card">
                <div class="card-header bg-white">
                  <div class="d-flex align-items-start gap-3">
                    <span class="section-icon"><i class="bi bi-fonts" aria-hidden="true"></i></span>
                    <div>
                      <h3 class="h4 mb-1">Casing Conversion</h3>
                      <p class="text-muted mb-0">Convert names between camel case, kebab case, and snake case.</p>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <casing-conversion />
                </div>
              </div>
            </article>

            <article
              v-if="isToolVisible('uuid-generator')"
              id="uuid-generator"
              class="tool-section"
              tabindex="-1">
              <div class="card">
                <div class="card-header bg-white">
                  <div class="d-flex align-items-start gap-3">
                    <span class="section-icon"><i class="bi bi-hash" aria-hidden="true"></i></span>
                    <div>
                      <h3 class="h4 mb-1">UUID and KSUID Generator</h3>
                      <p class="text-muted mb-0">Generate random UUIDs and time-aware KSUID values.</p>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <uuid-generator />
                </div>
              </div>
            </article>

            <article
              v-if="isToolVisible('time-format')"
              id="time-format"
              class="tool-section"
              tabindex="-1">
              <div class="card">
                <div class="card-header bg-white">
                  <div class="d-flex align-items-start gap-3">
                    <span class="section-icon"><i class="bi bi-clock" aria-hidden="true"></i></span>
                    <div>
                      <h3 class="h4 mb-1">Time Format Converter</h3>
                      <p class="text-muted mb-0">Read current timestamps and convert formatted dates to epoch seconds.</p>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <time-format />
                </div>
              </div>
            </article>

            <article
              v-if="isToolVisible('winscp-decoder')"
              id="winscp-decoder"
              class="tool-section"
              tabindex="-1">
              <div class="card">
                <div class="card-header bg-white">
                  <div class="d-flex align-items-start gap-3">
                    <span class="section-icon"><i class="bi bi-shield-lock" aria-hidden="true"></i></span>
                    <div>
                      <h3 class="h4 mb-1">WinSCP Password Decoder</h3>
                      <p class="text-muted mb-0">Decode WinSCP saved-session passwords from registry values.</p>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <win-scp-decoder />
                </div>
              </div>
            </article>
          </div>
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
      activeTool: 'kafka-partitions',
      searchQuery: '',
      selectedCategory: 'all',
      unit: 1,
      rate: 0,
      messageSizeKB: 1,
      categories: [
        { id: 'all', label: 'All', icon: 'bi bi-grid-3x3-gap' },
        { id: 'stream', label: 'Stream', icon: 'bi bi-diagram-3' },
        { id: 'spark', label: 'Spark', icon: 'bi bi-star' },
        { id: 'formatting', label: 'Formatting', icon: 'bi bi-fonts' },
        { id: 'identifiers', label: 'Identifiers', icon: 'bi bi-hash' },
        { id: 'time', label: 'Time', icon: 'bi bi-clock' },
        { id: 'security', label: 'Security', icon: 'bi bi-shield-lock' }
      ],
      tools: [
        {
          id: 'kafka-partitions',
          title: 'Kafka Partitions',
          category: 'stream',
          summary: 'Topic partition estimate',
          keywords: ['kafka', 'topic', 'partition', 'stream'],
          icon: 'bi bi-diagram-3'
        },
        {
          id: 'spark-executor-memory',
          title: 'Spark Executor Memory',
          category: 'spark',
          summary: 'Executor overhead calculator',
          keywords: ['spark', 'executor', 'memory', 'overhead'],
          icon: 'bi bi-star'
        },
        {
          id: 'dataproc-serverless',
          title: 'Dataproc Serverless',
          category: 'spark',
          summary: 'Driver memory ranges',
          keywords: ['dataproc', 'serverless', 'driver', 'memory'],
          icon: 'bi bi-cloud'
        },
        {
          id: 'casing-conversion',
          title: 'Casing Conversion',
          category: 'formatting',
          summary: 'Naming style conversion',
          keywords: ['case', 'casing', 'camel', 'kebab', 'snake'],
          icon: 'bi bi-fonts'
        },
        {
          id: 'uuid-generator',
          title: 'UUID and KSUID',
          category: 'identifiers',
          summary: 'Identifier generation',
          keywords: ['uuid', 'ksuid', 'identifier', 'id'],
          icon: 'bi bi-hash'
        },
        {
          id: 'time-format',
          title: 'Time Format',
          category: 'time',
          summary: 'Date and epoch conversion',
          keywords: ['time', 'date', 'epoch', 'format'],
          icon: 'bi bi-clock'
        },
        {
          id: 'winscp-decoder',
          title: 'WinSCP Decoder',
          category: 'security',
          summary: 'Saved password decoding',
          keywords: ['winscp', 'password', 'decoder', 'security'],
          icon: 'bi bi-shield-lock'
        }
      ]
    }
  },
  computed: {
    noPartitions () {
      return Math.ceil(this.rate * this.unit * this.messageSizeKB / 1024)
    },
    selectedUnitLabel () {
      const selected = {
        1: 'per second',
        60: 'per minute',
        3600: 'per hour',
        86400: 'per day'
      }
      return selected[this.unit] || 'per second'
    },
    filteredTools () {
      const query = this.searchQuery.toLowerCase()
      return this.tools.filter((tool) => {
        const categoryMatches = this.selectedCategory === 'all' || tool.category === this.selectedCategory
        const haystack = [
          tool.title,
          tool.summary,
          ...tool.keywords
        ].join(' ').toLowerCase()
        return categoryMatches && (!query || haystack.includes(query))
      })
    }
  },
  watch: {
    searchQuery () {
      this.syncActiveToolWithFilter()
    }
  },
  methods: {
    categoryCount (categoryId) {
      if (categoryId === 'all') return this.tools.length
      return this.tools.filter((tool) => tool.category === categoryId).length
    },
    clearFilters () {
      this.searchQuery = ''
      this.selectedCategory = 'all'
      this.syncActiveToolWithFilter()
    },
    isToolVisible (toolId) {
      return this.filteredTools.some((tool) => tool.id === toolId)
    },
    openTool (toolId) {
      this.activeTool = toolId
      this.$nextTick(() => {
        const target = document.getElementById(toolId)
        if (target) {
          target.scrollIntoView({ behavior: 'smooth', block: 'start' })
          target.focus({ preventScroll: true })
          window.history.replaceState(null, '', `#${toolId}`)
        }
      })
    },
    selectCategory (categoryId) {
      this.selectedCategory = categoryId
      this.syncActiveToolWithFilter()
    },
    syncActiveToolWithFilter () {
      this.$nextTick(() => {
        if (this.filteredTools.length === 0) return
        if (!this.isToolVisible(this.activeTool)) {
          this.activeTool = this.filteredTools[0].id
        }
      })
    }
  },
  mounted () {
    const hashTool = window.location.hash.replace('#', '')
    if (this.tools.some((tool) => tool.id === hashTool)) {
      this.openTool(hashTool)
    }
  },
  components: {
    Banner,
    WinScpDecoder,
    DataprocServerless,
    SparkExecutorMemory,
    TimeFormat,
    UuidGenerator,
    CasingConversion
  }
}
</script>

<style scoped>
.tools-wrapper {
  padding-top: 2rem;
}

.tools-heading {
  border-bottom: 1px solid var(--bs-border-color);
  padding-bottom: 1.25rem;
}

.tools-heading h2 {
  font-weight: 500;
}

.category-button {
  align-items: center;
  display: inline-flex;
  gap: 0.45rem;
}

.tools-nav {
  position: sticky;
  top: 1rem;
}

.tools-nav .list-group-item {
  font-size: 0.95rem;
}

.tools-nav .list-group-item i {
  color: var(--bs-primary);
}

.tools-nav .list-group-item.active i {
  color: #fff;
}

.tool-card {
  align-items: flex-start;
  background: #fff;
  border: 1px solid var(--bs-border-color);
  border-radius: var(--bs-border-radius);
  color: var(--bs-body-color);
  display: flex;
  gap: 0.75rem;
  min-height: 7.75rem;
  padding: 1rem;
  text-align: left;
  transition: border-color 160ms ease, box-shadow 160ms ease, transform 160ms ease;
  width: 100%;
}

.tool-card:hover,
.tool-card.active {
  border-color: var(--bs-primary);
  box-shadow: 0 0.25rem 0.75rem rgba(13, 110, 253, 0.12);
}

.tool-card:hover {
  transform: translateY(-1px);
}

.tool-card-icon,
.section-icon {
  align-items: center;
  background: rgba(13, 110, 253, 0.08);
  border-radius: var(--bs-border-radius);
  color: var(--bs-primary);
  display: inline-flex;
  flex: 0 0 auto;
  justify-content: center;
}

.tool-card-icon {
  font-size: 1.35rem;
  height: 2.75rem;
  width: 2.75rem;
}

.section-icon {
  font-size: 1.4rem;
  height: 3rem;
  width: 3rem;
}

.tool-card-copy strong,
.tool-card-copy small {
  display: block;
}

.tool-card-copy strong {
  font-size: 1rem;
  font-weight: 600;
  margin-bottom: 0.25rem;
}

.tool-card-copy small {
  color: var(--bs-secondary-color);
  line-height: 1.35;
}

.tool-section {
  margin-bottom: 1.5rem;
  scroll-margin-top: 1rem;
}

.tool-section:focus {
  outline: 0;
}

.tool-section:focus .card {
  border-color: var(--bs-primary);
  box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.15);
}

.partition-result {
  align-items: center;
  background: var(--bs-light);
  border: 1px solid var(--bs-border-color);
  border-radius: var(--bs-border-radius);
  display: flex;
  gap: 1rem;
  justify-content: space-between;
  padding: 1rem;
}

.partition-result span,
.partition-result strong {
  display: block;
}

.partition-result strong {
  color: var(--bs-primary);
  font-size: 2.5rem;
  line-height: 1;
}

.partition-result small {
  max-width: 26rem;
  text-align: right;
}

.empty-state {
  border: 1px dashed var(--bs-border-color);
  border-radius: var(--bs-border-radius);
  padding: 2.5rem 1rem;
  text-align: center;
}

.empty-state i {
  color: var(--bs-primary);
  font-size: 2rem;
}

.tool-section :deep(form) {
  margin: 0;
}

.tool-section :deep(.row) {
  row-gap: 0.75rem;
}

.tool-section :deep(.form-control),
.tool-section :deep(.form-select),
.tool-section :deep(.input-group-text),
.tool-section :deep(.btn),
.tool-section :deep(.alert) {
  border-radius: var(--bs-border-radius);
}

.tool-section :deep(.input-group > .form-control),
.tool-section :deep(.input-group > .form-select),
.tool-section :deep(.input-group > .input-group-text),
.tool-section :deep(.input-group > .btn) {
  border-radius: 0;
}

.tool-section :deep(.input-group > :first-child) {
  border-bottom-left-radius: var(--bs-border-radius);
  border-top-left-radius: var(--bs-border-radius);
}

.tool-section :deep(.input-group > :last-child) {
  border-bottom-right-radius: var(--bs-border-radius);
  border-top-right-radius: var(--bs-border-radius);
}

@media (max-width: 991.98px) {
  .tools-nav {
    flex-direction: row;
    margin-bottom: 0.5rem;
    overflow-x: auto;
    position: static;
  }

  .tools-nav .list-group-item {
    border-width: 1px;
    flex: 0 0 auto;
    white-space: nowrap;
    width: auto;
  }
}

@media (max-width: 767.98px) {
  .category-button {
    justify-content: space-between;
    width: 100%;
  }

  .partition-result {
    align-items: flex-start;
    display: block;
  }

  .partition-result small {
    display: block;
    margin-top: 0.75rem;
    max-width: none;
    text-align: left;
  }

  .tool-section :deep(.col-1),
  .tool-section :deep(.col-2),
  .tool-section :deep(.col-3),
  .tool-section :deep(.col-4),
  .tool-section :deep(.col-5),
  .tool-section :deep(.col-6),
  .tool-section :deep(.col-7),
  .tool-section :deep(.col-8),
  .tool-section :deep(.col-9),
  .tool-section :deep(.col-10),
  .tool-section :deep(.col-11),
  .tool-section :deep(.col-12) {
    flex: 0 0 100%;
    max-width: 100%;
    width: 100%;
  }
}
</style>
