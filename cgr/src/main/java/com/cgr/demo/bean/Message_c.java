package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/17 0017 下午 12:32
 * description:
 */
public class Message_c {
    private Integer messagecsanduserid;
    private Integer messagecreceiveuserid;
    private String messageid;
    private Integer messagecnum;
    private String messagecontent;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date messagecdate;
    private Integer messagecid;
    private Integer messagecstate;
    private List<User> users;

    public Integer getMessagecstate() {
        return messagecstate;
    }

    public void setMessagecstate(Integer messagecstate) {
        this.messagecstate = messagecstate;
    }

    public Integer getMessagecnum() {
        return messagecnum;
    }

    public void setMessagecnum(Integer messagecnum) {
        this.messagecnum = messagecnum;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getMessagecsanduserid() {
        return messagecsanduserid;
    }

    public void setMessagecsanduserid(Integer messagecsanduserid) {
        this.messagecsanduserid = messagecsanduserid;
    }

    public Integer getMessagecreceiveuserid() {
        return messagecreceiveuserid;
    }

    public void setMessagecreceiveuserid(Integer messagecreceiveuserid) {
        this.messagecreceiveuserid = messagecreceiveuserid;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public Date getMessagecdate() {
        return messagecdate;
    }

    public void setMessagecdate(Date messagecdate) {
        this.messagecdate = messagecdate;
    }

    public Integer getMessagecid() {
        return messagecid;
    }

    public void setMessagecid(Integer messagecid) {
        this.messagecid = messagecid;
    }
}
