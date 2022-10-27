<template>
  <div>
    <tab-controller>
      <tab-controller-item v-for="(item,index) in title"
                           :class="{active: index === currentIndex ,def:currentIndex == -1}">
        <div @click="itemClick(index)">
        <span>{{ item }}</span>
        </div>
      </tab-controller-item>
    </tab-controller>
  </div>
</template>

<script>
  import TabController from "../../common/tabController/TabController";
  import TabControllerItem from "../../common/tabController/TabControllerItem";

  export default {
    name: "MainTabController",
    props: {
      title: {
        type: Array,
        default() {
          return []
        }
      },
      def:{
        type:Number
      }
    },
    data() {
      return {
        currentIndex: 0 | this.def
      }
    },
    methods: {
      itemClick(index) {
        this.currentIndex = index
        this.$emit('tabClick',index)
      }
    },
    components: {
      TabControllerItem,
      TabController
    }
  }
</script>

<style scoped>
  .active {
    color: var(--color-high-text);
  }

  .active span {
    border-bottom: 3px solid var(--color-tint);
  }
  .def{
    /*background-color: var(--color-tint);*/
    color: var(--color-tint);
  }
</style>
