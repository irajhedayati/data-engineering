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
          <tutorial-cell title="Introduction" link="/tutorials/introduction" description="A brief introduction to Data Science, Data Engineering, and Business Intelligence."/>
          <tutorial-cell title="Hadoop and Zookeeper" link="/tutorials/hadoop" description="The Apache Hadoop software library is a framework that allows for the distributed processing of large data sets across clusters of computers using simple programming models."/>
          <tutorial-cell title="Hive" link="/tutorials/hive" description="The Apache Hive data warehouse software facilitates reading, writing, and managing large datasets residing in distributed storage using SQL."/>
        </div>
        <div class="row">
          <tutorial-cell title="Kafka and Schema Registry" link="/tutorials/kafka" description="A messaging system based on pub/sub architecture perfectly designed for streaming and message passing."/>
          <tutorial-cell title="Spark" link="/tutorials/spark" description="Spark is a unified distributed data processing platform."/>
          <tutorial-cell title="AWS" link="/tutorials/aws" description="AWS is the world’s most comprehensive and broadly adopted cloud platform, offering over 175 fully featured services from data centers globally."/>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import Banner from '@/components/Banner.vue'
import TutorialCell from '@/components/TutorialCell.vue'

export default {
  name: 'HomeView',
  data () {
    return {}
  },
  components: { Banner, TutorialCell }
}
</script>
