import {request} from "./request";

export function insertAttention(userid,attentionuserid){
  return request({
    url:'/attention/insertattention',
    params:{
      userid,
      attentionuserid
    }
  })
}
export function checkedAttention(userid,attentionuserid){
  return request({
    url:'/attention/selectifattention',
    params:{
      userid,
      attentionuserid
    }
  })
}
export function AttentionMy(attentionuserid){
  return request({
    url:'/attention/attentionmy',
    params:{
      attentionuserid
    }
  })
}
export function MyAttention(userid){
  return request({
    url:'/attention/myattention',
    params:{
      userid
    }
  })
}
export function MyAttentionNews(userid){
  return request({
    url:'/attention/myattentionnews',
    params:{
      userid
    }
  })
}
export function deleteAttentionMy(userid,attentionuserid){
  return request({
    url:'/attention/deleteattentionmy',
    params:{
      userid,
      attentionuserid
    }
  })
}
