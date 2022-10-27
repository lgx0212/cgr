<template>
    <div class="slide">
      <slot></slot>
    </div>
</template>

<script>
	export default {
		name: "Slide"
	}
</script>

<style scoped>
  .slide {
    width: 100%;
    height: 300px;
    flex-shrink: 0;
  }

  .slide img ,video{
    width: 100%;
    height: 100%;
  }
</style>
