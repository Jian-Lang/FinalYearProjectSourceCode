<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 30px">编 辑 学 生 信 息</h2>
    <el-form :inline="true" :model="form" class="demo-form-inline" label-width="100px">

      <el-form-item label="学号">
        <el-input v-model="form.student_number" disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.student_name" placeholder="请输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
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
  name: "editStudent",
  data(){
    return{
      form:{

      }
    }
  },
  created(){
    const student_number = this.$route.query.student_number
    request.get("student/" + student_number).then(res=>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.put('/student/update',this.form).then(res =>{
        if(res.code === '200'){
          this.$notify({
            title: "操作提示",
            message: "修改成功",
            dangerouslyUseHTMLString: true,
            duration: 2000,

          });

          this.$router.push("/studentList")
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