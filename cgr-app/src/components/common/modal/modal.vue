<template>
  <div class="modal-bg" v-show="show">
    <div class="modal-container">
      <div class="modal-header">
        {{title}}
      </div>
      <div class="modal-main">
        <!--
          如果有多个插槽时，可以采用具名插槽的方式实现
          <slot name="main"></slot>
         -->
        <slot></slot>
      </div>
      <div class="modal-footer">
        <button @click="close">关 闭</button>
        <button @click="submit">确 定</button>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "",
    data() {
      return {}
    },
    props: {
      show: {    // 控制弹窗展示
        type: Boolean,
        default: false,
        required: true,   // 必传递
      },
      title: {
        type: String,
        default: 'title',
      }
    },
    methods: {
      // 通过事件绑定及$emit来执行父组件的方法，改变弹窗展示状态
      close() {
        this.$emit("hideModal");
      },
      submit() {
        this.$emit("submit");
      }
    }
  }
</script>

<style scoped>
  .modal-bg{
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    background: rgba(0, 0, 0, .4);
    z-index:999;
  }
  .modal-container{
    border-radius: 8px;
    background: #fff;
  }
  .model-header{
    heigth: 60px;
    background: blue;
    color:#fff;
  }
  .modal-main {
    padding: 20px 40px;
  }
  .modal-footer{
    height: 60px;
    display: flex;
    justify-content: center;
    align-item: center;
    border-top: 1px solid #000;
  }
  .modal-footer button{
    width:100px;
  }
</style>
