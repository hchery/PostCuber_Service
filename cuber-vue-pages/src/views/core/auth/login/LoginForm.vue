<script setup lang="ts">
import { useI18n } from '@/stores'
import { Message, Unlock } from '@element-plus/icons-vue'
import { reactive, ref } from 'vue'
import type { FormInstance } from 'element-plus'
import type { LoginRequest } from '@/http/models'
import { alertInfoEvent, appEmit } from '@/event'

const i18n = useI18n().current
const isLoading = ref(false)

const formRef = ref<FormInstance>()
const formItem = reactive<LoginRequest>({
  email: "",
  credential: ""
})

function a() {
  console.log("aa")
  appEmit(alertInfoEvent("ss"))
}
</script>

<template>
  <el-form
    class="w-form"
    ref="formRef"
    v-loading="isLoading"
  >
    <el-form-item prop="email">
      <el-input
        class="w-input"
        :placeholder="i18n['login-placeholder-email']"
        :suffix-icon="Message"
        v-model="formItem.email"
      />
    </el-form-item>
    <el-form-item prop="credential">
      <el-input
        class="w-input"
        :placeholder="i18n['login-placeholder-credential']"
        :suffix-icon="Unlock"
        v-model="formItem.credential"
        type="password"
      />
    </el-form-item>
    <el-button
      type="primary"
      class="w-login-btn"
      :disabled="isLoading"
      @click="a"
    >{{ i18n['login-submit'] }}</el-button>
  </el-form>
</template>

<style scoped>
.w-form {
  width: 300px;
  margin: 20px auto;
}

.el-input > :deep(.el-input__wrapper) {
  box-shadow: none;
  border-radius: 0;
  border-bottom: 1px solid var(--pc-color--login-border);
}

.w-input {
  font-size: 13px;
}

.w-login-btn {
  border-radius: 15px;
  width: 150px;
  height: 34px;
  margin-top: 20px;
}
</style>