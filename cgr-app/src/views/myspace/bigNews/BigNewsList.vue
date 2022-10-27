<template>
<div class="bigNewList">
  <div class="baby-info" v-for="item in BigNewsList" @click="BigNewsitem(item.bignewid)">
    <div class="info">
      <div class="login">
        <div class="height">
          <span class="content">{{item.bignewcontent}}</span>
        </div>
      </div>
      <div class="date">{{item.bignewdate|formatDate}}</div>
    </div>
  </div>
</div>
</template>

<script>
  import {formatDate} from "@/common/date";

  export default {
    name: "BigNewsList",
    props:{
      BigNewsList:{
        type:Array
      }
    },
    methods:{
      BigNewsitem(id){
        this.$router.push('/bignewsedit/'+id)
      }
    },
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd');
      }
    }
  }
</script>

<style scoped>
  .baby-info {
    height: 65px;
    padding: 6px 15px;

    display: flex;
    color: rgb(109, 104, 104);
    border-bottom: solid 1px #f3f3f3;
  }

  .info {
    flex: 1;
  }

  .info .login {
    margin-top: 15px;
  }
  .height{
    height: 20px;
    width: 290px;
    display: inline-block;
    text-align: center;
  }
  .content{
    color: var(--color-tint);
    font-size: 17px;
  }
  .date{
    float: right;
    margin-right: 5px;
    margin-top: 7px;
    font-size: 13px;
    color: #d7d7d7;
  }

</style>
