<template>
<div id="bigNewsEdit">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>编辑大事件</div>
    </template>
    <template v-slot:right>
      <div @click="saveBigNews">
        <div>保存</div>
      </div>
    </template>
  </nav-bar>
  <div class="name">
    <input v-model="bignewcontent"  type="text" placeholder="大事件内容">
    <img @click="clear" src="~assets/img/common/clear.svg">
  </div>
  <div class="name">
    <input v-model="bignewdate"  type="date" placeholder="">
  </div>
  <div class="set">
    <div class="setup" tapmode @click="deleteBigNews">删除大事件</div>
  </div>
  <confirm ref="myConfirm" @userBehavior="userBehaviorFun"></confirm>
  <toast ref="toast"></toast>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Confirm from "@/components/common/confirm/Confirm";
  import Toast from "@/components/common/toast/Toast";
  import {selectBigNewsData,deleteBigNewsData,updateBigNewsData} from "@/network/bignews"
  import {formatDate} from "@/common/date";
  export default {
    name: "BigNewsEdit",
    components:{
      NavBar,
      Confirm,
      Toast
    },
    data(){
      return{
        bigNews:this.$route.params.bigNewsid,
        bignewcontent:'',
        bignewdate:''
      }
    },
    created() {
      selectBigNewsData(this.bigNews).then(res=>{
        this.bignewcontent = res.data[0].bignewcontent
        var date = new Date(res.data[0].bignewdate);
        this.bignewdate = formatDate(date, 'yyyy-MM-dd');
        console.log(this.bignewdate);
      })
    },
    methods:{
      backClick(){
        this.$router.back()
      },
      clear(){
        this.bignewcontent=''
      },
      saveBigNews(){
        updateBigNewsData(this.bignewcontent,this.bignewdate,this.bigNews).then(res=>{
          if(res.ret==1){
            this.$toast({message: '保存成功！'})
            this.$router.push('/bignews')
          }
        })
      },
      deleteBigNews(){
        this.userBehaviorFun()
      },
      userBehaviorFun(){
        console.log(this.$refs)
        this.$refs.myConfirm.show('你确定要删除吗？')
        if(this.$refs.myConfirm.chose==1){
          deleteBigNewsData(this.bigNews).then(res=>{
            if(res.ret==1){
              this.$toast({message: '删除成功！'})
              this.$router.back()
            }
          })
        }
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
  #bigNewsEdit {
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
  .set{
    margin: 40px 0 10px;
  }
  .setup {
    width: 80%;
    height: 44px;
    line-height: 44px;
    text-align: center;
    font-size: 13px;
    color: #fff;
    border-radius: 4px;
    background-color: red;
    margin: 0 auto;
  }
</style>
