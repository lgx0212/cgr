<template>
  <div id="myfans">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>我的收藏</div>
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">
      <div class="baby-info" v-for="item in mycollect" @click="collectItem(item.mynewid)">
        <div v-for="(i,index) in item.mynews[0].mynewp">
          <img class="avatar" v-if="index==0" :src="url+i.mynewpimg" alt="">
        </div>
        <div class="info">
          <div class="login">{{ item.mynews[0].mynewcontent }}</div>
        </div>
        <div class="arrow">
          <img src="~assets/img/common/right.svg" alt="">
        </div>
      </div>
    </scroll>
    <toast ref="toast"></toast>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Scroll from "@/components/common/scroll/Scroll";
  import Toast from "@/components/common/toast/Toast";
  import {MyCollect} from "@/network/collect"

  export default {
    name: "MyMyCollect",
    inject: ['reload'],
    components: {
      NavBar,
      Scroll,
      Toast
    },
    data() {
      return {
        userid: '',
        mycollect: {},
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        url: this.$root.defaulturl
      }
    },
    created() {
      MyCollect(localStorage.getItem('userid')).then(res => {
        console.log(res);
        this.mycollect = res.data
      })
    },
    methods: {
      backClick() {
        this.$router.back()
      },
      collectItem(mynewid){
        this.$router.push('/commonnewinfo/' + mynewid)
      }
    }
  }
</script>

<style scoped>
  #myfans {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }

  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }

  .content {
    overflow: hidden;
    position: absolute;
    top: 44px;
    bottom: 1px;
    left: 0;
    right: 0;
  }

  .baby-info {
    height: 85px;
    /*background-color: var(--color-tint);*/
    /*padding: 6px 15px;*/
    margin: 6px 15px;
    border-bottom: solid 1px var(--color-tint);

    display: flex;
    color: rgb(109, 104, 104);
  }

  .baby-info .avatar {
    width: 70px;
    height: 70px;
    /*border-radius: 50%;*/
  }

  .info {
    padding-left: 15px;
    padding-right: 30px;
    flex: 1;
    display: flex;
  }

  .info .login {
    margin: auto 0;
  }

  .arrow {
    width: 20px;
    line-height: 85px;
  }

  .arrow img {
    width: 20px;
  }
</style>
