<template>
  <div  style="width: 80%">
    <h2 style="margin-bottom: 30px;text-align: center">编 辑 管 理 员 信 息</h2>
    <el-form :inline="true" :model="form" class="demo-form-inline" label-width="100px">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email" placeholder="请输入年龄"></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
      </el-form-item>
    </el-form>
    <div  style="text-align: center;margin-top: 30px">
      <el-button type="primary" @click="save" size="medium">提交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "editAdmin",
  data(){
    return{
      form:{

      }
    }
  },
  created(){
    const id = this.$route.query.id
    request.get("admin/" + id).then(res=>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.put('/admin/update',this.form).then(res =>{
        if(res.code === '200'){
          this.$notify.success('更新成功')
          // this.form = {}
          this.$router.push("/adminList")
        }else{
          this.$notify.error(res.msg)
        }
      })
    }
  },
}
</script>

<style scoped>

</style>