<template>
  <div id="babyInfo" @click="changeBackImg" :style="{backgroundImage: 'url(' + backgroundImg + ')'}">
    <div class="baby-info">
      <img class="avatar" :src="ifImg?img:defaultImgUrl" alt="">
      <div class="info">
        <div class="login">{{ name }}</div>
        <div class="brith" v-show="ifBaby">
          <img src="~assets/img/profile/brith.svg" alt="">
          <span>{{ brith|formatDate }}</span>
        </div>
      </div>
      <div class="arrow" @click.stop="addMynew">
        <img src="~assets/img/profile/camera.svg" alt="">
      </div>
    </div>
    <toast ref="toast"></toast>
    <confirm ref="myConfirmImg" @userBehavior="userBehaviorImg">

      <div class="date">
        <form id="loginForm" :action="defaulturl+'/baby/updatebackimg'" method="post" target="frameName" enctype="multipart/form-data">
          <div class="uploadImg">
            <div class="upload-content">
              <ul class="img-list">
                <div class="uploadSec">
                  <img :src="ifbackimg?backgroundImg:'img/backimg.8edfc2b8.png'" alt="" width="100" height="80" id="img">
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
  </div>
</template>

<script>
  import {checkedBabyData} from '@/network/myspace'
  import {selectUserData} from "@/network/profile";
  import Toast from "@/components/common/toast/Toast";
  import {formatDate} from "@/common/date";
  import Confirm from "@/components/common/confirm/Confirm";
  import $ from "jquery";

  export default {
    name: "MyspaceInfo",
    components:{
      Toast,
      Confirm
    },
    data(){
      return{
        babyid:localStorage.getItem('babyid'),
        ifBaby:true,
        name:'',
        img:'',
        ifImg:false,
        ifbackimg:false,
        brith:'',
        backgroundImg:'',
        defaultImgUrl:'img/avatar.bd23b9b1.svg',
        defaulturl:this.$root.defaulturl
      }
    },
    created() {
      checkedBabyData(localStorage.getItem('userid')).then(res=>{
        if(res.ret==0){
          this.ifBaby = false
          return
        }
        this.name=res.data[0].babyname
        this.brith = res.data[0].babybrith
        if(res.data[0].babybackimg){
          this.ifbackimg = true
          this.backgroundImg = this.$root.defaulturl+res.data[0].babybackimg

        }
        if(res.data[0].babyimg!=null){
          this.ifImg=true
          this.img = this.$root.defaulturl+res.data[0].babyimg
        }
      })

    },
    methods:{
      addMynew(){
        if(localStorage.getItem('babyid')==null){
          this.$toast({message:"请先添加一个宝宝哦"})
        }else {
          this.$router.push('/babymynewadd')
        }
      },
      changeBackImg(){
        this.userBehaviorImg()
        console.log('a');
      },
      userBehaviorImg(){
        this.$refs.myConfirmImg.show(' ', {

          titleText: '点击图片上传'
        })
        if(this.$refs.myConfirmImg.chose==1){
          $("#loginForm").submit()
          var that = this
          setTimeout(function (){
            that.$router.go(0)
          },500)
        }
      },
      showImg(){
        var f = new FileReader();
        f.onload = function (ev){
          img.src = ev.target.result;
        }
        f.readAsDataURL(file.files[0]);
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
  #babyInfo{
    background-size:100% 100%;
    background-color: #f1f1f1;

  }
  .baby-info {
    height: 150px;

    /*background-color: var(--color-tint);*/
    padding: 6px 15px;
    /*border: solid 1px;*/

    display: flex;
    /*color: rgb(109, 104, 104);*/
  }

  .baby-info .avatar {
    margin-top: 30px;
    width: 70px;
    height: 70px;
    border-radius: 50%;
  }

  .info {
    padding-left: 15px;
    flex: 1;
  }

  .info .login {
    margin-top: 40px;

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
    text-align: center;
    width: 40px;
    height: 40px;
    line-height: 40px;
  }

  .arrow img {
    width: 20px;
    margin-top: 10px;

  }
  .iframe{
    display: none;
  }
  .uploadSec{
    position: relative;
    display: inline-block;
    width: 80px;
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
