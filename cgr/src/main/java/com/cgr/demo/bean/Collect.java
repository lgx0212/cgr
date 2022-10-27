package com.cgr.demo.bean;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/24 0024 上午 10:57
 * description:
 */
public class Collect {
    private Integer userid;
    private Integer mynewid;
    private Integer collectionuserid;
    private Integer collectionid;
    private List<Mynew> mynews;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Mynew> getMynews() {
        return mynews;
    }

    public void setMynews(List<Mynew> mynews) {
        this.mynews = mynews;
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

    public Integer getCollectionuserid() {
        return collectionuserid;
    }

    public void setCollectionuserid(Integer collectionuserid) {
        this.collectionuserid = collectionuserid;
    }

    public Integer getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(Integer collectionid) {
        this.collectionid = collectionid;
    }
}
