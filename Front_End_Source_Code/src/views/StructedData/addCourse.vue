<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 50px">录 入 课 程 信 息</h2>
    <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" class="demo-form-inline" label-width="100px">
      <el-form-item label="学号" prop="student_number">
        <el-input v-model="form.student_number" placeholder="请输入学生学号"></el-input>
      </el-form-item>
      <el-form-item label="姓名" prop="student_name">
        <el-input v-model="form.student_name" placeholder="请输入学生姓名"></el-input>
      </el-form-item>
      <el-form-item label="课程名称" prop="course">
        <el-input v-model="form.course" placeholder="请输入课程名称"></el-input>
      </el-form-item>
      <el-form-item label="成绩" prop="grade">
        <el-input v-model="form.grade" placeholder="请输入成绩"></el-input>
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
  name: "addCourse",
  data(){

    return{
      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      form:{
        teacher_number: '',
        teacher_name :''
      },
      rules: {
        student_number: [
          {required: true, message: '请输入学生学号', trigger: 'blur'},

        ],
        student_name: [
          { required: true, message: '请输入学生姓名', trigger: 'blur' }
        ],
        course: [
          { required: true, message: '请输入课程名称', trigger: 'blur' }
        ],
        grade: [
          { required: true, message: '请输入成绩', trigger: 'blur' }
        ],
      }
    }
  },
  methods:{
    save(){
      this.$refs["ruleForm"].validate((valid)=>{
        if(valid){
          this.form.teacher_name = this.teacher.teacher_name
          this.form.teacher_number = this.teacher.teacher_number
          request.post('/course/save',this.form).then(res =>{
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