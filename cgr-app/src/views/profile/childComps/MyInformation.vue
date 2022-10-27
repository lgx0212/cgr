<template>
  <div id="myInformation">
      <nav-bar class="home-nav">
        <template v-slot:left>
          <div class="back" @click="backClick">
            <img src="~assets/img/common/back.svg" alt="">
          </div>
        </template>
        <template v-slot:center>
          <div>账号资料</div>
        </template>
      </nav-bar>
    <div class="normal-list">
      <div  class="item">

        <div class="info">头像</div>
        <img :src="ifImg?userimg:defaultImgUrl" @click="changeImg">
<!--        <input type="file" id="file" style="filter:alpha(opacity=0);opacity:0;width:100%;height:100%;" />-->
      </div>
    </div>
    <div class="normal-list">
      <div  class="item">

        <div class="info">昵称</div>
        <div class="right" @click="changeName">{{ username }}</div>

      </div>
    </div>
    <div class="normal-list">
      <div  class="item">

        <div class="info">性别</div>
        <div class="right" @click="changeSex">{{ usersex }}</div>
      </div>
    </div>
    <div class="normal-list">
      <div  class="item">

        <div class="info">生日</div>
        <div class="right" @click="changeDate">{{ userdate | formatDate }}</div>
      </div>
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
        <input v-model="userdate" type="date" name="user_date" />

      </div>
    </confirm>
    <confirm ref="myConfirmImg" @userBehavior="userBehaviorImg">

      <div class="date">
        <form id="loginForm" :action="defaulturl+'/users/updateimg'" method="post" target="frameName" enctype="multipart/form-data">
          <div class="uploadImg">
            <div class="upload-content">
              <ul class="img-list">
                <div class="uploadSec">
                  <img :src="ifImg?userimg:defaultImgUrl" alt="" width="100" height="80" id="img">
                  <input type="file" name="file" id="file" @change="showImg">
                </div>
              </ul>
            </div>
          </div>
          <input id="id" type="text" name="userid" required="required" :value="userid">
        </form>
        <iframe class="iframe" src="" frameborder="0" name="frameName"></iframe>
      </div>
    </confirm>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Confirm from "@/components/common/confirm/Confirm";
  import {formatDate} from "@/common/date";
  import {selectUserData} from "@/network/profile";
  import {updateUser} from "@/network/profile";
  import $ from "jquery";

  export default {
    name: "MyInformation",
    inject:['reload'],
    components:{
      NavBar,
      Confirm
    },

    data(){
      return{
        userid:localStorage.getItem('userid'),
        userimg:'',
        username:'',
        usersex:'',
        userdate:'',
        ifImg:false,
        defaultImgUrl:'img/avatar.bd23b9b1.svg',
        checkValue:'男',
        defaulturl:this.$root.defaulturl
      }
    },
    created() {
      this.getuserInfo()

    },
    methods:{
      getuserInfo(){
        selectUserData(localStorage.getItem('userid')).then(res=>{
          this.username=res.data[0].username
          if(res.data[0].userimg!=null){
            this.ifImg=true
            this.userimg = this.defaulturl+res.data[0].userimg
          }
          this.usersex = res.data[0].usersex
          this.checkValue =  res.data[0].usersex
          const date = new Date(res.data[0].userbrith);
          this.userdate = formatDate(date, 'yyyy-MM-dd')

        })
      },
      backClick(){
        this.$router.push("/profile")
      },
      changeName(){
        this.$router.push('/changeName')
      },
      changeSex(){
        this.userBehaviorFun()

      },
      changeDate(){
        this.userBehaviorDate()
      },
      changeImg(){
        this.userBehaviorImg()
      },
      showImg(){
        var f = new FileReader();
        f.onload = function (ev){
          img.src = ev.target.result;
        }
        f.readAsDataURL(file.files[0]);
      },
      userBehaviorFun(){
        this.$refs.myConfirm.show(' ', {
          // type: 'confirm',
          // confirmText: '确定',
          // titleText: '消息提示'
        })
        if(this.$refs.myConfirm.chose==1){

          console.log(this.checkValue)
          updateUser(localStorage.getItem('username'),this.checkValue,localStorage.getItem('userbrith'),localStorage.getItem('userid')).then(res=>{
            localStorage.setItem('usersex',this.checkValue)
            console.log(this.$root.username)
            if(res.ret==1){
              this.getuserInfo();
            }
          })
        }
      },
      userBehaviorDate(){
        this.$refs.myConfirmData.show(' ', {
          // type: 'confirm',
          // confirmText: '确定',
          // titleText: '消息提示'
        })
        if(this.$refs.myConfirmData.chose==1){
          console.log(this.userdate)
          updateUser(localStorage.getItem('username'),localStorage.getItem('usersex'),this.userdate,localStorage.getItem('userid')).then(res=>{
            console.log(res)
            localStorage.setItem('userbrith',this.userdate)
            // console.log(this.$root.username)
            if(res.ret==1){
              this.getuserInfo();
            }
          })
        }
      },
      userBehaviorImg(){
        this.$refs.myConfirmImg.show(' ', {

          titleText: '点击图片上传'
        })
        if(this.$refs.myConfirmImg.chose==1){
          $("#loginForm").submit()
          var that = this
          setTimeout(function (){that.getuserInfo()},500)
        }
      },
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
  #myInformation {
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
  .item img{
    width: 40px;
    height: 40px;
    /*display: inline;*/
    /*justify-content:center;*/
    float: right;
    margin-top: 2px;
    margin-right: 20px;
    border-radius: 50%;

  }
  .item .right{
    float: right;
    margin-right: 25px;
  }
  .sex select{
    width: 80%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
  }
  .iframe{
    display: none;
  }
  .uploadImg{
    /*text-align: left;*/
  }
  .upload-content{
    /*margin-left: 0.3rem;*/
  }


  .img-list{
    display: inline-block;
    /*margin: 0.6rem 0.3rem 0.3rem 0;*/
  }

  .uploadSec img{
    width: 100%;
    height: 100%;
  }


  .uploadSec{
    position: relative;
    display: inline-block;
    width: 60px;
    height: 60px;
    overflow: hidden;}
  .uploadSec img{
    width: 100%;
    height: 100%;
  }
  #file{
    position: absolute;
    height: 100%;
    left: 0;
    top: 0;
    opacity: 0;
  }
  #id{
    display: none;
  }

</style>
