<template>
  <a class="skip-link" href="#main-content">Skip to content</a>
  <nav class="navbar navbar-expand-lg site-nav" aria-label="Main navigation">
    <div class="container">
      <router-link class="navbar-brand brand" to="/"><span class="brand-mark" aria-hidden="true"><i class="bi bi-layers-fill"></i></span>DataEdu<span class="brand-dot">.</span></router-link>
      <button class="navbar-toggler" type="button" aria-controls="siteMenu" :aria-expanded="menuOpen" aria-label="Toggle navigation" @click="menuOpen = !menuOpen"><span class="navbar-toggler-icon"></span></button>
      <div id="siteMenu" class="collapse navbar-collapse" :class="{ show: menuOpen }">
        <ul class="navbar-nav ms-auto align-items-lg-center">
          <li v-for="item in navigation" :key="item.path" class="nav-item"><router-link class="nav-link" exact-active-class="active" :to="item.path" @click="menuOpen = false">{{ item.label }}</router-link></li>
          <li class="nav-item ms-lg-3"><router-link class="btn btn-primary nav-cta" to="/tools" @click="menuOpen = false">Explore tools <i class="bi bi-arrow-up-right ms-2" aria-hidden="true"></i></router-link></li>
        </ul>
      </div>
    </div>
  </nav>
  <main id="main-content" tabindex="-1"><router-view :key="$route.fullPath" /></main>
  <footer class="site-footer">
    <div class="container">
      <div class="footer-top">
        <div><router-link class="brand" to="/"><span class="brand-mark" aria-hidden="true"><i class="bi bi-layers-fill"></i></span>DataEdu.</router-link><p>A space to learn, experiment,<br>and build better data systems.</p></div>
        <div class="footer-links"><strong>Explore</strong><router-link to="/tools">General tools</router-link><router-link to="/json">JSON editor</router-link><router-link to="/avro">Avro tools</router-link></div>
        <div class="footer-links"><strong>Keep learning</strong><router-link to="/tutorials/introduction">Tutorials</router-link><router-link to="/resume">About Iraj</router-link><a href="https://medium.com/@iraj.hedayati" target="_blank" rel="noopener noreferrer">Writing <i class="bi bi-arrow-up-right" aria-hidden="true"></i></a></div>
      </div>
      <div class="footer-bottom"><span>Built by Iraj Hedayati. A data engineer, a student and a teacher.</span><div class="social-links"><a href="https://www.linkedin.com/in/irajhedayati/" aria-label="LinkedIn" target="_blank" rel="noopener noreferrer"><i class="bi bi-linkedin"></i></a><a href="https://github.com/irajhedayati/" aria-label="GitHub" target="_blank" rel="noopener noreferrer"><i class="bi bi-github"></i></a><a href="mailto:iraj.hedayati@gmail.com" aria-label="Email"><i class="bi bi-envelope"></i></a></div></div>
      <small class="footer-credit">Icon: Tehran by Befoolish from <a href="https://thenounproject.com/browse/icons/term/tehran/" target="_blank" rel="noopener noreferrer">Noun Project</a> (CC BY 3.0)</small>
    </div>
  </footer>
</template>
<script setup>
import { ref } from 'vue'
const menuOpen = ref(false)
const navigation = [{ label: 'Home', path: '/' }, { label: 'JSON', path: '/json' }, { label: 'Avro', path: '/avro' }, { label: 'Tools', path: '/tools' }, { label: 'Resume', path: '/resume' }]
</script>
