<template>
  <div style="height: 100vh;overflow: hidden">
    <div style="width: 520px; height: 400px; background-color: white;border-radius: 10px;
    margin: 150px auto;padding:50px">
      <div style="margin-top:-10px; text-align: center; font-size: 30px;font-weight: bold;color: dodgerblue">虚 拟 现 实 实 验 云 服 务 平 台 </div>
      <div style="margin: 20px; text-align: center; font-size: 30px;font-weight: bold;color: dodgerblue">教 师 登 录</div>
      <el-form :model="teacher" :rules="rules" ref="loginForm" >
        <el-form-item prop="teacher_number">
          <el-input placeholder="请输入学工号" prefix-icon="el-icon-user" size="medium" v-model="teacher.teacher_number"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="请输入密码" prefix-icon="el-icon-lock" show-password size="medium" v-model="teacher.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" size="medium" type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
      <div style="text-align: right">
        <el-button type="success" @click="$router.push('/adminLogin')">管理员登录</el-button>
        <el-button type="warning" @click="$router.push('/studentLogin')">学生登录</el-button></div>

    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from 'js-cookie';

export default {
  name: "teacherLogin",
  created() {
    window.addEventListener('keydown', this.handkeyCode, true)//开启监听键盘按下事件
  },
  data(){
    return{
      teacher:{},
      rules: {
        teacher_number: [
          {required: true, message: '请输入学工号', trigger: 'blur'},
          {min: 3, max: 10, message:'学工号长度在3-10个字',trigger: 'blur'}
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
          request.post('/teacher/login',this.teacher).then(res => {
            if (res.code === '200'){

              this.$notify({
                title: "登录提示",
                message: "欢迎 " + res.data.teacher_name + " 老师登录",
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
              Cookies.set('identifier',2)
              this.$router.push('/')
              if(res.data != null){
                  Cookies.set('teacher',JSON.stringify(res.data))
              }
            }
            else {
              this.$notify({
                title: "登录提示",
                message: res.msg,
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
              this.$router.push('/teacherLogin')
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