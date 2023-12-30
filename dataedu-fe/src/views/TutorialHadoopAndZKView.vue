<template>
  <Banner
    caption='Distributed framework for massive data processing'
    title='Hadoop Framework'
  />
  <section id="content">
    <div class="wrapper doc">
      <IrajTabs>
        <IrajTab :selected="true" name="Hadoop">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vSGzX5-zAmPVkNRY6pIQ3B08AtQo6eTMzfwqHzghOLTLEBCuTwHRLX7KswWYYmKYqlw91eYmAxNvmWd/embed?start=false&loop=false&delayms=3000"
                  title="Hadoop framework"
                  width="960">
                </iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="HDFS">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vQX92imQICP2NKE2Fi7hHV38ul7Bz6OaX5hQNGUcYBY6CuMUUj0icBXL2uRDtHfF_11XkwaV-C2BKY0/embed?start=false&loop=false&delayms=3000"
                  title="HDFS"
                  width="960"
                >
                </iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h3>HDFS Architecture</h3>
                <p><img alt="HDFS Architecture" class="mr-3"
                        height="412" src='@/assets/images/HDFS-Architecture.png' width="800"></p>

                <h3>Namenode High Availability</h3>
                <p><img alt="Namenode High Availability" class="mr-3"
                        height="412" src='@/assets/images/NN-HA.png' width="650"></p>

                <h3>Environment Variable setup for HDFS client</h3>
                <p>
                  Let's assume that you have downloaded Apache Hadoop 2.7.7 and unpacked it under
                  <code>/home/user/opt/hadoop-2.7.7</code>.
                </p>
                <p>
                  In order to set the environment variables in a permanent way (so that every time you
                  login, they are defined), we can use shell profiles. Each shell may use different file
                  but in this tutorial we assume Linux CentOS. Open <code>~/.bashrc</code> file using
                  an editor (you can use command line editors such as <code>nano</code> or <code>vi</code>
                  or editors in GUI such as <code>gedit</code>).
                </p>
                <p>
                  The first environment variable is <code>PATH</code> which helps you to run Hadoop
                  commands without providing the absolute path. Add the following line to the file:
                </p>
                <pre><code>export PATH=$PATH:/home/user/opt/hadoop-2.7.7/bin</code></pre>
                <p>
                  The second environment variable is <code>JAVA_HOME</code> that points to the installation
                  directory of your JDK/JRE. Add the following line to the file
                </p>
                <pre><code>export JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")</code></pre>
                <p>If you are a Mac user, use</p>
                <pre><code>export JAVA_HOME=$(/usr/libexec/java_home -v1.8)</code></pre>
                <p>
                  The next environment variable is the one that indicates where are the configuration
                  files of Hadoop and it is <code>HADOOP_CONF_DIR</code>.
                  Let's assume that you have download the configuration files from the namenode and put
                  them under <code>/home/user/opt/hadoop-2.7.7/etc/my-cluster</code>
                  Add the following lines to the file
                </p>
                <pre><code>
                                export HADOOP_HOME=/home/user/opt/hadoop-2.7.7
                                export HADOOP_CONF_DIR=$HADOOP_HOME/etc/my-cluster
                            </code></pre>
                <p>
                  Note that the <code>HADOOP_HOME</code> is not necessary but just a good practice.
                </p>
                <p>
                  Save the file and run <code>source ~/.bashrc</code>. This is to setup your environment
                  variables for this session. From now on, whenever you login using user <code>user</code>,
                  all these environment variables are set.
                </p>
                <p>
                  If everything is set properly, the following command should return the content of the
                  root directory of your Hadoop cluster.
                </p>
                <pre><code>hadoop fs -ls /</code></pre>

                <h3>Impersonate Hadoop user</h3>
                <p>
                  Hadoop commands and library uses current user that is logged into the client as the
                  effective user (if you are using a Linux machine, just run <code>whoami</code> command
                  to see that).
                  If this user is different from the user that has permission to the HDFS directories and
                  files, you might need to impersonate the user with permission. To achieve this, you can
                  use <code>HADOOP_USER_NAME</code> environment variable.
                </p>
                <pre><code>export HADOOP_USER_NAME=user_with_permission</code></pre>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="YARN">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vQzwFG3L6-JsAPuK_FSpnwK4kUy47npuzBKbdX8Q0zfreBWWcuY3XsFEqLU4gyNuPQn_KSkmQ_dgQH0/embed?start=false&loop=false&delayms=3000"
                  title="YARN"
                  width="960">
                </iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="MapReduce">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569" src="https://docs.google.com/presentation/d/e/2PACX-1vTqx4tP9Qf8HFJa4T4IH9f8MuLb4SWSoTNLJytaJdvphgRdmHXHSlYmkPH-G_w80Sj_UgCiLsMCMJ2Y/embed?start=false&loop=false&delayms=3000" title="MaReduce"
                  width="960">
                </iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h3>MapReduce</h3>
                <p><img alt="MaReduce" class="mr-3"
                        height="412" src='@/assets/images/mr.png' width="900"></p>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Zookeeper">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <h4>Introduction to Zookeeper</h4>
                <p>
                  The code related to this section can be found on <a
                  href="https://github.com/irajhedayati/mcit/tree/master/zk">GitHub</a>.
                </p>
                <iframe
                  allow="fullscreen"
                  height="569" src="https://docs.google.com/presentation/d/e/2PACX-1vQ4c_y7IjxY6iCXgSCFSLdmXLx1VAWZjr1S7NBiSVsypje0cVmaNx_cJyZHjNbzQRaoh0smwM62WLXb/embed?start=false&loop=false&delayms=3000" title="Zookeeper Introduction"
                  width="960">
                </iframe>
                <h4>Installing Apache Zookeeper</h4>
                <p>
                  Apache Zookeeper distribution includes both server and CLI binaries. This guide covers only
                  Linux environment. For Mac and Windows, there are a couple of tweaks to do.
                </p>
                <h5>Download Apache Zookeeper</h5>
                <p>
                  Go to <a href="https://zookeeper.apache.org/releases.html">Apache Zookeeper Release</a> page
                  and follow the steps to download the revision that you need. You will get a TAR file.
                </p>
                <pre><code>
                            mkdir -p ~/opt
                            mv ~/Downloads/zookeeper-*.tar.gz ~/opt/
                            cd ~/opt
                            tar -xf zookeeper-*.tar.gz
                            mv ./zookeeper-*/ ./zookeeper
                        </code></pre>
                <p>Then open <code>~/.bashrc</code> file and add the following lines.</p>
                <pre><code>
                            export ZOOKEEPER_HOME=~/opt/zookeeper
                            export PATH=$PATH:$ZOOKEEPER_HOME/bin
                        </code></pre>
                <p>Then finish it by running <code>source ~/.bashrc</code></p>
                <h5>Run Zookeeper Server locally</h5>
                <p>
                  Open <code>$ZOOKEEPER_HOME/conf/zoo.cfg</code> file (if doesn't exist, create one) and add
                  the following lines
                </p>
                <pre><code>
                            tickTime=2000
                            dataDir=$ZOOKEEPER_HOME/data
                            clientPort=2181
                        </code></pre>
                <p>Run the server <code>zkServer.sh start</code></p>
                <h5>Run Zookeeper CLI</h5>
                <p>
                  In order to run the Zookeeper CLI, just execute <code>zkCli.sh -server localhost:2181</code>.
                </p>

                <h3>Leader Election in Distributed Environment</h3>
                <iframe
                  allow="fullscreen"
                  height="569" src="https://docs.google.com/presentation/d/e/2PACX-1vQwb-aJa7gLMlwiIOLtPwYpLOMfUxzieA8q97s6zqXCsXXdKFIo44hzmfM7l3NKO4BQK7mKdMvwxHcV/embed?start=false&loop=false&delayms=3000" title="Leader Election with Zookeeper"
                  width="960">
                </iframe>
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

export default {
  components: { IrajTab, Banner, IrajTabs }
}
</script>
