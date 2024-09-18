/**
 * DATE: 2024/9/18
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import type { HttpRequest, HttpResponse } from '@/http/models/index'

export interface AccessToken {}

export interface RefreshToken {}

export interface LoginRequest extends HttpRequest {
  email: string,
  credential: string
}

export type LoginResponse = HttpResponse<{
  accessToken: AccessToken,
  refreshToken: RefreshToken
}>
