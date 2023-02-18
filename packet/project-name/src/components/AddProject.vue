<template>
  <h1 class="plan ">Project Plan</h1>
  <div class="about">
    <section>
      <form class="row g-3">
        <div class="col-md-6">
          <label for="inputProjectName" class="form-label name1">packetPreUit</label>
          <input v-model="request.packetName" type="text" class="form-control" id="inputProjectName" placeholder="packetPreUit">
        </div>
        <div class="col-md-6">
          <label for="inputProjectName" class="form-label name1">packetPreUnit</label>
          <input v-model="request.packetPreUnit" type="text" class="form-control" id="inputProjectName" placeholder="packetPreUit">
        </div>
        <div class="col-12 ">
          <button @click="save" type="button" class="button">confirm</button>
        </div>
        <div class="col-12 ">
          <button @click="this.$router.push('/pageProjectList')" type="button" class="button">back</button>
        </div>
      </form>
    </section>
  </div>
</template>

<script>
import axios from 'axios';
import Swal from "sweetalert2";

export default {
  name: 'AddProject',
  props: {
    msg: String
  },
  data() {
    return {
      request: {
        packetId: 0,
        packetName: "",
        packetPreUnit: "",
      },

    }
  },
  created() {
    if(this.$route.query.packetId){
      axios.get('http://localhost:8090/api/project/get/' + this.$route.query.packetId).then((response) => {
        this.request = response.data
      })
    }

  },
  methods: {
    async save() {
      await axios.post('http://localhost:8090/api/project/save', this.request).then((response) => {
        this.request = response.data
        Swal.fire('บันทึกสำเร็จ', '', 'success');
        this.$router.push('/pageProjectList')
      }).catch(() => {
        Swal.fire('บันทึกไม่สำเร็จ', '', 'error');
      })
      const headers = {
        'Content-Type': 'application/json'
      }
      await axios.post('http://localhost:8090/api/project/save', this.request, headers).then(() => {
        // this.request = response.data
        console.log(this.request)
      })
    },

  }
}
</script>
<style src="@vueform/multiselect/themes/default.css"></style>

<style scoped>
.plan {
  color: #79bd9d;
  font-family: "Agency FB";
  width: 100%;
  height: 100%;
}

.name1 {
  display: flex;
  font-family: "Agency FB";
  font-size: 20px;
  color: #79bd9d;
}

.button {
  display: inline-block;
  padding: 0px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #eaeaea;
  background-color: #79bd9d;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
  font-family: "Agency FB";
}

.button:hover {
  background-color: #79bd9d
}

.button:active {
  background-color: #79bd9d;
  box-shadow: 0 1px #666;
  transform: translateY(4px);
}

</style>
