import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path: '/cat',
    name: 'cat',
    component: () => import( '../views/catcare/CatView.vue')
  },
  {
    path: '/dept',
    name: 'dept',
    component: () => import('../views/catcare/DeptView.vue')
  },
  {
    path: '/',
    redirect: '/cat'
  }
]

const router = new VueRouter({
  routes
})

export default router
