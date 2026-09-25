<script>
export default {
  name: 'TutorialCell',
  props: ['title', 'description', 'link', 'icon']
}
</script>
<template>
  <div class="col-lg-4 col-md-6">
    <router-link class="tutorial-card" :to="link">
      <span class="tutorial-icon"><i :class="icon || 'bi bi-journal-code'" aria-hidden="true"></i></span>
      <h3>{{ title }}</h3>
      <p>{{ description }}</p>
      <span class="card-action">Explore tutorial <i class="bi bi-arrow-right" aria-hidden="true"></i></span>
    </router-link>
  </div>
</template>
