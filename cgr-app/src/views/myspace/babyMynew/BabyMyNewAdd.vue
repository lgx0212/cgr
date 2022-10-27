<template>
<div id="babyMyNewAdd">
  <nav-bar class="home-nav">
    <template v-slot:left>
      <div class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
    </template>
    <template v-slot:center>
      <div>发布动态</div>
    </template>
    <template v-slot:right>
      <div @click="addBigNew">添加</div>
    </template>
  </nav-bar>
  <div class="name">
    <textarea v-model="mynewcontent" style="border:0;resize: none;font-size: 15px" placeholder="请输入内容"></textarea>
  </div>
  <div>
    <div style="display:flex;">
      <div class="omgui-radio">
        <input
          type="radio"
          :value="optionValue"
          @change="retainRecord"
          @click="controlSingel($event)"
          id="showon"
        />
        <label for="showon">是否公开</label>
      </div>
    </div>
  </div>
  <div id="vue-imgUpload">
    <div class="group-coms-pic"  style="display: inline-block;">
      <div class="item" v-if="list.length>0" v-for="(v,i) in list" :key="i" style="display: inline-block;">

              <img class="img" :src="v.src">

<!--        <span class="del" @click="delImg(i)">x</span>-->
      </div>
      <div class="upload-content" v-show="num<9" style="display: inline-block;">
        <ul class="img-list">
          <div class="uploadSec">
            <img src="~assets/img/common/addPhoto.svg" alt="" width="100" height="80" id="img">
            <input name="file" type="file" accept="image/*" multiple class="up-file" id="add-pic-btn" @change="addImg">

          </div>
        </ul>
      </div>
    </div>
  </div>
  <toast ref="toast"></toast>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar"
  import Toast from "@/components/common/toast/Toast"
  import {insertMyNewData,getMyNewData} from "@/network/myNew"
  import $ from "jquery"
  export default {
    name: "BabyMyNewAdd",
    components:{
      NavBar,
      Toast
    },
    data(){
      return{
        mynewcontent:'',
        defaultImgUrl: 'img/avatar.bd23b9b1.svg',
        list:[], //用于结构渲染
        allArr:[],  //存储每次上传的所有flie，
        limitNum:9, //限制数量
        num:0,
        imgdata:{},
        optionValue:'',
        changed:false
      }
    },
    created() {

    },
    methods:{
      text(){
        console.log($("#showon")[0].checked);
      },
      backClick(){
        this.$router.back()
      },
      controlSingel($event) {
        let _this = this;
        window.setTimeout(() => {
          if (!this.changed) {
            $event.target.checked = false
            // 可以写些单选框没有选中的代码处理
          }
          _this.changed = false;
        }, 0);
      },
      retainRecord(){
        // 可以写些单选框选中的代码处理
        this.changed = true;
      },
      addBigNew(){
        if(this.mynewcontent==''){
          console.log($("#showon")[0].checked);
          let checked = $("#showon")[0].checked?1:0
          if($("#showon")[0].checked){
            console.log('1');
          }else {
            console.log('0');
          }
          this.$toast({message:'内容为空！'})
          return
        }
        let checked = $("#showon")[0].checked?1:0
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
        insertMyNewData(localStorage.getItem('userid'),localStorage.getItem('babyid'),value,this.mynewcontent,checked).then(res=>{
          getMyNewData(localStorage.getItem('babyid')).then(res=>{
            if(this.imgdata[0]==undefined){
              let _this = this
              setTimeout(function (){
                _this.$toast({message: "添加成功！"})
                window.location.href=_this.$root.vuedefaulturl;
              },500)
              return
            }
            for(let i in this.imgdata){
              this.addbabyimg(res.data[0].mynewid)
              let _this = this
              setTimeout(function (){
                _this.$toast({message: "添加成功！"})
                window.location.href=_this.$root.vuedefaulturl;
              },500)
              return
            }
          })
        })
      },
      addbabyimg(mynewid){
        for(var i =0;i<this.num;i++){
          this.imgdata[i].append("mynewid", mynewid);
          $.ajax({
            url: this.$root.defaulturl+"/mynewp/insert",
            data: this.imgdata[i],
            type: "Post",
            dataType: "json",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (result) {
            },
          })
        }

      },
      addImg(){
        var fileObj = document.getElementById("add-pic-btn").files[0]; // js 获取文件对象
        // if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
        //   alert("请选择图片");
        //   return;
        // }
        var formFile = new FormData();
        formFile.append("action", "UploadVMKImagePath");
        formFile.append("file", fileObj);
        formFile.append("userid", localStorage.getItem('userid'));
        formFile.append("babyid", localStorage.getItem('babyid'));
        console.log(formFile);
        this.imgdata[this.num] = formFile;
        this.num++


        let that = this;
        var obj = that.getId('add-pic-btn'),
          obArr =  obj.files,
          length = obArr.length,
          arr = [],
          limitNum = that.limitNum;
        for(let x of obArr){
          var params = {name: x.name, src:''};
          arr.push(params);
        }
        that.allArr = [...that.allArr,...arr];
        // 定义一个函数作回调
        const Pro = function () {
          return new Promise(function (resolve, reject) {
            arr.forEach((v,i,array)=>{
              resolve(array)
            });
          })
        };
        Pro().then((newArr)=>{
          // console.log(newArr);
          for(let i=0; i<newArr.length; i++) {
            var reader = new FileReader();
            if (!reader) {
              return
            }
            //读取成功
            reader.onload = function(e) {
              // console.log(e)
              var _src = e.target.result;
              newArr[i].src = _src;
              that.clearVal();
            };
            // reader.onloadstart=function(){
            //   console.log('开始')
            // };
            // reader.onprogress=function(e){
            //   if(e.lengthComputable){
            //     console.log("正在读取文件")
            //   }
            // };
            // reader.error = function(){
            //   console.log("读取异常")
            // };
            reader.readAsDataURL(obj.files[i]);
          }
          //合并数组,先合并在删除多余；
          var len1 = that.list.length,
            len2 = newArr.length;
          var d = [...that.list,...newArr];
          that.list = d;
          // console.log(len1,len2,d)
          if(d.length > limitNum){
            alert(`最多只能上传${limitNum}张图片`);
            that.list.splice(limitNum,d.length-limitNum);
            // console.log(that.list)
          }
        });
      },
      delImg(i){
        var flag = confirm(`确认要删除名为：${this.list[i].name}的图片？`);
        if(flag) {
          this.list.splice(i,1);
          this.allArr.splice(i,1);
        }
        //这个得清空，不然全部被删除后，无法再次上传同一图片
        if(this.list.length<=0){
          this.clearVal();
        }
      },
      //每次上传完清除一下value
      clearVal(){
        this.getId('add-pic-btn').value = null;
      },
      //dom
      getId(id){
        return document.getElementById(id);
      }
    }
  }
</script>

<style scoped>
  #babyMyNewAdd {
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
  .name textarea
  {
    margin-top: 20px;
    margin-left: 10px;
    width: 90%;
    height: 103px;
    line-height: 16px;
    outline: none;
    font-size: 14px;
    color: #999;
    box-sizing: border-box;
    padding-left: 10px;
    border-width:0;
    /*border-bottom: solid 1px var(--color-tint);*/
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
    width: 100px;
    height: 100px;
    overflow: hidden;
    text-align: center;
    background-color: #f5f5f5;
    border-radius: 3%;
  }

  .uploadSec img {
    text-align: center;
    width: 50%;
    height: 50%;
    margin: auto;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
  }

  .upload-content {
    width: 30%;
    text-align: center;

  }

  #add-pic-btn {
    position: absolute;
    height: 100%;
    left: 0;
    top: 0;
    opacity: 0;
  }
  .img{
    width: 100px;
    height: 100px;
  }
  #vue-imgUpload{
    margin: 10px;
  }
  .omgui-radio {
    margin-left:20px;
    /*margin-right:2rem;*/
  }

  .omgui-radio input[type="radio"] {
    opacity: 0;
  }

  .omgui-radio label {
    position: relative;
    cursor: pointer;
  }

  .omgui-radio label::before {
    content: '';
    position: absolute;
    left: -24px;
    border-radius: 50%;
    width: 20px;
    height: 20px;
    border: 1px solid #999;
  }

  .omgui-radio label::after {
    content: '';
    position: absolute;
    left: -20px;
    top: 4px;
    border-radius: 50%;
    width: 12px;
    height: 12px;
    transform: scale(0);
  }
  /* + 是兄弟选择器,获取选中后的label元素*/
  .omgui-radio input+label::before {
    border-color: #ccc;
  }

  .omgui-radio input+label::after {
    background-color: #ccc;
    transform: scale(1);
    /*transition: all .3s;*/
  }
  .omgui-radio input:checked+label::before {
    border-color: var(--color-tint);
  }

  .omgui-radio input:checked+label::after {
    background-color: var(--color-tint);
    transform: scale(1);
    /*transition: all .3s;*/
  }
</style>
