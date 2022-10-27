<template>
  <div>
    <tab-controller>
      <tab-controller-item v-for="(item,index) in title"
                           class="def">
        <div @click="itemClick(index)">
        <span>{{ item }}</span>
        </div>
      </tab-controller-item>
    </tab-controller>
  </div>
</template>

<script>
  import TabController from "./tabController/TabController";
  import TabControllerItem from "./tabController/TabControllerItem";

  export default {
    name: "SpaceTabController",
    props: {
      title: {
        type: Array,
        default() {
          return []
        }
      }
    },
    data() {
      return {

      }
    },
    methods: {
      itemClick(index) {
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

  .active span {
    border-bottom: 3px solid var(--color-tint);
  }
  .def{
    /*background-color: var(--color-tint);*/
    color: var(--color-tint);
  }
</style>
