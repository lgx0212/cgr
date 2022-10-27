import {request} from "./request";

export function getUserData(userusername,userpassword){
  return request({
    url:'/users/users',
    params:{
      userusername,
      userpassword
    }
  })
}
export function selectUserData(userid){
  return request({
    url:'/users/selectusers',
    params:{
      userid
    }
  })
}
export function selectUserByName(username){
  return request({
    url:'/users/selectusersbyname',
    params:{
      username
    }
  })
}
export function ifUser(userusername){
  return request({
    url:'/users/ifusers',
    params:{
      userusername
    }
  })
}
export function insertUser(username,usersex,userusername,userpassword,userbrith){
  return request({
    url:'/users/insert',
    params:{
      username,
      usersex,
      userusername,
      userpassword,
      userbrith
    }
  })
}
export function updateUser(username,usersex,userbrith,userid){
  return request({
    url:'/users/update',
    params:{
      username,
      usersex,
      userbrith,
      userid
    }
  })
}
export function insertPhotoData(img){
  return request({
    url:'/users/updateimg',
    params:{
      img
    }
  })
}
