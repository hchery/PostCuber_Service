/**
 * DATE: 2024/9/12
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import type { RouteRecordRaw } from 'vue-router'
import { Routes } from '@/router/jumper'
import authRoute from '@/router/core/auth'

const coreRoute: RouteRecordRaw = {
  name: Routes.Core,
  path: "/core",
  children: [
    authRoute
  ]
}

export default coreRoute
