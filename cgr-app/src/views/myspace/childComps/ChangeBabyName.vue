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
    <input v-model="babyname"  type="text" name='name' placeholder="昵称" id="name">
    <img src="~assets/img/common/clear.svg">
  </div>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import {updateBabyName} from "@/network/myspace";

  export default {
    name: "ChangeName",
    components:{
      NavBar
    },
    data(){
      return{
        babyname:this.$route.params.babyname
      }
    },
    created() {

    },
    methods:{
      backClick(){
        this.$router.back()
      },
      changeName(){
        if(this.$route.params.babyid==localStorage.getItem('babyid')){
          localStorage.setItem('changebaby', '1')
        }
        updateBabyName(this.$route.params.babyid,this.babyname).then(res=>{

          if(res.ret==1){
            this.$router.push('/babyinfo/'+this.$route.params.babyid)
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
