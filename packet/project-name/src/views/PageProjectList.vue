<template>
  <div class="container">
    <ProjectList/>
  </div>
</template>

<script>
// @ is an alias to /src

import ProjectList from "@/components/ProjectList";
export default {
  name: 'HomeView',
  components: {
    ProjectList,
  }
}
</script>
