<template>
<div id="profile">
  <nav-bar class="home-nav">
    <template v-slot:center>
      <div>我的</div>
    </template>
  </nav-bar>
  <user-info/>
  <account-info/>
  <list-view/>
</div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import AccountInfo from "@/views/profile/childComps/AccountInfo";
  import UserInfo from "@/views/profile/childComps/UserInfo";
  import ListView from "@/views/profile/childComps/ListView";
  import {selectUserData} from "@/network/profile";

  export default {
        name: "Profile",
      components:{
          NavBar,
        AccountInfo,
        ListView,
        UserInfo
      }
  }
</script>

<style scoped>
  .home-nav {
    background-color: var(--color-tint);
    color: #ffffff;
  }
</style>
