<template>
  <div id="selectUser">
    <div class="tab-bar">
      <div class="tab-bar-item">
        <div class="messageContent">
          <input type="text" v-model="content" placeholder="搜索" @input="select">
        </div>
        <div class="sand" @click="back">取消</div>
      </div>
    </div>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">
      <div class="baby-info" v-for="item in userData" @click="userInfo(item.userid)">
        <img class="avatar" :src="item.userimg?url+item.userimg:defaultImgUrl" alt="">
        <div class="info">
          <div class="login">{{ item.username }}</div>
        </div>
        <img v-if="item.userid==userid" class="myself" src="~assets/img/common/myself.svg" >

      </div>
    </scroll>
  </div>
</template>

<script>
  import {selectUserByName} from "@/network/profile";
  import Scroll from "@/components/common/scroll/Scroll";

  export default {
    name: "selectUser",
    components: {
      Scroll
    },
    data() {
      return {
        userid:localStorage.getItem('userid'),
        content: '',
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        url: this.$root.defaulturl,
        userData: []
      }
    },
    methods: {
      back() {
        this.$router.push('/community')
      },
      select() {
        selectUserByName(this.content).then(res => {
          if (this.content == '') {
            this.userData = []
          } else {
            console.log(res);
            this.userData = res.data
          }
        })
      },
      userInfo(userid){
        this.$router.push('/userspace/'+userid)
      }
    }
  }
</script>

<style scoped>
  #selectUser {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }
  .content {
    overflow: hidden;
    position: absolute;
    top: 55px;
    bottom: 1px;
    left: 0;
    right: 0;
  }
  .tab-bar {
    height: 49px;
    border-top: 1px solid #eee;
    box-shadow: 0 -1px 1px rgba(150, 150, 150, .08);
    position: fixed;
    left: 0;
    right: 0;
    top: 0;
    text-align: center;
  }

  .tab-bar-item {
    display: flex;
    font-size: 14px;
  }

  .messageContent {
    width: 80%;
    height: 49px;
    line-height: 49px;
  }

  input {
    width: 90%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
    border-width: 0;
    border-bottom: solid 1px var(--color-tint);
  }

  .sand {

    width: 20%;
    line-height: 49px;
    text-align: center;
    font-size: 13px;
    /*background-color: var(--color-tint);*/
    color: #ff0000;

  }

  .baby-info {
    height: 85px;
    /*background-color: var(--color-tint);*/
    /*padding: 6px 15px;*/
    margin: 6px 15px;
    /*border-bottom: solid 1px var(--color-tint);*/

    display: flex;
    color: var(--color-text);
  }

  .baby-info .avatar {
    width: 70px;
    height: 70px;
    border-radius: 50%;
  }

  .myself{
    width: 15px;
    height: 15px;
    margin: auto 0;
  }

  .info {
    padding-left: 15px;
    flex: 1;
    display: flex;
  }

  .info .login {
    margin: auto 0;
  }

</style>
