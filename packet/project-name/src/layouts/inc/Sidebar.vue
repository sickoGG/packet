<template>
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a class="brand-link">
      <img src="@/assets/M2.png" alt="icon" class="brand-image img-circle elevation-3">
      <span class="brand-text font-weight-light b1">Project Plan</span>
    </a>

    <div class="sidebar">
      <nav class="mt-2" >
        <ul
            class="nav nav-pills nav-sidebar flex-column"
            data-widget="treeview"
            role="menu"
            data-accorion="false"
        >
          <li class="nav-header">
            TABLE
          </li>
          <nav-item icon="nav-icon fas fa-table" link="/pageProjectList" class="b1">
            Project List
          </nav-item>
          <nav-item icon="nav-icon fas fa-columns" link="/pageUserList" class="b1">
            Person List
          </nav-item>
          <nav-item icon="nav-icon far fa-plus-square" link="/pageName" class="b1">
            Test List
          </nav-item>
          <li class="nav-header">
            ADD
          </li>
          <nav-item icon="nav-icon fas fa-edit" link="/pageAddProject" class="b1">
            Add Project
          </nav-item>
          <nav-item icon="nav-icon fas fa-edit" link="/oopTest" class="b1">
            Set D......
          </nav-item>
        </ul>
      </nav>
    </div>
  </aside>
</template>

<script>
import NavItem from "@/layouts/inc/NavItem";
export default {
  name: "SideBar",
  components: {
    NavItem
  }
}
</script>

<style scoped>


</style>

