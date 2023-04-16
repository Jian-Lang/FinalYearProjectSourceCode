<template>
  <div>
  <!-- 搜索表单开始 -->
    <div style="margin-bottom: 5px">
      <el-input style="width: 240px" placeholder="请输入学号进行查询" v-model="params.student_number"></el-input>
      <el-input style="width: 240px; margin-left: 5px" placeholder="请输入姓名进行查询" v-model="params.student_name"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
      <el-button style="margin-left: 5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>
    <!-- 搜索表单结束 -->
    <el-table :data="tableData" stripe  :header-cell-style="{'text-align':'center'}"
              :cell-style="{'text-align':'center'}">
      <el-table-column prop="student_number" label="学号" min-width="45%" ></el-table-column>
      <el-table-column prop="student_name" label="姓名" ></el-table-column>
      <el-table-column prop="password" label="密码"></el-table-column>
      <el-table-column prop="createtime" label="录入时间"></el-table-column>
      <el-table-column prop="updatetime" label="更新时间"></el-table-column>

      <el-table-column label="操作" min-width="100%">
        <template v-slot="scope">
          <el-button type="primary" @click="$router.push('/editStudent?student_number=' + scope.row.student_number)">编辑</el-button>
          <el-popconfirm
              style="margin-left: 5px"
              title="你确定删除这行数据吗？"
              @confirm="del(scope.row.student_number)"
          >
            <el-button type="danger" slot="reference">删除</el-button>
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
import request from "@/utils/request"; // 导入封装好的axios请求函数

export default {
  name: 'studentList',
  data(){
    return {
      tableData:[],
      total: 0,
      params:{
        pageNum: 1,
        pageSize: 10,
        student_number: '',
        student_name: ''
      }
    }
  },
  created(){
    this.load()
    window.addEventListener('keydown', this.handkeyCode, true)//开启监听键盘按下事件
  },
  methods:{
    load(){
      request.get('/student/page',{
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
        student_name: ''
      }
      this.load()
    },
    handleCurrentChange(pageNum){
      // 点击分页按钮，触发分页效果
      // console.log(pageNum)
      this.params.pageNum = pageNum;
      this.load()
    },
    del(student_number){
      request.delete("student/delete/" + student_number).then(res=>{
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