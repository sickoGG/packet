<template>
  <div class="card ">
    <div class="card-header">
      <div class="row">
        <div class="col-md-10 text-center">
          <span style="font-size: 25px">
           Packet
          </span>
        </div>
        <div class="col-md-2 text-end" style="size: 5px">
          <a href="/pageAddProject">
            <button type="button" class="btn btn-block btn-warning">
              <img src="@/assets/grade.png" alt="icon" class="brand-image img-circle elevation-3" style="width: 25px">
              Add Packet
            </button>
          </a>
        </div>
      </div>
    </div>

    <div class="card-body">
      <table class="table table-bordered table-striped dataTable dtr-inline">
        <thead>
        <tr>
          <th scope="col">packetId</th>
          <th scope="col">packetName</th>
          <th scope="col">packetPreUnit</th>
          <th scope="col">createdDate</th>
          <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(test,index) in projectList " :key="index+test">
          <td>{{test.packetId}}</td>
          <td>{{test.packetName}}</td>
          <td>{{test.packetPreUnit}}</td>
          <td>{{test.createdDate}}</td>
          <td class="text-right">
            <button type="button" class="btn btn-success btn-sm" @click="getProject(test.packetId)">
              <i class="fas fa-pencil-alt">
              </i>
              Edit
            </button>
            <button class="btn btn-danger btn-sm ms-1" @click="deleteProject(test.packetId)">
              <i class="fas fa-trash">
              </i>
              Delete
            </button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>

  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h3 >แก้ไขข้อมูล</h3>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form class="row g-3">
            <div class="col-md-12">
              <label for="inputProjectName" class="form-label name1">Project Name</label>
              <input v-model="edit.projectName" type="text" class="form-control" id="inputProjectName" placeholder="ระบุชื่อโปรเจก">
            </div>
            <div class="col-md-12">
              <label for="inputPerson" class="form-label name1">Person</label>
              <input v-model="edit.person"  type="text" class="form-control" id="inputPerson" placeholder="ระบุชื่อผู้รับผิดชอบ">
            </div>
            <div class="col-md-12">
              <label for="inputProgress" class="form-label name1">Progress</label>
              <input v-model="edit.progress" type="text" class="form-control" id="inputProgress" placeholder="ระบุความคืบหน้า">
            </div>
            <div class="col-md-6">
              <label for="datePicker1" class="form-label name1">Date Start</label>
              <input v-model="edit.dateStart" type="date" id="datePicker1"  class="form-control">
            </div>
            <div class="col-md-6">
              <label for="datePicker2" class="form-label name1">Date End</label>
              <input v-model="edit.dateEnd" type="date" id="datePicker2"  class="form-control">
            </div>
            <div class="col-md-3">
              <label for="inputDayWork" class="form-label name1">Day Work</label>
              <div class="input-group">
                <input v-model="edit.dayWork" type="text" class="form-control" id="inputDayWork " aria-describedby="inputDayWork">
                <span class="input-group-text" id="inputDayWork">Day</span>
              </div>
            </div>
            <div class="col-md-5">
              <label for="inputState" class="form-label name1">Status</label>
              <select id="inputState" class="form-select" v-model="edit.status">
                <option selected disabled value="">โปรดเลือก...</option>
                <option>สําเร็จ</option>
                <option>ไม่สําเร็จ</option>
                <option>กำลังดำเนินงาน</option>
              </select>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary " @click="editProject" data-bs-dismiss="modal">Save</button>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" >Close</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Swal from "sweetalert2";
import axios from "axios";
export default {
  name: "projectList",
  props: {
    msg: String
  },
  data(){
    return{
      // pre data
      projectList: [],

      edit:{
        projectName:"",
        person:"",
        progress:"",
        dateStart:"",
        dateEnd:"",
        dayWork:"",
        status:"",
      },
    }
  },
  created() {
    this.test();
  },
  methods: {
    logout(){
      localStorage.removeItem('token')
    },
    async test() {
      await axios.get('http://localhost:8090/api/project/list').then((response) => {
        this.projectList = response.data

      })
    },
    deleteProject(packetId){
      Swal.fire({
        title: 'คุณต้องการลบข้อมูลใช่หรือไม่?',
        text: "คุณจะไม่สามารถกู้คืนข้อมูลได้หากคุณลบ!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'ใช่, ลบข้อมูล!',
        cancelButtonText: 'ยกเลิก'
      }).then((result) => {
        if (result.isConfirmed) {
          axios.delete('http://localhost:8090/api/project/delete/'+packetId).then(() => {
            this.test();
          })
          Swal.fire(
            'ลบข้อมูลสำเร็จ!',
            'ข้อมูลของคุณถูกลบแล้ว',
            'success'
          )
        }
      })


    },
    editProject(){
      Swal.fire({
        position: 'top-center',
        icon: 'success',
        title: 'บันทึกสำเร็จ',
        showConfirmButton: false,
        timer: 1500
      })
      // console.log(id)
      axios.post('http://localhost:8090/api/project/save',this.edit).then(() => {
        // this.request = response.data
      })
    },

    getProject(packetId){
      this.$router.push({path: '/pageAddProject', query: { packetId: packetId }})
    },
  }
}
</script>

<style scoped>
.plan{
  color: #a0a1ee;
  font-family: "Agency FB";
  width: 100%;
  height: 100%;

}

.name1{
  display: flex;
  font-family: "Agency FB";
  font-size: 20px;
  color: #79bd9d;
}


</style>
