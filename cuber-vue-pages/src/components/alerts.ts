/**
 * DATE: 2024/9/16
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import { ElMessage } from 'element-plus'
import type { AppListener } from '@/event'

export type AlertType = "info" | "warning" | "error" | "success"

export interface AlertArgs {
  message: string,
  type: AlertType
}

function showAlert(args: AlertArgs) {
  ElMessage({
    showClose: true,
    center: true,
    type: args.type,
    message: args.message
  })
}

export function alertListener(): AppListener<AlertArgs> {
  return {
    channel: 'alert',
    action(args: AlertArgs) {
      showAlert(args)
    }
  }
}
