<template>
  <div id="babyAdd">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>添加宝宝</div>
      </template>
      <template v-slot:right>
        <div @click="addBaby">添加</div>
      </template>
    </nav-bar>
    <div class="login_box">
      <form id="loginForm" :action='$root.defaulturl+"/baby/insertimg"' method="post" target="frameName"
            enctype="multipart/form-data">
        <input type="text" style="display: none" name="userid" id="userid" v-model="userid">
        <div class="uploadImg">
          <div class="upload-content">
            <ul class="img-list">
              <div class="uploadSec">
                <img :src="defaultImgUrl" alt="" width="100" height="80" id="img">
                <input type="file" name="file" id="file" @change="showImg">
              </div>
            </ul>
          </div>
        </div>
        <iframe class="iframe" src="" frameborder="0" name="frameName"></iframe>
        <div class="date">
          名字：
          <input v-model="babyname" type="text" name='babyname' id="babyname">
        </div>
        <div class="sex">
          性别：
          <select v-model="babysex" name="babysex" id="babysex">
            <option value="男">男</option>
            <option value="女">女</option>
          </select>
        </div>
        <div class="date">
          生日：
          <input v-model="babybrith" type="date" name="babybrith" id="babybrith"/>

        </div>
      </form>

    </div>
    <toast></toast>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Toast from "@/components/common/toast/Toast";
  import {insertBaby} from "@/network/myspace"
  import $ from "jquery"

  export default {
    name: "BabyAdd",
    components: {
      NavBar,
      Toast
    },
    data() {
      return {
        ifImg: false,
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        userid: localStorage.getItem("userid"),
        babyname: '',
        babysex: '',
        babybrith: ''
      }
    },
    methods: {
      backClick() {
        this.$router.back()
      },
      addBaby() {
        if (this.babyname == '') {
          this.$toast({message: '姓名不能为空！'})
        } else if (this.babysex == '') {
          this.$toast({message: '性别不能为空！'})
        } else if (this.babybrith == '') {
          this.$toast({message: '生日不能为空！'})
        } else {
          var fileInput = $('#file').get(0).files[0];
          if (fileInput) {
            var imgStr = /\.(jpg|jpeg|png|bmp|BMP|JPG|PNG|JPEG)$/;
            if (!imgStr.test(fileInput.name)) {
              insertBaby(localStorage.getItem("userid"), this.babyname, this.babysex, this.babybrith).then(res => {
              if(res.ret==1){
                this.$toast({message: '添加成功！'})
                this.$router.push('/babylist')
              }
              })
            }
            else {
              $("#loginForm").submit()
              let _this = this
              setTimeout(function (){
                _this.$toast({message: '添加成功'})
                _this.$router.push('/babylist')
              },500)

            }
          } else {
            insertBaby(localStorage.getItem("userid"), this.babyname, this.babysex, this.babybrith).then(res => {
              if(res.ret==1){
                this.$toast({message: '添加成功！'})
                this.$router.push('/babylist')
              }
            })
          }
        }

      },
      showImg() {
        let imgFile = $('#file').get(0).files[0];
        var imgStr = /\.(jpg|jpeg|png|bmp|BMP|JPG|PNG|JPEG)$/;
        if (!imgStr.test(imgFile.name)) {
          this.$toast({message: '文件不是图片类型！'})
          return false;
        } else {
          let f = new FileReader();
          f.onload = function (ev) {
            img.src = ev.target.result;
          }
          f.readAsDataURL(file.files[0]);
        }
      }
    }
  }
</script>

<style scoped>
  #babyAdd {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }

  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }

  .login_box {
    box-sizing: border-box;
    padding: 10px 20px;
  }

  .phone input,
  .password input,
  .name input {
    width: 100%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
  }

  .sex, .date {
    padding-top: 20px;
  }

  .sex select,
  .date input {
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
    border-radius: 50%;
  }

  .upload-content {
    text-align: center;
  }

  #file {
    position: absolute;
    height: 100%;
    left: 0;
    top: 0;
    opacity: 0;
  }
</style>
