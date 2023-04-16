<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 30px">学 生 成 绩 修 改</h2>
    <el-form :inline="true" :model="form" class="demo-form-inline" label-width="100px">

      <el-form-item label="学号">
        <el-input v-model="form.student_number" disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.student_name" disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="课程名称">
        <el-input v-model="form.course" disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="成绩">
        <el-input v-model="form.grade" placeholder="请输入成绩"></el-input>
      </el-form-item>

    </el-form>
    <div  style="text-align: center;margin-top: 30px">
      <el-button type="primary" @click="save" size="medium">提交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";


export default {
  name: "editCourse",
  data(){
    return{
      form:{

      }
    }
  },
  created(){
    const student_number = this.$route.query.student_number
    const course = this.$route.query.course
    request.get("course/" + student_number + "/" + course).then(res=>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.put('/course/update',this.form).then(res =>{
        if(res.code === '200'){
          this.$notify({
            title: "操作提示",
            message: "修改成功",
            dangerouslyUseHTMLString: true,
            duration: 2000,

          });
          // this.form = {}
          this.$router.push("/courseList")
        }else{
          this.$notify({
            title: "操作提示",
            message: res.msg,
            dangerouslyUseHTMLString: true,
            duration: 2000,

          });
        }
      })
    }
  },
}
</script>

<style scoped>

</style>