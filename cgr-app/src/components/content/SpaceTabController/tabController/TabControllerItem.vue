<template>
  <div class="tab-control-item">
    <div><slot><span></span></slot></div>
  </div>
</template>

<script>
  export default {
    name: "TabControllerItem",
  }
</script>

<style scoped>
.tab-control-item{
  flex: 1;
}
.tab-control-item span{
  padding: 5px;
}
</style>
