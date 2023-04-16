<template>
  <div>
  <!-- 搜索表单开始 -->
    <div style="margin-bottom: 5px">
      <el-input style="width: 240px" placeholder="请输入学生学号" v-model="params.student_number" :disabled="searchDataDisabled"></el-input>
      <el-input style="width: 240px; margin-left: 5px" placeholder="请输入学生姓名" v-model="params.student_name" :disabled="searchDataDisabled"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load" :disabled="searchDataDisabled"><i class="el-icon-search" ></i>搜索</el-button>
      <el-button style="margin-left: 5px" type="warning" @click="reset":disabled="searchDataDisabled"><i class="el-icon-refresh"></i>重置</el-button>
    </div>
    <!-- 搜索表单结束 -->
    <el-table :data="tableData" stripe  :header-cell-style="{'text-align':'center'}"
              :cell-style="{'text-align':'center'}">
      <el-table-column prop="course" label="课程名称"></el-table-column>
      <el-table-column prop="student_number" label="学号"  ></el-table-column>
      <el-table-column prop="student_name" label="姓名" ></el-table-column>
      <el-table-column prop="grade" label="成绩"></el-table-column>
      <el-table-column prop="teacher_name" label="授课教师"></el-table-column>
      <el-table-column prop="createtime" label="创建时间"></el-table-column>
      <el-table-column prop="updatetime" label="更新时间"></el-table-column>

      <el-table-column label="操作">
        <template v-slot="scope">
          <el-button type="primary" @click="$router.push('/editCourse?student_number=' + scope.row.student_number + '&course=' + scope.row.course)":disabled="editDataDisabled">编辑</el-button>
          <el-popconfirm
              style="margin-left: 5px"
              title="你确定删除这行数据吗？"
              @confirm="del(scope.row.student_number,scope.row.course)"
          >
            <el-button type="danger" slot="reference" :disabled="editDataDisabled">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>

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
  name: 'courseList',
  data(){
    return {
      tableData:[],
      total: 0,
      params:{
        pageNum: 1,
        pageSize: 10,
        teacher_number: '',
        student_number: '',
        student_name: ''
      },
      student: Cookies.get('student') ? JSON.parse(Cookies.get('student')) : {},
      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      identifier: Cookies.get('identifier'),
      editDataDisabled: false,
      searchDataDisabled: false
    }
  },
  created(){
    if(this.identifier == 2){
      this.params.teacher_number = this.teacher.teacher_number
    }
    else if(this.identifier == 3){
      this.params.student_number = this.student.student_number
      this.editDataDisabled = true
      this.searchDataDisabled = true
    }

    this.load()
    window.addEventListener('keydown', this.handkeyCode, true)//开启监听键盘按下事件
  },
  methods:{
    load(){
      request.get('/course/page',{
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
        student_number: '',
        student_name: '',
        teacher_number: this.teacher.teacher_number

      }

      this.load()
    },
    handleCurrentChange(pageNum){
      // 点击分页按钮，触发分页效果
      // console.log(pageNum)
      this.params.pageNum = pageNum;
      this.load()
    },
    del(student_number,course){
      request.delete("course/delete/" + student_number + "/" + course).then(res=>{
        if(res.code === '200'){
          this.$notify({
            title: "操作提示",
            message: "删除成功",
            dangerouslyUseHTMLString: true,
            duration: 2000,

          });
          this.load()
        }else{
          this.$notify({
            title: "操作提示",
            message: res.msg,
            dangerouslyUseHTMLString: true,
            duration: 2000,

          });
        }
      })

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