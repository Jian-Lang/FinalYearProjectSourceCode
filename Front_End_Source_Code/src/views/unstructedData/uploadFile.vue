<template>
  <div  style="text-align: center">
    <h2 style="margin-bottom: 50px">上 传 非 结 构 化 数 据</h2>
    <el-form :model="form" :rules="rules" ref="ruleUser" style="width: 400px;margin-left: 30%">
      <el-form-item label='序号' prop='id' :label-width="formLabelWidth" v-if="false">
        <el-input placeholder='请输入序号' clearable autocomplete="off" v-model='form.id' size="small"  />
      </el-form-item>
      <el-form-item label='文件名' prop='name' :label-width="formLabelWidth">
        <el-input placeholder='请输入文件名' clearable autocomplete="off" v-model='form.name' size="small"  />
      </el-form-item>
      <el-form-item label='文件类型' prop='type' :label-width="formLabelWidth">
        <el-select  v-model="form.type" placeholder="请选择">
          <el-option
                  v-for="item in typeOptions"
                  :lable="item.value"
                  :key="item.value"
                  :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label='上传文件' prop='url' :label-width="formLabelWidth">
        <el-upload
                class="upload-demo"
                action="/api/file/upload"
                :on-remove="handleRemove"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                multiple
                :limit="1"
                :on-exceed="handleExceed"
                :file-list="fileList">
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传一个文件，且文件大小不能超过500M</div>
        </el-upload>
<!--        <el-button size="small" type="success" v-if="download" @click="downloadFile">下载</el-button>-->
      </el-form-item>
      <el-form-item :label-width="formLabelWidth">
        <el-button @click="uploadfile" type="success">提交保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie"; // 导入封装好的axios请求函数

export default {
  name: "uploadUnstructedData",
  data(){
    const typeOptions=[
      {
        value:"视频"
      },
      {
        value:"图片"
      },
      {
        value:"文本"
      },
      {
        value:"VR模型数据"
      },
    ]
    return{
      typeOptions,
      form:this.initForm(),
      formLabelWidth:"100px",
      rules: {
        id :[
          {required: true, message: '请输入序号', trigger: 'blur'},],
        name :[
          {required: true, message: '请输入文件名', trigger: 'blur'},],
        type :[
          {required: true, message: '请输入文件类型', trigger: 'blur'},],
        url :[
          {required: true, message: '请输入文件链接', trigger: 'blur'},],
        ext1 :[
          {required: true, message: '请输入扩展字段', trigger: 'blur'},],
        ext2 :[
          {required: true, message: '请输入扩展字段', trigger: 'blur'},],
      },
      fileList:[],
      download:false,

    }
  },
  methods:{
    async uploadfile() {
      this.$refs.ruleUser.validate((valid) => {
        if (valid) {
          this.operatorUser()
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    async operatorUser() {
      request.post('/datainfo/insert',this.form).then(res =>{
        if(res.status === '200'){
          this.$message.success("提交成功");
          this.$router.push("/fileList")
        }else{
          this.$message.error("提交失败");
        }
      })
    },
    initForm() {//初始数据
      return {
        id : "", // 序号
        name : "", // 文件名
        type : "", // 文件类型
        url : "", // 下载链接
        ext1 : "", // 扩展字段
        ext2 : "", // 扩展字段
      }
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
      this.form.url=""
      this.download=false
    },
    handleExceed(files, fileList) {
      this.$message.error(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    handleAvatarSuccess(res, file) {
      console.log(res.data)
      console.log(file.response.status)
      if (file.response.status=="200"){
        this.form.url=file.response.data
        this.download=true
      }else {
        this.form.url=""
        this.download=false
      }
    },
    beforeAvatarUpload(file) {
      const isLt2M = file.size / 1024 / 1024 <= 500;
      if (!isLt2M) {
        this.$message.error('上传文件大小不能超过 500MB!');
      }
      return isLt2M;
    },
  }
}

</script>

<style scoped>

</style>
