<template>
<div id="Setup">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>设置</div>
    </template>
  </nav-bar>
  <set-up-list-view :list-data="orderList"/>

  <div class="set">
    <div class="setup" tapmode @click="quit">退出账号</div>
  </div>
  <confirm ref="myConfirm" @userBehavior="userBehaviorFun"></confirm>
</div>

</template>

<script>
  import SetUpListView from "@/views/profile/childComps/SetUpListView";
  import NavBar from "@/components/common/navbar/NavBar";
  import Confirm from "@/components/common/confirm/Confirm";
  export default {
    name: "SetUp",
    components:{
      NavBar,
      Confirm,
      SetUpListView
    },
    data(){
      return{
        orderList: [
          { info: '账号与安全'},
          { info: '帮助与反馈'}
        ]
      }
    },
    methods:{
      quit(){
        this.userBehaviorFun()
      },
      userBehaviorFun(){
        this.$refs.myConfirm.show('你确定要退出吗？', {
          // type: 'confirm',
          // confirmText: '确定',
          // titleText: '消息提示'
        })
        if(this.$refs.myConfirm.chose==1){

          localStorage.clear()
          window.location.href=this.$root.vuedefaulturl;
        }
      },
      backClick(){
        this.$router.back()
      }

    }
  }
</script>

<style scoped>
  #Setup {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }
  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }
  .set{
    margin: 20px 0 10px;
  }
  .setup {
    width: 80%;
    height: 44px;
    line-height: 44px;
    text-align: center;
    font-size: 13px;
    color: #fff;
    border-radius: 4px;
    background-color: red;
    margin: 0 auto;
  }
</style>
