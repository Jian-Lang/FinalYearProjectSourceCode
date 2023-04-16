import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/home/HomeView.vue'
import Layout from "@/views/Layout.vue";

Vue.use(VueRouter)

const routes = [
    // 登录
  {
    path: '/adminLogin',
    name: 'adminLogin',
    component: () => import('@/views/login/adminLogin.vue')
  },

  {
    path: '/studentLogin',
    name: 'studentLogin',
    component: () => import('@/views/login/studentLogin.vue')
  },

  {
    path: '/teacherLogin',
    name: 'teacherLogin',
    component: () => import('@/views/login/teacherLogin.vue')
  },

  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: '/home',
    // 子路由
    children:[
      // 主页
      {
        path: 'home',
        name: 'Home',
        component: () => import('@/views/home/HomeView.vue')
      },
      // structedData

        // 课程信息
      {
        path: 'CourseList',
        name: 'CourseList',
        component: () => import('@/views/StructedData/courseList.vue')
      },
      {
        path: 'addCourse',
        name: 'addCourse',
        component: () => import('@/views/StructedData/addCourse.vue')
      },
      {
        path: 'editCourse',
        name: 'editCourse',
        component: () => import('@/views/StructedData/editCourse.vue')
      },

      // Admin
      {
        path: 'adminList',
        name: 'adminList',
        component: () => import('@/views/Admin/adminList.vue')
      },
      {
        path: 'addAdmin',
        name: 'addAdmin',
        component: () => import('@/views/Admin/addAdmin.vue')
      },
      {
        path: 'editAdmin',
        name: 'editAdmin',
        component: () => import('@/views/Admin/editAdmin.vue')
      },
        // student
      {
        path: 'studentList',
        name: 'studentList',
        component: () => import('@/views/Student/studentList.vue')
      },
      {
        path: 'addStudent',
        name: 'addStudent',
        component: () => import('@/views/Student/addStudent.vue')
      },
      {
        path: 'editStudent',
        name: 'editStudent',
        component: () => import('@/views/Student/editStudent.vue')
      },
        // teacher
      {
        path: 'teacherList',
        name: 'teacherList',
        component: () => import('@/views/Teacher/teacherList.vue')
      },
      {
        path: 'addTeacher',
        name: 'addTeacher',
        component: () => import('@/views/Teacher/addTeacher.vue')
      },
      {
        path: 'editTeacher',
        name: 'editTeacher',
        component: () => import('@/views/Teacher/editTeacher.vue')
      },
      // 多人实验
      {
        path: 'startCreateLab',
        name: 'startCreateLab',
        component: () => import('@/views/MultiVRLab/startCreateLab.vue')
      },
      {
        path: 'createLab',
        name: 'createLab',
        component: () => import('@/views/MultiVRLab/createLab.vue')
      },
      {
        path: 'addCourseSelect',
        name: 'addCourseSelect',
        component: () => import('@/views/MultiVRLab/addCourseSelect.vue')
      },
      {
        path: 'courseSelectList',
        name: 'courseSelectList',
        component: () => import('@/views/MultiVRLab/courseSelectList.vue')
      },
      {
        path: 'labList',
        name: 'labList',
        component: () => import('@/views/MultiVRLab/labList.vue')
      },
      {
        path: 'editLab',
        name: 'editLab',
        component: () => import('@/views/MultiVRLab/editLab.vue')
      },
      {
        path: 'labResultList',
        name: 'labResultList',
        component: () => import('@/views/MultiVRLab/labResultList.vue')
      },
      {
        path: 'startCreateQuestionnaire',
        name: 'startCreateQuestionnaire',
        component: () => import('@/views/MultiVRLab/startCreateQuestionnaire.vue')
      },
      {
        path: 'createQuestionnaire',
        name: 'createQuestionnaire',
        component: () => import('@/views/MultiVRLab/createQuestionnaire.vue')
      },
      {
        path: 'startEditQuestionnaire',
        name: 'startEditQuestionnaire',
        component: () => import('@/views/MultiVRLab/startEditQuestionnaire.vue')
      },
      {
        path: 'editQuestionnaire',
        name: 'editQuestionnaire',
        component: () => import('@/views/MultiVRLab/editQuestionnaire.vue')
      },
      {
        path: 'launchLab',
        name: 'launchLab',
        component: () => import('@/views/MultiVRLab/launchLab.vue')
      },
        // 非结构化数据
      {
        path: 'uploadFile',
        name: 'uploadFile',
        component: () => import('@/views/unstructedData/uploadFile.vue')
      },
      {
        path: 'fileList',
        name: 'fileList',
        component: () => import('@/views/unstructedData/fileList.vue')
      },
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
