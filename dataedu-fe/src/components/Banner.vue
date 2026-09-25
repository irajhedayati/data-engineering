<template>
  <header class="page-banner">
    <div class="container">
      <span class="eyebrow">THE DATA ENGINEER’S WORKSPACE</span>
      <h1>{{ title }}</h1>
      <p>{{ caption }}</p>
    </div>
  </header>
</template>
<script>
export default {
  name: 'PageBanner',
  props: ['title', 'caption']
}
</script>
