<template>
  <Banner
    caption='The Apache Hive data warehouse software facilitates reading, writing, and managing large datasets residing in distributed storage using SQL.'
    title='Apache Hive'
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
                  src="https://docs.google.com/presentation/d/e/2PACX-1vSdrD0gPuLBfMr7_kRLD24kks0j-URmBMCSwXcwPPeK9AdeNMWsmYXQusyAlT25oz7NeYbOl3vQ-qHZ/embed?start=false&loop=false&delayms=3000"
                  title="Hive Introduction" width="960">
                </iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="HiveQL - Basics">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vRaU4jpTzkU4I0ESu3A9nHSdDiGuzbgrG-TbURhfmHtD_hZfVqN8_AdCrzAluzeGTFjV_rWwznobt8i/embed?start=false&loop=false&delayms=3000"
                  title="HiveQL Basics" width="960">
                </iframe>

                <h4>Tutorial</h4>
                <HiveSQLBasicsGist />

                <p>
                  By default, Hive uses the Hadoop configuration to decide how to run the jobs (normally it is
                  YARN). If you are trying to run interactive queries on very small data, that might have been
                  an overkill and will slow you down. In order to use the local mode, you need to set the
                  following configuration:
                </p>
                <pre><code>
                            SET mapreduce.framework.name=local;
                            SET hive.exec.mode.local.auto=false;
                        </code></pre>
                <p>
                  For more information, refer to
                  <a
                    href="https://cwiki.apache.org/confluence/display/Hive/GettingStarted#GettingStarted-Hive,Map-ReduceandLocal-Mode">
                    Apache Hive Wiki</a>
                </p>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Encoding">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vTOMs2YQrWp2uX3uzIeiAqwYig92LhsyNwujDQt7cTXxxV8O5etk6m6F2yElHdzpnNX6BXiWonNcqfm/embed?start=false&loop=false&delayms=3000"
                  title="HiveQL Encoding" width="960">
                </iframe>

                <h4>Tutorial</h4>

                <EncodingGist />

                <h4>How to make Hive to write compressed files</h4>
                <p>
                  You need to set the following properties in your Hive session. Run the commands in your CLI
                  or JDBC connection:
                </p>
                <pre><code>
                            set hive.exec.compress.output=true;
                            set mapreduce.output.fileoutputformat.compress.codec=org.apache.hadoop.io.compress.GzipCodec;
                        </code></pre>

                <p>
                  If you are using Hue, you can set settings in your editor:
                  <!--suppress CheckImageSize -->
                  <img alt="Setting Hive compression in Hue UI" class="mr-3" height="360" src='@/assets/images/hive-hue-settings.png'
                       width="1024">
                </p>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Programming">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vQ1WR1mBgZ93XQJIdnZ_5i3xmkguC-avPiZhPVxNzRF7p4M33J1zN2SbclckVJyjSkSnI9CFe7SppEi/embed?start=false&loop=false&delayms=3000"
                  title="Programming with Hive" width="960">
                </iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="HiveQL Advanced">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vRGu2k9YrG1jl6HbSqZL79Ve39P3U6dpj9tyA90MZkbyct8X4dzyX6dZat7vNTZDxoQJMRcIMRsRdEf/embed?start=false&loop=false&delayms=3000"
                  title="HiveQL Advanced" width="960">
                </iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Sharding">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vTp0kgBMhtnkdKKk7FfdnrOGKVJQVtQWJxod01yspg0P7lNRsVN0ysj6uxsLkB8kIVJZtbiDtfngX_N/embed?start=false&loop=false&delayms=3000"
                  title="Sharding and Partitioning in Hive" width="960">
                </iframe>

                <h1 id="practice-sharding-in-hive">Practice sharding in Hive</h1>
                <p>Sharding is implemented in Hive using <strong>partitioning</strong> concept.</p>
                <p>The sample files are taken from <a
                  href="https://lagunita.stanford.edu/courses/DB/2014/SelfPaced/about">Stanford Online Education</a>.</p>
                <h2 id="prerequisite">Prerequisite</h2>
                <p>In this section we assume you have practiced Hive Encoding. We will re-use </p>
                <ul>
                  <li>The database we created called <code>your_name</code></li>
                  <li>The table we created called <code>enriched_movie</code> (doesn&#39;t matter what encodings you
                    have used)
                  </li>
                  <li>The schema-on-read concept</li>
                </ul>
                <h2 id="create-a-partitioned-table">Create a partitioned table</h2>
                <pre><code class="lang-sql"><span class="hljs-keyword">CREATE</span> <span
                  class="hljs-keyword">TABLE</span> your_name.enriched_movie_p (
  <span class="hljs-keyword">mid</span> <span class="hljs-built_in">int</span>,
  title <span class="hljs-keyword">STRING</span>,
  director <span class="hljs-keyword">STRING</span>,
  rid <span class="hljs-built_in">int</span>,
  stars <span class="hljs-built_in">int</span>,
  ratingdate <span class="hljs-keyword">STRING</span>
)
PARTITIONED <span class="hljs-keyword">BY</span> (<span class="hljs-keyword">year</span> <span
                    class="hljs-built_in">int</span>)
<span class="hljs-keyword">stored</span> <span class="hljs-keyword">as</span> PARQUET
tblproperties(<span class="hljs-string">"parquet.compression"</span>=<span class="hljs-string">"GZIP"</span>);
</code></pre>
                <p>As you can see, it has exactly the same structure of &quot;parquet&quot; encoding table with &quot;GZip&quot;
                  compression
                  except the <code>year</code> column that now is in the new clause of <code>PARTITIONED BY</code>.</p>
                <p>Let&#39;s check the structure:</p>
                <pre><code class="lang-sql">DESCRIBE FORMATTED <span class="hljs-keyword">TABLE</span> your_name.enriched_movie_p
</code></pre>
                <h2 id="populate-the-partitioned-table">Populate the partitioned table</h2>
                <pre><code class="lang-sql">
<span class="hljs-keyword">INSERT</span> <span class="hljs-keyword">INTO</span> your_name.enriched_movie_p <span
                  class="hljs-keyword">PARTITION</span>(<span class="hljs-keyword">year</span>)
<span class="hljs-keyword">SELECT</span> * <span class="hljs-keyword">FROM</span> enriched_movie
                        </code></pre>
                <p>The query won&#39;t work if Hive is configured in the strict mode. It makes sens as we do
                  partitioning (sharding)
                  when the table is big. Hence, you wouldn&#39;t normally run a query that works possibly on all the
                  partitions.
                  However, if you really know what you&#39;re doing, in this case we know the data is not &quot;big&quot;,
                  you could turn it off.</p>
                <p>In a Hive connection (CLI or JDBC) just run the following commands:</p>
                <pre><code class="lang-sql">
set hive.exec.dynamic.partition=nonstrict;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.mapred.mode=nonstrict;
                        </code></pre>
                <p>If you are working with Hue, you could set the settings in your current session by clicking on
                  the gear icon on top-right of the page right above the query text box.</p>
                <p>Now run the query again. If successful, then run the following command to list the partitions.</p>
                <pre><code class="lang-sql"><span class="hljs-keyword">SHOW</span> <span
                  class="hljs-keyword">PARTITIONS</span> your_name.enriched_movie_p
</code></pre>
                <p>As you observe, the list of partitions is not quite right. Try to identify the problem!</p>
                <p>The problem is due the mismatch in the list of columns. As discussed in the encoding section,
                  Hive follows the concept of schema on read. Hence, it won&#39;t apply the schema during the write
                  operation.
                  The query, will use the following mapping of the columns:</p>
                <table>
                  <caption>Partition comes last in the data</caption>
                  <thead>
                  <tr>
                    <th id="table-partition-source">source</th>
                    <th id="table-partition-destination">destination</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>mid</td>
                    <td>mid</td>
                  </tr>
                  <tr>
                    <td>title</td>
                    <td>title</td>
                  </tr>
                  <tr>
                    <td>director</td>
                    <td>director</td>
                  </tr>
                  <tr>
                    <td>year</td>
                    <td>rid</td>
                  </tr>
                  <tr>
                    <td>rid</td>
                    <td>stars</td>
                  </tr>
                  <tr>
                    <td>stars</td>
                    <td>ratingdate</td>
                  </tr>
                  <tr>
                    <td>ratingdate</td>
                    <td>year</td>
                  </tr>
                  </tbody>
                </table>
                <p>That makes Hive to partition data based on <code>ratingdate</code> when it writes the data not the
                  <code>year</code>.
                  You will also see <code>null</code> values in incompatible fields. Find them.</p>
                <p>In Hive, the proper way is to mention all the fields explicitly to avoid such bugs.</p>
                <p>Drop the table and create it again.
                  This time, we will create table as text in order to be able to see the contents.</p>
                <pre><code class="lang-sql"><span class="hljs-keyword">DROP</span> <span
                  class="hljs-keyword">TABLE</span> your_name.enriched_movie_p;

<span class="hljs-keyword">CREATE</span> <span class="hljs-keyword">TABLE</span> your_name.enriched_movie_p (
  <span class="hljs-keyword">mid</span> <span class="hljs-built_in">int</span>,
  title <span class="hljs-keyword">STRING</span>,
  director <span class="hljs-keyword">STRING</span>,
  rid <span class="hljs-built_in">int</span>,
  stars <span class="hljs-built_in">int</span>,
  ratingdate <span class="hljs-keyword">STRING</span>
)
PARTITIONED <span class="hljs-keyword">BY</span> (<span class="hljs-keyword">year</span> <span
                    class="hljs-built_in">int</span>)
<span class="hljs-keyword">ROW</span> <span class="hljs-keyword">FORMAT</span> <span
                    class="hljs-keyword">DELIMITED</span>
<span class="hljs-keyword">FIELDS</span> <span class="hljs-keyword">TERMINATED</span> <span
                    class="hljs-keyword">BY</span> <span class="hljs-string">','</span>
<span class="hljs-keyword">STORED</span> <span class="hljs-keyword">AS</span> TEXTFILE;
</code></pre>
                <p>Now we can populate the table. Note that <code>WHERE year&lt;2000</code> filters data. We will
                  practice another
                  concept in the next section with the rest of the data.</p>
                <pre><code class="lang-sql"><span class="hljs-keyword">INSERT</span> OVERWRITE <span
                  class="hljs-keyword">TABLE</span> your_name.enriched_movie_p <span
                  class="hljs-keyword">PARTITION</span>(<span class="hljs-keyword">year</span>)
<span class="hljs-keyword">SELECT</span>
    <span class="hljs-keyword">mid</span>,
    title,
    director,
    rid,
    stars,
    ratingdate,
    <span class="hljs-keyword">year</span>
<span class="hljs-keyword">FROM</span> enriched_movie
<span class="hljs-keyword">WHERE</span> <span class="hljs-keyword">year</span>&lt;<span class="hljs-number">2000</span>
</code></pre>
                <p>Run <code>SHOW PARTITIONS your_name.enriched_movie_p</code> to see if the procedure was successful.
                </p>
                <h2 id="file-structure">File structure</h2>
                <p>Run <code>hdfs dfs -ls /user/hive/warehouse/your_name.db/enriched_movie_p/</code> to see the list of
                  partitions.
                  Go through the sub-directories to get to the files. You could validate the content of the files
                  using <code>hdfs dfs -cat ...</code> command.</p>
                <h2 id="load-data-to-the-table-directly">Load data to the table directly</h2>
                <p>In the previous section, we loaded the data using a SQL query ran directly through Hive server.
                  You were able to see the files and metadata (using <code>SHOW PARTITIONS</code>) right after.</p>
                <p>Another way is to load the data directly through the HDFS. As discussed, the path to the
                  partition is <code>/path/to/hive/warehouse/db_name.db/table_name/partition_column_name=partition_column_value</code>.
                  For example, <code>/user/warehouse/your_name.db/enriched_movie_p/year=1976</code>.
                  The files under this firectory on HDFS hold the data of the partition.</p>
                <p>In order to load the data using HDFS, let&#39;s create a directory for a partition that doesn&#39;t
                  exist
                  and upload the data. Note the data that have the same schema without year.</p>
                <pre><code
                  class="lang-bash">hadoop fs -mkdir -p /user/hive/warehouse/iraj.db/enriched_movie_p/year=<span
                  class="hljs-number">2009</span>
cat &lt;&lt;<span class="hljs-literal">EOF</span> &gt;~/enriched_movie_2009
<span class="hljs-number">107</span>,Avatar,James Cameron,<span class="hljs-number">206</span>,<span
                    class="hljs-number">3</span>,<span class="hljs-number">2011</span><span
                    class="hljs-number">-01</span><span class="hljs-number">-15</span>
<span class="hljs-number">107</span>,Avatar,James Cameron,<span class="hljs-number">207</span>,<span
                    class="hljs-number">5</span>,<span class="hljs-number">2011</span><span
                    class="hljs-number">-01</span><span class="hljs-number">-20</span>
<span class="hljs-literal">EOF</span>
hadoop fs -copyFromLocal ~/enriched_movie_2009 /user/hive/warehouse/iraj.db/enriched_movie_p/year=<span
                    class="hljs-number">2009</span>/
</code></pre>
                <p>Try to see if the partition is detected by the Hive:</p>
                <pre><code class="lang-sql"><span class="hljs-keyword">SHOW</span> <span
                  class="hljs-keyword">PARTITIONS</span> your_name.enriched_movie_p;
<span class="hljs-keyword">SELECT</span> * <span class="hljs-keyword">FROM</span> your_name.enriched_movie_p;
</code></pre>
                <p>You won&#39;t be able to see the new set of data. The reason is that you have updated the underlying
                  data
                  storeage but not the Hive metastore and partitions are part of the metadata. In order to get the
                  partitions:</p>
                <pre><code class="lang-sql">MSCK <span class="hljs-keyword">REPAIR</span> <span class="hljs-keyword">TABLE</span> your_name.enriched_movie_p;
<span class="hljs-keyword">SHOW</span> <span class="hljs-keyword">PARTITIONS</span> your_name.enriched_movie_p;
<span class="hljs-keyword">SELECT</span> * <span class="hljs-keyword">FROM</span> your_name.enriched_movie_p;
</code></pre>

              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Nested Types">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <h4>Collection Data Types</h4>
                <table class="table table-bordered">
                  <caption>Collection Types in Hive</caption>
                  <thead>
                  <tr>
                    <th id="table-collection-type">Type</th>
                    <th id="table-collection-size">Size</th>
                    <th id="table-collection-syntax">Literal Syntax Examples</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>STRUCT</td>
                    <td>Analogous to a C struct or an “object.” Fields can be accessed using the “dot” notation.
                      For example, if a column name is of type <code>STRUCT {first STRING; last STRING}</code>,
                      then the first name field can be referenced using <code>name.first</code>.
                    </td>
                    <td><code>struct(‘John’, ‘Doe’)</code></td>
                  </tr>
                  <tr>
                    <td>MAP</td>
                    <td>A collection of key-value tuples, where the fields are accessed using array notation
                      (e.g., <code>['key']</code>). For example, if a column name is of type MAP with
                      <strong>key→value</strong> pairs<code>'first'→'John'</code> and <code>'last'→'Doe'</code>,
                      then the last name can be referenced using <code>name['last']</code>.
                    </td>
                    <td><code>map(‘first’, ‘John’, ‘last’, ‘Doe’)</code></td>
                  </tr>
                  <tr>
                    <td>ARRAY</td>
                    <td>Ordered sequences of the same type that have zero-based indices. For example,
                      if a column name is of type ARRAY of strings with the value <code>['John', 'Doe']</code>,
                      then the second element can be referenced using <code>name[1]</code>.
                    </td>
                    <td><code>array(‘John’, ‘Doe’)</code></td>
                  </tr>
                  </tbody>
                </table>
                <h4>Tutorial</h4>
                <NestedTypesGist />
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
import HiveSQLBasicsGist from '@/components/HiveSQLBasicsGist.vue'
import EncodingGist from '@/components/EncodingGist.vue'
import NestedTypesGist from '@/components/NestedTypesGist.vue'

export default {
  components: { Banner, IrajTabs, IrajTab, HiveSQLBasicsGist, EncodingGist, NestedTypesGist }
}
</script>
