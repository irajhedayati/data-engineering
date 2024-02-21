import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-icons/font/bootstrap-icons.css'
import 'bootstrap'
import '@/assets/css/main.css'
import { VueClipboard } from '@soerenmartius/vue3-clipboard'

createApp(App).use(router).use(VueClipboard).mount('#app')
