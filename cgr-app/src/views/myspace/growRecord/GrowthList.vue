<template>
<div id="growthList" >
  <div class="baby-info" v-for="(item,index) in growthListData" @click="editGrowth(item.growthid)" >
    <div class="info">
      <div class="login">
        <div class="height">
          <span>身高: </span>
          <span class="content">{{item.growthheight}}</span>
          <span> cm</span>
        </div>
        <div class="weight">
          <span>体重: </span>
          <span class="content">{{item.growthweight}}</span>
          <span> kg</span>
        </div>
      </div>
      <div class="date">{{item.growthdate|formatDate}}</div>
    </div>
  </div>
</div>
</template>

<script>
  import {formatDate} from "@/common/date";

  export default {
    name: "GrowthList",
    data(){
      return{

      }
    },
    components:{
    },
    props:{
      growthListData:{
        type:Array
      }
    },
    methods:{
      editGrowth(id){
        this.$emit('listid',id)
      },

    },
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm').substring(0, 10);
      }
    }
  }
</script>

<style scoped>

  .baby-info {
    height: 65px;
    /*background-color: var(--color-tint);*/
    padding: 6px 15px;
    /*border: solid 1px;*/

    display: flex;
    color: rgb(109, 104, 104);
    border-bottom: solid 1px #f3f3f3;
  }

  .baby-info .avatar {
    width: 70px;
    height: 70px;
    border-radius: 50%;

  }

  .info {
    flex: 1;
  }

  .info .login {
    margin-top: 15px;
  }
  .height{
    height: 20px;
    width: 145px;
    display: inline-block;
  }
  .weight{
    height: 20px;
    width: 145px;
    float: right;
    display: inline-block;
  }
  .content{
    color: var(--color-tint);
    font-size: 19px;
  }
  .date{
    float: right;
    margin-right: 5px;
    margin-top: 7px;
    font-size: 13px;
    color: #d7d7d7;
  }
  .arrow {
    width: 20px;
    line-height: 65px;
  }

  .arrow img {
    width: 20px;
  }
</style>
