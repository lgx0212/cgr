<template>
  <div id="messageInfo">
    <nav-bar class="home-nav">
      <template v-slot:left>
        <div class="back" @click="backClick">
          <img src="~assets/img/common/back.svg" alt="">
        </div>
      </template>
      <template v-slot:center>
        <div>消息</div>
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true"
    >
      <div class="empty" v-show="ifshow">

      </div>
      <div class="goods-list" ref="goodlist" v-for="i in message" >
        <div class="goods-item item" v-for="item in i.message_cs" v-if="messageshow">
          <div class="babyitem" v-if="item.messagecreceiveuserid==userid"
               @touchstart="gtouchstart(item.messagecid)"
               @touchmove="gtouchmove()"
               @touchend="gtouchend(item.messagecid)">
            <div class="baby-info">
              <img class="avatar" :src="item.users[0].userimg?url+item.users[0].userimg:defaultImgUrl" alt="">
              <div class="info">
                <div class="mynewcontent">{{ item.messagecontent }}</div>
              </div>
            </div>
          </div>
          <div class="babyitem" v-if="item.messagecreceiveuserid!=userid"
               @touchstart="gtouchstart(item.messagecid)"
               @touchmove="gtouchmove()"
               @touchend="gtouchend(item.messagecid)">
            <div class="baby-info-r">
              <div class="info-r">
                <div class="mynewcontent">
                  {{ item.messagecontent }}
                </div>
              </div>
              <img class="avatar" :src="item.users[0].userimg?url+item.users[0].userimg:defaultImgUrl" alt="">

            </div>
          </div>
        </div>
      </div>
    </scroll>
    <div class="tab-bar">
      <div class="tab-bar-item">
        <div class="messageContent">
          <input type="text" v-model="content">
        </div>
        <div class="sand" @click="sand">发送</div>
      </div>
    </div>
    <edit-confirm ref="myEditConfirm"
                  :edit="false"
                  @deleteCancel="deleteCancel"
                  :attention="false">
    </edit-confirm>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import Scroll from "@/components/common/scroll/Scroll";
  import EditConfirm from "@/components/common/confirm/EditConfirm";
  import {getMessageItem, insertMessageContent,selectMessageNum,deleteMessageCbyContentid,updateState} from "@/network/message";

  export default {
    name: "MessageInfo",
    inject: ["reload"],
    data() {
      return {
        content: '',
        messagereceiveuserid: '',
        userid: localStorage.getItem('userid'),
        messageid: this.$route.params.messageid,
        message: [],
        messagelength: '',
        selectlength: '',
        url: this.$root.defaulturl,
        ifImg: false,
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        ifshow: true,
        messageshow:false,
        messageCId:'',
        timer: null,
        messagenum:''
      }
    },
    components: {
      NavBar,
      Scroll,
      EditConfirm
    },
    created() {
      this.getmessageinfo()


      let _this = this
      this.timer = setInterval(() => {
        setTimeout(() => {
          let y = _this.$refs.goodlist[0].offsetHeight - _this.$refs.scroll.$el.offsetHeight
          console.log(y,_this.$refs.scroll.getScrollY());
          if(y <= -_this.$refs.scroll.getScrollY()){
            _this.getmessageinfo()
            setTimeout(function () {
              let yy = _this.$refs.goodlist[0].offsetHeight - _this.$refs.scroll.$el.offsetHeight
              if (yy > 0) {
                _this.$refs.scroll.scrollTo(0, -yy, 500)
              }
            }, 100)
          }else {
            _this.getmessageinfo()
          }

        }, 0)
      }, 5000)

    },
    beforeDestroy() {
      clearInterval(this.timer);
      this.timer = null;
    },
    methods: {
      getmessageinfo(){
        getMessageItem(this.messageid, localStorage.getItem('userid')).then(res => {
          console.log(res);
          this.messagenum = res.data[0].messagenum
          console.log(this.messagenum);
          updateState(this.messagenum)
          this.messagereceiveuserid = res.data[0].messagereceiveuserid
          if(res.data[0].message_cs[0].users.length=='0'){
            this.messageshow=false
            return
          }else {
            this.message = res.data
            if(res.data[0].message_cs[0].users.length>0){
              this.messageshow=true
            }
          }
        })
      },
      backClick() {
        this.$router.back()
      },
      sand() {
        selectMessageNum(this.messageid).then(res => {
          let a = this.messagenum
          let b
          for(let j = 0 ; j<res.data.length;j++){
            console.log(res.data[j].messagenum);
            if(a!=res.data[j].messagenum){
              b = res.data[j].messagenum
            }
          }

          console.log(a,b)
          var padaDate = function(value) {
            return value < 10 ? "0" + value : value;
          };
          //创建一个时间日期对象
          var date = new Date();
          var year = date.getFullYear(); //存储年
          var month = padaDate(date.getMonth() + 1); //存储月份
          var day = padaDate(date.getDate()); //存储日期
          var hours = padaDate(date.getHours()); //存储时
          var minutes = padaDate(date.getMinutes()); //存储分
          var seconds = padaDate(date.getSeconds()); //存储秒
          //返回格式化后的日期
          var value =
            year +
            "-" +
            month +
            "-" +
            day +
            " " +
            hours +
            ":" +
            minutes +
            ":" +
            seconds

          if (this.content == '') {
            return
          } else {
            insertMessageContent(localStorage.getItem('userid'), this.messagereceiveuserid, this.messageid, this.content, value,a,1).then(res => {
              insertMessageContent(localStorage.getItem('userid'), this.messagereceiveuserid, this.messageid, this.content, value,b,0).then(res => {
                this.content = ''
                this.getmessageinfo()
                let _this = this
                setTimeout(function () {
                  let y = _this.$refs.goodlist[0].offsetHeight - _this.$refs.scroll.$el.offsetHeight

                  if (y > 0) {
                    _this.$refs.scroll.scrollTo(0, -y, 500)
                  }
                }, 100)
              })
            })

          }
        })
      },
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
        this.messageCId = id
        this.$refs.myEditConfirm.show()
      },
      goChat(id){


      },
      deleteCancel(){
        deleteMessageCbyContentid(this.messageCId).then(()=>{
          this.getmessageinfo()
        })
      }
    },
    mounted() {
      let _this = this
      setTimeout(function () {
        let y = _this.$refs.goodlist[0].offsetHeight - _this.$refs.scroll.$el.offsetHeight

        if (y > 0) {
          _this.$refs.scroll.scrollTo(0, -y, 0)
        }
      }, 100)
      setTimeout(function () {
        _this.ifshow = false
      }, 200)

    }
  }
</script>

<style scoped>
  #messageInfo {
    position: relative;
    z-index: 9;
    background-color: #ffffff;
    height: 100vh;
  }

  .home-nav {
    background-color: var(--color-tint);
    width: 100%;
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
.empty{
  width: 100%;
  height: 100vh;
  bottom: 0px;
  z-index: 9999;
  position: fixed;
  background-color: white;
}
  .goods-list {
    display: flex;
    flex-wrap: wrap;
    padding: 5px;
    justify-content: space-around;
  }

  .goods-list .item {
    width: 100%;
    margin-bottom: 5px;
  }

  .goods-item {
    position: relative;
  }


  .babyitem {
    background-color: #ffffff;
  }


  .babyimg img {
    width: 100px;
    height: 100px;
    padding: 3px;
  }

  .baby-info {
    display: flex;
  }

  .baby-info-r {
    display: flex;
    float: right;
  }

  .baby-info .avatar {
    width: 45px;
    height: 45px;
    border-radius: 50%;
    margin-left: 10px;
  }

  .baby-info-r .avatar {
    width: 45px;
    height: 45px;
    border-radius: 50%;
    margin-left: 10px;
  }

  .info {
    display: flex;
    padding-left: 15px;
    flex: 1;
  }

  .info-r {
    display: flex;
    padding-left: 15px;
    text-align: left;
    flex: 1;
  }


  .mynewcontent {
    /*width: 100%;*/
    margin: auto 0;
    font-size: 14px;
    color: #6d6d6d;
    padding: 5px;
    background-color: #ededed;
    border-radius: 10%;
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
