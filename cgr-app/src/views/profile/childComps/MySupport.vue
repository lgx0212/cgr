<template>
  <div id="myfans">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>获赞</div>
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">
      <div class="baby-info" v-for="item in myfans">
        <img class="avatar" :src="item.users[0].userimg?url+item.users[0].userimg:defaultImgUrl" alt="">
        <div class="info">
          <div class="login">{{ item.users[0].username }}</div>
        </div>
        <div v-for="i in item.mynews" class="info-r">
          <div v-for="(a,index) in i.mynewp">
            <img v-if="index==0&&a.mynewpimg" class="avatar-r" :src="url+a.mynewpimg" alt="">
          </div>
          <div class="login-r" v-if="i.mynewp.length==0">{{ i.mynewcontent }}</div>
        </div>
      </div>
    </scroll>
    <toast ref="toast"></toast>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Scroll from "@/components/common/scroll/Scroll";
  import EditConfirm from "@/components/common/confirm/EditConfirm";
  import Confirm from "@/components/common/confirm/Confirm";
  import Toast from "@/components/common/toast/Toast";
  import {supportmy} from "@/network/support"

  export default {
    name: "MyFans",
    inject: ['reload'],
    components: {
      NavBar,
      Scroll,
      EditConfirm,
      Confirm,
      Toast
    },
    data() {
      return {
        userid: '',
        myfans: {},
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        url: this.$root.defaulturl
      }
    },
    created() {
      supportmy(localStorage.getItem('userid')).then(res => {
        console.log(res);
        this.myfans = res.data
      })
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
  .info-r {
    text-align: right;
    padding-left: 15px;
    display: flex;
  }
  .info-r .login-r {
    margin: auto 0;
    text-align: center;
  }
  .baby-info .avatar-r {
    width: 70px;
    height: 70px;
  }
</style>
