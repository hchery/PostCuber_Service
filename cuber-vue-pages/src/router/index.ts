import { createRouter, createWebHistory } from 'vue-router'
import { Routes } from '@/router/jumper'
import coreRoute from '@/router/core'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: Routes.Root,
      path: "/",
      component: () => import("@/views/RootView.vue")
    },
    coreRoute
  ]
})

export default router
