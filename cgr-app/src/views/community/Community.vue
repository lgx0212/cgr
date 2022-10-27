<template>
  <div id="community">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="selectUser">
          <img src="~assets/img/common/select.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>社区</div>
      </template>
    </nav-bar>
    <main-tab-controller
      :title="['推荐','关注']"
      @tabClick="tabClick"
      class="tab-control"/>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">

      <common-news v-show="currentType=='recommend'"></common-news>
      <my-attention-news v-show="currentType=='new'"></my-attention-news>
    </scroll>
    <re-fresh @click.native="reFresh"></re-fresh>
    <back-top @click.native="backClick"></back-top>
  </div>
</template>

<script>
  import CommonNews from "@/views/community/childComps/CommonNews";
  import MyAttentionNews from "@/views/community/myattention/MyAttentionNews";
  import NavBar from "@/components/common/navbar/NavBar";
  import Scroll from "@/components/common/scroll/Scroll";
  import MainTabController from "@/components/content/tabController/MainTabController";
  import ReFresh from "@/components/content/backTop/ReFresh";
  import BackTop from "@/components/content/backTop/BackTop";
  import {getNewData} from "@/network/myNew";

  export default {
    name: "Community",

    components: {
      CommonNews,
      NavBar,
      Scroll,
      MainTabController,
      MyAttentionNews,
      BackTop,
      ReFresh
    },
    data() {
      return {
        currentType: 'recommend',
        userid:''

      }
    },
    created() {
      this.userid = localStorage.getItem('userid')
    },
    activated() {

    },
    methods:{
      reFresh() {
        this.$router.go(0)
      },
      backClick(){
        this.$refs.scroll.scrollTo(0, 0,500)
      },
      selectUser(){
        this.$router.push('/selectuser')
      },
      tabClick(index) {
        switch (index) {
          case 0:
            this.currentType='recommend'
            console.log('0')
            break
          case 1:
            this.currentType='new'
            console.log('1')
            break
        }
      }
    }

  }
</script>

<style scoped>
  .content {
    overflow: hidden;
    position: absolute;
    top: 84px;
    bottom: 49px;
    left: 0;
    right: 0;
  }
  .home-nav {
    background-color: var(--color-tint);
    width: 100%;
    color: #ffffff;
    position: fixed;
  }
  .tab-control{
    padding-top: 44px;
  }
</style>
