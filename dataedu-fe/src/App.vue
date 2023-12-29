<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">DataEdu</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link to="/" aria-current="page" class="nav-link" active-class="nav-link active" exact>Home</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/json" aria-current="page" class="nav-link" active-class="nav-link active">JSON</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <router-view/>
</template>
<script setup>
</script>
