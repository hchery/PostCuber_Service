/**
 * DATE: 2024/9/12
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import type { RouteRecordRaw } from 'vue-router'
import { Routes } from '@/router/jumper'
import loginRoute from '@/router/core/auth/login'

const authRoute: RouteRecordRaw = {
  name: Routes.Auth,
  path: "auth",
  children: [
    loginRoute
  ]
}

export default authRoute
