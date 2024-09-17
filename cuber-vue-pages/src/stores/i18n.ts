/**
 * DATE: 2024/9/18
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'
import { I18n_ZH_CN } from '@/i18n/zh-cn'

export const useI18n = defineStore("i18n",() => {
  const i18n = ref(I18n_ZH_CN)
  const current = computed(() => i18n.value)
  return { current }
})
