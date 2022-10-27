<template>
  <div id="myfans">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div v-if="type==1">点赞的人</div>
        <div v-if="type==2">收藏的人</div>
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">
      <div class="baby-info" v-for="item in mynewUserData" @click="delfan(item.userid)">
        <img class="avatar" :src="item.users[0].userimg?url+item.users[0].userimg:defaultImgUrl" alt="">
        <div class="info">
          <div class="login">{{ item.users[0].username }}</div>
        </div>
        <!--    <div class="arrow" >-->
        <!--      <img src="~assets/img/common/right.svg" alt="">-->
        <!--    </div>-->
      </div>
    </scroll>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Scroll from "@/components/common/scroll/Scroll";
  import {selectSupportNum} from "@/network/support"
  import {selectCollectNum} from "@/network/collect"
  export default {
    name: "BabyMyNewSCList",
    components: {
      NavBar,
      Scroll
    },
    data() {
      return {
        type:this.$route.params.type,
        mynewid:this.$route.params.mynewid,
        mynewUserData:[],
        userid:'',
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        url: this.$root.defaulturl,
      }
    },
    created() {
      if(this.type==1){
        selectSupportNum(this.mynewid).then(res=>{
          this.mynewUserData = res.data
        })
      }else if(this.type==2){
        selectCollectNum(this.mynewid).then(res=>{
          this.mynewUserData = res.data
        })
      }

    },
    methods: {
      backClick() {
        this.$router.back()
      },
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
    border-radius: 50%;
  }

  .info {
    padding-left: 15px;
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
