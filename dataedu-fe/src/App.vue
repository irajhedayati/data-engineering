<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">DataEdu</a>
      <button aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation"
              class="navbar-toggler"
              data-bs-target="#navbarNavDropdown" data-bs-toggle="collapse" type="button">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div id="navbarNavDropdown" class="collapse navbar-collapse">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link active-class="nav-link active" aria-current="page" class="nav-link" exact to="/">Home
            </router-link>
          </li>
          <li class="nav-item">
            <router-link active-class="nav-link active" aria-current="page" class="nav-link" to="/json">JSON
            </router-link>
          </li>
          <li class="nav-item">
            <router-link active-class="nav-link active" aria-current="page" class="nav-link" to="/avro">Avro
            </router-link>
          </li>
          <li class="nav-item">
            <router-link active-class="nav-link active" aria-current="page" class="nav-link" to="/tools">Tools
            </router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <router-view :key="$route.fullPath"/>

  <div class="container">
    <footer class="text-center bg-body-tertiary">
      <div class="container pt-4">
        <section class="mb-4">
          <!-- Linkedin -->
          <button
            class="btn btn-link btn-floating btn-lg text-body m-1"
            data-mdb-ripple-color="dark"
            data-mdb-ripple-init
            onclick="window.open('https://www.linkedin.com/in/irajhedayati/', '_blank')"
          ><i class="bi bi-linkedin"></i></button>
          <!-- Github -->
          <button
            class="btn btn-link btn-floating btn-lg text-body m-1"
            data-mdb-ripple-color="dark"
            data-mdb-ripple-init
            onclick="window.open('https://github.com/irajhedayati/', '_blank')"
          ><i class="bi bi-github"></i></button>
          <!-- EMail -->
          <button
            class="btn btn-link btn-floating btn-lg text-body m-1"
            data-mdb-ripple-color="dark"
            data-mdb-ripple-init
            onclick="location.href='mailto:iraj.hedayati@gmail.com'"
          ><i class="bi bi-envelope"></i></button>
          <!-- Medium -->
          <button
            class="btn btn-link btn-floating btn-lg text-body m-1"
            data-mdb-ripple-color="dark"
            data-mdb-ripple-init
            onclick="window.open('https://medium.com/@iraj.hedayati', '_blank')"
          ><i class="bi bi-medium"></i></button>
        </section>
        <!-- Section: Social media -->
      </div>
      <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.05);">
        <p class="lead">Iraj Hedayati</p>
        <p class="text-muted">A data engineer, a student and a teacher.</p>
        <p class="text-muted">Icon: Tehran by Befoolish from <a
          href="https://thenounproject.com/browse/icons/term/tehran/"
          target="_blank" title="Tehran Icons">Noun Project</a> (CC BY
          3.0)</p>
      </div>
    </footer>
  </div>
</template>
<script setup>
</script>
