<template>
  <Banner title='Data Engineering Tools'
          caption='A site to share contents, tutorials and online tools that I use in my day-to-day tasks as a data engineer.'
  />
</template>

<script>
import Banner from '@/components/Banner.vue'

export default {
  name: 'HomeView',
  data () {
    return {
      bannerImage: `${require('@/assets/images/banner.jpg')}`,
      title: 'Data Engineering Tools',
      caption: 'A site to share contents, tutorials and online tools that I use in my day-to-day tasks as a data engineer.'
    }
  },
  components: {
    Banner
  }
}
</script>
