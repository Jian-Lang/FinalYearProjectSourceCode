<template>
  <div style="height: 100vh;overflow: hidden">
    <div style="width: 520px; height: 400px; background-color: white;border-radius: 10px;
    margin: 150px auto;padding:50px">
      <div style="margin-top:-10px; text-align: center; font-size: 30px;font-weight: bold;color: dodgerblue">虚 拟 现 实 实 验 云 服 务 平 台 </div>
      <div style="margin: 20px; text-align: center; font-size: 30px;font-weight: bold;color: dodgerblue">学 生 登 录</div>
      <el-form :model="student" :rules="rules" ref="loginForm" >
        <el-form-item prop="student_number">
          <el-input placeholder="请输入学号" prefix-icon="el-icon-user" size="medium" v-model="student.student_number"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="请输入密码" prefix-icon="el-icon-lock" show-password size="medium" v-model="student.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" size="medium" type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
      <div style="text-align: right">
        <el-button type="success" @click="$router.push('/teacherLogin')">教师登录</el-button>
        <el-button type="warning" @click="$router.push('/adminLogin')">管理员登录</el-button></div>

    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from 'js-cookie';

export default {
  name: "studentLogin",
  created() {
    window.addEventListener('keydown', this.handkeyCode, true)//开启监听键盘按下事件
  },
  data(){
    return{
      student:{},
      rules: {
        student_number: [
          {required: true, message: '请输入学号', trigger: 'blur'},
          {min: 6, max: 9, message:'学号长度为6-9个字',trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 10, message:'密码长度在3-10个字',trigger: 'blur'}
        ]
      }
    }
  },
  methods:{
    login(){
      this.$refs["loginForm"].validate((valid)=>{
        if(valid){
          request.post('/student/login',this.student).then(res => {
            if (res.code === '200'){
              this.$notify({
                title: "登录提示",
                message: "欢迎 " + res.data.student_name + " 同学登录",
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
              Cookies.set('identifier',3)
              this.$router.push('/')
              if(res.data != null){
                  Cookies.set('student',JSON.stringify(res.data))

              }
            }
            else {
              this.$notify({
                title: "登录提示",
                message: res.msg,
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
              this.$router.push('/studentLogin')
            }
          })
        }else{
          this.$notify.error('输入的数据不符合要求')
        }
      })

    },
    handkeyCode(e) {
      console.log(e); // 打印出按键后的信息
      if(e.keyCode === 13 || e.keyCode === 32){
        this.login()
      }
    },
  }
}
</script>

<style scoped>

</style>