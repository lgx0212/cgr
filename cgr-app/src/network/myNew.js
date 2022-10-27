import {request} from "./request";

export function getMyNewData(babyid){
  return request({
    url:'/mynew/selectmynew',
    params:{
      babyid
    }
  })
}
export function getMyNewDataItem(mynewid){
  return request({
    url:'/mynew/selectmynewbyid',
    params:{
      mynewid
    }
  })
}

export function getNewData(){
  return request({
    url:'/mynew/mynewmynew'
  })
}
export function selectUserInformationData(userid){
  return request({
    url:'/mynew/selectuserinformationdata',
    params:{
      userid
    }
  })
}
export function insertMyNewData(userid,babyid,mynewdate,mynewcontent,mynewopen){
  return request({
    url:'/mynew/insert',
    params:{
      userid,
      babyid,
      mynewdate,
      mynewcontent,
      mynewopen
    }
  })
}
export function updateIfOpen(mynewopen,mynewid){
  return request({
    url:'/mynew/updateifopen',
    params:{
      mynewopen,
      mynewid
    }
  })
}
export function deleteMyNewData(mynewid){
  return request({
    url:'/mynew/delete',
    params:{
      mynewid
    }
  })
}
