import { createRouter, createWebHistory } from 'vue-router'
import AvroView from '@/views/AvroView.vue'
import HomeView from '@/views/HomeView.vue'
import JsonEditorView from '@/views/JsonEditorView.vue'
import TutorialIntroductionView from '@/views/TutorialIntroductionView.vue'
import TutorialHadoopAndZKView from '@/views/TutorialHadoopAndZKView.vue'
import TutorialHiveView from '@/views/TutorialHiveView.vue'
import TutorialKafkaView from '@/views/TutorialKafkaView.vue'
import TutorialSparkView from '@/views/TutorialSparkView.vue'
import TutorialAWSView from '@/views/TutorialAWSView.vue'
import ToolsView from '@/views/ToolsView.vue'

const routes = [
  { path: '/', name: 'Home', component: HomeView },
  { path: '/json', name: 'JsonEditor', component: JsonEditorView },
  { path: '/tutorials/introduction', name: 'TutorialIntroductionView', component: TutorialIntroductionView },
  { path: '/tutorials/hadoop', name: 'TutorialHadoopAndZKView', component: TutorialHadoopAndZKView },
  { path: '/tutorials/hive', name: 'TutorialHiveView', component: TutorialHiveView },
  { path: '/tutorials/kafka', name: 'TutorialKafkaView', component: TutorialKafkaView },
  { path: '/tutorials/spark', name: 'TutorialSparkView', component: TutorialSparkView },
  { path: '/tutorials/aws', name: 'TutorialAWSView', component: TutorialAWSView },
  { path: '/avro', name: 'AvroView', component: AvroView },
  { path: '/tools', name: 'ToolsView', component: ToolsView }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL), routes
})

export default router
