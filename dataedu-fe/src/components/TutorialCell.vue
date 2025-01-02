<script>
export default {
  name: 'TutorialCell',
  props: ['title', 'description', 'link']
}
</script>

<template>
<div class="col-4 mt-1 mb-1">
  <div class="card h-100">
    <div class="card-body">
      <div class="row-cols-1 mb-3" style="height: 10%"><h5 class="card-title">{{ title }}</h5></div>
      <div class="row-cols-1 mb-3" style="height: 55%">
        <p class="card-text">{{ description }}</p>
      </div>
      <div class="row">
        <div class="col-4"></div>
        <div class="col-4"></div>
        <div class="col-4">
          <router-link aria-current="page" class="btn btn-primary" to="{{ link }}">Content</router-link>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<style scoped>

</style>
