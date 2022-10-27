<template>
  <div class="goods-list">
    <div class="goods-item item" v-for="item in myNew" @click="newInfo(item.mynewid)">
      <div v-for="(i,index) in item.mynewp">
        <img v-if="i.mynewpimg.substring(i.mynewpimg.length-3,i.mynewpimg.length)!='mp4'"
             v-show="index==0&&item.mynewp" :src='url+i.mynewpimg'>
        <video v-show="index==0&&item.mynewp"
               v-if="i.mynewpimg.substring(i.mynewpimg.length-3,i.mynewpimg.length)=='mp4'">
          <source :src="url+i.mynewpimg">
        </video>
      </div>
      <div class="babyitem">
        <div class="baby-info">
          <img class="avatar" :src="item.users[0].userimg?url+item.users[0].userimg:defaultImgUrl" alt="">
          <div class="info">
            <div class="login">{{ item.users[0].username }}</div>
          </div>
        </div>
        <div class="a">
          <div class="mynewcontent">{{ item.mynewcontent }}</div>
          <div class="word">{{ item.mynewdate | formatDate}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {getNewData} from "@/network/myNew";
  import {formatDate} from "@/common/date";

  export default {
    name: "CommonNews",
    data() {
      return {
        myNew: [],
        url: this.$root.defaulturl,
        ifImg: false,
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',

      }
    },
    created() {
      getNewData().then(res => {
        let data = res.data
        this.myNew = data
      })
    },
    methods: {
      newInfo(mynewid) {
        this.$router.push('/commonnewinfo/' + mynewid)

      }
    },
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm');
      }
    }
  }
</script>

<style scoped>
  .goods-list {
    display: flex;
    flex-wrap: wrap;
    padding: 5px;
    justify-content: space-around;
  }

  .goods-list .item {
    margin-top: 5px;
    width: 100%;
    /*height: 200px;*/
    /*border-bottom: solid 2px #fafafa;*/
  }

  .goods-item {
    /*padding-bottom: 40px;*/
    position: relative;
  }

  .goods-item img ,video{
    width: 100%;
    height: 150px;
    border-radius: 5px;
  }


  .babyitem {
    margin: 10px;
    background-color: #ffffff;
    border-bottom: solid 1px var(--color-tint);
  }


  .babyimg img {
    width: 100px;
    height: 100px;
    padding: 3px;
  }

  .baby-info {
    height: 40px;

    /*background-color: var(--color-tint);*/
    /*padding: 6px 15px;*/
    /*border: solid 1px;*/

    display: flex;
    /*color: rgb(109, 104, 104);*/
  }

  .baby-info .avatar {
    width: 35px;
    height: 35px;
    border-radius: 50%;
    /*margin-top: 10px;*/
    margin-left: 10px;
  }

  .info {
    padding-left: 15px;
    flex: 1;
  }

  .info .login {
    /*margin-top: 40px;*/
    /*height: 28px;*/
    line-height: 28px;
    margin-top: 10px;


  }

  .mynewcontent {
    width: 270px;
    word-break: break-all;
    margin-left: 15px;
    margin-bottom: 10px;
    font-size: 14px;
    color: #6d6d6d;
  }

  .a {
    margin-top: 20px;
  }

  .word {
    font-size: 14px;
    color: #999;
    margin-left: 10px;
    text-align: right;
  }
</style>
