<script>
/**
 * ElementPlus在使用鼠标缩放窗口时有概率触发以下错误：
 *   窗口缩放超限错误
 * 这段JS就是为了解决这个问题
 */
const debounce = (func, delay) => {
  return function () {
    // eslint-disable-next-line @typescript-eslint/no-this-alias
    const context = this
    const args = arguments
    const tm = setTimeout(() => {
      func.apply(context, args)
      clearTimeout(tm)
    }, delay)
  }
}

const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver{
  constructor(callback) {
    callback = debounce(callback, 16);
    super(callback);
  }
}
</script>

<template>
  <router-view/>
</template>
