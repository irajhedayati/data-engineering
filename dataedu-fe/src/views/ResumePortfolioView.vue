<template>
  <section class="portfolio-shell">
    <div class="portfolio-aurora portfolio-aurora-left"></div>
    <div class="portfolio-aurora portfolio-aurora-right"></div>

    <div class="container py-5 position-relative">
      <div class="hero-card shadow-lg">
        <div class="row g-4 align-items-center">
          <div class="col-lg-8">
            <div class="eyebrow">Resume and portfolio</div>
            <h1 class="display-5 mb-3">Iraj Hedayati</h1>
            <p class="lead hero-copy mb-4">
              A seasoned data engineer, data architect, instructor, and hands-on builder. The throughline in the resume
              is clear: design durable systems, mentor people, and ship practical data platforms that work at scale.
            </p>

            <div class="d-flex flex-wrap gap-2 mb-4">
              <a class="btn btn-dark btn-lg" href="https://www.linkedin.com/in/irajhedayati/" rel="noreferrer" target="_blank">
                <i class="bi bi-linkedin me-2"></i>LinkedIn
              </a>
              <a class="btn btn-outline-dark btn-lg" href="https://github.com/irajhedayati/" rel="noreferrer" target="_blank">
                <i class="bi bi-github me-2"></i>GitHub
              </a>
              <a class="btn btn-outline-secondary btn-lg" href="https://medium.com/@iraj.hedayati" rel="noreferrer" target="_blank">
                <i class="bi bi-medium me-2"></i>Writing
              </a>
            </div>

            <div class="quick-facts">
              <span v-for="fact in quickFacts" :key="fact.label" class="fact-pill">
                <strong>{{ fact.value }}</strong>
                <span>{{ fact.label }}</span>
              </span>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="profile-card">
              <div class="profile-badge">Montreal area</div>
              <div class="profile-meta">
                <p class="text-uppercase text-muted small mb-1">Primary focus</p>
                <h2 class="h4 mb-2">Data platform backend engineering</h2>
                <p class="mb-0 text-muted">
                  Streaming, orchestration, governance, cloud infrastructure, and the kind of architecture that still
                  behaves when the system gets busy.
                </p>
              </div>
              <hr />
              <div class="stack-tags">
                <span v-for="tag in focusTags" :key="tag" class="stack-tag">{{ tag }}</span>
              </div>
            </div>
          </div>
        </div>
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

      <div class="section-block">
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

      <div class="section-block">
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

const focusTags = [
  'Spark',
  'Kafka',
  'GCP',
  'AWS',
  'Kubernetes',
  'Data governance',
  'Scala',
  'Java',
  'Python',
  'Mentorship'
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
.portfolio-shell {
  position: relative;
  overflow: hidden;
  background:
    radial-gradient(circle at top left, rgba(255, 177, 102, 0.18), transparent 35%),
    radial-gradient(circle at top right, rgba(18, 99, 101, 0.18), transparent 32%),
    linear-gradient(180deg, #fffaf3 0%, #f4f7f7 100%);
}

.portfolio-aurora {
  position: absolute;
  inset: auto;
  width: 24rem;
  height: 24rem;
  filter: blur(80px);
  opacity: 0.55;
  pointer-events: none;
}

.portfolio-aurora-left {
  top: 4rem;
  left: -8rem;
  background: rgba(255, 163, 90, 0.25);
}

.portfolio-aurora-right {
  right: -10rem;
  top: 18rem;
  background: rgba(63, 139, 136, 0.22);
}

.hero-card,
.profile-card,
.trait-card,
.skill-card,
.spotlight-card,
.highlight-card {
  border: 1px solid rgba(28, 39, 52, 0.08);
  border-radius: 1.5rem;
  background: rgba(255, 255, 255, 0.82);
  backdrop-filter: blur(10px);
}

.hero-card {
  padding: 2rem;
}

.eyebrow,
.section-kicker {
  text-transform: uppercase;
  letter-spacing: 0.18em;
  font-size: 0.75rem;
  color: #8a5b33;
  font-weight: 700;
}

.hero-copy {
  max-width: 58rem;
  font-size: 1.1rem;
  line-height: 1.75;
}

.quick-facts {
  display: flex;
  flex-wrap: wrap;
  gap: 0.85rem;
}

.fact-pill {
  display: inline-flex;
  flex-direction: column;
  min-width: 9.5rem;
  padding: 0.85rem 1rem;
  border-radius: 1rem;
  background: rgba(27, 35, 43, 0.04);
  border: 1px solid rgba(27, 35, 43, 0.08);
}

.fact-pill strong {
  font-size: 1rem;
  line-height: 1.1;
}

.fact-pill span {
  color: #6c757d;
  font-size: 0.85rem;
}

.profile-card {
  padding: 1.5rem;
}

.profile-badge {
  display: inline-flex;
  align-items: center;
  padding: 0.35rem 0.7rem;
  border-radius: 999px;
  background: #163137;
  color: #fff;
  font-size: 0.78rem;
  font-weight: 700;
  letter-spacing: 0.05em;
  margin-bottom: 1rem;
}

.stack-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.55rem;
}

.stack-tag {
  padding: 0.4rem 0.7rem;
  border-radius: 999px;
  background: rgba(22, 49, 55, 0.08);
  color: #163137;
  font-size: 0.9rem;
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
  background: linear-gradient(135deg, rgba(255, 177, 102, 0.24), rgba(63, 139, 136, 0.18));
  color: #163137;
  font-size: 1.1rem;
}

.skill-topline {
  width: 3rem;
  height: 0.3rem;
  border-radius: 999px;
  margin-bottom: 1rem;
  background: linear-gradient(90deg, #163137, #aa6f3d);
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
  background: #163137;
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
  color: #163137;
}

.timeline-company {
  font-weight: 600;
  color: #7a5b44;
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
  color: #163137;
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
  color: #163137;
}

.highlight-title {
  font-weight: 700;
  color: #163137;
  margin-bottom: 0.5rem;
}

@media (max-width: 768px) {
  .hero-card {
    padding: 1.2rem;
  }

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
