<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 45px">创 建 实 验 问 卷</h2>
    <el-select v-model="course" placeholder="请选择课程" style="margin-right: 15px" @change="handleChange">
      <el-option
          v-for="item in courses"
          :lable="item.course"
          :key="item.course"

          :value="item.course">
      </el-option>
    </el-select>
    <el-select v-model="lab" placeholder="请选择实验" :disabled="labDisabled">
      <el-option
          v-for="item in labs"
          :lable="item.lab"
          :key="item.lab"
          :value="item.lab">
      </el-option>
    </el-select>
    <div  style="text-align: center;margin-top: 60px">
      <el-button type="primary" @click="start" size="medium">开始创建</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie"; // 导入封装好的axios请求函数

export default {
  name: "startCreateLab",
  created() {
    this.load()
  },

  data(){

    return{
      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      courses: [],
      course: '',
      labs: [],
      lab:'',
      labDisabled: true,
      form:{

      },
      rules: {
        student_number: [
          {required: true, message: '请输入学生学号', trigger: 'blur'},

        ],
      }
    }
  },
  methods:{
    load(){
      // fetch('http://localhost:9090/user/list').then(res => res.json()).then(res => {
      //   console.log(res)
      //   this.tableData = res
      // }) fetch太低级了，用封装好的axios进行请求

      request.get("courseSelect/listByTeacherNumber/" + this.teacher.teacher_number).then(res=>{
        this.courses = res.data
      })
    },
    start(){
      if(this.course && this.lab){
        this.$router.push('/createQuestionnaire?course=' + this.course + "&lab=" + this.lab)
      }
      else{
        this.$notify({
          title: "操作提示",
          message: "请先选择课程和实验",
          dangerouslyUseHTMLString: true,
          duration: 2000,

        });
      }
    }
    ,
    handleChange(){
      this.labDisabled = false
      this.lab = null
      console.log(this.course)
      request.get("lab/listByTeacherNumberAndCourse/" + this.teacher.teacher_number + "/" + this.course).then(res=>{
        this.labs = res.data
      })
    }
  },
}
</script>

<style scoped>

</style>