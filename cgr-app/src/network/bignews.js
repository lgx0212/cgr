import {request} from "./request";

export function selectBigNewsData(bignewid){
  return request({
    url:'/bignew/selectbignew',
    params:{
      bignewid
    }
  })
}
export function selectAllBigNewsData(babyid){
  return request({
    url:'/bignew/bignew',
    params:{
      babyid
    }
  })
}
export function updateBigNewsData(bignewcontent,bignewdate,bignewid){
  return request({
    url:'/bignew/updatebignew',
    params:{
      bignewcontent,
      bignewdate,
      bignewid
    }
  })
}
export function insertBigNewsData(userid,babyid,bignewcontent,bignewdate){
  return request({
    url:'/bignew/insertbignew',
    params:{
      userid,
      babyid,
      bignewcontent,
      bignewdate
    }
  })
}

export function deleteBigNewsData(bignewid){
  return request({
    url:'/bignew/deletebignew',
    params:{
      bignewid
    }
  })
}
