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

  <router-view/>

  <div class="container">
    <footer class="text-center bg-body-tertiary">
      <div class="container pt-4">
        <section class="mb-4">
          <!-- Linkedin -->
          <a
            class="btn btn-link btn-floating btn-lg text-body m-1"
            data-mdb-ripple-color="dark"
            data-mdb-ripple-init
            href="https://www.linkedin.com/in/irajhedayati/"
            role="button"
          ><i class="bi bi-linkedin"></i></a>
          <!-- Github -->
          <a
            class="btn btn-link btn-floating btn-lg text-body m-1"
            data-mdb-ripple-color="dark"
            data-mdb-ripple-init
            href="https://github.com/irajhedayati/"
            role="button"
          ><i class="bi bi-github"></i></a>
          <!-- EMail -->
          <a
            class="btn btn-link btn-floating btn-lg text-body m-1"
            data-mdb-ripple-color="dark"
            data-mdb-ripple-init
            href="mailto:iraj.hedayati@gmail.com"
            role="button"
          ><i class="bi bi-envelope"></i></a>
          <!-- Medium -->
          <a
            class="btn btn-link btn-floating btn-lg text-body m-1"
            data-mdb-ripple-color="dark"
            data-mdb-ripple-init
            href="https://medium.com/@iraj.hedayati"
            role="button"
          ><i class="bi bi-medium"></i></a>
        </section>
        <!-- Section: Social media -->
      </div>
      <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.05);">
        <p class="lead">Iraj Hedayati</p>
        <p class="text-muted">A data engineer, a student and a teacher.</p>
      </div>
    </footer>
  </div>
</template>
<script setup>
</script>
