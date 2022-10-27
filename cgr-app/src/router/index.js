import Vue from 'vue'
import Router from 'vue-router'
const Myspace = ()=>import('../views/myspace/Myspace')
const Community = ()=>import('../views/community/Community')
const Message = ()=>import('../views/message/Message')
const Profile = ()=>import('../views/profile/Profile')
const Login = ()=>import('../views/profile/childComps/Login')
const Register = ()=>import('../views/profile/childComps/Register')
const MyFans = ()=>import('../views/profile/childComps/MyFans')
const MySupport = ()=>import('../views/profile/childComps/MySupport')
const MyAttention = ()=>import('../views/profile/childComps/MyAttention')
const MyCollect = ()=>import('../views/profile/childComps/MyCollect')
const Setup = ()=>import('../views/profile/childComps/SetUp')
const BabyList = ()=>import('../views/myspace/childComps/BabyList')
const BabyAdd = ()=>import('../views/myspace/childComps/BabyAdd')
const MyInformation = ()=>import('../views/profile/childComps/MyInformation')
const ChangeName =()=>import('../views/profile/childComps/ChangeName')
const BabyInfo =()=>import('../views/myspace/childComps/BabyInfo')
const ChangeBabyName =()=>import('../views/myspace/childComps/ChangeBabyName')
const Growth =()=>import('../views/myspace/growRecord/Growth')
const GrowthAdd=()=>import('../views/myspace/growRecord/GrowthAdd')
const GrowthEdit=()=>import('../views/myspace/growRecord/GrowthEdit')
const BigNews=()=>import('../views/myspace/bigNews/BigNews')
const BigNewsEdit=()=>import('../views/myspace/bigNews/BigNewsEdit')
const BigNewsAdd=()=>import('../views/myspace/bigNews/BigNewsAdd')
const BabyMyNewInfo=()=>import('../views/myspace/babyMynew/BabyMyNewItemInfo')
const BabyMyNewAdd=()=>import('../views/myspace/babyMynew/BabyMyNewAdd')
const BabyMyNewSCList=()=>import('../views/myspace/babyMynew/BabyMyNewSCList')
const Album=()=>import('../views/myspace/album/Album')
const CommonNewInfo=()=>import('../views/community/childComps/CommonNewInfo')
const SelectUser=()=>import('../views/community/childComps/SelectUser')
const MessageInfo=()=>import('../views/message/childComps/MessageInfo')
const UserSpace=()=>import('../views/userspace/UserSpace')
const UserInformation=()=>import('../views/userspace/childComps/UserInformation')

// 解决ElementUI导航栏中的vue-router在3.0版本以上重复点菜单报错问题
const originalReplace = Router.prototype.replace;
Router.prototype.replace = function replace(location) {
  return originalReplace.call(this, location).catch(err => err);
};

Vue.use(Router)

export default new Router({
  routes: [{
    path: '',
    redirect: '/login'
  },
    {
      path:'/myspace',
      component:Myspace
    },
    {
      path:'/babyList',
      component:BabyList
    },
    {
      path:'/babyadd',
      component:BabyAdd
    },
    {
      path:'/community',
      component:Community
    },
    {
      path:'/profile',
      component:Profile
    },
    {
      path:'/myinformation',
      component:MyInformation
    },
    {
      path:'/changeName',
      component:ChangeName
    },
    {
      path:'/login',
      component:Login
    },
    {
      path:'/register',
      component:Register
    },
    {
      path:'/myfans',
      component:MyFans
    },
    {
      path:'/myattention',
      component:MyAttention
    },
    {
      path:'/mysupport',
      component:MySupport
    },
    {
      path:'/mycollect',
      component:MyCollect
    },
    {
      path: '/setup',
      component:Setup
    },
    {
      path:'/message',
      component:Message
    },
    {
      path:'/babyinfo/:babyid',
      component:BabyInfo
    },
    {
      path:'/changebabyname/:babyid/:babyname',
      component:ChangeBabyName
    },
    {
      path:'/bignews',
      component:BigNews
    },
    {
      path:'/bignewsadd',
      component:BigNewsAdd
    },
    {
      path:'/bignewsedit/:bigNewsid',
      component:BigNewsEdit
    },
    {
      path:'/growth',
      component:Growth
    },
    {
      path:'/growthadd',
      component:GrowthAdd
    },
    {
      path:'/growthedit/:growthid',
      component:GrowthEdit
    },
    {
      path:'/babymynewinfo/:mynewid',
      component:BabyMyNewInfo
    },
    {
      path:'/babymynewadd',
      component:BabyMyNewAdd
    },{
      path:'/babymynewsclist/:type/:mynewid',
      component:BabyMyNewSCList
    },
    {
      path:'/album',
      component:Album
    },
    {
      path:'/commonnewinfo/:mynewid',
      component:CommonNewInfo
    },
    {
      path:'/selectuser',
      component:SelectUser
    },
    {
      path:'/messageinfo/:messageid',
      component:MessageInfo
    },
    {
      path:'/userspace/:userid',
      component:UserSpace
    },
    {
      path:'/userinformation/:userid',
      component:UserInformation
    }
  ],
  mode:'hash'
})




