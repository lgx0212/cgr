import {request} from "./request";

export function getGrowthData(babyid){
  return request({
    url:'/growth/growth',
    params:{
      babyid
    }
  })
}export function selectGrowthEchart(babyid){
  return request({
    url:'/growth/selectgrowthechart',
    params:{
      babyid
    }
  })
}
export function selectGrowthData(growthid){
  return request({
    url:'/growth/selectgrowth',
    params:{
      growthid
    }
  })
}
export function upGrowthData(userid,babyid,growthheight,growthweight,growthdate){
  return request({
    url:'/growth/insert',
    params:{
      userid,
      babyid,
      growthheight,
      growthweight,
      growthdate
    }
  })
}
export function updateGrowthData(growthheight,growthweight,growthid,growthdate){
  return request({
    url:'/growth/update',
    params:{
      growthheight,
      growthweight,
      growthid,
      growthdate
    }
  })
}
export function deleteGrowthData(growthid){
  return request({
    url:'/growth/delete',
    params:{
      growthid
    }
  })
}
