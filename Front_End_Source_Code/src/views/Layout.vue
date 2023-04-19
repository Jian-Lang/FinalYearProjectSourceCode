<template>
  <div>
    <!-- 头部区域开始 -->
    <div style="height: 60px;line-height: 60px;background-color: white;margin-bottom: 2px;display: flex">
      <div style="width: 500px;">
        <img src="@/assets/logo.png" alt="" style="width: 40px; height: 40px; position:relative; top:13px; left: 20px">
        <span style="margin-left: 30px;font-size: 24px;font-weight: bold">虚 拟 现 实 实 验 云 服 务 平 台 </span>
      </div>
      <div style="flex: 1;text-align: right;padding-right: 20px">
        <el-dropdown size="medium">
        <span class="el-dropdown-link" style="cursor: pointer">
         {{ job }}&nbsp;&nbsp;{{ name }}<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
          <el-dropdown-menu slot="dropdown" style="margin-top: -5px">
            <el-dropdown-item><div style="width: 50px;text-align: center;" @click="logout">退出</div></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>

    </div>
    <!-- 头部区域结束 -->

    <!-- 侧边栏与主体区域开始 -->
    <div style="display: flex">
      <!-- 侧边栏部分开始 calc(100vh - 62px) overflow-->
      <div style="width: 200px;min-height:calc(100vh - 62px);margin-right: 2px;background-color: white">
        <el-menu :default-active="$route.path" router class="el-menu-demo">
          <el-menu-item index="/" >
            <i class="el-icon-school" style="color: black"></i>
            <span>首页</span>
          </el-menu-item>

          <el-submenu index="structedData" :disabled="structedDataDisabled">
            <template slot="title">
              <i class="el-icon-s-data" style="color: darkorange"></i>
              <span>结构化数据管理</span>
            </template>
            <el-menu-item index="/addCourse" :disabled="addDataDisabled">历史课程信息录入</el-menu-item>
            <el-menu-item index="/courseList">历史课程信息列表</el-menu-item>
          </el-submenu>

          <el-submenu index="unstructedData" :disabled="unstructedDataDisabled">
            <template slot="title">
              <i class="el-icon-files"></i>
              <span>非结构化数据管理</span>
            </template>
            <el-menu-item index="/uploadFile" :disabled="unstructedDataUploadDisabled">数据上传</el-menu-item>
            <el-menu-item index="/fileList">数据列表</el-menu-item>
          </el-submenu>

          <el-submenu index="mvta">
            <template slot="title">
              <i class="el-icon-s-flag" style="color: crimson"></i>
              <span>多人VR实验管理</span>
            </template>
            <el-menu-item index="/addCourseSelect" :disabled="courseSelectDisabled">选课信息录入</el-menu-item>
            <el-menu-item index="/courseSelectList" :disabled="courseSelectDisabled">选课信息列表</el-menu-item>
            <el-menu-item index="/startCreateLab" :disabled="VRLabDisabled">虚拟实验创建</el-menu-item>
            <el-menu-item index="/startCreateQuestionnaire" :disabled="VRLabDisabled">实验问卷创建</el-menu-item>
            <el-menu-item index="/startEditQuestionnaire" :disabled="VRLabDisabled">实验问卷编辑</el-menu-item>
            <el-menu-item index="/launchLab" :disabled="VRLabDisabled">虚拟实验发布</el-menu-item>
            <el-menu-item index="/labList" :disabled="VRLabDisabled">已发布实验列表</el-menu-item>
            <el-menu-item index="/labResultList" :disabled="VRLabResultDisabled">实验结果列表</el-menu-item>
          </el-submenu>

          <el-submenu index="admin" :disabled="adminDisabled">
            <template slot="title">
              <i class="el-icon-s-custom" style="color: black;"></i>
              <span>管理员管理</span>
            </template>
            <el-menu-item index="/addAdmin" >管理员添加</el-menu-item>
            <el-menu-item index="/adminList">管理员列表</el-menu-item>
          </el-submenu>

          <el-submenu index="teacher" :disabled="adminDisabled">
            <template slot="title">
              <i class="el-icon-s-custom" style="color: dodgerblue"></i>
              <span>教师管理</span>
            </template>
            <el-menu-item index="/addTeacher" >教师信息录入</el-menu-item>
            <el-menu-item index="/teacherList">教师列表</el-menu-item>
          </el-submenu>

          <el-submenu index="student" :disabled="adminDisabled">
            <template slot="title">
              <i class="el-icon-s-custom" style="color: #42b983"></i>
              <span>学生管理</span>
            </template>
            <el-menu-item index="/addStudent" >学生信息录入</el-menu-item>
            <el-menu-item index="/studentList">学生列表</el-menu-item>
          </el-submenu>

        </el-menu>
      </div>
      <!-- 侧边栏部分结束 -->
      <!-- 主体区域开始 -->
      <div style="flex: 1;background-color: white; padding: 10px">
        <router-view/>
      </div>
      <!-- 主体区域结束 -->
    </div>
    <!-- 侧边栏与主题区域结束 -->
  </div>
</template>

<script>
import Cookies from "js-cookie";
export default {
  name: "Layout",
  created() {
    if(this.identifier == 1){
      this.name = this.admin.username
      this.job = "管理员"
      this.adminDisabled = false
      this.courseSelectDisabled = false
    }
    else if(this.identifier == 2){
      this.name = this.teacher.teacher_name
      this.job = "教师"
      this.structedDataDisabled = false
      this.addDataDisabled = false
      this.VRLabDisabled = false
      this.VRLabResultDisabled = false
      this.unstructedDataDisabled = false
      this.unstructedDataUploadDisabled = false

    }
    else if(this.identifier == 3){
      this.name = this.student.student_name
      this.job = "学生"
      this.structedDataDisabled = false
      this.VRLabResultDisabled = false
      this.unstructedDataDisabled = false

    }
  },
  data(){
    return {
      admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {},
      student: Cookies.get('student') ? JSON.parse(Cookies.get('student')) : {},
      teacher: Cookies.get('teacher') ? JSON.parse(Cookies.get('teacher')) : {},
      identifier: Cookies.get('identifier'),
      name: "",
      job: "",
      adminDisabled: true,
      structedDataDisabled : true,
      unstructedDataDisabled : true,
      addDataDisabled: true,
      courseSelectDisabled: true,
      VRLabDisabled: true,
      VRLabResultDisabled: true,
      unstructedDataUploadDisabled : true,

    }
  },
  methods:{
    logout() {
      // 清除cookie
      Cookies.remove('admin')
      Cookies.remove('student')
      Cookies.remove('teacher')
      Cookies.remove('identifier')
      this.$router.push('/adminLogin')
    }
  }
}
</script>

<style scoped>

</style>