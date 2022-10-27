import {request} from "./request";

export function getBabyData(userid){
  return request({
    url:'/baby/selectbaby',
    params:{
      userid
    }
  })
}
export function defaultBabyChecked(userid){
  return request({
    url:'/baby/defaultbabychecked',
    params:{
      userid
    }
  })
}
export function checkedBabyData(userid){
  return request({
    url:'/baby/checkedbaby',
    params:{
      userid
    }
  })
}
export function selectBabyItem(babyid){
  return request({
    url:'/baby/selectbabyitem',
    params:{
      babyid
    }
  })
}
export function insertBaby(userid,babyname,babysex,babybrith,babychecked){
  return request({
    url:'/baby/insert',
    params:{
      userid,
      babyname,
      babysex,
      babybrith,
      babychecked
    }
  })
}
export function deleteBaby(babyid){
  return request({
    url:'/baby/delete',
    params:{
      babyid
    }
  })
}
export function updateBabyItem(babyname,babysex,babybrith,babyid){
  return request({
    url:'/baby/update',
    params:{
      babyname,
      babysex,
      babybrith,
      babyid
    }
  })
}
export function updateBabyName(babyid,babyname){
  return request({
    url:'/baby/updatename',
    params:{
      babyid,
      babyname
    }
  })
}
export function updateBabyChecked(userid,babyid){
  return request({
    url:'/baby/updatechecked',
    params:{
      userid,
      babyid
    }
  })
}
