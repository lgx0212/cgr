<template>
  <div id="album">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>相册</div>
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">
      <div class="babyimg">
        <div v-for="i in imgData">
          <img preview-title-enable="true"
               preview-nav-enable="true"
               v-preview="ImgUrl+i.mynewpimg"
               v-if="i.mynewpimg.substring(i.mynewpimg.length-3,i.mynewpimg.length)!='mp4'"
               :src=ImgUrl+i.mynewpimg>
          <video v-if="i.mynewpimg.substring(i.mynewpimg.length-3,i.mynewpimg.length)=='mp4'">
            <source :src="ImgUrl+i.mynewpimg">
          </video>
        </div>
      </div>
    </scroll>
  </div>
</template>

<script>
  import Scroll from "@/components/common/scroll/Scroll";
  import NavBar from "@/components/common/navbar/NavBar";
  import {getMyNewPByBabyId} from '@/network/myNewP'

  export default {
    name: "Album",
    components: {
      NavBar,
      Scroll
    },
    data() {
      return {
        ImgUrl: this.$root.defaulturl,
        imgData: []
      }
    },
    created() {
      getMyNewPByBabyId(localStorage.getItem('babyid')).then(res => {
        console.log(res.data);
        this.imgData = res.data
      })
    },
    methods: {
      backClick() {
        this.$router.back()
      },
      clickImg(e) {
        this.showImg = true;
        // 获取当前图片地址
        this.imgSrc = e.currentTarget.src;
      },
      viewImg(){
        this.showImg = false;
      }
    }
  }
</script>

<style scoped>
  #album {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }

  .home-nav {
    background-color: var(--color-tint);
    width: 100%;
    color: #ffffff;
    position: fixed;
  }

  .babyimg {
    display: flex;
    flex-wrap: wrap;
    margin: 10px;
  }

  .babyimg img, video {
    width: 100px;
    height: 100px;
    padding: 3px;
  }
  .content {
    overflow: hidden;
    position: absolute;
    top: 44px;
    bottom: 1px;
    left: 0;
    right: 0;
  }
</style>
