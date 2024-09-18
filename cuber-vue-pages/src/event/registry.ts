/**
 * DATE: 2024/9/16
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import type { ObjectPlugin } from 'vue'
import { appOn } from '@/event/index'
import { alertListener } from '@/components/alerts'

const registryEvents: ObjectPlugin = {
  install() {
    appOn(alertListener())
  }
}

export default registryEvents
