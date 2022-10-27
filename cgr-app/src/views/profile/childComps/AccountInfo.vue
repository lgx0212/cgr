<template>
  <div class="account">
    <div class="account-item" @click="attention">
      <div class="number">
        <span class="balance">{{attentionmy}}</span>
      </div>
      <div class="account-info">我的粉丝</div>
    </div>
    <div class="account-item" @click="support">
      <div class="number">
        <span class="balance">{{ supportmy }}</span>
      </div>
      <div class="account-info">我收到的赞</div>
    </div>
  </div>
</template>

<script>
  import {AttentionMy} from "@/network/attention"
  import {countSupport} from "@/network/support"
	export default {
		name: "AccountInfo",
    data(){
		  return{
		    attentionmy:'',
        supportmy:''
      }
    },
    created() {
		  AttentionMy(localStorage.getItem('userid')).then(res=>{
		    if(res.ret==1){
          this.attentionmy = res.data.length
        }else {
		      this.attentionmy = 0
        }
      })
      countSupport(localStorage.getItem('userid')).then(res=>{
        if(res.ret==1){
          this.supportmy = res.data.length
        }else {
          this.supportmy = 0
        }
      })
    },
    methods:{
      attention(){
        this.$router.push('/myfans')
      },
      support(){
        this.$router.push('/mysupport')
      }
    }
  }
</script>

<style scoped>
  .account {
    display: flex;
  }

  .account-item {
    width: 100%;
    background-color: #fff;
    margin-right: 1px;
    text-align: center;
  }

  .account-item:last-of-type {
    margin-right: 0;
  }

  .account-item {
    color: #666;
    font-size: 13px;
    padding: 18px;
  }

  .account-item .balance {
    font-size: 24px;
    font-weight: 700;
    color: #ff5f3e;
  }

  .account-info {
    margin-top: 6px;
  }
</style>
