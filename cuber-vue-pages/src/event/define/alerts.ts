/**
 * DATE: 2024/9/18
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import type { AppEvent } from '@/event'
import type { AlertArgs, AlertType } from '@/components/alerts'

function alertEvent(message: string, type: AlertType): AppEvent<AlertArgs> {
  return {
    channel: 'alert',
    args: {
      type: type,
      message: message
    }
  }
}

export function alertHintEvent(message: string): AppEvent<AlertArgs> {
  return alertEvent(message, "info")
}

export function alertInfoEvent(message: string): AppEvent<AlertArgs> {
  return alertEvent(message, "success")
}

export function alertWarnEvent(message: string): AppEvent<AlertArgs> {
  return alertEvent(message, "warning")
}

export function alertErrorEvent(message: string): AppEvent<AlertArgs> {
  return alertEvent(message, "error")
}
