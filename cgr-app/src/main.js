import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Toast from "components/common/toast";
import jqueryForm from 'jquery-form'
import VueAwesomeSwiper from 'vue-awesome-swiper'

import vuePicturePreview from 'vue-picture-preview'

Vue.use(vuePicturePreview)

import 'swiper/swiper-bundle.css'
import VideoPlayer from 'vue-video-player'
Vue.use(VideoPlayer);

Vue.use(VueAwesomeSwiper, /* { default options with global component } */)

Vue.use(jqueryForm)

Vue.use(Toast)
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  data:function (){
    return{
      defaulturl:'http://localhost:8888/cgr',
      vuedefaulturl:'http://localhost:8080',
      userid:JSON.parse(sessionStorage.getItem("userid")),
      username:JSON.parse(sessionStorage.getItem("username")),
      usersex:JSON.parse(sessionStorage.getItem("usersex")),
      userbrith:JSON.parse(sessionStorage.getItem("userbrith")),
      userimg:JSON.parse(sessionStorage.getItem("userimg")),
      usermyspaceimg:JSON.parse(sessionStorage.getItem("usermyspaceimg"))
    }
  }
}).$mount('#app')
