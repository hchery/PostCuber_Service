<script setup lang="ts">
import { env } from '@/components/env'
</script>

<template>
  <div class="w-footer">
    <el-space>
      <span class="w-text">{{env.AUTHOR}}@GitHub(<span>
        <a class="w-text" target="_blank" :href="env.GITHUB_AUTHOR">
          <u>{{env.GITHUB_AUTHOR}}</u>
        </a>
      </span>)</span>
      <span class="w-text">#{{env.CREATED_YEAR}}#</span>
    </el-space>
  </div>
</template>

<style scoped>
.w-footer {
  display: flex;
}
.w-text {
  font-size: 13px;
  color: var(--pc-color--page-footer);
}
</style>