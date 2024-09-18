/**
 * DATE: 2024/9/18
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

export interface HttpRequest {
}

export interface HttpResponse<T> {
  code: number,
  desc: string,
  time: string,
  data: T
}

export * from "./login"
