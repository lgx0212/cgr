<template>
  <div id="bigNews">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>大事件</div>
      </template>
      <template v-slot:right>
        <div @click="addBigNew">添加</div>
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">
    <big-news-list :big-news-list="BigNewsList"></big-news-list>
    </scroll>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import BigNewsList from "@/views/myspace/bigNews/BigNewsList";
  import Scroll from "@/components/common/scroll/Scroll";
  import {selectAllBigNewsData} from "@/network/bignews"

  export default {
    name: "BigNews",
    components: {
      NavBar,
      BigNewsList,
      Scroll
    },
    data(){
      return{
        BigNewsList:[]
      }
    },
    created() {
      selectAllBigNewsData(localStorage.getItem('babyid')).then(res => {
        this.BigNewsList = res.data
        console.log(res.data);
      })
    },
    methods: {
      backClick() {
        this.$router.push('/myspace')
      },
      addBigNew(){
        this.$router.push('/bignewsadd')
      }
    }
  }
</script>

<style scoped>
  #bigNews {
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
  .content {
    overflow: hidden;
    position: absolute;
    top: 44px;
    bottom: 49px;
    left: 0;
    right: 0;
  }
</style>
