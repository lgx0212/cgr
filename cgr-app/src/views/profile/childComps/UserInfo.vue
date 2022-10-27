<template>
  <div class="user-info">
    <img class="avatar" :src="ifImg?userimg:defaultImgUrl" alt="">
    <div class="info">
      <div class="login">{{ username }}</div>
    </div>
    <div class="arrow" @click="information">
      <img src="~assets/img/common/arrow-left.svg" alt="">
    </div>
  </div>
</template>

<script>
	import {selectUserData} from "@/network/profile";

  export default {
		name: "UserInfo",
    methods:{
      information(){
        this.$router.push('/myinformation')
      }
    },
    data(){
		  return{
		    username:'',
        userimg:'',
        ifImg:false,
        defaultImgUrl:'img/avatar.bd23b9b1.svg'
      }
    },
    created() {
		  selectUserData(localStorage.getItem('userid')).then(res=>{
        this.username = res.data[0].username
        if(res.data[0].userimg!=null){
          this.ifImg=true
          this.userimg = this.$root.defaulturl+res.data[0].userimg
        }

      })
        // this.username=this.$root.username
        if(this.$root.userimg!=null){
          this.ifImg=true
          this.userimg = this.$root.defaulturl+this.$root.userimg
        }

    },

  }
</script>

<style scoped>
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
