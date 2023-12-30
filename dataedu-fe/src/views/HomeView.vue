<template>
  <Banner
    caption='A site to share contents, tutorials and online tools that I use in my day-to-day tasks as a data engineer.'
    title='Data Engineering Tools'
  />
  <section id="content">
    <div class="wrapper doc">
      <div class="container">
        <div class="row">
          <div class="col-auto">
            <h1>Welcome to my tutorial pages</h1>
            <p>
              In this website, you will find contents, tutorials and online tools that I use in my day-to-day tasks as a
              data engineer.
            </p>
            <p>
              The primary reason of this site is to publish tools that helps me to understand, practice, or even develop
              proof of concepts for my projects. There would be small tutorials and links to sources if you'd like to
              learn
              more.
            </p>
          </div>
        </div>
        <div class="row">
          <div class="col-sm">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Introduction</h5>
                <p class="card-text">A brief introduction to Data Science, Data Engineering, and Business
                  Intelligence.</p>
                <router-link aria-current="page" class="btn btn-primary" to="/tutorials/introduction">Content
                </router-link>
              </div>
            </div>
          </div>
          <div class="col-sm">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Hadoop and Zookeeper</h5>
                <p class="card-text">The Apache Hadoop software library is a framework that allows for the distributed
                  processing of large data sets across clusters of computers using simple programming models.</p>
                <router-link aria-current="page" class="btn btn-primary" to="/tutorials/hadoop">Content</router-link>
              </div>
            </div>
          </div>
          <div class="col-sm">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Hive</h5>
                <p class="card-text">The Apache Hive data warehouse software facilitates reading, writing, and managing
                  large datasets residing in distributed storage using SQL.</p>
                <router-link aria-current="page" class="btn btn-primary" to="/">Content</router-link>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-sm">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Kafka and Schema Registry</h5>
                <p class="card-text">A messaging system based on pub/sub architecture perfectly designed for streaming
                  and
                  message passing.</p>
                <router-link aria-current="page" class="btn btn-primary" to="/">Content</router-link>
              </div>
            </div>
          </div>
          <div class="col-sm">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Spark</h5>
                <p class="card-text">Spark is a unified distributed data processing platform.</p>
                <router-link aria-current="page" class="btn btn-primary" to="/">Content</router-link>
              </div>
            </div>
          </div>
          <div class="col-sm">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">AWS</h5>
                <p class="card-text">AWS is the world’s most comprehensive and broadly adopted cloud
                  platform, offering over 175 fully featured services from data centers globally.</p>
                <router-link aria-current="page" class="btn btn-primary" to="/">Content</router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import Banner from '@/components/Banner.vue'

export default {
  name: 'HomeView',
  data () {
    return {}
  },
  components: {
    Banner
  }
}
</script>
