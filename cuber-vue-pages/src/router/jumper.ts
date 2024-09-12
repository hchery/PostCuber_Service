/**
 * DATE: 2024/9/12
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import type { LocationQuery, LocationQueryValue, LocationQueryValueRaw } from 'vue-router'
import router from '@/router/index'

export namespace Routes {
  export const Root = 'Root'
  export const Core = 'Core'
  export const Auth = `${Core}.Auth`
  export const AuthLogin = `${Auth}.Login`
}

export type RouteQuery = Record<string, LocationQueryValueRaw>

export function jumpRoute(routeName: string, query: RouteQuery = {}) {
  return router.push({
    name: routeName,
    query: query
  })
}

export function refreshRoute(query: RouteQuery = {}) {
  const currentRoute = router.currentRoute.value.path
  return jumpRoute(currentRoute, query)
}

export function currentRouteName() {
  const current = router.currentRoute.value
  return current.name as string
}

export function isRoute(routeName: string) {
  return routeName === currentRouteName()
}

export function redirectRoute(routeName: string, query: RouteQuery = {}) {
  const current = router.currentRoute.value
  const routeQuery = ((q: LocationQuery) => q ? q : {})(current.query)
  const newQuery = {
    _f_: currentRouteName(),
    _r_: encodeURIComponent(JSON.stringify(routeQuery)),
    ...query
  }
  return jumpRoute(routeName, newQuery)
}

export function returnPreviousRoute() {
  const current = router.currentRoute.value
  const from = ((_: LocationQueryValue | LocationQueryValue[]) => _ ? _.toString(): "")(current.query["_f_"])
  const query = ((_: LocationQueryValue | LocationQueryValue[]) => {
    if (!_) return {}
    const decoded = decodeURIComponent(_.toString())
    return JSON.parse(decoded)
  })(current.query["_f_"])
  return jumpRoute(from, query)
}
