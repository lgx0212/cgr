<template>
<div id="userInformation">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>账号资料</div>
    </template>
  </nav-bar>
  <div class="normal-list">
    <div  class="item">
      <div class="info">头像</div>
      <img :src="ifImg?defaulturl+userimg:defaultImgUrl" >
    </div>
  </div>
  <div class="normal-list">
    <div  class="item">

      <div class="info">昵称</div>
      <div class="right" >{{ username }}</div>

    </div>
  </div>
  <div class="normal-list">
    <div  class="item">

      <div class="info">性别</div>
      <div class="right" >{{ usersex }}</div>
    </div>
  </div>
  <div class="normal-list">
    <div  class="item">

      <div class="info">生日</div>
      <div class="right" >{{ userdate  | formatDate}}</div>
    </div>
  </div>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import {selectUserData} from "@/network/profile";
  import {formatDate} from "@/common/date";

  export default {
    name: "userInformation",
    components:{
      NavBar
    },
    data(){
      return{
        userid:this.$route.params.userid,
        userimg:'',
        username:'',
        usersex:'',
        userdate:'',
        ifImg:false,
        defaultImgUrl:'img/avatar.bd23b9b1.svg',
        defaulturl:this.$root.defaulturl
      }
    },
    created() {
      selectUserData(this.userid).then(res=>{
        console.log(res);
        this.username = res.data[0].username
        this.usersex = res.data[0].usersex
        this.userdate = res.data[0].userbrith
        if(res.data[0].userimg){
          this.userimg =  res.data[0].userimg
          this.ifImg=true
        }
      })
    },
    methods:{
      backClick(){
        this.$router.back()
      }
    },
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd');
      }
    }
  }
</script>

<style scoped>
  #userInformation {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }
  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }
  .normal-list {
    background-color: #fff;
    font-size: 15px;
    color: #333;
    /*margin-top: 15px;*/
    border-bottom: 1px solid rgba(100, 100, 100, .1);

  }

  .normal-list .item {
    height: 44px;
    line-height: 44px;
    position: relative;

  }

  .item .info {
    margin-left: 20px;
    margin-right: 20px;
    padding-left: 5px;
    /*display: inline;*/
    float: left;
    /*justify-content:center;*/


  }
  .item img{
    width: 40px;
    height: 40px;
    /*display: inline;*/
    /*justify-content:center;*/
    float: right;
    margin-top: 2px;
    margin-right: 20px;
    border-radius: 50%;

  }
  .item .right{
    float: right;
    margin-right: 25px;
  }
  .sex select{
    width: 80%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
  }
</style>
