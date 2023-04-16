<template>
  <div  style="width: 80%;text-align: center">
    <h2 style="margin-bottom: 30px">编 辑 实 验 信 息</h2>
    <el-form :inline="true" :model="form" class="demo-form-inline" label-width="100px">
      <el-form-item label="课程名称">
        <el-input v-model="form.course" disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="实验名称">
        <el-input v-model="form.lab" disabled="true"></el-input>
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
    <div  style="text-align: center;margin-top: 30px">
      <el-button type="primary" @click="save" size="medium">提交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie";


export default {
  name: "editLab",
  data(){
    return{
      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      form:{
        course:'',
        lab:'',
        teacher_number:'',
        size_of_group: '',
        num_of_group: ''

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
      number:''
    }
  },
  created(){
    this.form.course = this.$route.query.course
    this.form.lab = this.$route.query.lab
    request.get('/courseSelect/countByTeacherNumberAndCourse/'+this.teacher.teacher_number+'/'+this.form.course,{

    }).then(res=>{
      if(res.code === '200')
        this.number = res.data
    })
  },
  methods:{
    save(){
      if(this.value){
        this.form.teacher_number = this.teacher.teacher_number
        console.log(this.form.teacher_number)
        this.form.size_of_group = this.value
        this.form.num_of_group = this.number / this.value
        if(this.number % this.value != 0){
          this.form.num_of_group += 1
        }

        request.put('/lab/update',this.form).then(res =>{
          if(res.code === '200'){
            this.$notify({
              title: "操作提示",
              message: "修改成功",
              dangerouslyUseHTMLString: true,
              duration: 2000,

            });

            this.$router.push("/labList")
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
          message: "请选择实验小组人数",
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