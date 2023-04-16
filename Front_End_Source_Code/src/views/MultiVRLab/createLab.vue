<template>
  <div  style="width: 80%;text-align: center">

    <div style="display:inline-block;  padding: 10px;width: 100%;background-color: #f0f0f0">
      <div style="font-size: 18px; font-weight: bold">
        <span style="margin-right: 10px;; color: #F44336;">{{form.course}}&nbsp;</span>
        <span style="margin-right: 10px; color: #555;">选课人数:</span>
        <span style="color:red;">{{number}}</span>

      </div>
    </div>
    <div style="margin-top: 50px">
        <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" class="demo-form-inline" label-width="130px">

          <el-form-item label="实验名称" prop="lab">
            <el-input v-model="form.lab" placeholder="请输入创建的实验名称"></el-input>
          </el-form-item>
        </el-form>

      <div style="margin-top: 20px">

        <el-select  v-model="value" placeholder="请选择小组人数" style="display: inline-block">
          <el-option
              v-for="item in options"
              :lable="item.label"
              :key="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </div>
      <div  style="text-align: center;margin-top: 40px">

        <el-button type="primary" @click="create" size="medium" style="margin-right: 10px;margin-top: 15px">创建实验</el-button>
        <el-button type="warning" @click="goBack" size="medium">返回上步</el-button>

      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie"; // 导入封装好的axios请求函数

export default {
  name: "createLab",
  created() {

    this.form.course = this.$route.query.course
    this.load()
    this.form.teacher_name = this.teacher.teacher_name
    this.form.teacher_number = this.teacher.teacher_number

  },

  data(){

    return{

      number:'',
      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      form:{
        course :'',
        teacher_number:'',
        teacher_name:'',
        size_of_group:'',
        num_of_group:''
      },
      options: [{
        value: 2,
        label: 2
      },
        {
          value: 3,
          label: 3
        },{
          value: 4,
          label: 4
        },{
          value: 5,
          label: 5
        }],
      value: '',
      rules: {
        lab: [
          {required: true, message: '请输入实验名称', trigger: 'blur'},
        ],
      }
    }
  },
  methods:{
    load(){
      request.get('/courseSelect/countByTeacherNumberAndCourse/'+this.teacher.teacher_number+'/'+this.form.course,{

      }).then(res=>{
        if(res.code === '200')
          this.number = res.data
      })

    },
    create(){
      this.form.size_of_group = this.value
      this.form.num_of_group = this.number / this.value
      if(this.number % this.value != 0){
        this.form.num_of_group += 1
      }

      this.$refs["ruleForm"].validate((valid)=>{
        if(valid){
          if(this.value){
            if(this.number < this.value){
              this.$notify({
                title: "操作提示",
                message: "选课人数不足，请尝试修改小组人数",
                dangerouslyUseHTMLString: true,
                duration: 2000,

              });
            }
            else{
              request.post('/lab/save',this.form).then(res =>{
                if(res.code === '200'){
                  this.$notify({
                    title: "操作提示",
                    message: "创建成功",
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

          }else{
            this.$notify({
              title: "操作提示",
              message: "请输入实验名称",
              dangerouslyUseHTMLString: true,
              duration: 2000,

            });
          }
          }else{
          this.$notify({
            title: "操作提示",
            message: "请选择实验小组人数",
            dangerouslyUseHTMLString: true,
            duration: 2000,
          });
        }

      })

    },
    goBack(){
      this.$router.push("/startCreateLab")
    }
  },
}
</script>

<style scoped>

</style>