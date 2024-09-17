<script setup lang="ts">
import LoginHeader from '@/views/core/auth/login/LoginHeader.vue'
import LoginFooter from '@/views/core/auth/login/LoginFooter.vue'
import LoginForm from '@/views/core/auth/login/LoginForm.vue'
</script>

<template>
  <el-card class="w-card">
    <el-container>
      <el-header class="w-padding-disable">
        <login-header></login-header>
      </el-header>
      <el-main class="w-padding-disable">
        <login-form></login-form>
      </el-main>
      <el-footer class="w-padding-disable">
        <login-footer></login-footer>
      </el-footer>
    </el-container>
  </el-card>
</template>

<style scoped>
.w-card {
  top: max(calc(50% - 200px), 0px);
  left: max(calc(50% - 250px), 0px);
  position: absolute;
  width: 400px;
  height: 400px;
  border-radius: 5px;
}
.w-padding-disable {
  padding: 0;
}
</style>