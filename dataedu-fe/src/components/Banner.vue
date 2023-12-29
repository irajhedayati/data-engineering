<template>
  <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
      <div class="carousel-item active d-flex flex-wrap align-items-center">
        <img :src="bannerImage" class="d-block w-100" alt="Tehran Banner">
        <div class="position-absolute top-0 left-0 d-flex justify-content-center align-items-center w-100 h-100 text-white fs-5" style="background: rgba(0,0,0,0.6);">
          <div class="carousel-caption d-none d-md-block">
            <h1 class="display-4">{{ title }}</h1>
            <p class="text-white-50">{{ caption }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data () {
    return {
      bannerImage: `${require('@/assets/images/banner.jpg')}`
    }
  },
  props: ['title', 'caption']
}
</script>

<style>
.carousel .carousel-item {
  height: 500px;
}

.carousel-item img {
  position: relative;
  top: 50%;
  transform: translateY(-50%);
}
</style>
