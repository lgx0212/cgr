import {request} from "./request";

export function insertComment(mynewid,commentuserid,commentcontent,commentdate){
  return request({
    url:'/comment/insertcomment',
    params:{
      mynewid,
      commentuserid,
      commentcontent,
      commentdate
    }
  })
}
export function selectComment(mynewid){
  return request({
    url:'/comment/selectcomment',
    params:{
      mynewid
    }
  })
}
export function deleteComment(commentid){
  return request({
    url:'/comment/deletecomment',
    params:{
      commentid
    }
  })
}

export function insertReply(commentreplycommentid,commentreplysanduserid,commentreplyreceiveuserid,commentreplycontent,commentreplydate){
  return request({
    url:'/commentreply/insertreply',
    params:{
      commentreplycommentid,
      commentreplysanduserid,
      commentreplyreceiveuserid,
      commentreplycontent,
      commentreplydate
    }
  })
}

export function deleteReply(commentreplyid){
  return request({
    url:'/commentreply/delreply',
    params:{
      commentreplyid
    }
  })
}
