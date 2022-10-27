import {request} from "./request";

export function getMyNewPData(mynewid){
  return request({
    url:'/mynewp/selectbabymynewp',
    params:{
      mynewid
    }
  })
}
export function getMyNewPByBabyId(babyid){
  return request({
    url:'/mynewp/selectmynewpbyid',
    params:{
      babyid
    }
  })
}
export function deleteMyNewPData(mynewid){
  return request({
    url:'/mynewp/deletebabymynewp',
    params:{
      mynewid
    }
  })
}
