<template>
  <div>
  <!-- 搜索表单开始 -->
    <div>
      <el-input style="width: 240px" placeholder="请输入用户名" v-model="params.username"></el-input>
      <el-input style="width: 240px; margin-left: 5px" placeholder="请输入联系方式" v-model="params.phone"></el-input>
      <el-input style="width: 240px; margin-left: 5px" placeholder="请输入邮箱" v-model="params.email"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
      <el-button style="margin-left: 5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>
    <!-- 搜索表单结束 -->
    <el-table :data="tableData" stripe :header-cell-style="{'text-align':'center'}"
              :cell-style="{'text-align':'center'}">
      <el-table-column prop="id" label="编号" min-width="25%"></el-table-column>
      <el-table-column prop="username" label="用户名"></el-table-column>
      <el-table-column prop="phone" label="联系方式"></el-table-column>
      <el-table-column prop="email" label="邮箱"></el-table-column>
      <el-table-column prop="createtime" label="创建时间"></el-table-column>
      <el-table-column prop="updatetime" label="更新时间"></el-table-column>

      <el-table-column label="操作" min-width="100%">
        <template v-slot="scope">

          <el-button type="primary" @click="$router.push('/editAdmin?id=' + scope.row.id)">编辑</el-button>
          <el-popconfirm
              style="margin-left: 5px"
              title="你确定删除该管理员吗？"
              @confirm="del(scope.row.id)"
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
  name: 'Admin',
  data(){
    return {
      tableData:[],
      total: 0,
      params:{
        pageNum: 1,
        pageSize: 10,
        username: '',
        phone: '',
        email:''
      }
    }
  },
  created(){
    this.load()
    window.addEventListener('keydown', this.handkeyCode, true)//开启监听键盘按下事件
  },
  methods:{
    load(){
      // fetch('http://localhost:9090/user/list').then(res => res.json()).then(res => {
      //   console.log(res)
      //   this.tableData = res
      // }) fetch太低级了，用封装好的axios进行请求
      request.get('/admin/page',{
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
        username: '',
        phone: '',
        email:''
      }
      this.load()
    },
    handleCurrentChange(pageNum){
      // 点击分页按钮，触发分页效果
      // console.log(pageNum)
      this.params.pageNum = pageNum;
      this.load()
    },
    del(id){
      request.delete("admin/delete/" + id).then(res=>{
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