<template>
  <div id="babyInfo">
  <div class="baby-info" v-for="item in babyData" :class="item.babychecked?'show':''">
    <img class="avatar" :src="item.babyimg?url+item.babyimg:defaultImgUrl" alt="">
    <div class="info">
      <div class="login">{{item.babyname}}</div>
      <div class="brith">
        <img src="~assets/img/profile/brith.svg" alt="">
        <span>{{item.babybrith | formatDate}}</span>
      </div>
    </div>
    <div class="arrow" @click="babyItem(item.babyid)">
      <img src="~assets/img/common/right.svg" alt="">
    </div>
  </div>
  </div>
</template>

<script>
  import {formatDate} from "@/common/date";

  export default {
		name: "BabyListItem",
    data(){
		  return{
        defaultImgUrl:'img/avatar.bd23b9b1.svg',
		    url:this.$root.defaulturl
      }
    },
    props:{
		  babyData:{
        type:Array,
        default(){
          return [
          ]
        }
      }
    },
    methods:{
      babyItem(id){
        // console.log("babyid:"+id)
        this.$router.push('/babyinfo/'+id)
      }
    },
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm').substring(0,10);
      }
    }
  }
</script>

<style scoped>
  .baby-info {
    height: 85px;
    /*background-color: var(--color-tint);*/
    padding: 6px 15px;
    /*border: solid 1px;*/

    display: flex;
    color: rgb(109, 104, 104);
  }

  .baby-info .avatar {
    width: 70px;
    height: 70px;
    border-radius: 50%;
  }

  .info {
    padding-left: 15px;
    flex: 1;
  }

  .info .login {
    margin-top: 15px;
  }

  .brith img {
    width: 20px;
    height: 30px;
    vertical-align: middle;
    margin-left: -5px;
  }

  .brith span {
    font-size: 13px;
  }

  .arrow {
    width: 20px;
    line-height: 85px;
  }

  .arrow img {
    width: 20px;
  }
  .show{
    background-color: var(--color-back);
  }
</style>
