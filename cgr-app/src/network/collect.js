import {request} from "./request"

export function MyCollect(userid){
  return request({
    url:'/collect/mycollect',
    params:{
      userid
    }
  })
}
export function selectIfCollect(userid,mynewid){
  return request({
    url:'/collect/selectifcollect',
    params:{
      userid,
      mynewid
    }
  })
}export function selectCollectNum(mynewid){
  return request({
    url:'/collect/selectcollectnum',
    params:{
      mynewid
    }
  })
}

export function insertCollect(userid,mynewid,collectionuserid){
  return request({
    url:'/collect/insertcollect',
    params:{
      userid,
      mynewid,
      collectionuserid
    }
  })
}
export function deleteCollect(userid,mynewid){
  return request({
    url:'/collect/deletecollect',
    params:{
      userid,
      mynewid
    }
  })
}
