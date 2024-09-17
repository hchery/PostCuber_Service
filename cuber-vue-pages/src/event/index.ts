/**
 * DATE: 2024/9/16
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import mitt from 'mitt'
import type { Channel } from '@/event/channel'

const __mitt__ = mitt()

export function appEmit<T>(event: AppEvent<T>) {
  __mitt__.emit(event.channel, event.args)
}

export function appOn<T>(listener: AppListener<T>) {
  __mitt__.emit(listener.channel, (argv: T) => listener.action(argv))
}

export interface AppEvent<T> {
  channel: Channel
  args: T
}

export interface AppListener<T> {
  channel: Channel,
  action(args: T): void
}
