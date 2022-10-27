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
        <img @click="mynewsetup" src="~assets/img/common/dian.svg" alt="">
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
          <img class="avatar" :src="ifImg?babyInfo['img']:defaultImgUrl" alt="">
          <div class="info">
            <div class="login">{{ babyInfo['name'] }}</div>
          </div>
          <div @click="like">
            <img  class="like" src="~assets/img/common/like.svg" alt="">
            <div class="likenum">{{supportnum}}</div>
          </div>
          <div @click="collect">
            <img  class="like" src="~assets/img/common/collect.svg" alt="">
            <div class="likenum">{{collectnum}}</div>
          </div>
        </div>
        <div class="a">
          <div class="mynewcontent">{{myNewInfo['content']}}</div>
          <div class="word">{{this.myNewInfo['date'] | formatDate}}</div>
        </div>
      </div>
      <baby-my-new-comment @reply="reply(arguments)"
                           @del="delComment"
                           @delreply="delreply"
                           :comment-data="commentData"></baby-my-new-comment>
    </scroll>
    <div class="tab-bar">
      <div class="tab-bar-item">
        <div class="messageContent">
          <input type="text" v-model="content" placeholder="评论">
        </div>
        <div class="sand" @click="sand">评论</div>
      </div>
    </div>
    <edit-confirm :edit="false" ref="myConfirm"
                  :attention="false"
                  :open="!ifopen"
                  :close="ifopen"
                  @deleteCancel="deleteCancel"
                  @openCancel="openCancel"
                  @closeCancel="closeCancel">

    </edit-confirm>
    <edit-confirm :edit="false" ref="CommentConfirm"
                  :attention="false"
                  @deleteCancel="deleteComment">

    </edit-confirm>
    <edit-confirm :edit="false" ref="CommentReplyConfirm"
                  :attention="false"
                  @deleteCancel="deleteCommentReply">

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
  import BabyMyNewSwiper from "./BabyMyNewSwiper";
  import BabyMyNewComment from "./BabyMyNewComment";
  import Scroll from "@/components/common/scroll/Scroll";
  import Confirm from "@/components/common/confirm/Confirm";
  import EditConfirm from "@/components/common/confirm/EditConfirm"
  import Toast from "@/components/common/toast/Toast";
  import {getMyNewDataItem,deleteMyNewData,updateIfOpen} from "@/network/myNew"
  import {deleteMyNewPData} from "@/network/myNewP"
  import {checkedBabyData, updateBabyItem} from "@/network/myspace";
  import {selectSupportNum} from "@/network/support"
  import {selectCollectNum} from "@/network/collect"
  import {formatDate,NowDate} from "@/common/date";
  import {insertComment,selectComment,deleteComment,insertReply,deleteReply} from "@/network/comment"

  export default {
    name: "BabyMyNewItemInfo",
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
        mynewid:this.$route.params.mynewid,
        topImages: [],
        babyInfo: {},
        myNewInfo:{},
        ifopen:'',
        ifImg: false,
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        scrollshow:true,
        supportnum:0,
        collectnum:0,
        content:'',
        commentData:'',
        commentid:'',
        commentreplyid:'',
        msg:[],
        replyContent:''
      }
    },
    created() {
      selectSupportNum(this.mynewid).then(res=>{
        if(res.ret){
          this.supportnum = res.data.length
        }
      })
      selectCollectNum(this.mynewid).then(res=>{
        if(res.ret) {
          this.collectnum = res.data.length
        }
      })
      getMyNewDataItem(this.mynewid).then(res => {
        this.topImages = res.data[0].mynewp
        if(this.topImages.length==0){
          this.scrollshow = false
        }
        this.myNewInfo['content'] = res.data[0].mynewcontent
        this.myNewInfo['date'] = res.data[0].mynewdate
        this.ifopen = res.data[0].mynewopen?true:false

      })
      checkedBabyData(localStorage.getItem('userid')).then(res => {
        this.babyInfo['name'] = res.data[0].babyname
        if(res.data[0].babyimg){
          this.ifImg=true
          this.babyInfo['img'] = this.$root.defaulturl + res.data[0].babyimg

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
      mynewsetup() {

        this.$refs.myConfirm.show()
      },
      deleteCancel() {
        deleteMyNewData(this.mynewid).then(res=>{
          if(res.ret==1){
            deleteMyNewPData(this.mynewid)
            this.$toast({message:"删除成功！"})
            window.location.href=this.$root.vuedefaulturl;
          }
        })
      },
      openCancel(){
        updateIfOpen(1,this.mynewid).then(()=>{
          this.ifopen = true
        })
      },
      closeCancel(){
        updateIfOpen(0,this.mynewid).then(()=>{
          this.ifopen = false
        })
      },
      like(){
        this.$router.push({
          path: `/babymynewsclist/1/${this.mynewid}`
        })
      },
      collect(){
        this.$router.push({
          path: `/babymynewsclist/2/${this.mynewid}`
        })
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
      delComment(id){
        this.commentid = id
        this.$refs.CommentConfirm.show()

      },
      delreply(id){
        this.commentreplyid = id
        this.$refs.CommentReplyConfirm.show()
      },
      deleteComment(){
        deleteComment(this.commentid).then(res=>{
          if(res.ret==1){
            this.$toast({message:"删除成功"})
            selectComment(this.mynewid).then(res=>{
              this.commentData = res.data
            })
          }
        })
      },
      deleteCommentReply(){
        deleteReply(this.commentreplyid).then(res=>{
          if(res.ret==1){
            this.$toast({message:"删除成功"})
            selectComment(this.mynewid).then(res=>{
              this.commentData = res.data
            })
          }
        })
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
  .mynewcontent{
    width: 270px;
    word-break: break-all;
    margin-left: 15px;
    margin-bottom: 10px;
  }
  .a {
    margin-top: 20px;
    margin-bottom: 20px;
  }
  .word{
    font-size: 14px;
    color: #999;
    margin-left: 10px;
  }
  .like {
    width: 25px;
    height: 25px;
    border-radius: 50%;
    margin-top: 10px;
    margin-left: 10px;
  }
  .likenum{
    margin-left: 10px;
    text-align: center;
    font-size: 13px;
    color: #828282;
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
