<template>
<div id="babyList">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>宝宝</div>
    </template>
    <template v-slot:right>
      <div @click="addBaby">添加</div>
    </template>
  </nav-bar>
  <scroll class="content"
          ref="scroll"
          :probe-type="3"
          :pull-up-load="true">
    <baby-list-item :baby-data="babyData"/>
  </scroll>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import BabyListItem from "./BabyListItem";
  import Scroll from "@/components/common/scroll/Scroll";
  import {getBabyData,checkedBabyData,defaultBabyChecked} from "@/network/myspace";
  export default {
    name: "BabyList",
    components:{
      NavBar,
      BabyListItem,
      Scroll
    },
    data(){
      return{
        babyData:[]
      }
    },
    created() {
      getBabyData(localStorage.getItem('userid')).then(res=>{
        if(res.ret==1){
          checkedBabyData(localStorage.getItem('userid')).then(res=>{
            if(res.ret==0){
              defaultBabyChecked(localStorage.getItem('userid')).then(res=>{
                checkedBabyData(localStorage.getItem('userid')).then(res=>{
                  localStorage.setItem('babyid',res.data[0].babyid)
                })
              })
            }
          })
        }

        this.babyData = res.data
        // console.log(this.babyData)
      })
    },
    methods:{
      backClick(){
        if(localStorage.getItem('changebaby')=='1'){
          localStorage.removeItem('changebaby')
          window.location.href = this.$root.vuedefaulturl;
        }
          this.$router.push('/myspace')
      },
      addBaby(){
        this.$router.push("/babyadd")
      }
    }
  }
</script>

<style scoped>
  #babyList {
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
</style>
