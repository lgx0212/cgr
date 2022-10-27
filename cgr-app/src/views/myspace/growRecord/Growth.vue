<template>
  <div id="growth">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>成长记录</div>
      </template>
      <template v-slot:right>
        <div @click="addGrowth">添加</div>
      </template>
    </nav-bar>
    <main-tab-controller
      :title="['记录列表','身高曲线','体重曲线']"
      @tabClick="tabClick"
      class="tab-control"/>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">

      <growth-list @listid="editGrowth" v-show="dataShow=='list'" :growth-list-data="growthListData"></growth-list>
      <growth-echart v-show="dataShow=='height'" :growthData="growthHeightData" :growth-key="growthKey"></growth-echart>
      <growth-weight-echart v-show="dataShow=='weight'" :growthData="growthWeightData" :growth-key="growthKey"></growth-weight-echart>
    </scroll>
    <edit-confirm ref="myEditConfirm"
                  @editCancel="editCancel"
                  @deleteCancel="deleteCancel"
                  @clickCancel="clickCancel" :attention="false">
    </edit-confirm>
    <confirm ref="myConfirm" @userBehavior="userBehaviorFun"></confirm>
    <toast ref="toast"></toast>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import GrowthEchart from "@/views/myspace/growRecord/GrowthEchart";
  import GrowthWeightEchart from "@/views/myspace/growRecord/GrowthWeightEchart";
  import GrowthList from "@/views/myspace/growRecord/GrowthList";
  import MainTabController from "@/components/content/tabController/MainTabController";
  import Scroll from "@/components/common/scroll/Scroll";
  import EditConfirm from "@/components/common/confirm/EditConfirm";
  import Confirm from "@/components/common/confirm/Confirm";
  import Toast from "@/components/common/toast/Toast";
  import {getGrowthData,deleteGrowthData,selectGrowthEchart} from '@/network/growth'
  import {checkedBabyData} from "@/network/myspace";

  export default {
    name: "Growth",
    inject: ['reload'],
    components: {
      GrowthEchart,
      GrowthWeightEchart,
      NavBar,
      GrowthList,
      MainTabController,
      Scroll,
      EditConfirm,
      Confirm,
      Toast
    },
    data() {
      return {
        growthListData: [],
        growthHeightData: [],
        growthWeightData:[],
        growthKey: [],
        dataShow: 'list',
        checkedGrowthItem:''
      }
    },
    created() {
        getGrowthData(localStorage.getItem('babyid')).then(res => {

          this.growthListData = res.data.reverse()
        })
      selectGrowthEchart(localStorage.getItem('babyid')).then(res=>{
        for (let i = 0; i < res.data.length; i++) {
          this.growthHeightData.push(res.data[i].growthheight)
          this.growthWeightData.push(res.data[i].growthweight)

          this.growthKey.push(i + 1)
        }
      })

    },
    methods: {
      backClick() {
        this.$router.back()
      },
      addGrowth() {
        this.$router.push('/growthadd')
      },
      editGrowth(id){
        this.checkedGrowthItem = id
        this.BehaviorFun()
      },
      BehaviorFun(){

        this.$refs.myEditConfirm.show()
      },
      editCancel(){
        this.$router.push('/growthedit/'+this.checkedGrowthItem)
      },
      deleteCancel(){
        this.userBehaviorFun()

      },
      userBehaviorFun(){
        this.$refs.myConfirm.show('你确定要删除吗？', {
          // type: 'confirm',
          // confirmText: '确定',
          // titleText: '消息提示'
        })
        if(this.$refs.myConfirm.chose==1){
          deleteGrowthData(this.checkedGrowthItem).then(res=>{
            console.log(res);
            if(res.ret==1){
              this.$toast({message: '删除成功!'})
              this.reload()
            }
          })
        }
      },
      clickCancel(){
        console.log(0);
      },
      tabClick(index) {
        switch (index) {
          case 0:
            this.dataShow = 'list'
            console.log('0')
            break
          case 1:
            this.dataShow = 'height'
            console.log('1')
            break
          case 2:
            this.dataShow = 'weight'
            console.log('2')
            break
        }
      }
    }
  }
</script>

<style scoped>
  #growth {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }

  .home-nav {
    background-color: var(--color-tint);
    width: 100%;
    color: #ffffff;
    /*position: fixed;*/
  }

  .content {
    overflow: hidden;
    position: absolute;
    top: 84px;
    bottom: 1px;
    left: 0;
    right: 0;
  }
</style>
