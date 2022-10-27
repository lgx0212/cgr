<template>
<div id="bigNewsAdd">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>添加大事件</div>
    </template>
    <template v-slot:right>
      <div @click="addBigNew">添加</div>
    </template>
  </nav-bar>
  <div class="name">
    <input v-model="content"  type="text" placeholder="请输入大事件内容">
    <img @click="clear" src="~assets/img/common/clear.svg">
  </div>
  <div class="name">
    <input v-model="date"  type="date">
  </div>
  <toast ref="toast"></toast>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Toast from "@/components/common/toast/Toast"
  import {insertBigNewsData} from "@/network/bignews"
  export default {
    name: "BigNewsAdd",
    components:{
      NavBar,
      Toast
    },
    data(){
      return{
        content:'',
        date:''
      }
    },
    methods:{
      backClick(){
        this.$router.back()
      },
      addBigNew(){
        if(this.content==''){
          this.$toast({message: "请输入内容！"})
        }else if(this.date==''){
          this.$toast({message: "请输入日期！"})
        }else {
          insertBigNewsData(localStorage.getItem('userid'),localStorage.getItem('babyid'),this.content,this.date).then(res=>{
            if(res.ret==1){
              this.$toast({message:"添加成功！"})
              this.$router.back()
            }
          })
        }

      },
      clear(){
        this.content=''
      }
    }
  }
</script>

<style scoped>
  #bigNewsAdd {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }
  .home-nav {
    background-color: var(--color-tint);
    width: 100%;
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
