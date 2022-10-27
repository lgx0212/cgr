<template>
  <div id="babyInfo">
    <div class="baby-info" v-for="item in babyData"
         @touchstart="gtouchstart(item.messagenum)"
         @touchmove="gtouchmove()"
         @touchend="gtouchend(item.messageid)">

        <img v-if="item.message_cs[item.message_cs.length - 1].messagecontent"
             class="avatar" :src=url+item.users[0].userimg alt="">
        <div v-if="item.message_cs[item.message_cs.length - 1].messagecontent"
             class="info">
          <div class="login">{{ item.users[0].username }}
            <span>{{ item.message_cs[item.message_cs.length - 1].messagecdate | formatDate }}</span>
          </div>
          <div class="brith">
            <span>{{ item.message_cs[item.message_cs.length - 1].messagecontent.substring(0, 15) }}</span>
            <span v-if="item.message_cs[item.message_cs.length - 1].messagecontent.length>15">......</span>
            <span v-if="item.message_cs[item.message_cs.length - 1].messagecstate==0" class="state"></span>
          </div>
        </div>
    </div>
  </div>
</template>

<script>
  import {formatDate} from "@/common/date";

  export default {
    name: "MessageListItem",
    data() {
      return {
        url: this.$root.defaulturl,
        timeOutEvent:0
      }
    },
    components:{
    },
    props: {
      babyData: {
        type: Array,
        default() {
          return []
        }
      }
    },
    methods: {
      //开始按
      gtouchstart(item){
        var self = this;
        this.timeOutEvent = setTimeout(function(){
          self.longPress(item)
        },500);//这里设置定时器，定义长按500毫秒触发长按事件，时间可以自己改，个人感觉500毫秒非常合适
        return false;
      },
      //手释放，如果在500毫秒内就释放，则取消长按事件，此时可以执行onclick应该执行的事件
      gtouchend(item){
        clearTimeout(this.timeOutEvent);//清除定时器
        if(this.timeOutEvent!=0){
          //这里写要执行的内容（尤如onclick事件）
          this.goChat(item);
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
        this.$emit('editMessage',id)
      },
      goChat(id){
        this.$router.push('/messageinfo/' + id)

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
  .baby-info {
    height: 85px;
    /*background-color: var(--color-tint);*/
    padding: 6px 15px;
    /*border: solid 1px;*/
    border-bottom: solid 1px #fafafa;

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

  .login span {
    float: right;
    font-size: 10px;
    color: #d7d7d7;
  }

  .brith img {
    width: 20px;
    height: 30px;
    vertical-align: middle;
    margin-left: -5px;
  }

  .brith span {
    font-size: 13px;
    color: #d7d7d7;
    /*width: 130px;*/
  }

  .brith {
    margin-top: 10px;

  }
  .state{
    float: right;
    width: 14px;
    height: 14px;
    border-radius: 50%;
    background-color: red;
  }

  .arrow {
    width: 80px;
    height: 30px;
    line-height: 50px;
    font-size: 10px;
    color: #d7d7d7;
  }


  .show {
    background-color: var(--color-back);
  }
</style>
