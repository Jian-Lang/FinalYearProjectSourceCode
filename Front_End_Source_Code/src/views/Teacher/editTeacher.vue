<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 30px">编 辑 教 师 信 息</h2>
    <el-form :inline="true" :model="form" class="demo-form-inline" label-width="100px">

      <el-form-item label="学工号">
        <el-input v-model="form.teacher_number" disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.teacher_name" placeholder="请输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="手机号码">
        <el-input v-model="form.phone" placeholder="请输入手机号码"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
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
  name: "editTeacher",
  data(){
    return{
      form:{

      }
    }
  },
  created(){
    const teacher_number = this.$route.query.teacher_number
    request.get("teacher/" + teacher_number).then(res=>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.put('/teacher/update',this.form).then(res =>{
        if(res.code === '200'){
          this.$notify({
            title: "操作提示",
            message: "修改成功",
            dangerouslyUseHTMLString: true,
            duration: 2000,

          });
          // this.form = {}
          this.$router.push("/teacherList")
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