<template>
  <div class="wrapper">
        <Navbar/>
        <sidebar/>
    <div class="content-wrapper iframe-mode " data-widget="iframe">
      <div class="tab-content">
        <div class="container text-center">
          <router-view/>
        </div>
      </div>
    </div>
    <aside class="control-sidebar control-sidebar-dark "></aside>
  </div>
</template>

<script>
import Navbar from "@/layouts/inc/Navbar";
import Sidebar from "@/layouts/inc/Sidebar";
export default {
  name: "MainLayout",
  components: {
    Navbar,
    Sidebar,
  },
  data() {
    return {};
  },
  methods: {
  }
}
</script>

<style scoped>

</style>
