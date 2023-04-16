<template>
  <div>
  <!-- 搜索表单开始 -->
    <div style="margin-bottom: 5px">
      <el-input style="width: 240px" placeholder="请输入课程名称" v-model="params.course" ></el-input>
      <el-input style="width: 240px; margin-left: 5px" placeholder="请输入实验名称" v-model="params.lab"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load"><i class="el-icon-search" ></i>搜索</el-button>
      <el-button style="margin-left: 5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>
    <!-- 搜索表单结束 -->
    <el-table :data="tableData" stripe  :header-cell-style="{'text-align':'center'}"
              :cell-style="{'text-align':'center'}">
      <el-table-column prop="course" label="课程名称"></el-table-column>
      <el-table-column prop="lab" label="实验名称"  ></el-table-column>
      <el-table-column prop="student_number" label="学号" ></el-table-column>
      <el-table-column prop="student_name" label="姓名"></el-table-column>
      <el-table-column prop="group_number" label="组号"></el-table-column>
      <el-table-column prop="time" label="用时"></el-table-column>
      <el-table-column prop="operate_count" label="操作次数"></el-table-column>
      <el-table-column prop="error_count" label="错误次数"></el-table-column>
      <el-table-column prop="tips_count" label="提示次数"></el-table-column>
      <el-table-column prop="grade" label="成绩"></el-table-column>




    </el-table>
    <!-- 页码显示部分 -->
    <div style="margin-top: 20px">
      <el-pagination
          background
          layout="prev, pager, next"
          :current-page="params.pageNum"
          @current-change="handleCurrentChange"
          :total="total"
          :page-size="params.pageSize">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie"; // 导入封装好的axios请求函数

export default {
  name: 'labResultList',
  data(){
    return {
      tableData:[],
      total: 0,
      params:{
        pageNum: 1,
        pageSize: 10,
        teacher_number: '',
        student_number: '',

      },
      student: Cookies.get('student') ? JSON.parse(Cookies.get('student')) : {},
      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      identifier: Cookies.get('identifier'),
    }
  },
  created(){
    if(this.identifier == 2){
      this.params.teacher_number = this.teacher.teacher_number
    }
    else if(this.identifier == 3){
      this.params.student_number = this.student.student_number

    }

    this.load()
    window.addEventListener('keydown', this.handkeyCode, true)//开启监听键盘按下事件
  },
  methods:{
    load(){
      if(this.identifier == 2){
        this.params.teacher_number = this.teacher.teacher_number
      }
      else if(this.identifier == 3){
        this.params.student_number = this.student.student_number
      }
      request.get('/mvta/page',{
        params: this.params
      }).then(res=>{
        if(res.code === '200')
          this.tableData = res.data.list
        this.total = res.data.total
      })
    },
    reset(){

      this.params = {
        pageNum: 1,
        pageSize: 10,
        course: '',
        lab: '',
        student_number: '',
        teacher_number: ''
      }
      if(this.identifier == 2){
        this.params.teacher_number = this.teacher.teacher_number
      }
      else if(this.identifier == 3){
        this.params.student_number = this.student.student_number
      }
      this.load()
    },
    handleCurrentChange(pageNum){
      // 点击分页按钮，触发分页效果
      // console.log(pageNum)
      this.params.pageNum = pageNum;
      this.load()
    },

    handkeyCode(e) {
      console.log(e); // 打印出按键后的信息
      if(e.keyCode === 13 || e.keyCode === 32){
        this.load()
      }
    },
  }

}
</script>

<style scoped>

</style>