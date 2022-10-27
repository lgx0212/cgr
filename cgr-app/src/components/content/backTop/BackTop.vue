<template>
  <div class="back-top">
    <img src="~assets/img/common/backTop.png" alt="">
  </div>
</template>

<script>
  export default {
    name: "BackTop"
  }
</script>

<style scoped>
  .back-top{
    position: fixed;
    width: 33px;
    height: 33px;
    right: 50px;
    bottom: 55px;
    background-color: #ffffff;
    border-radius: 50%;
  }
  .back-top img{
    width: 33px;
    height: 33px;
  }
</style>
