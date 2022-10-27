package com.cgr.demo.bean;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/22 0022 下午 5:08
 * description:
 */
public class Attention {
    private Integer userid;
    private Integer attentionuserid;
    private Integer attentionid;
    private List<User> users;
    private List<Mynew> mynews;

    public List<Mynew> getMynews() {
        return mynews;
    }

    public void setMynews(List<Mynew> mynews) {
        this.mynews = mynews;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAttentionuserid() {
        return attentionuserid;
    }

    public void setAttentionuserid(Integer attentionuserid) {
        this.attentionuserid = attentionuserid;
    }

    public Integer getAttentionid() {
        return attentionid;
    }

    public void setAttentionid(Integer attentionid) {
        this.attentionid = attentionid;
    }
}
