<template>
  <div id="babyInfo">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>宝宝信息</div>
      </template>
      <template v-slot:right>
        <div v-show="ifChange" @click="changeBaby">切换</div>
      </template>
    </nav-bar>
    <div class="normal-list">
      <div class="item">

        <div class="info">头像</div>
        <img :src="ifImg?babyimg:defaultImgUrl" @click="changeImg">
        <!--        <input type="file" id="file" style="filter:alpha(opacity=0);opacity:0;width:100%;height:100%;" />-->
      </div>
    </div>
    <div class="normal-list">
      <div class="item">

        <div class="info">昵称</div>
        <div class="right" @click="changeBabyName">{{ babyname }}</div>

      </div>
    </div>
    <div class="normal-list">
      <div class="item">

        <div class="info">性别</div>
        <div class="right" @click="changeBabySex">{{ babysex }}</div>
      </div>
    </div>
    <div class="normal-list">
      <div class="item">

        <div class="info">生日</div>
        <div class="right" @click="changeBabyDate">{{ babydate | formatDate }}</div>
      </div>
    </div>
    <div class="set">
      <div class="setup" tapmode @click="deleteBaby">删除宝宝</div>
    </div>
    <confirm ref="myConfirm" @userBehavior="userBehaviorFun">

      <div class="sex">
        <select v-model="checkValue">
          <option value="男">男</option>
          <option value="女">女</option>
        </select>
      </div>
    </confirm>
    <confirm ref="myConfirmData" @userBehavior="userBehaviorDate">

      <div class="date">
        <input v-model="babydate" type="date" name="user_date"/>

      </div>
    </confirm>
    <confirm ref="myConfirmImg" @userBehavior="userBehaviorImg">

      <div class="date">
        <form id="loginForm" :action='$root.defaulturl+"/baby/updateimg"' method="post" target="frameName"
              enctype="multipart/form-data">
          <div class="uploadImg">
            <div class="upload-content">
              <ul class="img-list">
                <div class="uploadSec">
                  <img :src="ifImg?babyimg:defaultImgUrl" alt="" width="100" height="80" id="img">
                  <input type="file" name="file" id="file" @change="showImg">
                </div>
              </ul>
            </div>
          </div>
          <input id="id" type="text" name="babyid" required="required" :value="babyid">
        </form>
        <iframe class="iframe" src="" frameborder="0" name="frameName"></iframe>
      </div>
    </confirm>
    <confirm ref="deleteBaby" @userBehavior="userBehaviorDelete"></confirm>
    <toast></toast>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Confirm from "@/components/common/confirm/Confirm";
  import Toast from "@/components/common/toast/Toast";
  import {checkedBabyData, selectBabyItem} from "@/network/myspace";
  import {formatDate} from "@/common/date";
  import {updateBabyItem, updateBabyChecked, deleteBaby, getBabyData} from "@/network/myspace";
  import $ from "jquery";

  export default {
    name: "BabyInfo",
    inject: ['reload'],
    components: {
      NavBar,
      Confirm,
      Toast
    },
    data() {
      return {
        babyid: this.$route.params.babyid,
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        ifImg: false,
        babyimg: '',
        babyname: '',
        babysex: '',
        babydate: '',
        checkValue: '',
        ifChange: false
      }
    },
    created() {
      this.getbabyInfo()
    },
    methods: {
      getbabyInfo(){
        selectBabyItem(this.babyid).then(res => {
          if (res.data[0].babyimg != null) {
            this.ifImg = true
            this.babyimg = this.$root.defaulturl + res.data[0].babyimg
          }
          this.babyname = res.data[0].babyname
          this.babysex = res.data[0].babysex
          this.checkValue = res.data[0].babysex
          const date = new Date(res.data[0].babybrith);
          this.babydate = formatDate(date, 'yyyy-MM-dd')
          if (res.data[0].babychecked == 0) {
            this.ifChange = true
          }
        })
      },
      backClick() {
        this.$router.push('/babyList')
      },
      deleteBaby() {
        this.userBehaviorDelete()
      },
      changeImg() {
        this.userBehaviorImg()
      },
      changeBaby() {
        updateBabyChecked(localStorage.getItem('userid'), this.babyid).then(res => {
          localStorage.setItem('babyid', this.babyid)
          this.$toast({message: '切换成功！'})
          window.location.href = this.$root.vuedefaulturl;
        })
      },
      changeBabyName() {
        // this.$router.push('/changebabyname/'+this.babyid)
        this.$router.push({
          path: `/changebabyname/${this.babyid}/${this.babyname}`
        })
      },
      changeBabySex() {
        this.userBehaviorFun()
      },
      changeBabyDate() {
        this.userBehaviorDate()
      },
      userBehaviorFun() {
        this.$refs.myConfirm.show(' ', {
          // type: 'confirm',
          // confirmText: '确定',
          // titleText: '消息提示'
        })
        if (this.$refs.myConfirm.chose == 1) {

          var date = new Date(this.babydate);
          var brith = formatDate(date, 'yyyy-MM-dd')
          updateBabyItem(this.babyname, this.checkValue, brith, this.babyid).then(res => {
            if (res.ret == 1) {
              this.getbabyInfo()
            }
          })

        }
      },
      userBehaviorDate() {
        this.$refs.myConfirmData.show(' ', {
          // type: 'confirm',
          // confirmText: '确定',
          // titleText: '消息提示'
        })
        if (this.$refs.myConfirmData.chose == 1) {
          var date = new Date(this.babydate);
          var brith = formatDate(date, 'yyyy-MM-dd')
          if(this.babyid==localStorage.getItem('babyid')){
            localStorage.setItem('changebaby', '1')
          }
          updateBabyItem(this.babyname, this.babysex, brith, this.babyid).then(res => {
            if (res.ret == 1) {
              this.getbabyInfo()
            }
          })


        }
      },
      userBehaviorImg() {
        this.$refs.myConfirmImg.show(' ', {
          titleText: '点击图片上传'
        })
        if (this.$refs.myConfirmImg.chose == 1) {
          if(this.babyid==localStorage.getItem('babyid')){
            localStorage.setItem('changebaby', '1')
          }
          $("#loginForm").submit()
          var that = this
          setTimeout(function () {
            that.getbabyInfo()
          }, 500)
        }
      },
      userBehaviorDelete() {
        this.$refs.deleteBaby.show('删除后宝宝的动态都会消失哦，你确定要删除吗？')
        if (this.$refs.deleteBaby.chose == 1) {
          if (this.babyid == localStorage.getItem('babyid')) {
            deleteBaby(this.babyid).then(res => {
              getBabyData(localStorage.getItem('userid')).then(res => {

                if (res.ret == 1) {
                  localStorage.setItem('babyid',res.data[0].babyid)
                  updateBabyChecked(localStorage.getItem('userid'), res.data[0].babyid).then(() => {
                    this.$toast({message: '删除成功！'})

                    this.$router.push('/babyList')
                  })
                } else {
                  localStorage.removeItem('babyid')
                  this.$toast({message: '删除成功！'})
                  this.$router.push('/babyList')
                }
              })
            })

          } else {
            deleteBaby(this.babyid).then(res=>{
              if(res.ret==1){
                this.$toast({message: '删除成功！'})
                this.$router.push('/babyList')
              }else {
                this.$toast({message: '删除失败！'})
              }
            })
          }

        }
      },
      showImg() {
        var f = new FileReader();
        f.onload = function (ev) {
          img.src = ev.target.result;
        }
        f.readAsDataURL(file.files[0]);
      }
    },
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd')
      }
    }
  }
</script>

<style scoped>
  #babyInfo {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }

  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }

  .normal-list {
    background-color: #fff;
    font-size: 15px;
    color: #333;
    /*margin-top: 15px;*/
    border-bottom: 1px solid rgba(100, 100, 100, .1);

  }

  .normal-list .item {
    height: 44px;
    line-height: 44px;
    position: relative;

  }

  .item .info {
    margin-left: 20px;
    margin-right: 20px;
    padding-left: 5px;
    /*display: inline;*/
    float: left;
    /*justify-content:center;*/


  }

  .item img {
    width: 40px;
    height: 40px;
    /*display: inline;*/
    /*justify-content:center;*/
    float: right;
    margin-top: 2px;
    margin-right: 20px;
    border-radius: 50%;

  }

  .item .right {
    float: right;
    margin-right: 25px;
  }

  .sex select {
    width: 80%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
  }

  .iframe {
    display: none;
  }

  .img-list {
    display: inline-block;
    /*margin: 0.6rem 0.3rem 0.3rem 0;*/
  }

  .uploadSec {
    position: relative;
    display: inline-block;
    width: 60px;
    height: 60px;
    overflow: hidden;
  }

  .uploadSec img {
    width: 100%;
    height: 100%;
  }

  #file {
    position: absolute;
    height: 100%;
    left: 0;
    top: 0;
    opacity: 0;
  }

  #id {
    display: none;
  }

  .set {
    margin: 40px 0 10px;
  }

  .setup {
    width: 80%;
    height: 44px;
    line-height: 44px;
    text-align: center;
    font-size: 13px;
    color: #fff;
    border-radius: 4px;
    background-color: red;
    margin: 0 auto;
  }
</style>
