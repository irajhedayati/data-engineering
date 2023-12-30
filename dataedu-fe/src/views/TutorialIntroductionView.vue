<template>
  <Banner
    caption='Introduction to Data Science, Data Engineering, and Business Intelligence'
    title='Introduction'
  />
  <section id="content">
    <div class="wrapper doc">
      <IrajTabs>
        <IrajTab :selected="true" name="Data Science">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vREudkVR1P88y-43O0szyAwkKt6S7jy_daoGqVwYLm27AbV5f_pDKJ7IStVPTgm4ufCQj05GLttLL51/embed?start=false&loop=false&delayms=3000"
                  title="Introduction to Data Science" width="960"></iframe>
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vRBWjUEeA2nRZVtinO9BtsxeH9iLiYHWsrNlo9oKms0wqqgMB2mzZIAUie9jHILw5o45c15GROCaPAH/embed?start=false&loop=false&delayms=3000"
                  title="Descriptive Statistics" width="960"></iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Data Engineering">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vSRNwB64o428L580cFrR6lBubR9WP0SGlnVEscQBzUgD023uQHqavzr5utU6oCjehiGFuIRmV8wgoKu/embed?start=false&loop=false&delayms=3000"
                  title="Introduction to Data Engineering" width="960"></iframe>
              </div>
            </div>
          </div>
        </IrajTab>
        <IrajTab name="Business Intelligence">
          <div class="container">
            <div class="row">
              <div class="col-sm">
                <iframe
                  allow="fullscreen"
                  height="569"
                  src="https://docs.google.com/presentation/d/e/2PACX-1vQ62QgZNnCwN-7WbuOFHeuftYhgia0w1zmKwsrVlI_9Sm1CrAizJWwHjsEGD4GaY8cNs6laAZ-unkwu/embed?start=false&loop=false&delayms=3000"
                  title="Introduction to Business Intelligence" width="960"></iframe>
              </div>
            </div>
          </div>
        </IrajTab>
      </IrajTabs>
    </div>
  </section>
</template>
<script setup>
import Banner from '@/components/Banner.vue'
import IrajTabs from '@/components/IrajTabs.vue'
import IrajTab from '@/components/IrajTab.vue'
</script>
