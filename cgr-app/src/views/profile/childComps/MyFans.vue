<template>
  <div id="myfans">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>ζηη²δΈ</div>
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">
      <div class="baby-info" v-for="item in myfans" @click="delfan(item.userid)">
        <img class="avatar" :src="item.users[0].userimg?url+item.users[0].userimg:defaultImgUrl" alt="">
        <div class="info">
          <div class="login">{{ item.users[0].username }}</div>
        </div>
        <!--    <div class="arrow" >-->
        <!--      <img src="~assets/img/common/right.svg" alt="">-->
        <!--    </div>-->
      </div>
    </scroll>
    <edit-confirm :edit="false"
                  ref="myConfirm"
                  :del="false"
                  :attention="false"
                  :movefan="true"
                  :message="true"
                  :userspace="true"
                  @userspaceCancel="userspaceCancel"
                  @movefanCancel="movefan"
                  @messageCancel = "message">
    </edit-confirm>
    <confirm ref="Confirm" @userBehavior="userBehaviorFun"></confirm>
    <toast ref="toast"></toast>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Scroll from "@/components/common/scroll/Scroll";
  import EditConfirm from "@/components/common/confirm/EditConfirm";
  import Confirm from "@/components/common/confirm/Confirm";
  import Toast from "@/components/common/toast/Toast";
  import {AttentionMy,deleteAttentionMy} from "@/network/attention";
  import {insertMessage,selectIfMessage} from '@/network/message'

  export default {
    name: "MyFans",
    inject:['reload'],
    components: {
      NavBar,
      Scroll,
      EditConfirm,
      Confirm,
      Toast
    },
    data() {
      return {
        userid:'',
        myfans: {},
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        url: this.$root.defaulturl,
        messageid:''
      }
    },
    created() {
      this.getMyFansDate()

    },
    methods: {
      getMyFansDate(){
        AttentionMy(localStorage.getItem('userid')).then(res => {
          this.myfans = res.data
        })
      },
      backClick() {
        this.$router.back()
      },
      delfan(userid){
        this.$refs.myConfirm.show()
        this.userid = userid
      },
      message(){
        if(localStorage.getItem('userid')<this.userid){
          this.messageid = localStorage.getItem('userid')+'and'+this.userid
        }else {
          this.messageid = this.userid+'and'+localStorage.getItem('userid')
        }
        // console.log(this.messageid);
        // console.log(localStorage.getItem('userid'),this.messageid,'2020-12-12',this.userid);
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
      movefan(){
        this.userBehaviorFun()
      },
      userBehaviorFun(){
        this.$refs.Confirm.show('δ½ η‘?ε?θ¦η§»ι€θ―₯η²δΈεοΌ')
        if(this.$refs.Confirm.chose==1){
          deleteAttentionMy(this.userid,localStorage.getItem('userid')).then(res=>{
            if(res.ret==1){
              this.$toast({message:'η§»ι€ζεοΌ'})
              this.getMyFansDate()
            }
          })
        }
      },
      userspaceCancel(){
        this.$router.push('/userspace/'+this.userid)
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
