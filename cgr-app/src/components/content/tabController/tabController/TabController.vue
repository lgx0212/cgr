<template>
  <div class="tab-control">
    <slot></slot>
  </div>
</template>

<script>
  export default {
    name: "TabController"
  }
</script>

<style scoped>
  .tab-control{
    display: flex;
    text-align: center;
    font-size: 15px;
    height: 40px;
    line-height: 40px;
    background-color: #ffffff;
  }

</style>
