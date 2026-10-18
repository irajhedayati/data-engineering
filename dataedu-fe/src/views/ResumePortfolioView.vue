<template>
  <section class="portfolio-shell">
    <div class="container portfolio-container">
      <header class="resume-intro">
        <div class="intro-identity">
          <img class="profile-photo" src="@/assets/images/portfolio/iraj-hedayati.jpg" alt="Iraj Hedayati" width="112" height="112" />
          <div>
            <p class="eyebrow">Engineer. Educator. Builder.</p>
            <h1>Iraj Hedayati<span class="name-period">.</span></h1>
            <p class="intro-location">Data engineer &amp; architect <span aria-hidden="true">/</span> Montreal, Canada</p>
          </div>
        </div>
        <p class="intro-copy">I build practical tools and dependable data systems. Here’s a selection of what I’ve made, followed by the experience behind it.</p>
        <div class="intro-bottom">
          <nav class="resume-nav" aria-label="Resume sections">
            <a href="#projects">Selected projects <i class="bi bi-arrow-down" aria-hidden="true"></i></a>
            <a href="#experience">Experience</a>
            <a href="#skills">Skills</a>
          </nav>
          <div class="intro-socials">
            <a href="https://www.linkedin.com/in/irajhedayati/" target="_blank" rel="noopener noreferrer">LinkedIn <i class="bi bi-arrow-up-right" aria-hidden="true"></i></a>
            <a href="https://github.com/irajhedayati/" target="_blank" rel="noopener noreferrer">GitHub <i class="bi bi-arrow-up-right" aria-hidden="true"></i></a>
          </div>
        </div>
      </header>

      <section id="projects" class="projects-section" aria-labelledby="projects-title">
        <div class="projects-heading">
          <div><p class="section-kicker">Selected work / 01</p><h2 id="projects-title">Ideas, built into tools.</h2></div>
          <p>From developer workflows<br class="desktop-break" /> to everyday collections.</p>
        </div>
        <article class="featured-project" aria-labelledby="kassandra-title">
          <div class="featured-copy">
            <div class="project-status"><span class="featured-label">Featured project</span><span>Open source</span></div>
            <div class="project-symbol" aria-hidden="true"><i class="bi bi-database"></i></div>
            <h3 id="kassandra-title">Kassandra</h3>
            <p class="project-subtitle">A clearer view of Cassandra.</p>
            <p class="project-description">A graphical client for Apache Cassandra. Explore schemas, browse and edit data, and write CQL in one focused workspace.</p>
            <ul class="project-tags" aria-label="Kassandra technologies"><li>React</li><li>TypeScript</li><li>Node.js</li><li>Cassandra</li></ul>
            <div class="project-actions">
              <a class="project-primary" href="https://irajhedayati.github.io/kassandra/" target="_blank" rel="noopener noreferrer" aria-label="Explore Kassandra">Explore project <i class="bi bi-arrow-up-right" aria-hidden="true"></i></a>
              <a href="https://github.com/irajhedayati/kassandra" target="_blank" rel="noopener noreferrer" aria-label="View Kassandra source on GitHub"><i class="bi bi-github" aria-hidden="true"></i> Source code</a>
            </div>
          </div>
          <figure class="project-preview">
            <div class="preview-caption"><span><i class="bi bi-window" aria-hidden="true"></i> Inside Kassandra</span><span>Data browser</span></div>
            <a href="https://irajhedayati.github.io/kassandra/" target="_blank" rel="noopener noreferrer" aria-label="Explore the Kassandra data browser">
              <img src="@/assets/images/portfolio/kassandra.png" alt="Kassandra interface showing the schema explorer, column filters, and paginated Cassandra records" width="1687" height="688" />
            </a>
            <figcaption>Explore schemas. Work with data. Stay in flow.</figcaption>
          </figure>
        </article>
        <div class="supporting-projects">
          <article class="project-card" aria-labelledby="metal-title">
            <div class="project-card-top"><span class="project-symbol metal-symbol" aria-hidden="true"><i class="bi bi-box-seam"></i></span><span class="project-type">Independent product · Closed source</span></div>
            <h3 id="metal-title">Metal Earth Tracker</h3>
            <p class="project-subtitle">A little order for a growing collection.</p>
            <p class="project-description">Keep track of the models you own, the ones you’ve built, and what’s next. A dedicated home for a hobby, without the spreadsheet.</p>
            <div class="collection-flow" aria-label="Track models from wishlist to owned to built"><span><i class="bi bi-bookmark" aria-hidden="true"></i> Wishlist</span><i class="bi bi-arrow-right" aria-hidden="true"></i><span><i class="bi bi-box" aria-hidden="true"></i> Owned</span><i class="bi bi-arrow-right" aria-hidden="true"></i><span><i class="bi bi-check2-circle" aria-hidden="true"></i> Built</span></div>
            <div class="project-actions"><a class="project-primary" href="https://metalearthtracker.com" target="_blank" rel="noopener noreferrer" aria-label="Visit Metal Earth Tracker">Visit website <i class="bi bi-arrow-up-right" aria-hidden="true"></i></a><span class="private-source"><i class="bi bi-lock" aria-hidden="true"></i> Private source</span></div>
          </article>
          <article class="project-card" aria-labelledby="savro-title">
            <div class="project-card-top"><span class="project-symbol savro-symbol" aria-hidden="true"><i class="bi bi-braces"></i></span><span class="project-type">Open source · Scala library</span></div>
            <h3 id="savro-title">SAvro</h3>
            <p class="project-subtitle">Less friction. More Scala. Better Avro.</p>
            <p class="project-description">A Scala toolkit for Apache Avro: infer schemas from JSON, convert between schemas and IDL, and turn case classes into Avro records.</p>
            <div class="code-sample"><span>SCALA / APACHE AVRO</span><code><span class="code-keyword">import</span> ca.dataedu.savro._</code></div>
            <div class="project-actions"><a class="project-primary" href="https://savro.dataedu.ca/" target="_blank" rel="noopener noreferrer" aria-label="Read SAvro documentation">Documentation <i class="bi bi-arrow-up-right" aria-hidden="true"></i></a><a href="https://github.com/irajhedayati/savro" target="_blank" rel="noopener noreferrer" aria-label="View SAvro source on GitHub"><i class="bi bi-github" aria-hidden="true"></i> Source code</a></div>
          </article>
        </div>
      </section>

      <div class="resume-divider"><span>The experience behind the work</span><i class="bi bi-arrow-down" aria-hidden="true"></i></div>
      <div class="quick-facts">
        <span v-for="fact in quickFacts" :key="fact.label" class="fact-pill"><strong>{{ fact.value }}</strong><span>{{ fact.label }}</span></span>
      </div>
      <div class="section-block">
        <div class="section-heading">
          <p class="section-kicker">Profile in a sentence</p>
          <h2>Experienced, pragmatic, and people-oriented</h2>
        </div>
        <div class="row g-4">
          <div v-for="item in profileTraits" :key="item.title" class="col-md-6 col-xl-4">
            <div class="trait-card h-100">
              <div class="trait-icon"><i :class="item.icon"></i></div>
              <h3 class="h5">{{ item.title }}</h3>
              <p class="mb-0 text-muted">{{ item.description }}</p>
            </div>
          </div>
        </div>
      </div>

      <div id="skills" class="section-block">
        <div class="section-heading">
          <p class="section-kicker">Core strengths</p>
          <h2>What stands out across the resume</h2>
        </div>
        <div class="row g-4">
          <div v-for="skill in skills" :key="skill.title" class="col-md-6 col-xl-4">
            <div class="skill-card h-100">
              <div class="skill-topline"></div>
              <h3 class="h5">{{ skill.title }}</h3>
              <p class="text-muted mb-0">{{ skill.description }}</p>
            </div>
          </div>
        </div>
      </div>

      <div id="experience" class="section-block">
        <div class="section-heading">
          <p class="section-kicker">Career snapshot</p>
          <h2>Selected roles and impact</h2>
        </div>
        <div class="timeline">
          <article v-for="job in experience" :key="job.role" class="timeline-item">
            <div class="timeline-marker"></div>
            <div class="timeline-card">
              <div class="d-flex flex-wrap justify-content-between gap-2 align-items-start mb-2">
                <div>
                  <p class="timeline-role mb-1">{{ job.role }}</p>
                  <p class="timeline-company mb-0">{{ job.company }}</p>
                </div>
                <div class="timeline-meta text-end">
                  <div>{{ job.period }}</div>
                  <div class="text-muted">{{ job.location }}</div>
                </div>
              </div>
              <p class="text-muted mb-3">{{ job.summary }}</p>
              <ul class="timeline-list mb-0">
                <li v-for="bullet in job.highlights" :key="bullet">{{ bullet }}</li>
              </ul>
            </div>
          </article>
        </div>
      </div>

      <div class="row g-4 section-block">
        <div class="col-lg-7">
          <div class="section-heading">
            <p class="section-kicker">Teaching and research</p>
            <h2>Long-running educator energy</h2>
          </div>
          <div class="spotlight-card h-100">
            <p class="mb-3">
              The resume reads like someone who enjoys building systems, but also enjoys explaining how they work. That
              comes through in the instructor role, the mentorship history, and the research background.
            </p>
            <div v-for="education in educationHistory" :key="education.school" class="education-item">
              <div>
                <h3 class="h5 mb-1">{{ education.school }}</h3>
                <p class="text-muted mb-1">{{ education.degree }}</p>
              </div>
              <span class="education-year">{{ education.year }}</span>
            </div>
          </div>
        </div>

        <div class="col-lg-5">
          <div class="section-heading">
            <p class="section-kicker">Selected signals</p>
            <h2>Links and proof points</h2>
          </div>
          <div class="spotlight-card h-100">
            <div class="link-list">
              <a v-for="link in links" :key="link.label" class="link-row" :href="link.href" rel="noreferrer" target="_blank">
                <div>
                  <div class="link-label">{{ link.label }}</div>
                  <div class="text-muted small">{{ link.description }}</div>
                </div>
                <i class="bi bi-arrow-up-right"></i>
              </a>
            </div>
          </div>
        </div>
      </div>

      <div class="section-block">
        <div class="section-heading">
          <p class="section-kicker">Selected themes</p>
          <h2>How I’d frame the story</h2>
        </div>
        <div class="row g-4">
          <div v-for="highlight in highlights" :key="highlight.title" class="col-lg-6">
            <div class="highlight-card h-100">
              <p class="highlight-title">{{ highlight.title }}</p>
              <p class="mb-0 text-muted">{{ highlight.description }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
const quickFacts = [
  { value: '19 years', label: 'software engineering' },
  { value: '8 years', label: 'data engineering and big data' },
  { value: 'Montreal', label: 'based in Quebec' },
  { value: 'Instructor', label: 'Montreal College of IT since 2018' }
]

const profileTraits = [
  {
    icon: 'bi bi-gear-wide-connected',
    title: 'Systems thinker',
    description: 'Likes architecture that scales, stays observable, and reduces operational friction.'
  },
  {
    icon: 'bi bi-people',
    title: 'Mentor-minded',
    description: 'Repeatedly shows up as a team lead, teacher, and person who helps others level up.'
  },
  {
    icon: 'bi bi-lightbulb',
    title: 'Builder first',
    description: 'Comfortable moving from strategy to implementation, from whiteboard to working code.'
  }
]

const skills = [
  {
    title: 'Data architecture and engineering',
    description: 'ETL/ELT, batch and real-time processing, platform modernization, and large-scale data systems.'
  },
  {
    title: 'Streaming and distributed computing',
    description: 'Spark, Kafka, Flink, Dataflow, Apache Beam, Hive, HBase, Cassandra, BigQuery, Iceberg.'
  },
  {
    title: 'Cloud and platform tooling',
    description: 'AWS, GCP, Dataproc, EMR, GKE, Docker, Kubernetes, CI/CD, Terraform, and orchestration.'
  },
  {
    title: 'Governance and observability',
    description: 'DataHub-style cataloging, quality, lineage, monitoring, and durable operational practices.'
  },
  {
    title: 'Programming and implementation',
    description: 'Scala, Java, Python, Go, SQL, React, TypeScript, and backend services that actually ship.'
  },
  {
    title: 'Leadership and education',
    description: 'Team topology thinking, knowledge transfer, curriculum design, and hands-on mentorship.'
  }
]

const experience = [
  {
    role: 'Data Platform Backend Engineer (Contract)',
    company: 'Apple Inc. | Seattle, WA (Remote)',
    period: 'May 2025',
    location: 'Remote',
    summary: 'Worked on data infrastructure modernization across backend, orchestration, and self-service layers.',
    highlights: [
      'Maintained and extended Spark-based data pipelines to improve reliability and performance.',
      'Contributed to an orchestration service built with Spring Framework microservices.',
      'Worked across frontend and backend components of a self-service platform for internal teams.',
      'Used Docker, Kubernetes, Parquet, Iceberg, and Hive in a modern data-lake environment.'
    ]
  },
  {
    role: 'Lead Data Engineer',
    company: 'Wunderkind | New York, NY (Remote)',
    period: 'Nov 2021 - Apr 2025',
    location: 'Remote',
    summary: 'Built practical data systems spanning RAG, product feeds, operational tooling, and data cataloging.',
    highlights: [
      'Built a RAG pipeline with LangChain, Pinecone, and OpenAI embeddings.',
      'Designed a feed ingestion pipeline with Spark, Spark SQL, Dataproc Serverless, Scala, and Kubernetes.',
      'Introduced a control center for data quality and operations using React.',
      'Pioneered data cataloging and governance through DataHub adoption.'
    ]
  },
  {
    role: 'Data Engineer L3',
    company: 'Paytm Labs | Toronto, ON (remote)',
    period: 'Jul 2019 - Nov 2021',
    location: 'Remote',
    summary: 'Architected low-latency data pipelines and collaborative Kubernetes-based tooling.',
    highlights: [
      'Designed a real-time pipeline using microservices, Kafka, Akka Streams, Kubernetes, Scala, and Cassandra.',
      'Built a collaborative environment to control and monitor many Kafka and Akka Streams jobs in one deployment.'
    ]
  },
  {
    role: 'BI & DE Instructor',
    company: 'Montreal College of IT | Montreal, QC',
    period: 'Jun 2018 - Present',
    location: 'Montreal',
    summary: 'Teaches the Big Data Developer program, spanning Hadoop, Spark, Kafka, cloud, and distributed systems.',
    highlights: [
      'Designed and delivered curriculum covering distributed systems, SQL/NoSQL, streaming, and cloud data engineering.',
      'Developed the program to help students build job-ready skills for the market.'
    ]
  },
  {
    role: 'Data Team Lead',
    company: 'Guavus | Montreal, QC',
    period: 'Apr 2016 - Jul 2019',
    location: 'Montreal',
    summary: 'Led team growth, code quality, and real-time data systems for large-scale analytics pipelines.',
    highlights: [
      'Led the transition to Agile and Team Topologies practices.',
      'Built low-latency pipelines, real-time aggregations, and data enrichment services.',
      'Improved code quality and testing through SonarQube and better engineering practices.'
    ]
  },
  {
    role: 'Java Software Developer and Research Assistant',
    company: 'Dealflo and Concordia University | Montreal, QC',
    period: '2015 - 2016',
    location: 'Montreal',
    summary: 'Started from application engineering and research work in distributed systems and automata.',
    highlights: [
      'Built a full-stack e-signature portal and its test coverage.',
      'Researched map-reduce algorithms, DFA minimization, and skew handling in distributed systems.'
    ]
  }
]

const educationHistory = [
  {
    school: 'Concordia University, Montreal, Canada',
    degree: 'Masters in Computer Science',
    year: '2014 - 2016'
  },
  {
    school: 'Qazvin Azad University, Qazvin, Iran',
    degree: 'Masters in Software Engineering',
    year: '2010 - 2012'
  }
]

const links = [
  {
    label: 'LinkedIn',
    description: 'Public profile and network presence.',
    href: 'https://www.linkedin.com/in/irajhedayati/'
  },
  {
    label: 'GitHub',
    description: 'Code and technical work.',
    href: 'https://github.com/irajhedayati/'
  },
  {
    label: 'Medium',
    description: 'Writing, explanations, and longer-form thinking.',
    href: 'https://medium.com/@iraj.hedayati'
  },
  {
    label: 'YouTube',
    description: 'Talks and teaching content.',
    href: 'https://www.youtube.com/@IrajHedayati'
  },
  {
    label: 'Coursera',
    description: 'Learning trail and ongoing curiosity.',
    href: 'https://www.coursera.org/learner/iraj-hedayati'
  },
  {
    label: 'Personal site',
    description: 'The broader DataEdu home base.',
    href: 'http://www.dataedu.ca'
  }
]

const highlights = [
  {
    title: 'Builder with taste for real systems',
    description: 'The resume is strongest when it talks about pipelines, orchestration, infrastructure, and quality. That suggests someone who prefers working software over slideware.'
  },
  {
    title: 'Senior enough to lead, close enough to code',
    description: 'Across the roles, the pattern is consistent: architecture, hands-on implementation, and practical collaboration with frontend, backend, and platform teams.'
  },
  {
    title: 'Teacher energy is part of the brand',
    description: 'Teaching, mentoring, and knowledge transfer are not side notes here. They are central to the professional identity and a big part of the portfolio story.'
  },
  {
    title: 'Modern data stack fluency',
    description: 'Spark, Kafka, Kubernetes, GCP, AWS, Dataflow, Dataproc, BigQuery, Iceberg, and React all show up as tools used to solve real problems.'
  }
]
</script>

<style scoped>
.portfolio-shell { background: #fcfcfb; }
.portfolio-container { padding-top: 2.5rem; padding-bottom: 2rem; }
.resume-intro { padding-bottom: 2rem; border-bottom: 1px solid #e2e3dc; }
.intro-identity { display: flex; align-items: center; gap: 1.5rem; }
.profile-photo { width: 112px; height: 112px; object-fit: cover; border-radius: 50%; border: 5px solid #fff; box-shadow: 0 0 0 1px #e0e1d9; }
.eyebrow, .section-kicker { text-transform: uppercase; letter-spacing: .14em; font-size: .7rem; font-weight: 700; color: #64695d; margin-bottom: .65rem; }
.resume-intro h1 { font-size: clamp(2.3rem, 4.5vw, 3.7rem); letter-spacing: -.055em; margin-bottom: .45rem; }
.name-period { color: #788367; }
.intro-location { margin-bottom: 0; color: #62665d; font-size: .9rem; }
.intro-location span { margin: 0 .5rem; color: #a0a497; }
.intro-copy { max-width: 680px; font-size: 1.08rem; color: #60645b; margin: 1.5rem 0; }
.intro-bottom, .resume-nav, .intro-socials { display: flex; flex-wrap: wrap; align-items: center; gap: 1.5rem; }
.intro-bottom { justify-content: space-between; }
.resume-nav a, .intro-socials a { color: #42473c; font-size: .85rem; text-decoration: none; padding: .5rem 0; }
.resume-nav a:first-child { color: #24291e; font-weight: 700; }
.resume-nav a:hover, .intro-socials a:hover, .project-actions a:hover { text-decoration: underline; }
.resume-nav i, .intro-socials i { margin-left: .4rem; }
.projects-section { padding-top: 2.6rem; }
.projects-heading { display: flex; justify-content: space-between; align-items: flex-end; gap: 1.5rem; margin-bottom: 1.5rem; }
.projects-heading h2 { font-size: clamp(2rem, 3.3vw, 2.8rem); margin: 0; letter-spacing: -.05em; }
.projects-heading > p { font-size: .87rem; color: #73776e; margin: 0; }
.featured-project { display: grid; grid-template-columns: .9fr 1.1fr; border: 1px solid #dce0d3; border-radius: 20px; overflow: hidden; background: #f0f2e9; }
.featured-copy { padding: 2.2rem; }
.project-status { display: flex; align-items: center; flex-wrap: wrap; gap: .8rem; font-size: .7rem; color: #566044; margin-bottom: 1.8rem; }
.featured-label { background: #38452b; color: #fff; padding: .3rem .65rem; border-radius: 5px; }
.project-symbol { display: inline-grid; place-items: center; width: 44px; height: 44px; border-radius: 12px; background: #e1e6d5; color: #3c4b2e; font-size: 1.4rem; margin-bottom: 1rem; }
.featured-copy h3 { font-size: 2.5rem; margin-bottom: .6rem; }
.project-subtitle { color: #414638; font-weight: 600; margin-bottom: .8rem; }
.project-description { color: #64695d; font-size: .93rem; line-height: 1.75; margin-bottom: 1.3rem; }
.project-tags { display: flex; flex-wrap: wrap; list-style: none; padding: 0; gap: .45rem; margin-bottom: 1.8rem; }
.project-tags li { font-size: .68rem; border: 1px solid #d4dac8; border-radius: 5px; padding: .25rem .55rem; color: #4e5941; }
.project-actions { display: flex; flex-wrap: wrap; gap: 1.25rem; align-items: center; margin-top: auto; }
.project-actions a { display: inline-flex; align-items: center; justify-content: center; gap: .55rem; min-height: 44px; color: #343d2b; font-size: .8rem; font-weight: 600; text-decoration: none; }
.project-actions .project-primary { background: #293323; color: #fff; border-radius: 7px; padding: .65rem 1rem; }
.project-actions .project-primary:hover { background: #414e37; }
.project-preview { display: flex; min-width: 0; flex-direction: column; justify-content: center; background: #e6eadc; padding: 2rem 1.6rem; margin: 0; border-left: 1px solid #d9dfcd; }
.preview-caption { display: flex; justify-content: space-between; gap: .5rem; font-size: .65rem; color: #59644d; margin-bottom: .8rem; }
.preview-caption i { margin-right: .4rem; }
.project-preview a { display: block; border-radius: 7px; box-shadow: 0 16px 32px #3440221c; }
.project-preview img { display: block; width: 100%; height: auto; border: 1px solid #c6ceb9; border-radius: 7px; }
.project-preview figcaption { font-size: .73rem; color: #59644d; margin-top: 1.3rem; text-align: center; }
.supporting-projects { display: grid; grid-template-columns: 1fr 1fr; gap: 1.3rem; margin-top: 1.3rem; }
.project-card { display: flex; flex-direction: column; border: 1px solid #e1e2dc; border-radius: 16px; padding: 1.8rem; background: #fff; min-width: 0; }
.project-card-top { display: flex; align-items: center; justify-content: space-between; gap: .8rem; margin-bottom: 1.4rem; }
.project-card-top .project-symbol { margin-bottom: 0; flex-shrink: 0; }
.project-type { color: #70746a; font-size: .7rem; text-align: right; }
.metal-symbol { background: #f5ecdc; color: #8b6130; }
.savro-symbol { background: #eeedf6; color: #68608c; }
.project-card h3 { font-size: 1.55rem; }
.project-card .project-subtitle { font-size: .93rem; }
.collection-flow { display: flex; align-items: center; justify-content: space-between; gap: .5rem; padding: 1.4rem .9rem; border-radius: 8px; background: #f7f5ef; color: #726247; margin: .2rem 0 1.8rem; font-size: .75rem; }
.collection-flow span { display: flex; align-items: center; gap: .4rem; }
.code-sample { display: flex; flex-direction: column; gap: .5rem; padding: 1rem 1.2rem; background: #f4f3f8; border-radius: 8px; margin: .2rem 0 1.8rem; }
.code-sample > span { font-size: .6rem; color: #756d87; letter-spacing: .1em; }
.code-sample code { color: #454050; font-size: .85rem; overflow-wrap: anywhere; }
.code-keyword { color: #85639c; }
.private-source { color: #797c73; font-size: .75rem; }
.resume-divider { display: flex; justify-content: space-between; gap: 1rem; padding-top: 2.5rem; margin: 3.5rem 0 1.5rem; border-top: 1px solid #dedfd7; color: #606655; font-size: .75rem; letter-spacing: .1em; text-transform: uppercase; }
.quick-facts { display: grid; grid-template-columns: repeat(4, 1fr); gap: 1rem; }
.fact-pill { display: flex; flex-direction: column; padding: 1rem; background: #f2f3ed; border-radius: 8px; }
.fact-pill strong { font-size: 1.1rem; color: #353d2b; }
.fact-pill span { color: #6c7360; font-size: .8rem; }
.trait-card, .skill-card, .spotlight-card, .highlight-card { border: 1px solid #e3e5dd; border-radius: 12px; background: white; }
#projects, #skills, #experience { scroll-margin-top: 2rem; }
@media (max-width: 991px) {
  .featured-project { grid-template-columns: 1fr; }
  .project-preview { border-left: 0; border-top: 1px solid #d9dfcd; }
  .featured-copy { padding: 1.8rem; }
}
@media (max-width: 600px) {
  .portfolio-container { padding-top: 1.5rem; }
  .intro-identity { gap: 1rem; }
  .profile-photo { width: 76px; height: 76px; border-width: 3px; }
  .resume-intro h1 { font-size: 2.1rem; }
  .eyebrow { font-size: .58rem; }
  .intro-location { font-size: .75rem; }
  .intro-location span { margin: 0 .15rem; }
  .intro-copy { font-size: 1rem; }
  .intro-bottom { gap: .65rem; }
  .resume-nav { gap: 1.2rem; }
  .projects-heading { display: block; }
  .projects-heading > p { margin-top: .75rem; }
  .desktop-break { display: none; }
  .supporting-projects { grid-template-columns: 1fr; }
  .featured-copy, .project-card { padding: 1.4rem; }
  .project-preview { padding: 1.3rem 1rem; }
  .quick-facts { grid-template-columns: 1fr 1fr; gap: .6rem; }
}
@media (prefers-reduced-motion: reduce) {
  *, *::before, *::after { transition: none !important; }
}

.section-block {
  margin-top: 3rem;
}

.section-heading {
  margin-bottom: 1.25rem;
}

.section-heading h2 {
  margin-bottom: 0;
  font-size: clamp(1.5rem, 2vw, 2rem);
}

.trait-card,
.skill-card,
.spotlight-card,
.highlight-card {
  padding: 1.35rem;
  box-shadow: 0 14px 40px rgba(15, 23, 42, 0.05);
}

.trait-icon {
  width: 2.5rem;
  height: 2.5rem;
  border-radius: 0.9rem;
  display: grid;
  place-items: center;
  margin-bottom: 1rem;
  background: #edf0e6;
  color: #38452b;
  font-size: 1.1rem;
}

.skill-topline {
  width: 3rem;
  height: 0.3rem;
  border-radius: 999px;
  margin-bottom: 1rem;
  background: #7d886c;
}

.timeline {
  position: relative;
  padding-left: 1rem;
}

.timeline::before {
  content: '';
  position: absolute;
  left: 1.05rem;
  top: 0.4rem;
  bottom: 0.4rem;
  width: 2px;
  background: linear-gradient(180deg, rgba(22, 49, 55, 0.3), rgba(170, 111, 61, 0.15));
}

.timeline-item {
  position: relative;
  padding-left: 2.5rem;
  margin-bottom: 1.35rem;
}

.timeline-marker {
  position: absolute;
  left: 0.55rem;
  top: 1rem;
  width: 1rem;
  height: 1rem;
  border-radius: 999px;
  border: 3px solid #f4f7f7;
  background: #38452b;
  box-shadow: 0 0 0 4px rgba(22, 49, 55, 0.08);
}

.timeline-card {
  padding: 1.35rem;
  border-radius: 1.35rem;
  background: rgba(255, 255, 255, 0.86);
  border: 1px solid rgba(28, 39, 52, 0.08);
  box-shadow: 0 10px 30px rgba(15, 23, 42, 0.04);
}

.timeline-role {
  font-size: 1.15rem;
  font-weight: 700;
  color: #38452b;
}

.timeline-company {
  font-weight: 600;
  color: #68745b;
}

.timeline-meta {
  font-size: 0.92rem;
}

.timeline-list {
  padding-left: 1.15rem;
}

.timeline-list li {
  margin-bottom: 0.5rem;
}

.education-item {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  gap: 1rem;
  padding: 1rem 0;
  border-top: 1px solid rgba(28, 39, 52, 0.08);
}

.education-item:first-of-type {
  border-top: 0;
  padding-top: 0;
}

.education-year {
  white-space: nowrap;
  color: #38452b;
  font-weight: 700;
}

.link-list {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.link-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 1rem;
  padding: 1rem 1.05rem;
  border-radius: 1rem;
  background: rgba(22, 49, 55, 0.04);
  text-decoration: none;
  color: inherit;
  transition: transform 0.2s ease, background 0.2s ease;
}

.link-row:hover {
  transform: translateY(-2px);
  background: rgba(22, 49, 55, 0.08);
}

.link-label {
  font-weight: 700;
  color: #38452b;
}

.highlight-title {
  font-weight: 700;
  color: #38452b;
  margin-bottom: 0.5rem;
}

@media (max-width: 768px) {
  .timeline {
    padding-left: 0;
  }

  .timeline::before {
    left: 0.45rem;
  }

  .timeline-item {
    padding-left: 1.6rem;
  }

  .timeline-marker {
    left: 0;
  }

  .education-item {
    flex-direction: column;
  }
}
</style>
