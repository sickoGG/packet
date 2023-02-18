<template>
  <Login/>
  <router-view/>
</template>

<script>
import Login from "@/components/Login.vue";
export default {
  name: "PageLogin",
  components: {
    Login,
  }
}
</script>

<style scoped>

</style>