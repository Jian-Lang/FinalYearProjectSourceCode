<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 50px">录 入 教 师 信 息</h2>
    <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" class="demo-form-inline" label-width="100px">
      <el-form-item label="学工号" prop="teacher_number">
        <el-input v-model="form.teacher_number" placeholder="请输入学工号"></el-input>
      </el-form-item>
      <el-form-item label="姓名" prop="teacher_name">
        <el-input  v-model="form.teacher_name" placeholder="请输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="手机号码" prop="phone">
        <el-input v-model="form.phone" placeholder="请输入手机号码"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
      </el-form-item>
    </el-form>
    <div  style="text-align: center;margin-top: 40px">
      <el-button type="primary" @click="save" size="medium">提交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie"; // 导入封装好的axios请求函数

export default {
  name: "addTeacher",
  data(){

    return{

      form:{

      },
      rules: {
        teacher_number: [
          {required: true, message: '请输入学工号', trigger: 'blur'},

        ],
        teacher_name: [
          { required: true, message: '请输入姓名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    }
  },
  methods:{
    save(){
      this.$refs["ruleForm"].validate((valid)=>{
        if(valid){

          request.post('/teacher/save',this.form).then(res =>{
            if(res.code === '200'){
              this.$notify({
                title: "操作提示",
                message: "录入成功",
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
            }else{
              this.$notify({
                title: "操作提示",
                message: res.msg,
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
            }
          })
        }else{
          this.$notify.error('输入的数据不符合要求')
        }
      })

    }
  },
}
</script>

<style scoped>

</style>