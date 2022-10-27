package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/16 0016 下午 8:39
 * description:
 */
public class Message {
    private Integer messagesanduserid;
    private String messageid;
    private Integer messagereceiveuserid;
    private Integer messagenum;
    private List<User> users;
    private List<Message_c> message_cs;

    public Integer getMessagenum() {
        return messagenum;
    }

    public void setMessagenum(Integer messagenum) {
        this.messagenum = messagenum;
    }

    public Integer getMessagesanduserid() {
        return messagesanduserid;
    }

    public void setMessagesanduserid(Integer messagesanduserid) {
        this.messagesanduserid = messagesanduserid;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }



    public Integer getMessagereceiveuserid() {
        return messagereceiveuserid;
    }

    public void setMessagereceiveuserid(Integer messagereceiveuserid) {
        this.messagereceiveuserid = messagereceiveuserid;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message_c> getMessage_cs() {
        return message_cs;
    }

    public void setMessage_cs(List<Message_c> message_cs) {
        this.message_cs = message_cs;
    }
}
