<template>
<div id="Login">
  <nav-bar class="home-nav">
    <template v-slot:center>
      <div>登录</div>
    </template>
  </nav-bar>
  <div class="login_box" v-if="showlogin">
    <div class="phone">
      <input v-model="username" type="text" name='user' placeholder="账号" id="user">
    </div>
    <div class="password">
      <input v-model="password" type="password" name='pass' placeholder="密码" id="pass">
      <!--<div class="find" tapmode onclick="fnForgetPassword()">找回密码</div>-->
    </div>
    <div class="login" @click="login">登录</div>
    <div @click="register" class="register open-win" win="register_mobile">注册账号</div>
  </div>


  <toast ref="toast"></toast>
</div>
</template>

<script>

  import NavBar from "@/components/common/navbar/NavBar";
  import {getUserData} from "@/network/profile";
  import {formatDate} from "@/common/date";
  import {checkedBabyData} from "@/network/myspace";

  import Toast from "@/components/common/toast/Toast";

  export default {
    name: "Login",
    components:{
      NavBar,
      Toast
    },
    data(){
      return{
        username:'',
        password:'',
        showlogin:false
      }
    },
    created() {
      let myName=JSON.parse(localStorage.getItem("userid"))
      if(myName!=''&&myName!=null){
        this.$router.push('/myspace')
      }else {
        this.showlogin = true
      }
    },
    methods:{
      login(){
        getUserData(this.username,this.password).then(res=>{
          if(res.ret == 1){

            // this.$root.userid = res.data[0].userid
            checkedBabyData(res.data[0].userid).then(res=>{
              localStorage.setItem('babyid',res.data[0].babyid)
            })
            var date = new Date(res.data[0].userbrith);
            const userbrith = formatDate(date,'yyyy-MM-dd')
            // localStorage.clear()
            // localStorage.setItem('info',1)
            // localStorage['flag']=1
            // localStorage.setItem('flag',1)
            localStorage.clear()
            // sessionStorage['userid']=JSON.stringify(res.data.userInfo.id)
            localStorage.setItem('userid',res.data[0].userid)
            localStorage.setItem('username',res.data[0].username)
            localStorage.setItem('usersex',res.data[0].usersex)
            localStorage.setItem('userbrith',userbrith)
            localStorage.setItem('userimg',res.data[0].userimg)
            localStorage.setItem('usermyspaceimg',res.data[0].usermyspaceimg)
            // sessionStorage['token']=JSON.stringify(res.data.token)

            this.$toast({message: '登陆成功！'})
            setTimeout(()=>{
              window.location.href=this.$root.vuedefaulturl
            },500)
          }else {
            this.$toast({message: '账号或密码错误！'})
          }

        })
        // this.$router.push({
        //   path:`/text/${this.username}/${this.password}`
        // })
      },
      register(){
        this.$router.push("/register")
      }
    }
  }
</script>

<style scoped>
  #Login {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }
  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }
  body {
    height: 100%;
    background-color: #f4f5f6;
  }
  .login_box {
    box-sizing: border-box;
    padding: 30px 20px;
  }
  .phone {
    width: 100%;
    height: 43px;
    line-height: 43px;
    border: 1px solid #e8e8e8;
    background-color: #fff;
  }
  .phone input,
  .password input {
    width: 100%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
  }
  .password {
    width: 100%;
    height: 43px;
    border: 1px solid #e8e8e8;
    border-top: none;
    background-color: #fff;
    position: relative;
  }
  .find {
    width: 80px;
    height: 43px;
    line-height: 43px;
    text-align: center;
    color: #999;
    font-size: 14px;
    position: absolute;
    right: 0;
    bottom: 0;
    /*background-image: url(../image/my/line.png);*/
    background-repeat: no-repeat;
    background-size: 1px 14px;
    background-position: left center;
  }
  .login {
    width: 100%;
    height: 44px;
    line-height: 44px;
    text-align: center;
    font-size: 13px;
    border-radius: 4px;
    background-color: #999;
    margin: 20px 0 10px;
  }
  .register {
    width: 100%;
    height: 44px;
    line-height: 44px;
    text-align: center;
    font-size: 13px;
    color: #2a90d7;
  }
</style>
