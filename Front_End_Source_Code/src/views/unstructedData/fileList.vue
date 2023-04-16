<template>
  <div  style="text-align: center">
    <h2 style="margin-bottom: 50px">非 结 构 化 数 据 列 表</h2>
    <el-data-table ref="table" v-bind="tableConfig" :columns="columns">
    </el-data-table>

  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie"; // 导入封装好的axios请求函数

export default {
  name: "uploadUnstructedData",
  data(){
    const columns = [
      // {type: 'selection'},
      {prop: 'id',label: '序号'},
      {prop: 'name',label: '文件名'},
      {prop: 'type',label: '文件类型'},
      {prop: 'url',label: '下载链接',formatter:row => this.satateGetUrl(row)},
    ]
    const searchForm = [
      {
        type: 'input',
        id: 'name',
        label: '文件名',
        el: {placeholder: '请输入文件名', clearable: true},
      },
      {
        type: 'input',
        id: 'type',
        label: '文件类型',
        el: {placeholder: '请输入文件类型', clearable: true},
      },
      // {
      //   type: 'input',
      //   id: 'url',
      //   label: '下载链接',
      //   el: {placeholder: '请输入下载链接', clearable: true},
      // },
    ]
    return {
      columns,
      userinfo:{},
      tableConfig: {
        searchForm,
        url: '/api/datainfo/list',
        dataPath: 'data.list',
        totalPath: 'data.total',
        paginationSize:10,
        extraButtons: [
          // {
          //   type: 'primary',
          //   text: '编辑',
          //   icon: 'el-icon-edit-outline',
          //   atClick: async row => {
          //     this.handleEdit(row)
          //     return false
          //   },
          // },
          {
            type: 'primary',
            text: '删除',
            icon: 'el-icon-delete',
            atClick: async row => {
              this.handleDelete(row)
              return false
            },
          },
        ],
        headerButtons: [
          // {
          //   text: '新增',
          //   type: 'primary',
          //   atClick: async () => {
          //     this.handleInsert()
          //     return false
          //   },
          // },
          // {
          //   text: '批量删除',
          //   type: 'primary',
          //   disabled: selected => selected.length < 1,
          //   atClick: selected => {
          //     let ids = selected.map(item => item.id)
          //     this.Batch('delete', ids)
          //     return false
          //   },
          // },
        ],
        hasDelete: false,
        hasEdit: false,
        hasOperation: true,
        hasNew: false,
        operationAttrs: {
          width: '150px',
          fixed: 'right',
        },
      },
      form:this.initForm(),
      title:"",
      type:"",
      dialogFormVisible:false,
      formLabelWidth:"100px",
      rules: {
        id :[
          {required: true, message: '请输入序号', trigger: 'blur'},],
        name :[
          {required: true, message: '请输入文件名', trigger: 'blur'},],
        type :[
          {required: true, message: '请输入文件类型', trigger: 'blur'},],
        url :[
          {required: true, message: '请输入下载链接', trigger: 'blur'},],
        ext1 :[
          {required: true, message: '请输入扩展字段', trigger: 'blur'},],
        ext2 :[
          {required: true, message: '请输入扩展字段', trigger: 'blur'},],
      },
    }
  },
  methods:{
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
    satateGetUrl(row){
      if (row.url==""||row.url==undefined){
        return "无附件";
      } else {
        return <a href={row.url}>下载</a>
      }
    },
    handleDelete(row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.operatorDeleteUser(row)
      }).catch(() => {
        this.$message.info("已取消删除");
      });
    },
    async operatorDeleteUser(row) {
      request.delete("datainfo/delete?id=" + row.id).then(res=>{
        this.$refs.table.getList()
        if(res.status === '200'){
          this.$message.success(res.msg)
        }else{
          this.$message.error(res.msg)
        }
      })
    },
  },
}

</script>

<style scoped>

</style>
