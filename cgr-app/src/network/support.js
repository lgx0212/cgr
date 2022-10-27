import {request} from "./request";


export function supportmy(supportuserid){
  return request({
    url:'/support/supportmy',
    params:{
      supportuserid
    }
  })
}

export function selectIfSupport(userid,mynewid){
  return request({
    url:'/support/selectifsupport',
    params:{
      userid,
      mynewid
    }
  })
}
export function selectSupportNum(mynewid){
  return request({
    url:'/support/selectsupportnum',
    params:{
      mynewid
    }
  })
}
export function countSupport(supportuserid){
  return request({
    url:'/support/countsupport',
    params:{
      supportuserid
    }
  })
}
export function insertSupport(userid,mynewid,supportuserid){
  return request({
    url:'/support/insertsupport',
    params:{
      userid,
      mynewid,
      supportuserid
    }
  })
}
export function deleteSupport(userid,mynewid,supportuserid){
  return request({
    url:'/support/deletesupport',
    params:{
      userid,
      mynewid,
      supportuserid
    }
  })
}
