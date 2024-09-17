<script setup lang="ts">
import { useI18n } from '@/stores/i18n'
import { Message, Unlock } from '@element-plus/icons-vue'

const i18n = useI18n().current
</script>

<template>
  <el-form
    class="w-form"
  >
    <el-form-item>
      <el-input
        class="w-input"
        :placeholder="i18n['login-placeholder-email']"
        :suffix-icon="Message"
      />
    </el-form-item>
    <el-form-item>
      <el-input
        class="w-input"
        :placeholder="i18n['login-placeholder-credential']"
        :suffix-icon="Unlock"
        type="password"
      />
    </el-form-item>
    <el-button
      type="primary"
      class="w-login-btn"
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