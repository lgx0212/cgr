<template>
  <div id="growthEdit">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>修改成长记录</div>
      </template>
      <template v-slot:right>
        <div @click="storeGrowth">
          <div>保存</div>
        </div>
      </template>
    </nav-bar>
    <div class="name">
      <input v-model="weight"  type="text" placeholder="体重（单位：kg）">
      <span class="word"> (体重/kg)</span>
      <img @click="clearWeight" src="~assets/img/common/clear.svg">
    </div>
    <div class="name">
      <input v-model="height"  type="text" placeholder="身高（单位：cm）">
      <span class="word"> (身高/cm)</span>
      <img @click="clearHeight" src="~assets/img/common/clear.svg">
    </div>
    <div class="name">
      <input v-model="date"  type="date" >
      <span class="word"> (日期)</span>
    </div>
    <toast ref="toast"></toast>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Toast from "@/components/common/toast/Toast";
  import {formatDate} from "@/common/date";

  import {updateGrowthData,selectGrowthData} from "@/network/growth"
  export default {
    name: "GrowthEdit",
    components:{
      NavBar,
      Toast
    },
    data(){
      return{
        growthid:this.$route.params.growthid,
        weight:'',
        height:'',
        date:''
      }
    },
    created() {
      selectGrowthData(this.growthid).then(res=>{
        console.log(res);
        this.weight=res.data[0].growthweight
        this.height =res.data[0].growthheight
        var date = new Date(res.data[0].growthdate);
        this.date = formatDate(date, 'yyyy-MM-dd');
      })
    },
    methods:{
      backClick(){
        this.$router.back()
      },
      clearWeight(){
        this.weight=''
      },
      clearHeight(){
        this.height=''
      },
      storeGrowth(){
        if(this.weight=='' || this.height==''){
          this.$toast({message: '身高或体重为空！'})
        }else if(isNaN(this.height)){
          this.$toast({message: '请输入正确的数字'})
        }
        else if(isNaN(this.weight)){
          this.$toast({message: '请输入正确的数字'})
        }
        else {
          updateGrowthData(this.height,this.weight,this.growthid,this.date).then(res=>{
            console.log(res);
            if(res.ret==1){
              this.$toast({message: '修改成功！'})
              this.$router.back()
            }else {
              this.$toast({message: '修改失败！'})
            }
          })
        }

      }
    }
  }
</script>

<style scoped>
  #growthEdit {
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
    width: 60%;
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
  .word{
    font-size: 14px;
    color: #999;
  }
</style>
