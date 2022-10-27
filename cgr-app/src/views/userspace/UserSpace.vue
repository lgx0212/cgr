<template>
<div id="userSpace">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="back">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>{{username}}的空间</div>
    </template>
    <template v-slot:right v-if="ifsetup">
      <img @click="usersetup" src="~assets/img/common/dian.svg" alt="">
    </template>
  </nav-bar>
  <scroll class="content"
          ref="scroll"
          :probe-type="3"
          :pull-up-load="true">
  <div class="user-info">
    <img class="avatar" :src="ifImg?userimg:defaultImgUrl" alt="">
    <div class="info">
      <div class="login">{{ username }}</div>
    </div>
    <div class="arrow" @click="userInformation">
      <img src="~assets/img/common/arrow-left.svg" alt="">
    </div>
  </div>
    <user-space-news :my-new="myNew"></user-space-news>
  </scroll>
  <edit-confirm :edit="false"
                ref="myConfirm"
                :attention="!ifattention"
                :moveattention="ifattention"
                :open="false"
                :del="false"
                :message="true"
                @attentionCancel="attentionCancel"
                @moveattentionCancel="moveattentionCancel"
                @messageCancel = "message"
                >

  </edit-confirm>
  <toast ref="toast"></toast>
</div>
</template>

<script>
  import EditConfirm from "@/components/common/confirm/EditConfirm";
  import NavBar from "@/components/common/navbar/NavBar";
  import Scroll from "@/components/common/scroll/Scroll";
  import UserSpaceNews from "@/views/userspace/childComps/UserSpaceNews";
  import Toast from "@/components/common/toast/Toast";
  import {checkedAttention,insertAttention,deleteAttentionMy} from "@/network/attention"
  import {selectUserData} from "@/network/profile";
  import {selectUserInformationData} from "@/network/myNew"
  import {insertMessage, selectIfMessage} from "@/network/message";

  export default {
    name: "UserSpace",
    components:{
      NavBar,
      Scroll,
      EditConfirm,
      UserSpaceNews,
      Toast
    },
    data(){
      return{
        myNew:[],
        userid:this.$route.params.userid,
        username:'',
        userimg:'',
        ifImg:false,
        defaultImgUrl:'img/avatar.bd23b9b1.svg',
        ifsetup:false,
        ifattention:false
      }
    },
    created() {
      if(localStorage.getItem('userid')!=this.userid){
        this.ifsetup = true
      }
      selectUserData(this.userid).then(res=>{
        this.username = res.data[0].username
        if(res.data[0].userimg){
          this.userimg = this.$root.defaulturl + res.data[0].userimg
          this.ifImg = true
        }
      })
      selectUserInformationData(this.userid).then(res=>{
        this.myNew = res.data
      })
      this.action()
    },
    methods:{
      action(){
        checkedAttention(localStorage.getItem('userid'),this.userid).then(res=>{
          if(res.ret==1){
            this.ifattention = true
          }else {
            this.ifattention = false
          }
        })
      },
      back(){
        this.$router.back()
      },
      userInformation(){
        this.$router.push('/userinformation/'+this.userid)
      },
      usersetup(){
        this.$refs.myConfirm.show()
      },
      attentionCancel(){
        insertAttention(localStorage.getItem('userid'),this.userid).then(res=>{
          if(res.ret==1){
            this.$toast({message:"关注成功！"})
            this.action()
          }
        })
      },
      moveattentionCancel(){
        deleteAttentionMy(localStorage.getItem('userid'),this.userid).then(res=>{
          if(res.ret==1){
            this.$toast({message:"取关成功！"})
            this.action()
          }
        })
      },
      message(){
        if(localStorage.getItem('userid')<this.userid){
          this.messageid = localStorage.getItem('userid')+'and'+this.userid
        }else {
          this.messageid = this.userid+'and'+localStorage.getItem('userid')
        }
        selectIfMessage(this.messageid).then(res=>{
          if(res.ret==1){
            this.$router.push('/messageinfo/' + this.messageid)
            return
          }else {
            insertMessage(localStorage.getItem('userid'),this.messageid,this.userid).then(()=>{
              insertMessage(this.userid,this.messageid,localStorage.getItem('userid')).then(()=>{
                this.$router.push('/messageinfo/' + this.messageid)
              })
            })
          }
        })

      },
    }
  }
</script>

<style scoped>
  #userSpace {
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
  .user-info {
    height: 85px;
    background-color: var(--color-tint);
    padding: 6px 15px;

    display: flex;
    color: #fff;
  }

  .user-info .avatar {
    width: 70px;
    height: 70px;
    border-radius: 50%;
  }

  .info {
    padding-left: 15px;
    flex: 1;
  }

  .info .login {
    margin-top: 15px;
  }

  .phone img {
    width: 20px;
    height: 30px;
    vertical-align: middle;
    margin-left: -5px;
  }

  .phone span {
    font-size: 13px;
  }

  .arrow {
    width: 20px;
    line-height: 85px;
  }

  .arrow img {
    width: 20px;
  }


</style>
