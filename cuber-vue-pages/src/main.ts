import { createApp } from "vue"
import { createPinia } from "pinia"
import ElementPlus from "element-plus"
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

/**
 * 如果这里报错：
 *   Vue: Could not find a declaration file for module @/App.vue.
 *   implicitly has an any type.
 * 插件检测问题，忽略即可，不影响运行
 */
import App from "@/App.vue"
/** ------------------------------ **/
import router from "@/router"

import "element-plus/dist/index.css"
import "@/main.css"
import "@/theme/light.css"
import registryEvents from '@/event/registry'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(ElementPlus)
app.use(registryEvents)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.mount("#app")
