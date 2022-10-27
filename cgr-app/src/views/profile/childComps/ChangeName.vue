<template>
<div id="changeName">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>修改昵称</div>
    </template>
    <template v-slot:right>
      <div @click="changeName">
      <div>保存</div>
      </div>
    </template>
  </nav-bar>
  <div class="name">
    <input v-model="username"  type="text" name='name' placeholder="昵称" id="name">
    <img src="~assets/img/common/clear.svg">
  </div>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import {formatDate} from "@/common/date";
  import {updateUser,selectUserData} from "@/network/profile"
  export default {
    name: "ChangeName",
    components:{
      NavBar
    },
    data(){
      return{
        username:''
      }
    },
    created() {
      selectUserData(localStorage.getItem('userid')).then(res=>{
        this.username = res.data[0].username
      })
    },
    methods:{
      backClick(){
        this.$router.back()
      },
      changeName(){
        // console.log(this.$root.userbrith)
        // var date = new Date(this.$root.userbrith);
        // const userbrith = formatDate(date,'yyyy-MM-dd')
        // console.log(userbrith)
        updateUser(this.username,localStorage.getItem('usersex'),localStorage.getItem('userbrith'),localStorage.getItem('userid')).then(res=>{
          localStorage.setItem('username',this.username)
          if(res.ret==1){
            this.$router.push('/myinformation')
          }
        })
      }
    }
  }
</script>

<style scoped>
  #changeName {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }
  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }
  .name img{
    width: 14px;
    height: 14px;
    margin-left: 10px;
  }
  .name input
  {
    margin-top: 20px;
    margin-left: 10px;
    width: 80%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
    border-width:0;
    border-bottom: solid 1px var(--color-tint);
  }

</style>
