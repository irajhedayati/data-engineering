import { nextTick } from 'vue'
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
  { path: '/', name: 'Home', component: HomeView, meta: { title: 'My DE Space' } },
  { path: '/json', name: 'JsonEditor', component: JsonEditorView, meta: { title: 'My DE Space - JSON Editor' } },
  {
    path: '/tutorials/introduction',
    name: 'TutorialIntroductionView',
    component: TutorialIntroductionView,
    meta: { title: 'My DE Space - Tutorials - Introduction' }
  },
  {
    path: '/tutorials/hadoop',
    name: 'TutorialHadoopAndZKView',
    component: TutorialHadoopAndZKView,
    meta: { title: 'My DE Space - Tutorials - Hadoop' }
  },
  {
    path: '/tutorials/hive',
    name: 'TutorialHiveView',
    component: TutorialHiveView,
    meta: { title: 'My DE Space - Tutorials - Hive' }
  },
  {
    path: '/tutorials/kafka',
    name: 'TutorialKafkaView',
    component: TutorialKafkaView,
    meta: { title: 'My DE Space - Tutorials - Kafka' }
  },
  {
    path: '/tutorials/spark',
    name: 'TutorialSparkView',
    component: TutorialSparkView,
    meta: { title: 'My DE Space - Tutorials - Spark' }
  },
  {
    path: '/tutorials/aws',
    name: 'TutorialAWSView',
    component: TutorialAWSView,
    meta: { title: 'My DE Space - Tutorials - Cloud and AWS' }
  },
  { path: '/avro', name: 'AvroView', component: AvroView, meta: { title: 'My DE Space - Avro Tools' } },
  { path: '/tools', name: 'ToolsView', component: ToolsView, meta: { title: 'My DE Space - DE Tools' } }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL), routes
})

router.afterEach((to) => {
  nextTick(() => {
    // noinspection JSUnresolvedReference
    document.title = to.meta.title || 'My DE Space'
  })
})

export default router
