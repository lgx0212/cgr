<template>
  <div id="babyMyNewItemInfo">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>详情</div>
      </template>
      <template v-slot:right>
        <img @click="newsetup" src="~assets/img/common/dian.svg" alt="">
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true"
    >
      <baby-my-new-swiper v-show="scrollshow" :top-images="topImages"></baby-my-new-swiper>
      <div class="babyitem">
        <div class="baby-info">
          <img class="avatar" :src="ifImg?babyInfo['img']:defaultImgUrl" alt="" @click="userInformation">
          <div class="info">
            <div class="login">{{ babyInfo['name'] }}</div>
          </div>
          <div @click="likeNew">
            <img v-show="likenew==false" class="like" src="~assets/img/common/nolike.svg" alt="">
            <img v-show="likenew==true" class="like" src="~assets/img/common/like.svg" alt="">
          </div>
          <div @click="collectNew">
            <img v-show="collectnew==false" class="like" src="~assets/img/common/nocollect.svg" alt="">
            <img v-show="collectnew==true" class="like" src="~assets/img/common/collect.svg" alt="">
          </div>
        </div>
        <div class="a">
          <div class="mynewcontent">{{ myNewInfo['content'] }}</div>
          <div class="word">{{ this.myNewInfo['date'] |formatDate}}</div>
        </div>
      </div>
      <baby-my-new-comment @reply="reply(arguments)" :comment-data="commentData"></baby-my-new-comment>
    </scroll>
    <div class="tab-bar">
      <div class="tab-bar-item">
        <div class="messageContent">
          <input type="text" v-model="content" placeholder="评论">
        </div>
        <div class="sand" @click="sand">发送</div>
      </div>
    </div>
    <edit-confirm :edit="false" ref="myConfirm" :del="false" @attentionCancel="attention"
    >

    </edit-confirm>
    <confirm ref="myConfirmContent" @userBehavior="userBehaviorContent">

      <div class="date">
        <input v-model="replyContent"  type="text" name="user_date"/>

      </div>
    </confirm>
    <toast ref="toast"></toast>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import BabyMyNewSwiper from "./CommonNewSwiper";
  import BabyMyNewComment from "@/views/myspace/babyMynew/BabyMyNewComment";
  import Scroll from "@/components/common/scroll/Scroll";
  import Confirm from "@/components/common/confirm/Confirm";
  import EditConfirm from "@/components/common/confirm/EditConfirm"
  import Toast from "@/components/common/toast/Toast";
  import {getMyNewDataItem} from "@/network/myNew"
  import {insertAttention, checkedAttention} from "@/network/attention"
  import {selectIfSupport, insertSupport, deleteSupport} from "@/network/support"
  import {selectIfCollect, insertCollect, deleteCollect} from "@/network/collect";
  import {formatDate, NowDate} from "@/common/date";
  import {insertComment, insertReply, selectComment} from "@/network/comment";

  export default {
    name: "CommonNewInfo",
    components: {
      NavBar,
      BabyMyNewSwiper,
      BabyMyNewComment,
      Confirm,
      EditConfirm,
      Toast,
      Scroll
    },
    data() {
      return {
        mynewid: this.$route.params.mynewid,
        topImages: [],
        babyInfo: {},
        myNewInfo: {},
        ifImg: false,
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        scrollshow: true,
        likenew: false,
        collectnew: false,
        commentData:'',
        content:'',
        msg:[],
        replyContent:''
      }
    },
    created() {
      selectIfSupport(localStorage.getItem('userid'), this.mynewid).then(res => {
        if (res.ret == 1) {
          this.likenew = true
        }
      })
      selectIfCollect(localStorage.getItem('userid'),this.mynewid).then(res=>{
        if (res.ret == 1) {
          this.collectnew = true
        }
      })
      getMyNewDataItem(this.mynewid).then(res => {
        console.log(res);
        this.topImages = res.data[0].mynewp
        if (this.topImages.length == 0) {
          this.scrollshow = false
        }
        this.myNewInfo['content'] = res.data[0].mynewcontent
        this.myNewInfo['date'] = res.data[0].mynewdate
        this.babyInfo['name'] = res.data[0].users[0].username
        this.babyInfo['id'] = res.data[0].users[0].userid
        if (res.data[0].users[0].userimg) {
          this.ifImg = true
          this.babyInfo['img'] = this.$root.defaulturl + res.data[0].users[0].userimg
        }
      })
      selectComment(this.mynewid).then(res=>{
        this.commentData = res.data
        console.log(res);
      })
    },
    methods: {
      backClick() {
        this.$router.back()
      },
      newsetup() {
        this.$refs.myConfirm.show()
      },
      attention() {
        checkedAttention(localStorage.getItem('userid'), this.babyInfo['id']).then(res => {
          if (res.ret == 1) {
            this.$toast({message: '你已经关注过了哦！'})
          } else {
            if (localStorage.getItem('userid') != this.babyInfo['id']) {
              console.log(localStorage.getItem('userid'), this.babyInfo['id']);
              insertAttention(localStorage.getItem('userid'), this.babyInfo['id']).then(res => {
                if (res.ret == 1) {
                  this.$toast({message: "关注成功！"})
                }
              })
            } else {
              this.$toast({message: "不能关注自己哦！"})
            }
          }
        })

      },
      likeNew() {
        if (this.likenew == false) {
          insertSupport(localStorage.getItem('userid'), this.mynewid, this.babyInfo['id'])
          this.likenew = !this.likenew
          this.$toast({message:"点赞成功！"})
        } else if (this.likenew == true) {
          deleteSupport(localStorage.getItem('userid'), this.mynewid, this.babyInfo['id'])
          this.likenew = !this.likenew
          this.$toast({message:"已取消赞！"})
        }
      },
      collectNew() {
        if (this.collectnew == false) {
          insertCollect(localStorage.getItem('userid'), this.mynewid, this.babyInfo['id'])
          this.collectnew = !this.collectnew
          this.$toast({message:"收藏成功！"})
        } else if (this.collectnew == true) {
          deleteCollect(localStorage.getItem('userid'), this.mynewid)
          this.collectnew = !this.collectnew
          this.$toast({message:"已取消收藏！"})
        }
      },
      sand(){
        if(this.content==''){
          this.$toast({message: "评论为空！"})
        }else {
          let value = NowDate()
          insertComment(this.mynewid,localStorage.getItem('userid'),this.content,value).then(res=>{
            if(res.ret==1){
              this.$toast({message: "评论成功！"})
              this.content=''
              selectComment(this.mynewid).then(res=>{
                this.commentData = res.data
              })
            }
          })
        }
      },
      userInformation(){
        this.$router.push('/userspace/'+this.babyInfo['id'])
      },
      reply(msg){
        this.msg = msg
        this.userBehaviorContent()
      },
      userBehaviorContent() {
        this.$refs.myConfirmContent.show(' ', {
          // type: 'confirm',
          confirmText: '评论',
          titleText: '回复'
        })
        if (this.$refs.myConfirmContent.chose == 1) {

          insertReply(this.msg[0],localStorage.getItem('userid'),this.msg[1],this.replyContent,NowDate()).then(()=>{
            this.replyContent = ''
            selectComment(this.mynewid).then(res=>{
              this.commentData = res.data
            })
          })
        }
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
  #babyMyNewItemInfo {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }

  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }

  .content {
    overflow: hidden;
    position: absolute;
    top: 44px;
    bottom: 49px;
    left: 0;
    right: 0;
  }

  .babyitem {
    margin: 10px;
    background-color: #ffffff;
    border-top: solid 1px var(--color-tint);
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
    width: 45px;
    height: 45px;
    border-radius: 50%;
    margin-top: 10px;
    margin-left: 10px;
  }

  .like {
    width: 25px;
    height: 25px;
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

  .mynewcontent {
    width: 270px;
    word-break: break-all;
    margin-left: 15px;
    margin-bottom: 10px;
  }

  .a {
    margin-top: 20px;
  }

  .word {
    font-size: 14px;
    color: #999;
    margin-left: 10px;
  }
  .tab-bar {
    background-color: #f6f6f6;
    height: 49px;
    border-top: 1px solid #eee;
    box-shadow: 0 -1px 1px rgba(150, 150, 150, .08);
    position: fixed;
    left: 0;
    right: 0;
    bottom: 0;
    text-align: center;
  }

  .tab-bar-item {
    display: flex;
    font-size: 14px;
  }

  .messageContent {
    width: 70%;
    height: 49px;
    line-height: 49px;
  }

  input {
    width: 90%;
    height: 43px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
    border-width:0;
    border-bottom: solid 1px var(--color-tint);
  }

  .sand {
    width: 30%;
    line-height: 49px;
    text-align: center;
    font-size: 13px;
    background-color: var(--color-tint);
    color: #eeeeee;

  }
</style>
