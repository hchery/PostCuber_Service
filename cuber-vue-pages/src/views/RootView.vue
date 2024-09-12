<script setup lang="ts">
import { onMounted } from 'vue'
import { redirectRoute, Routes } from '@/router/jumper'

onMounted(() => redirectRoute(Routes.AuthLogin))
</script>

<template>
</template>