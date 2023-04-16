<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 45px">创 建 多 人 V R 实 验</h2>
    <el-select v-model="value" placeholder="请选择课程">
      <el-option
          v-for="item in options"
          :lable="item.course"
          :key="item.course"
          :value="item.course">
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
      options: [],
      value: '',
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
        this.options = res.data
      })
    },
    start(){
      if(this.value){
        this.$router.push('/createLab?course=' + this.value)
      }
      else{
        this.$notify({
          title: "操作提示",
          message: "请先选择课程",
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