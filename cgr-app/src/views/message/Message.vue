<template>
  <div id="message">
    <nav-bar class="home-nav">

      <template v-slot:center>
        <div>消息</div>
      </template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            :pull-up-load="true">
    <message-list-item :baby-data="messageData" @editMessage="editMessage"></message-list-item>
    </scroll>
    <edit-confirm ref="myEditConfirm"
                  :edit="false"
                  @deleteCancel="deleteCancel"
                  :attention="false">
    </edit-confirm>
    <confirm ref="deleteMessage" @userBehavior="BehaviorDelete"></confirm>
  </div>
</template>

<script>
  import {getMessageData,deleteMessageCbynum} from "@/network/message"
  import NavBar from "@/components/common/navbar/NavBar";
  import MessageListItem from "@/views/message/childComps/MessageListItem";
  import Scroll from "@/components/common/scroll/Scroll";
  import EditConfirm from "@/components/common/confirm/EditConfirm";
  import Confirm from "@/components/common/confirm/Confirm";

  export default {
    name: "Message",
    inject:["reload"],
    components: {
      NavBar,
      MessageListItem,
      Scroll,
      EditConfirm,
      Confirm
    },
    data(){
      return{
        messageData:[],
        messagenum:'',
        timer: null
      }
    },
    created() {
      let _this = this
      this.timer = setInterval(() => {
        setTimeout(() => {

          _this.getmessageinfo()


        }, 0)
      }, 5000)
      this.getmessageinfo()
    },
    beforeDestroy() {
      clearInterval(this.timer);
      this.timer = null;
    },
    methods:{
      getmessageinfo(){
        getMessageData(localStorage.getItem('userid')).then(res => {
          if(res.ret == 0){
            return
          }else {
            this.messageData=res.data
          }

        })
      },
      editMessage(id){
        this.messagenum = id
        this.$refs.myEditConfirm.show()
      },
      deleteCancel(){
        console.log(this.messagenum);
        this.$refs.deleteMessage.show('删除后消息记录都会删除哦，你确定要删除吗？')
      },
      BehaviorDelete(){
        if (this.$refs.deleteMessage.chose == 1) {
          deleteMessageCbynum(this.messagenum).then(()=>{
            this.getmessageinfo()
          })
        }
      }
    }
  }
</script>

<style scoped>
  .home-nav {
    background-color: var(--color-tint);
    width: 100%;
    color: #ffffff;
    position: fixed;
  }
  .content {
    overflow: hidden;
    position: absolute;
    top: 44px;
    bottom: 49px;
    left: 0;
    right: 0;
  }
</style>
