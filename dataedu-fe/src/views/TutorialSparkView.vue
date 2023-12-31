<template>
  <Banner caption="Spark is a unified distributed data processing platform"
          title="Spark"
  />
  <section id="content">
    <div class="wrapper doc">
      <IrajTabs>
        <IrajTab :selected="true" name="Introduction">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vRM_OQ-BDieg_uWBmE0F8AgrV5Ufhdnbacl7D_nhuJ1qzXl9MR7QNkExQ_s-ljek0XFS9KU9uc4Mu-b/embed?start=false&loop=false&delayms=3000"
                  title="An introduction to Spark"
                  width="960"></iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Core">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vRqWGyXVBLxt-cLpkWwRgtO0WSg3C4p_HWvTiZW80uNBXyPD2g_kPb7ghnNjD_Pw4kOUCLhppdWsvl_/embed?start=false&loop=false&delayms=3000"
                  title="Spark Core Application" width="960">
                </iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h3>Tutorial</h3>
                <p>
                  Here is a quick tutorial on how to start your first Spark application:
                </p>
                <p>
                  <iframe
                    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen
                    height="569"
                    src="https://www.youtube.com/embed/tioyZRXKZdc"
                    title="Spark Core Application Tutorial" width="960">
                  </iframe>
                </p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h3>Tutorial on partitions</h3>
                <p>
                  Here is a quick tutorial on how partitioning affects Spark jobs:
                </p>
                <p>
                  <iframe
                    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen
                    height="569"
                    src="https://www.youtube.com/embed/oFutWpGlsvI"
                    title="Spark Partitions Tutorial" width="960">
                  </iframe>
                </p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h3>Repartitioning vs Coalesce</h3>

                <p>In a nutshell, when even distribution of data is desired, we should use "repartition"
                  and when better performance is needed, we should use "coalesce".
                </p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <table class="table table-bordered">
                  <caption>Compare repartition and coalesce API</caption>
                  <thead>
                  <tr>
                    <th scope="col"></th>
                    <th scope="col">repartition</th>
                    <th scope="col">coalesce</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <th scope="row">Shuffle</th>
                    <td>YES</td>
                    <td>NO</td>
                  </tr>
                  <tr>
                    <th scope="row">Even distribution</th>
                    <td>YES</td>
                    <td>NO</td>
                  </tr>
                  </tbody>
                </table>
              </div>
              <div class="col-sm"></div>
              <div class="row">
                <div class="col-sm">
                  <h4>A quick tutorial</h4>

                  <pre><code>
                                // A map from partition number to the number of elements to sample
                                // i.e. we're going to take 44 from the first partition and 68 from the second and etc.
                                val sampling = Map(
                                    0 -> 44, 1 -> 68, 2 -> 87, 3 -> 10,
                                    4 -> 13, 5 -> 104, 6 -> 77, 7 -> 85
                                )
                                val x0 = sc.parallelize(1 to 1000)
                                // Each partition has 125 elements each
                                x0.foreachPartition(x => println(s"====> ${x.toList.size}"))
                                // Run the sampling
                                val x1 = x0.mapPartitionsWithIndex((idx, data) => data.take(sampling(idx)))
                                // print the initial distribution of data
                                x1.foreachPartition(x => println(s"====> ${x.toList.size}"))
                                // repartition and print the distribution of data
                                x1.repartition(4).foreachPartition(x => println(s"====> ${x.toList.size}"))
                                // coalesce and print the distribution of data
                                x1.coalesce(4).foreachPartition(x => println(s"====> ${x.toList.size}"))
                            </code></pre>

                  <p>Here is the distribution of data after sampling.</p>

                  <table class="table table-bordered">
                    <caption>A sample data before changing the number of partitions</caption>
                    <thead>
                    <tr>
                      <th scope="col">Partition</th>
                      <th scope="col">0</th>
                      <th scope="col">1</th>
                      <th scope="col">2</th>
                      <th scope="col">3</th>
                      <th scope="col">4</th>
                      <th scope="col">5</th>
                      <th scope="col">6</th>
                      <th scope="col">7</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <th scope="row"># of elements</th>
                      <td>10</td>
                      <td>44</td>
                      <td>13</td>
                      <td>68</td>
                      <td>77</td>
                      <td>87</td>
                      <td>104</td>
                      <td>85</td>
                    </tr>
                    </tbody>
                  </table>

                  <p>Here is the distribution of data after repartition. It has even distribution of data</p>

                  <table class="table table-bordered">
                    <caption>The sample data after changing the number of partitions using repartition API</caption>
                    <thead>
                    <tr>
                      <th scope="col">Partition</th>
                      <th scope="col">0</th>
                      <th scope="col">1</th>
                      <th scope="col">2</th>
                      <th scope="col">3</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <th scope="row"># of elements</th>
                      <td>123</td>
                      <td>120</td>
                      <td>122</td>
                      <td>123</td>
                    </tr>
                    </tbody>
                  </table>

                  <p>Here is the distribution of data after coalesce. It doesn't have even distribution and
                    the neighbor partitions are just merged
                  </p>

                  <table class="table table-bordered">
                    <caption>The sample data after changing the number of partitions using coalesce API</caption>
                    <thead>
                    <tr>
                      <th scope="col">Partition</th>
                      <th scope="col">0 <br/>(0 and 1 of original)</th>
                      <th scope="col">1 <br/>(2 and 3 of original)</th>
                      <th scope="col">2 <br/>(4 and 5 of original)</th>
                      <th scope="col">3 <br/>(6 and 7 of original)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <th scope="row"># of elements</th>
                      <td>112</td>
                      <td>97</td>
                      <td>117</td>
                      <td>162</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="SQL">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vQq3iibkdZJjDV9g5oG3wfHXml7LunQlxnMnsmkM93w-pf7YgtuFpwwcnQYK01YUKajmY_D2vDaZuqW/embed?start=false&loop=false&delayms=3000"
                  title="Spark SQL application" width="960"></iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Streaming">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vRZ8Aml7ftBbE1lZ6pMtUUJS12Tnpu1m-84C9rQv1tlai6QloJQvidswasmCEQGecvBa6DeQansJjcy/embed?start=false&loop=false&delayms=3000"
                  title="Spark Streaming application" width="960"></iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Spark with Kafka">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vQC4NdriQaFMJpZkZGWCWt-XVNjUHczAUbITNozdadwBnueZZfPnnzERX9pQLS5xCTZFICXh9eXu7th/embed?start=false&loop=false&delayms=3000"
                  title="Spark Streaming with Kafka"
                  width="960"></iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Machine Learning">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vRfu6eg8xBNZUwYCYNj7XdIMXPpUVEh-TWJzeYOCsDjhA-SD-IifWdr808aloriDCKNpaP0zejNanzc/embed?start=false&loop=false&delayms=3000"
                  title="Machine Learning Fundamentals" width="960"></iframe>
                <p>If you find yourself to quickly improve a some math skills that are used in this class,
                  I suggest take a look at <a href="https://www.coursera.org/learn/datasciencemathskills/home/welcome">Data
                    Science Math Skills</a>
                  course prepared by Duke University on Coursera platform.</p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h3>A tutorial on linear regression using Excel</h3>
                <p>
                  A nice step-by-step tutorial to follow about
                  <a href="https://www.ablebits.com/office-addins-blog/2018/08/01/linear-regression-analysis-excel/">Linear
                    regression analysis in Excel</a>.
                  Here is the dataset from the tutorial. We will use it in our Spark MLlib practices as well.
                  <SparkMLGist/>
                </p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vQ2lJOvCRMuURzVu6n-N7wMoJC7LK3ekW2o_NecJWHlclys_jO5cartZ7sEY2YcOzV6AUxZ237PzZDd/embed?start=false&loop=false&delayms=3000"
                  title="Spark MLlib" width="960">
                </iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <p>
                  The tutorial codes in Spark MLlib can be found on
                  <a
                    href="https://github.com/irajhedayati/mcit/tree/master/spark-playground/src/main/scala/ca/dataedu/spark/core">Github</a>
                </p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                Here is a notebook on databricks to practice a few ML pipelines.
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://databricks-prod-cloudfront.cloud.databricks.com/public/4027ec902e239c93eaaa8714f173bcfc/5443007526568798/844278729783386/8312309989798462/latest.html"
                  title="Spark MLlib" width="960">
                </iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                Additional resources:
                <ul>
                  <li><a href=https://mlu-explain.github.io/precision-recall>Calssification metrics (precision &
                    recall)</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Graph">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vSFHNlCYVRkqIn-gY8bTSntriju-qpYgU6ejlGxxjUGC38SN2ZKSX5IbtowE7B4qSFh7shINRB4wkHd/embed?start=false&loop=false&delayms=3000"
                  title="Spark GraphX" width="960"></iframe>
              </div>
            </div>
          </div>
        </IrajTab>
      </IrajTabs>
    </div>
  </section>
</template>
<script>
import Banner from '@/components/Banner.vue'
import IrajTabs from '@/components/IrajTabs.vue'
import IrajTab from '@/components/IrajTab.vue'
import SparkMLGist from '@/components/SparkMLGist.vue'

export default {
  components: { Banner, IrajTabs, IrajTab, SparkMLGist }
}
</script>
