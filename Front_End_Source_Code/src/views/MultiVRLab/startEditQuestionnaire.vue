<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 45px">编 辑 实 验 问 卷</h2>
    <el-select v-model="course" placeholder="请选择课程" style="margin-right: 15px" @change="handleCourseChange">
      <el-option
          v-for="item in courses"
          :lable="item.course"
          :key="item.course"

          :value="item.course">
      </el-option>
    </el-select>
    <el-select v-model="lab" placeholder="请选择实验" style="margin-right: 15px" :disabled="labDisabled" @change="handleLabChange">
      <el-option
          v-for="item in labs"
          :lable="item.lab"
          :key="item.lab"
          :value="item.lab">
      </el-option>
    </el-select>

    <el-select v-model="questionnaire_name" placeholder="请选择问卷" :disabled="questionnaireDisabled">
      <el-option
          v-for="item in questionnaire_names"
          :lable="item.questionnaire_name"
          :key="item.questionnaire_name"
          :value="item.questionnaire_name">
      </el-option>
    </el-select>
    <div  style="text-align: center;margin-top: 80px">
      <el-button type="primary" @click="edit" size="medium" style="margin-right: 15px">编辑问卷</el-button>

      <el-popconfirm
          style="margin-left: 5px"
          title="你确定删除这行数据吗？"
          @confirm="del()"
      >
        <el-button type="danger" slot="reference" size="medium">删除问卷</el-button>
      </el-popconfirm>
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
      questionnaire_name:'',
      questionnaire_names:[],
      labDisabled: true,
      questionnaireDisabled: true,
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
      request.get("courseSelect/listByTeacherNumber/" + this.teacher.teacher_number).then(res=>{
        this.courses = res.data
      })
    },
    edit(){
      if(this.course && this.lab && this.questionnaire_name){
        this.$router.push('/editQuestionnaire?course=' + this.course + '&lab=' + this.lab + '&questionnaire_name=' + this.questionnaire_name)
      }
      else{
        this.$notify({
          title: "操作提示",
          message: "请先选中要编辑的问卷",
          dangerouslyUseHTMLString: true,
          duration: 2000,
        });
      }
    },
    del(){
      if(this.course && this.lab && this.questionnaire_name){
        request.delete("questionnaire/delete/" + this.teacher.teacher_number + "/" + this.course + "/" + this.lab + "/" + this.questionnaire_name).then(res=>{
          if(res.code === '200'){
            this.$notify({
              title: "操作提示",
              message: "删除成功",
              dangerouslyUseHTMLString: true,
              duration: 2000,
            });
            this.handleLabChange()
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
          message: "请先选中要删除的问卷",
          dangerouslyUseHTMLString: true,
          duration: 2000,
        });
      }

    },
    handleCourseChange(){
      this.labDisabled = false
      this.lab = null
      this.questionnaire_name = null
      this.questionnaire_names = []

      request.get("lab/listByTeacherNumberAndCourse/" + this.teacher.teacher_number + "/" + this.course).then(res=>{
        this.labs = res.data
      })
    },
    handleLabChange(){
      this.questionnaireDisabled = false
      this.questionnaire_name = null

      request.get("questionnaire/listByTeacherNumberAndCourseAndLab/" + this.teacher.teacher_number + "/" + this.course+ "/" + this.lab).then(res=>{
        this.questionnaire_names = res.data
      })
    }
  },
}
</script>

<style scoped>

</style>