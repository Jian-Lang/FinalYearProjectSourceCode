import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'element-ui/lib/theme-chalk/index.css';
import ElementUI from 'element-ui';
import '@/assets/global.css'
import ElFormRenderer from '@femessage/el-form-renderer'
import ElDataTable from '@femessage/el-data-table'
import axios from 'axios'

Vue.config.productionTip = false
Vue.use(ElementUI,{size:'small'});
Vue.component('el-form-renderer', ElFormRenderer)
Vue.component('el-data-table', ElDataTable)
Vue.prototype.$axios = axios;

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
