<template>
  <section class="home-hero">
    <div class="container">
      <span class="eyebrow hero-label"><span></span> YOUR EVERYDAY DATA COMPANION</span>
      <h1>Big data.<br>Clearer thinking.</h1>
      <p class="hero-description">Practical tools and hands-on tutorials for the work<br class="d-none d-md-inline"> you do every day. Learn it. Try it. Build with it.</p>
      <div class="hero-actions"><router-link to="/tools" class="btn btn-primary btn-lg">Explore the tools <i class="bi bi-arrow-up-right ms-2" aria-hidden="true"></i></router-link><a href="#tutorials" class="btn btn-outline-dark btn-lg">Start learning</a></div>
      <p class="hero-note">Made by a data engineer. Shared with everyone.</p>
      <div class="workspace-preview" aria-label="Preview of the DataEdu toolkit">
        <aside class="preview-sidebar"><span class="preview-brand"><i class="bi bi-layers-fill" aria-hidden="true"></i> DataEdu</span><span class="preview-active"><i class="bi bi-grid" aria-hidden="true"></i> Workspace</span><router-link to="/json"><i class="bi bi-braces" aria-hidden="true"></i> JSON editor</router-link><router-link to="/tools"><i class="bi bi-tools" aria-hidden="true"></i> General tools</router-link><router-link to="/tutorials/introduction"><i class="bi bi-book" aria-hidden="true"></i> Tutorials</router-link><span class="preview-sidebar-note">A little less friction.<br>A lot more building.</span></aside>
        <div class="preview-main"><div class="preview-toolbar"><span>Your everyday toolkit</span><span class="preview-dots" aria-hidden="true">•••</span></div><div class="preview-heading"><div><span class="eyebrow">LET’S MAKE IT SIMPLE</span><h2>From bytes to possibilities.</h2></div><span class="preview-check" aria-hidden="true"><i class="bi bi-check-lg"></i></span></div><div class="preview-code"><div><span>HEX INPUT</span><code>48 65 6c 6c 6f 2c 20 64 61 74 61 21</code></div><i class="bi bi-arrow-down" aria-hidden="true"></i><div><span>DECODED TEXT</span><strong>Hello, data!</strong></div></div><div class="preview-bottom"><span><i class="bi bi-check-circle-fill" aria-hidden="true"></i> Small tools. Useful results.</span><router-link to="/tools#hex-to-text">Try Hex to Text <i class="bi bi-arrow-right" aria-hidden="true"></i></router-link></div></div>
      </div>
      <div class="technology-strip" aria-label="Tutorial topics"><span>Built around the tools you use</span><div><strong>Apache Kafka</strong><strong>Spark<span class="tech-star">✳</span></strong><strong>Hadoop</strong><strong>Hive</strong><strong>aws</strong></div></div>
    </div>
  </section>
  <section id="tutorials" class="learning-section">
    <div class="container"><div class="section-heading"><span class="eyebrow">LESS THEORY ALONE. MORE HANDS-ON.</span><h2>A good place to<br>build your understanding.</h2><p>Notes, examples, and practical guides from my day-to-day work.<br class="d-none d-md-inline"> Pick a topic and start exploring.</p></div>
      <div class="row g-4">
        <tutorial-cell title="Start with the foundations" link="/tutorials/introduction" icon="bi bi-compass" description="Find your bearings in data science, data engineering, and business intelligence." />
        <tutorial-cell title="Hadoop & Zookeeper" link="/tutorials/hadoop" icon="bi bi-hdd-network" description="Explore distributed storage, cluster coordination, and processing data at scale." />
        <tutorial-cell title="Hive" link="/tutorials/hive" icon="bi bi-database" description="Bring familiar SQL to large datasets in distributed storage." />
        <tutorial-cell title="Kafka & Schema Registry" link="/tutorials/kafka" icon="bi bi-diagram-3" description="Get hands-on with event streams, messaging, and the schemas that connect them." />
        <tutorial-cell title="Apache Spark" link="/tutorials/spark" icon="bi bi-lightning-charge" description="Work through the building blocks of distributed data processing." />
        <tutorial-cell title="Cloud & AWS" link="/tutorials/aws" icon="bi bi-cloud" description="Explore cloud services and practical patterns for your data projects." />
      </div>
    </div>
  </section>
  <section class="container"><div class="home-callout"><div><span class="eyebrow">LESS BUSYWORK. MORE PROGRESS.</span><h2>The right little tool,<br>right when you need it.</h2><p>Format JSON, work with Avro, decode hex, and more.</p></div><router-link to="/tools" class="btn btn-primary btn-lg">Open the toolkit <i class="bi bi-arrow-up-right ms-2" aria-hidden="true"></i></router-link></div></section>
</template>
<script>
import TutorialCell from '@/components/TutorialCell.vue'
export default { name: 'HomeView', components: { TutorialCell } }
</script>
