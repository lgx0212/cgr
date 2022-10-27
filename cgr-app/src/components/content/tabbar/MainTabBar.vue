<template>
  <tab-bar>
    <tab-bar-item path="/myspace">
      <img slot="item-icon" src="~assets/img/tabbar/Personal-space.png" alt="">
      <img slot="item-active-icon" src="~assets/img/tabbar/Personal-space-active.png" alt="">
      <span slot="item-text">首页</span>
    </tab-bar-item>
    <tab-bar-item path="/community">
      <img slot="item-icon" src="~assets/img/tabbar/Community.png" alt="">
      <img slot="item-active-icon" src="~assets/img/tabbar/Community-active.png" alt="">
      <span slot="item-text">社区</span>
    </tab-bar-item>
    <tab-bar-item path="/message">
      <img slot="item-icon" src="~assets/img/tabbar/Message.png" alt="">
      <img slot="item-active-icon" src="~assets/img/tabbar/Message-active.png" alt="">
      <span slot="item-text">消息</span>
    </tab-bar-item>
    <tab-bar-item path="/profile">
      <img slot="item-icon" src="~assets/img/tabbar/My.png" alt="">
      <img slot="item-active-icon" src="~assets/img/tabbar/My-active.png" alt="">
      <span slot="item-text">我的</span>
    </tab-bar-item>
  </tab-bar>
</template>

<script>
  import TabBar from 'components/common/tabbar/TabBar'
  import TabBarItem from 'components/common/tabbar/TabBarItem'

  export default {
    name: "MainTabBar",
    components: {
      TabBar,
      TabBarItem
    }
  }
</script>

<style scoped>

</style>
