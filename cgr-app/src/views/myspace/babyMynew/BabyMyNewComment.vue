<template>
  <div id="babymynewcomment">
    <div class="pl">评论</div>
    <div class="babyitem" v-for="item in commentData">
      <div class="baby-info"
           @touchstart="gtouchstart(item.commentid)"
           @touchmove="gtouchmove()"
           @touchend="gtouchend1(item.users[0].userid)"
      >

        <img class="avatar" :src=url+item.users[0].userimg alt="">
        <div class="info">
          <div class="login">{{ item.users[0].username }}
          </div>
        </div>
      </div>
      <div class="a"
           @touchstart="gtouchstart(item.commentid)"
           @touchmove="gtouchmove()"
           @touchend="gtouchend2(item.commentid,item.users[0].userid)"
           >
        <div class="mynewcontent">{{ item.commentcontent }}</div>
        <div class="word">{{ item.commentdate | formatDate }}</div>
      </div>
<!--      回复-->
      <div class="babyitem-r" v-for="i in item.comment_replies">
        <div class="baby-info-r" v-if="i.commentreplysanduserid">
          <img class="avatar-r" :src=url+i.users1[0].userimg alt=""
               @touchstart="gtouchstartReply(i.commentreplyid)"
               @touchmove="gtouchmove()"
               @touchend="gtouchend1(i.users1[0].userid)">
          <div class="info-r"
               @touchstart="gtouchstartReply(i.commentreplyid)"
               @touchmove="gtouchmove()"
               @touchend="gtouchend1(i.users1[0].userid)">
            <div class="login-r">{{ i.users1[0].username }}
            </div>
          </div>
          <div class="info-r-w">
            <div class="login-r-w">回复
            </div>
          </div>
          <img class="avatar-r" :src=url+i.users2[0].userimg alt=""
               @touchstart="gtouchstartReply(i.commentreplyid)"
               @touchmove="gtouchmove()"
               @touchend="gtouchend1(i.users2[0].userid)">
          <div class="info-r"
               @touchstart="gtouchstartReply(i.commentreplyid)"
               @touchmove="gtouchmove()"
               @touchend="gtouchend1(i.users2[0].userid)">
            <div class="login-r">{{ i.users2[0].username }}
            </div>
          </div>

        </div>
        <div class="a-r"
             v-if="i.commentreplysanduserid"
             @touchstart="gtouchstartReply(i.commentreplyid)"
             @touchmove="gtouchmove()"
             @touchend="gtouchend2(item.commentid,i.users1[0].userid)">
          <div class="mynewcontent-r">{{ i.commentreplycontent }}</div>
          <div class="word-r">{{ i.commentreplydate | formatDate }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {formatDate} from "@/common/date";

  export default {
    name: "",
    props: {
      commentData: {}
    },
    data() {
      return {
        url: this.$root.defaulturl,
        replyList:'',

      }
    },
    methods:{
      delComment(commentid){
        this.$emit('del',commentid)
      },
      //开始按
      gtouchstart(item){
        var self = this;
        this.timeOutEvent = setTimeout(function(){
          self.longPress(item)
        },500);//这里设置定时器，定义长按500毫秒触发长按事件，时间可以自己改，个人感觉500毫秒非常合适
        return false;
      },
      //手释放，如果在500毫秒内就释放，则取消长按事件，此时可以执行onclick应该执行的事件
      gtouchend1(item){
        clearTimeout(this.timeOutEvent);//清除定时器
        if(this.timeOutEvent!=0){
          //这里写要执行的内容（尤如onclick事件）
          this.goChat1(item);
        }
        return false;
      },
      gtouchend2(item1,item2){
        clearTimeout(this.timeOutEvent);//清除定时器
        if(this.timeOutEvent!=0){
          //这里写要执行的内容（尤如onclick事件）
          this.goChat2(item1,item2);
        }
        return false;
      },
      //如果手指有移动，则取消所有事件，此时说明用户只是要移动而不是长按
      gtouchmove(){
        clearTimeout(this.timeOutEvent);//清除定时器
        this.timeOutEvent = 0;

      },
      //真正长按后应该执行的内容
      longPress(id){
        this.timeOutEvent = 0;
        //执行长按要执行的内容，如弹出菜单
        this.$emit('del',id)
      },
      goChat1(userid){
        this.$router.push('/userspace/'+userid)

      },
      goChat2(id1,id2){
        this.$emit('reply',id1,id2)

      },
      gtouchstartReply(item){
        var self = this;
        this.timeOutEvent = setTimeout(function(){
          self.longPressReply(item)
        },500);//这里设置定时器，定义长按500毫秒触发长按事件，时间可以自己改，个人感觉500毫秒非常合适
        return false;
      },
      longPressReply(id){
        this.timeOutEvent = 0;
        //执行长按要执行的内容，如弹出菜单
        this.$emit('delreply',id)
      },
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
  #babymynewcomment {

  }
  .pl{
    text-align: center;
    color: #8f8f8f;
  }
  .babyitem {
    margin: 10px;
    background-color: #ffffff;
    border-bottom: solid 1px var(--color-back);
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
    margin-bottom: 5px;
  }

  .word {
    font-size: 14px;
    color: #999;
    margin-left: 10px;
    text-align: right;
  }
  .babyitem-r {
    margin-left: 20px;
    margin-right: 20px;
    background-color: #ffffff;
  }


  .baby-info-r {
    height: 30px;

    /*background-color: var(--color-tint);*/
    /*padding: 6px 15px;*/
    /*border: solid 1px;*/

    display: flex;
    /*color: rgb(109, 104, 104);*/
  }

  .baby-info-r .avatar-r {
    width: 25px;
    height: 25px;
    border-radius: 50%;
    /*margin-top: 10px;*/
    margin-left: 10px;
  }

  .info-r {
    padding-left: 10px;
    flex: 1;
  }

  .info-r .login-r {
    /*margin-top: 40px;*/
    /*height: 28px;*/
    line-height: 20px;
    margin-top: 8px;


  }

  .mynewcontent-r {
    width: 230px;
    word-break: break-all;
    margin-left: 15px;
    margin-bottom: 10px;
    font-size: 14px;
    color: #6d6d6d;
  }

  .a-r {
    margin-top: 5px;
    margin-bottom: 5px;
  }

  .word-r {
    font-size: 13px;
    color: #999;
    margin-left: 10px;
    text-align: right;
  }

  .info-r-w {
    padding-left: 10px;
    flex: 0.5;
  }

  .info-r-w .login-r-w {
    /*margin-top: 40px;*/
    /*height: 28px;*/
    line-height: 20px;
    margin-top: 8px;
    color: var(--color-tint);
    font-size: 15px;


  }
</style>
