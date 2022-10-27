<template>
<div id="register">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>注册</div>
    </template>
  </nav-bar>
  <div class="login_box">
    <div class="phone">
      <input v-model="username"  type="text" name='user' placeholder="账号" id="user">
    </div>
    <div class="password">
      <input v-model="password"  type="password" name='pass' placeholder="密码" id="pass">
      <!--<div class="find" tapmode onclick="fnForgetPassword()">找回密码</div>-->
    </div>
    <div class="name">
      <input v-model="name" type="text" name='name' placeholder="姓名" id="name">
    </div>
    <div class="sex">
      性别：
      <select v-model="checkValue">
        <option value="男" selected>男</option>
        <option value="女">女</option>
      </select>
    </div>
    <div class="date">
      生日：
      <input v-model="data" type="date" name="user_date" />

    </div>
    <div class="login" tapmode @click="register" >注册</div>

  </div>
  <toast ref="toast"></toast>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Toast from "@/components/common/toast/Toast";

  import {ifUser,insertUser} from "@/network/profile";

  export default {
    name: "Register",
    components:{
      NavBar,
      Toast
    },
    data(){
      return{
        username:'',
        password:'',
        name:'',
        data:'',
        checkValue:''
      }
    },
    methods:{
      register(){
        // console.log(this.username,this.password,this.name,this.data,this.checkValue)
        ifUser(this.username).then(res=>{
          console.log(res)
          if(res.ret==1){
            this.$toast({message: '账号重复！'})
          }
          else if(res.ret==0){
            insertUser(this.name,this.checkValue,this.username,this.password,this.data).then(res=>{
              console.log(res)
              this.$toast({message: '注册成功！'})
              this.$router.push("/login")
            })
          }
        })
      },
      backClick(){
        this.$router.back()
      }
    }
  }
</script>

<style scoped>
  #register {
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
  .password input,
  .name input
  {
    width: 100%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
  }
  .sex, .date{
    padding-top: 20px;
  }
  .sex select,
  .date input{
    width: 80%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
  }

  .password, .name {
    width: 100%;
    height: 43px;
    border: 1px solid #e8e8e8;
    /*border-top: none;*/
    background-color: #fff;
    position: relative;
  }

  .login {
    width: 100%;
    height: 44px;
    line-height: 44px;
    text-align: center;
    font-size: 13px;
    color: #fff;
    border-radius: 4px;
    background-color: #999;
    margin: 20px 0 10px;
  }

</style>
