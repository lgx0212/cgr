<template>
  <div id="myspace">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img class="a" src="~assets/img/common/back.svg" alt="">
          <div class="b">宝宝</div>
        </div>
      </template>
      <template v-slot:center>
        <div>我的空间</div>
      </template>
    </nav-bar>
    <space-tab-controller
      ref="tabController1"
      :title="['相册','成长记录','大事件']"
      @tabClick="tabClick"
      class="tab-control" v-show="isTabFixed"/>
    <scroll class="content"
            ref="scroll"
            @scroll="contentScroll"
            :probe-type="3"
            :pull-up-load="true">
      <myspace-info></myspace-info>
      <space-tab-controller
        ref="tabController2"
        :title="['相册','成长记录','大事件']"
        @tabClick="tabClick"/>
      <baby-my-new ></baby-my-new>
<!--      <div class="back-top">-->
<!--        <div class="arrow" >-->
<!--          <img src="~assets/img/profile/camera.svg" alt="">-->
<!--        </div>-->
<!--      </div>-->

    </scroll>

  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import MyspaceInfo from "./childComps/MyspaceInfo"
  import SpaceTabController from "@/components/content/SpaceTabController/SpaceTabController";
  import BabyMyNew from "./babyMynew/BabyMyNew"
  import Scroll from "@/components/common/scroll/Scroll";


  export default {
    name: "Myspace",
    components: {
      NavBar,
      MyspaceInfo,
      SpaceTabController,
      BabyMyNew,
      Scroll
    },
    data() {
      return {
        id: '',
        saveY:0,
        formMess: {
          "img": {}
        },
        isTabFixed: false,
        tabOffsetTop:0,
        ifbaby:false
      }
    },
    created() {
      if(localStorage.getItem('babyid')){
        this.ifbaby = true
      }
    },
    mounted() {
      let _this = this
      this.$nextTick(()=>{
        _this.$refs.scroll.refresh()
        _this.tabOffsetTop = _this.$refs.tabController2.$el.offsetTop
      })
    },
    activated() {
      // console.log(this.$refs.scroll.scrollTo(0, this.saveY, 0));
      // console.log(this.$refs.scroll.refresh());
      this.$refs.scroll.refresh()
      this.$refs.scroll.scrollTo(0, this.saveY, 0)
    },
    deactivated() {
      // 1.保存Y值
      this.saveY = this.$refs.scroll.getScrollY()
    },
    methods: {
      tabClick(index) {
        switch (index) {
          case 0:
            if(this.ifbaby){
              this.$router.push('/album')
            }else {
              this.$toast({message:'请先添加一个宝宝哦'})
            }
            break
          case 1:
            if(this.ifbaby){
              this.$router.push('/growth')
            }else {
              this.$toast({message:'请先添加一个宝宝哦'})
            }
            break
          case 2:
            if(this.ifbaby){
              this.$router.push('/bignews')
            }else {
              this.$toast({message:'请先添加一个宝宝哦'})
            }
            break
        }
      },
      backClick() {
        this.$router.push('/babyList')
      },
      addMynew(){
        if(localStorage.getItem('babyid')==null){
          this.$toast({message:"请先添加一个宝宝哦"})
        }else {
          this.$router.push('/babymynewadd')
        }
      },
      contentScroll(position) {
        this.isTabFixed = (-position.y) > this.tabOffsetTop
      },
    },

  }
</script>

<style scoped>
  #myspace {
    /*margin-bottom: 48px;*/

  }

  .home-nav {
    background-color: var(--color-tint);
    width: 100%;
    color: #ffffff;
    position: fixed;
  }

  .back {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .a {
    /*display: inline;*/
  }

  .b {
    height: 44px;
    width: 80px
  }

  .iframe {
    display: none;
  }
  .content {
    overflow: hidden;
    position: absolute;
    top: 44px;
    bottom: 49px;
    left: 0;
    right: 0;
  }
  .tab-control {
    position: relative;
    top: 44px;
    z-index: 9;
  }

  .back-top{
    position: fixed;
    right: 10px;
    width: 33px;
    height: 33px;
    top: 10px;
    /*background-color: #ffffff;*/
    border-radius: 50%;
  }
  .back-top img{
    width: 25px;
    height: 25px;
  }
</style>
