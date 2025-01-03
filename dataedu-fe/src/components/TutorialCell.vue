<script>
export default {
  name: 'TutorialCell',
  props: ['title', 'description', 'link']
}
</script>

<template>
<div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 mt-1 mb-1">
  <div class="card h-100">
    <div class="card-body">
      <div class="row-cols-1 mb-3" style="height: 10%"><h5 class="card-title">{{ title }}</h5></div>
      <div class="row-cols-1 mb-3" style="height: 55%"><p class="card-text">{{ description }}</p></div>
      <div class="row-cols-lg-3 row-cols-md-3 row-cols-sm-12 row-cols-xs-12 mb-3">
          <router-link aria-current="page" class="btn btn-primary" to="{{ link }}">Content</router-link>
      </div>
    </div>
  </div>
</div>
</template>

<style scoped>

</style>
