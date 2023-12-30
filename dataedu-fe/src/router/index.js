import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import JsonEditorView from '@/views/JsonEditorView.vue'
import TutorialIntroductionView from '@/views/TutorialIntroductionView.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/json',
    name: 'JsonEditor',
    component: JsonEditorView
  },
  {
    path: '/tutorials/introduction',
    name: 'TutorialIntroductionView',
    component: TutorialIntroductionView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
