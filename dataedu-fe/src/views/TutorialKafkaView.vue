<template>
  <Banner caption="A distributed streaming platform to build reliable and scalable data streaming applications."
          title="Kafka and Schema Registry"
          />
  <section id="content">
    <div class="wrapper doc">
      <IrajTabs>
        <IrajTab :selected="true" name="Kafka 1">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vS3TVL_BGr8IbNtjvWQ5bz8g6Qg6irmeyL4pyCiSYlW2o_3amjnwZesDG_CkT0ENMCsZ1o6kXFBCdgu/embed?start=false&loop=false&delayms=3000"
                  title="Kafka - session 1" width="960">
                </iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Kafka 2">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vTeSD-NVRZnyIJN3Dv4LFoOVDQW_Y6Yx9lIEZqLVae9LTSRkoXsAYQdGRjp53SJptn6mR6qL40LgdQs/embed?start=false&loop=false&delayms=3000"
                  title="Kafka - session 2" width="960">
                </iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h3>Tutorial</h3>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h4>Get Kafka up and running</h4>
                <p>You can start a single Kafka broker using either of the following distributions</p>
                <ul>
                  <li>Apache Kafka</li>
                  <li>
                    Confluent Kafka (refer to
                    <a href="https://docs.confluent.io/3.1.1/installation.html">Confluent web site</a>).
                    You can even use docker images or use docker-compose using the variety of options
                    provided on <a href="https://github.com/confluentinc/cp-all-in-one">confluentinc/cp-all-in-one</a>
                    GitHub repository.
                  </li>
                </ul>
                In order to install Apache Kafka

                <h5>Step 1: download</h5>
                Download a version from <a href="https://kafka.apache.org/downloads">Apache Kafka</a> page
                and un-tar it.
                For example, for version 2.11
                <pre><code>
tar -xf kafka_2.11-2.0.0.tgz .
cd kafka_2.11-2.0.0
</code></pre>

                <h5>Step 2: Start Zookeeper</h5>
                We know that Kafka depends on Zookeeper. If you already have a Zookeeper instance up and
                running, you can skip this step. Make sure you provide the running Zookeeper quorum in
                <strong>config/zookeeper.properties</strong> file.
                <pre><code>
./bin/zookeeper-server-start.sh config/zookeeper.properties
</code></pre>

                <h5>Step 3: Start Kafka</h5>
                <pre><code>
./bin/kafka-server-start.sh config/server.properties
</code></pre>

                To facilitate running commands, add the <code>bin</code> directory to your <code>$PATH</code>.
                <pre><code>
export PATH=$PATH:$KAFKA_HOME/bin
</code></pre>
                <p></p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <p></p>
                <h4>Kafka Command Line (basics)</h4>
                <p>To start working with Kafka command line tools, here are a set of commands.</p>
                <p>
                  <KafkaCommandsGist/>
                </p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <p></p>
                <h4>Kafka Topics Tutorial</h4>
                <iframe
                  allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen
                  height="569"
                  src="https://www.youtube.com/embed/jaPDDpyyhRk"
                  title="Kafka topics video tutorial" width="960"></iframe>
                <p></p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h4>Kafka consumer and producer Tutorial</h4>
                <p>
                  Source code on <a aria-pressed="true"
                                    class="btn btn-secondary btn-lg active"
                                    href="https://github.com/irajhedayati/mcit/tree/master/kafka-client" role="button">GitHub</a>
                </p>
                <iframe
                  allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen
                  height="569"
                  src="https://www.youtube.com/embed/OPTMje7wKmU"
                  title="Kafka consumer and producer tutorial" width="960"></iframe>
                <p></p>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h4>Multi-broker setup and ISR</h4>
                <p>
                  Let's start a Kafka cluster with multiple brokers. Use the following docker-compose file
                  to run your cluster by running <code>docker-compose up</code> (assuming you have installed
                  Docker and docker-compose).
                </p>
                <p>
                  Note that as we are running three dockers on the same host and also the limitations on brokers and
                  <a href="https://www.confluent.io/blog/kafka-listeners-explained/">listeners and advertised
                    listeners</a>
                  we are using different ports for each broker (i.e. 9092, 9093, and 9094). Keep in mind
                  that in real deployments, these ports stay the same.
                  <img alt="Multi-broker Kafka setup in docker-compose" class="mr-3"
                       height="412" src='@/assets/images/multi-broker-cluster.png' width="650"></p>
                <KafkaMultiBrokerGist/>
                <p>
                  To complete your tutorial, first create a topic. This time, we use replication factor 3
                  as we have 3 brokers available.
                </p>
                <pre><code>
    kafka-topics --bootstrap-server localhost:9092 --create --replication-factor 1 --partitions 3 --topic test2
    kafka-topics --bootstrap-server localhost:9092 --describe --topic test2
</code></pre>
                <img alt="Distribution of brokers and partitions" class="mr-3"
                     height="300" src='@/assets/images/isr1.png' width="1024">
                <p>Let's produce some messages</p>
                <pre><code>
kafka-console-producer --broker-list localhost:9092 --topic test2
>first message
>second message
>third message
</code></pre>
                <p>And then consume</p>
                <pre><code>
kafka-console-consumer --bootstrap-server localhost:9092 --topic test2 --from-beginning
second message
third message
first message
</code></pre>
                <p>There are 3 messages in this topic. Because we used the console producer, it doesn't
                  use any key for the messages and by design uses the round-robin method. Hence, each partition
                  has only one message. Let's see the message in partition 2</p>
                <pre><code>
kafka-console-consumer --bootstrap-server localhost:9092 --topic test2 --from-beginning --partition 2
first message
</code></pre>
                <p>It is <code>first message</code>. As we saw earlier, <strong>broker1</strong> is the leader
                  for this partition. Let's stop this broker using <code>docker stop broker1</code>.
                  Now describe the topic again</p>
                <pre><code>
kafka-topics --bootstrap-server localhost:9092 --describe --topic test2
Topic:test2&#9;PartitionCount:3&#9;ReplicationFactor:3&#9;Configs:
&#9;Topic: test2&#9;Partition: 0&#9;Leader: 2&#9;Replicas: 2,3,1&#9;Isr: 2,3
&#9;Topic: test2&#9;Partition: 1&#9;Leader: 3&#9;Replicas: 3,1,2&#9;Isr: 3,2
&#9;Topic: test2&#9;Partition: 2&#9;Leader: 3&#9;Replicas: 1,2,3&#9;Isr: 3,2
</code></pre>
                <p>As you can see, </p>
                <ul>
                  <li>The replica list is still <strong>1,2,3</strong> hoping that broker 1 recovers</li>
                  <li>There was a leader election between broker 2 and 3 and broker 3 became the leader.</li>
                  <li>In all the partitions, <strong>Isr</strong> is changed by removing broker 1</li>
                </ul>
                <p>If you try and consume the topic again, you will see that all the messages including
                  <code>first message</code> are still available and it is the power of failure recovery and
                  replication</p>
                <pre><code>
kafka-console-consumer --bootstrap-server localhost:9092 --topic test2 --from-beginning
first message
second message
third message
</code></pre>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Schema Registry">
          <div class="container">
            <div class="row"><div class="col-sm">
              <iframe
                src="https://docs.google.com/presentation/d/e/2PACX-1vTFbDVVRKjp_7eUOzq0VqOva9OCPHMcJZiQqcdy8GeueszDvcsd1DUZsumz1_QTmHiPi65hcqGkIhSK/embed?start=false&loop=false&delayms=3000"
                width="960" height="569" allow="fullscreen"
                title="Kafka - session 2">
              </iframe>
            </div></div>
            <div class="row"><div class="col-sm">
              <p></p>
              <h4>Tutorial on Avro, Schema Registry, and Kafka</h4>
              <p>
                The code in the tutorial can be found on
                <a href="https://github.com/irajhedayati/mcit/tree/master/schema-registry-practices">GitHub</a>
              </p>
              <iframe
                width="960" height="569" src="https://www.youtube.com/embed/kKW_0HPCAOU"
                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen title="Kafka topics video tutorial"></iframe>
              <p></p>
            </div></div>
            <div class="row"><div class="col-sm">
              <p></p>
              <h4>Register Avro schema from command line</h4>
              <p>The Avro schema in JSON format </p>
              <SchemaRegistryGist />
            </div> </div>
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
import KafkaCommandsGist from '@/components/KafkaCommandsGist.vue'
import KafkaMultiBrokerGist from '@/components/KafkaMultiBrokerGist.vue'
import SchemaRegistryGist from '@/components/SchemaRegistryGist.vue'

export default {
  components: { Banner, IrajTabs, IrajTab, KafkaCommandsGist, KafkaMultiBrokerGist, SchemaRegistryGist }
}
</script>
