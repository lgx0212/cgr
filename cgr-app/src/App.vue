<template>
  <div id="app">
    <keep-alive include="Community,Myspace">
    <router-view v-if="isRouterAlive"></router-view>
    </keep-alive>
    <main-tab-bar/>
    <lg-preview></lg-preview>

  </div>
</template>

<script>
  import MainTabBar from "components/content/tabbar/MainTabBar"
export default {
  name: 'App',
  components: {
    MainTabBar
  },
  provide () {    //父组件中通过provide来提供变量，在子组件中通过inject来注入变量。
    return {
      reload: this.reload
    }
  },
  data() {
    return{
      isRouterAlive: true                    //控制视图是否显示的变量
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false;            //先关闭，
      this.$nextTick(function () {
        this.isRouterAlive = true;         //再打开
      })
    }
  }

}
</script>

<style>
@import "./assets/css/base.css";
</style>
