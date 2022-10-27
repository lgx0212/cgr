import {request} from "./request";

export function getMessageData(messagesanduserid){
  return request({
    url:'/message/selectbyuserid',
    params:{
      messagesanduserid
    }
  })
}
export function getMessageItem(messageid,messagesanduserid){
  return request({
    url:'/message/selectbymessageid',
    params:{
      messageid,
      messagesanduserid
    }
  })
}
export function selectMessageNum(messageid){
  return request({
    url:'/message/selectmessagenum',
    params:{
      messageid
    }
  })
}
export function insertMessageContent(messagecsanduserid,messagecreceiveuserid,messageid,messagecontent,messagecdate,messagecnum,messagecstate){
  return request({
    url:'/messagec/insertmessagecontent',
    params:{
      messagecsanduserid,
      messagecreceiveuserid,
      messageid,
      messagecontent,
      messagecdate,
      messagecnum,
      messagecstate
    }
  })
}
export function selectIfMessage(messageid){
  return request({
    url:'/message/selectifmessage',
    params:{
      messageid
    }
  })
}
export function insertMessage(messagesanduserid,messageid,messagereceiveuserid){
  return request({
    url:'/message/insertmessage',
    params:{
      messagesanduserid,
      messageid,
      messagereceiveuserid
    }
  })
}
export function deleteMessageCbynum(messagecnum){
  return request({
    url:'/messagec/deletemessagecbynum',
    params:{
      messagecnum
    }
  })
}
export function deleteMessageCbyContentid(messagecid){
  return request({
    url:'/messagec/deletemessagecbycontentid',
    params:{
      messagecid
    }
  })
}
export function updateState(messagecnum){
  return request({
    url:'/messagec/updatestate',
    params:{
      messagecnum
    }
  })
}
