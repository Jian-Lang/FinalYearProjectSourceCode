<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 50px">添 加 管 理 员</h2>
    <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" class="demo-form-inline" label-width="70px">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
      </el-form-item>
    </el-form>
    <div  style="text-align: center;margin-top: 40px">
      <el-button type="primary" @click="save" size="medium">提交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request"; // 导入封装好的axios请求函数

export default {
  name: "addAdmin",
  data(){
    const checkPhone = (rule, value, callback) => {
      if (!/[1][3,4,5,6,7,8,9][0-9]{9}$/.test(value)) {
        callback(new Error('请输入有效手机号'));
      }
      callback()
    };
    return{
      form:{
      },
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 10, message:'用户名长度在3-10个字',trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 6, max: 10, message:'密码长度在6-10个字',trigger: 'blur'}
        ],
        phone: [
          { validator: checkPhone, trigger: 'blur' }
        ]
      }
    }
  },
  methods:{
    save(){
      this.$refs["ruleForm"].validate((valid)=>{
        if(valid){
          request.post('/admin/save',this.form).then(res =>{
            if(res.code === '200'){
              this.$notify({
                title: "操作提示",
                message: "添加成功",
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