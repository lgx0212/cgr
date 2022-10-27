package com.cgr.demo.bean;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/23 0023 下午 3:10
 * description:
 */
public class Support {
    private Integer userid;
    private Integer mynewid;
    private Integer supportuserid;
    private Integer supportid;
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

    public Integer getMynewid() {
        return mynewid;
    }

    public void setMynewid(Integer mynewid) {
        this.mynewid = mynewid;
    }

    public Integer getSupportuserid() {
        return supportuserid;
    }

    public void setSupportuserid(Integer supportuserid) {
        this.supportuserid = supportuserid;
    }

    public Integer getSupportid() {
        return supportid;
    }

    public void setSupportid(Integer supportid) {
        this.supportid = supportid;
    }
}
