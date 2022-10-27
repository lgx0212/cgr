<template>
  <div id="listView">
    <normal-list-view :list-data="orderList"/>
  </div>
</template>

<script>
  import NormalListView from "@/views/profile/childComps/NormalListView";
  export default {
    name: "ListView",
    components:{
      NormalListView
    },
    data() {
      return {
        orderList: [
          {icon: 'fensi.svg', info: '我的粉丝'},
          {icon: 'guanzhu.svg', info: '我的关注'},
          {icon: 'shoucang.svg', info: '我的收藏'},
          {icon: 'my.svg', info: '个人信息'},
          {icon: 'shezhi.svg', info: '设置'}
        ]
      }
    }
  }
</script>

<style scoped>

</style>
