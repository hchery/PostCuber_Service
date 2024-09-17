/**
 * DATE: 2024/9/12
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import type { RouteRecordRaw } from 'vue-router'
import { Routes } from '@/router/jumper'

const loginRoute: RouteRecordRaw = {
  name: Routes.AuthLogin,
  path: "login",
  component: () => import("@/views/core/auth/login/IndexView.vue")
}

export default loginRoute
