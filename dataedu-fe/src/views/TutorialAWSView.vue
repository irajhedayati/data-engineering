<template>
  <Banner
    caption="Amazon Web Services (AWS) is the world’s most comprehensive and broadly adopted cloud platform, offering over 175 fully featured services from data centers globally."
    title="Cloud Computing with AWS"
  />
  <section id="content">
    <div class="wrapper doc">
      <iraj-tabs>
        <iraj-tab :selected="true" name="Introduction">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <blockquote class="blockquote">
                  <p class="mb-0">AWS infrastructure: https://www.infrastructure.aws</p>
                </blockquote>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vTekiS2wKxH3A4NY4F3sDwq4m16PnYiqOwHS7MtMW8mds-Q502968ttnMd0hQXKXYuKUhocvZdIvSHc/embed?start=false&loop=false&delayms=3000"
                  title="An introduction to Cloud Computing" width="960"></iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <p></p>
                <h4>How to use AWS educate</h4>

                <p>A classroom is created on
                  <a href="https://aws.amazon.com/education/awseducate/">AWS educate</a> is created
                  and an invitation is sent to your email address. Follow the steps to create an account
                  and enroll to the class.
                </p>

                <p>
                  Everytime that you need to practice and execute labs, just follow these steps
                </p>
                <h3>Go to your classroom</h3>
                <p>
                  Once logged in, on top menu bar click on <strong>
                  <mark>myClassroom</mark>
                </strong>.
                </p>
                <p><img alt="AWS Educate home page" class="mr-3"
                        height="412" src='@/assets/images/aws-educate-1.png' width="650"></p>
                <p>
                  Find the class you enrolled and click on the blue button of
                  <strong>
                    <mark>Go to classroom</mark>
                  </strong>
                </p>
                <p><img alt="AWS Educate classroom list" class="mr-3"
                        height="412" src='@/assets/images/aws-educate-2.png' width="650"></p>
                <h3>Go to your AWS console</h3>
                <p>
                  Once in the class room, click on <strong>
                  <mark>AWS Console</mark>
                </strong> to go to
                  the AWS console. Bear in mind that it is not your AWS account and could have some
                  limitations.
                </p>
                <p><img alt="AWS educate classrooms" class="mr-3"
                        height="412" src='@/assets/images/aws-educate-3.png' width="650"></p>
              </div>
            </div>
          </div>
        </iraj-tab>
        <iraj-tab name="Infrastructure">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569" src="https://docs.google.com/presentation/d/e/2PACX-1vQFLrjYJyXy9gP5__-8waIXWNO2LQuxtH1Y9bVJG8T8RUKix_X8CPc0ifostkkg1EUEPUhcMg--R8Nm/embed?start=false&loop=false&delayms=3000" title="Deploy infrastructure" width="960"></iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569" src="https://docs.google.com/presentation/d/e/2PACX-1vRB-g_0byX0IHunGrFIkMUOrwEiIXdbyZRm5TpVZijB1bCF_BI9BGpE-_zuWkPGUTkPpeDBaYo4luzh/embed?start=false&loop=false&delayms=3000" title="Deploy infrastructure" width="960"></iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h4>Connect to a private subnet</h4>
                <p>
                  Here we have an architecture of a two-tier application in which there is a public
                  subnet with an instance running your web server which also has a public IP and a private
                  subnet with an instance running your DB server and is not reachable from outside.
                  <img alt="Private and Pubic subnets"
                       height="412" src='@/assets/images/private-public-subnets.png' width="650"/>
                </p>
                <p>
                  To connect to the instances in the private subnets, we use a special instance called
                  <mark>bastion host</mark>
                  . To more about them, refer to
                  <a href="https://aws.amazon.com/quickstart/architecture/linux-bastion/">AWS documentation</a>.
                </p>
                <p>
                  Here we take a simpler approach and we use the WS instance which is publicly accessible
                  as a "bastion host" to connect to the DB instance.
                  In order to connect to the DB instance in the private subnet,
                </p>
                <ol>
                  <li>Copy the private key associated to the DB instance to WS instance</li>
                  <li>Connect to the WS instance</li>
                  <li>From the WS instance, connect to the DB instance</li>
                </ol>
                <p>Assume that</p>
                <ul>
                  <li>both machines are running Ubuntu instances</li>
                  <li>the private key associated to WS instance is called <code>ws-private-key.pem</code></li>
                  <li>the private key associated to DB instance is called <code>db-private-key.pem</code></li>
                </ul>
                <pre><code>
                                local-user&#64;local-machine:~$ scp -i /path/to/ws-private-key.pem /path/to/db-private-key.pem ubuntu&#64;ws-ip:/home/ubuntu/
                                local-user&#64;local-machine:~$ ssh -i /path/to/ws-private-key.pem ubuntu&#64;ws-ip
                                ubuntu&#64;ws-ip:~$ ssh -i /home/ubuntu/db-private-key.pem ubuntu&#64;db-ip
                                ubuntu&#64;db-ip:~$
                            </code></pre>
              </div>
            </div>
          </div>
        </iraj-tab>
        <iraj-tab name="S3">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569" src="https://docs.google.com/presentation/d/e/2PACX-1vTWsrLCxgzOEA2TPadPeRXcpXfgMSTL6f8f8aBh3FLlL2E0ap0Z4jxMtFOnjbu10rv0rLpYbHWJeqVn/embed?start=false&loop=false&delayms=3000" title="Deploy infrastructure" width="960"></iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h4>Hosting static website on Amazon S3</h4>
                It is a fast, convenient and cost effective approach to host your static website
                on Amazon S3.
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen;accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                  height="569" src="https://www.youtube.com/embed/BfmpbAOaIy0"
                  title="Host static website on S3"
                  width="960"></iframe>
              </div>
            </div>
          </div>
        </iraj-tab>
        <iraj-tab name="EMR">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569" src="https://docs.google.com/presentation/d/e/2PACX-1vQSJe5wdf1i-rRTGmaUEJ_zRlJZfCHwHMY7QABwqnttf5iCtJ3Vpa815pm9t3sfKXIgB0Wue7dy-iO3/embed?start=false&loop=false&delayms=3000" title="EMR" width="960"></iframe>
              </div>
            </div>
          </div>
        </iraj-tab>
        <iraj-tab name="Kinesis">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569" src="https://docs.google.com/presentation/d/e/2PACX-1vQC6BRrgmd-2N-LJD5TenuzHW7nwtmBRSCXxy1ostPlnhpAW0f8JBXgjLULQzaTKf6mrUd5mJ8a_69u/embed?start=false&loop=false&delayms=3000" title="Kinesis" width="960"></iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <h3>A tutorial on AWS Kinesis Firehose delivery stream</h3>
                <p>
                  In this tutorial, we're trying to implement a data ingestion stream using an EC2
                  instance as the source producing messages using AWS Kinesis agent and a S3 bucket as
                  the destination.
                </p>
                <p>
                  The architecture of the implementation is drawn in the following diagram:
                  <img alt="Kinesis Firehose tutorial diagram"
                       height="650" src='@/assets/images/aws-firehose-tutorial.png' width="650"/>
                </p>
                <iframe
                  allow="fullscreen;accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                  height="569" src="https://www.youtube.com/embed/pxd1SZXFiZ0"
                  title="Kinesis Firehose tutorial"
                  width="960"></iframe>
                <p>
                  Here are links to the material used in this tutorial:
                </p>
                <ul>
                  <li><a href="https://docs.aws.amazon.com/firehose/latest/dev/writing-with-agents.html">AWS
                    documentation</a>
                    on how to install Kinesis agent. Make sure that you replace amzn2 with amzn1
                  </li>
                  <li><a href="https://docs.aws.amazon.com/general/latest/gr/ak.html">Kinesis endpoints</a></li>
                </ul>
                <p>
                  And here is the configuration put in <code>/etc/aws-kinesis/agent.json</code>
                </p>
                <pre><code>
                                {
                                    "firehose.endpoint": "https://kinesis.us-east-2.amazonaws.com",
                                    "flows": [
                                        {
                                            "filePattern": "/tmp/stop_times.csv",
                                            "deliveryStream": "kinesis-demo-fh-stream"
                                        }
                                    ]
                                }
                            </code></pre>
                <p>
                  and here is the commands to prepare data for Kinesis agent
                </p>
                <pre><code>
                                curl -o gtfs_stm.zip http://www.stm.info/sites/default/files/gtfs/gtfs_stm.zip
                                unzip gtfs_stm.zip
                                head -n 10 stop_times.txt
                                sed '1d' stop_times.txt > stop_times_without_header.csv
                                touch /tmp/stop_times.csv
                                head -n 10 stop_times_without_header.csv >> /tmp/stop_times.csv
                            </code></pre>
              </div>
            </div>
          </div>
        </iraj-tab>
      </iraj-tabs>
    </div>
  </section>
</template>
<script>
import Banner from '@/components/Banner.vue'
import IrajTabs from '@/components/IrajTabs.vue'
import IrajTab from '@/components/IrajTab.vue'

export default {
  components: { Banner, IrajTabs, IrajTab }
}
</script>
