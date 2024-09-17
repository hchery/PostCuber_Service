<script setup lang="ts">
import logo from "@/assets/logo-rgb-1050_289.png"
</script>

<template>
  <div class="w-header">
    <el-image :src="logo" class="w-logo"/>
  </div>
</template>

<style scoped>
.w-header {
  width: 100%;
  display: flex;
}
.w-logo {
  width: 160px;
}
</style>