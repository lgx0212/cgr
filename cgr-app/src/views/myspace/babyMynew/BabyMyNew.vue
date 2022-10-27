<template>
  <div id="babyMyNew">
    <div v-for="item in myNew" class="babyitem" @click="babyNewItem(item.mynewid)">
      <div class="baby-info">
        <img class="avatar" :src="ifImg?babyImg:defaultImgUrl" alt="">
        <div class="info">
          <div class="login">{{ babyname }}</div>
        </div>
      </div>
      <div class="a">
        <div class="mynewcontent">{{ item.mynewcontent }}</div>

      <div class="babyimg">
        <div v-for="i in item.img" >
          <img v-if="i.mynewpimg.substring(i.mynewpimg.length-3,i.mynewpimg.length)!='mp4'" :src=ImgUrl+i.mynewpimg>
          <video v-if="i.mynewpimg.substring(i.mynewpimg.length-3,i.mynewpimg.length)=='mp4'">
            <source :src="ImgUrl+i.mynewpimg">
          </video>
        </div>
      </div>
      <div class="word">{{ item.mynewdate | formatDate }}</div>
    </div>
  </div>
  </div>
</template>

<script>
  import {checkedBabyData} from "@/network/myspace";
  import {getMyNewData} from "@/network/myNew"
  import {getMyNewPData} from "@/network/myNewP";
  import {formatDate} from "@/common/date";

  export default {
    name: "BabyMyNew",
    inject: ['reload'],
    components: {
    },
    data() {
      return {
        myNew: [],
        babyImg: '',
        babyname: '',
        ifImg: false,
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        ImgUrl: this.$root.defaulturl
      }
    },
    created() {
      checkedBabyData(localStorage.getItem('userid')).then(res => {
        if(res.ret==0){
          return
        }
        this.babyname = res.data[0].babyname
        if (res.data[0].babyimg != null) {
          this.ifImg = true
          this.babyImg = this.$root.defaulturl + res.data[0].babyimg
          // console.log(res.data[0].babyimg.substring(res.data[0].babyimg.length - 3, res.data[0].babyimg.length));
        }
        getMyNewData(res.data[0].babyid).then(res => {
          this.myNew = res.data
          if(res.ret==0){
            return
          }
          for (let i = 0; i < res.data.length; i++) {
            this.myNew[i]['img'] = ''
          }
          // console.log(this.myNew)
          for (let i = 0; i < res.data.length; i++) {
            getMyNewPData(res.data[i].mynewid).then(res => {
              this.myNew[i]['img'] = res.data
              // console.log(this.myNew)
              this.$forceUpdate()
            })
          }
        })
      })
    },
    activated() {

    },
    methods: {
      babyNewItem(mynewId){
        this.$router.push("/babymynewinfo/"+mynewId)
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
  #babyMyNew {
    /*position: relative;*/
    /*z-index: 9;*/
    background-color: #f8f8f8;
    /*height: 100vh;*/
    padding-top: 1px;
  }

  .babyitem {
    margin: 10px;
    background-color: #ffffff;
  }

  .babyimg {
    display: flex;
    flex-wrap: wrap;
  }

  .babyimg img ,video{
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
    margin-top: 10px;
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


  .arrow {
    width: 20px;
    line-height: 85px;
  }

  .arrow img {
    width: 20px;
    margin-top: 40px;

  }
  .mynewcontent{
    width: 270px;
    word-break: break-all;
    margin-left: 15px;
    margin-bottom: 10px;
  }
  .a {
    margin-top: 20px;
  }
  .word{
    font-size: 14px;
    color: #999;
    margin-left: 10px;
  }
</style>
