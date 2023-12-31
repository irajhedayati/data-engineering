import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import JsonEditorView from '@/views/JsonEditorView.vue'
import TutorialIntroductionView from '@/views/TutorialIntroductionView.vue'
import TutorialHadoopAndZKView from '@/views/TutorialHadoopAndZKView.vue'
import TutorialHiveView from '@/views/TutorialHiveView.vue'
import TutorialKafkaView from '@/views/TutorialKafkaView.vue'
import TutorialSparkView from '@/views/TutorialSparkView.vue'

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
  },
  {
    path: '/tutorials/hadoop',
    name: 'TutorialHadoopAndZKView',
    component: TutorialHadoopAndZKView
  },
  {
    path: '/tutorials/hive',
    name: 'TutorialHiveView.vue',
    component: TutorialHiveView
  },
  {
    path: '/tutorials/kafka',
    name: 'TutorialKafkaView.vue',
    component: TutorialKafkaView
  },
  {
    path: '/tutorials/spark',
    name: 'TutorialSparkView.vue',
    component: TutorialSparkView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
