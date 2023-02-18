<template>
  <div class="login">
    <form>
      <div class="row d-flex justify-content-center">
        <div class="col-sm-12 d-flex justify-content-center mt-2">
          <label for="username">Username:</label>
          <input type="text" id="username" name="username" v-model="username" required>
        </div>
        <div class="col-sm-12 d-flex justify-content-center mt-2">
          <label for="password">Password:</label>
          <input type="password" id="password" name="password" v-model="password" required>
        </div>
        <div class="col-sm-3 d-flex justify-content-center mt-2 ">
          <button type="button" class="btn btn-success" @click="login">Login</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import Swal from "sweetalert2";

export default {
  name: "Login-View",
  data() {
    return {
      username: '',
      password: '',
    }
  },
  methods: {
    login() {
      if (this.username == 'admin' && this.password == 'admin') {
        this.$router.push('/pageProjectList')
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Login Fail',
          showConfirmButton: false,
          timer: 1500
        })
      }
    },
  }
}
</script>

<style scoped>

</style>