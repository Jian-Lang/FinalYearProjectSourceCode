<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 45px">发 布 虚 拟 现 实 实 验</h2>
    <el-select v-model="course" placeholder="请选择课程" style="margin-right: 15px" @change="handleCourseChange">
      <el-option
          v-for="item in courses"
          :lable="item.course"
          :key="item.course"
          :value="item.course">
      </el-option>
    </el-select>
    <el-select v-model="lab" placeholder="请选择实验" :disabled="labDisabled" @change="handleLabChange">
      <el-option
          v-for="item in labs"
          :lable="item.lab"
          :key="item.lab"
          :value="item.lab">
      </el-option>
    </el-select>
    <div  style="text-align: center;margin-top: 80px">
      <el-button type="success" @click="launch" size="medium" style="margin-right: 15px" >发布实验</el-button>
      <el-button type="danger" @click="recall" size="medium" >收回实验</el-button>
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
        is_launched:'',
        teacher_number:'',
        course:'',
        lab:''
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

      request.get("courseSelect/listByTeacherNumber/" + this.teacher.teacher_number).then(res=>{
        this.courses = res.data
      })
    },
    handleCourseChange(){
      this.labDisabled = false
      this.lab = null
      request.get("lab/listByTeacherNumberAndCourse/" + this.teacher.teacher_number + "/" + this.course).then(res=>{
        this.labs = res.data
      })
    },
    launch(){
      if(this.lab && this.course){
        this.form.is_launched = 1
        this.form.teacher_number = this.teacher.teacher_number
        this.form.lab = this.lab
        this.form.course = this.course
        request.put('/lab/update_state_of_lab',this.form).then(res =>{
          if(res.code === '200'){
            this.$notify({
              title: "操作提示",
              message: "发布成功",
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
      }
      else{
        this.$notify({
          title: "操作提示",
          message: "请先选中一个实验",
          dangerouslyUseHTMLString: true,
          duration: 2000,
        });
      }
    },
    recall(){
      if(this.lab && this.course){
        this.form.is_launched = 0
        this.form.teacher_number = this.teacher.teacher_number
        this.form.lab = this.lab
        this.form.course = this.course
        request.put('/lab/update_state_of_lab',this.form).then(res =>{
          if(res.code === '200'){
            this.$notify({
              title: "操作提示",
              message: "收回成功",
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
      }
      else{
        this.$notify({
          title: "操作提示",
          message: "请先选中一个实验",
          dangerouslyUseHTMLString: true,
          duration: 2000,

        });
      }

    }
  },
}
</script>

<style scoped>

</style>