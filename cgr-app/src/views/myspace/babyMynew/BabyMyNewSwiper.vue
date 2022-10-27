<template>
  <div>
    <swiper class="detail-swiper">
      <swiper-item v-for="item in topImages">
        <img v-if="item.mynewpimg.substring(item.mynewpimg.length-3,item.mynewpimg.length)!='mp4'" :src="$root.defaulturl+item.mynewpimg" alt="">
        <video :preload="preload"

               align="center"
               :controls="controls"
               v-if="item.mynewpimg.substring(item.mynewpimg.length-3,item.mynewpimg.length)=='mp4'">
          <source type="video/mp4" :src="$root.defaulturl+item.mynewpimg">
        </video>
      </swiper-item>
    </swiper>
  </div>
</template>

<script>
  import {Swiper,SwiperItem} from "@/components/common/swiper"
  export default {
    name: "DetailSwiper",
    components:{
      SwiperItem,
      Swiper
    },
    data(){
      return{
        preload: 'auto', //  建议浏览器是否应在<video>加载元素后立即开始下载视频数据。
        controls: true, // 确定播放器是否具有用户可以与之交互的控件。没有控件，启动视频播放的唯一方法是使用autoplay属性或通过Player API。
      }
    },
    props:{
      topImages:{
        type:Array,
        default(){
          return []
        }
      }
    }
  }
</script>

<style scoped>
  .detail-swiper{
    height: 300px;
    overflow: hidden;
  }
</style>
