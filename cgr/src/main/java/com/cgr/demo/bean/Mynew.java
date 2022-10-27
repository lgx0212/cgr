package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/26 0026 下午 4:00
 * description:
 */
public class Mynew {
    private Integer userid;
    private Integer babyid;
    private Integer mynewid;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date mynewdate;
    private String mynewcontent;
    private Integer mynewsupport;
    private Integer mynewcollect;
    private Integer mynewopen;
    private List<Mynew_p> mynewp;
    private List<User> users;
    private Attention attention;

    public Attention getAttention() {
        return attention;
    }

    public void setAttention(Attention attention) {
        this.attention = attention;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getMynewopen() {
        return mynewopen;
    }

    public void setMynewopen(Integer mynewopen) {
        this.mynewopen = mynewopen;
    }

    public List<Mynew_p> getMynewp() {
        return mynewp;
    }

    public void setMynewp(List<Mynew_p> mynewp) {
        this.mynewp = mynewp;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBabyid() {
        return babyid;
    }

    public void setBabyid(Integer babyid) {
        this.babyid = babyid;
    }

    public Integer getMynewid() {
        return mynewid;
    }

    public void setMynewid(Integer mynewid) {
        this.mynewid = mynewid;
    }

    public Date getMynewdate() {
        return mynewdate;
    }

    public void setMynewdate(Date mynewdate) {
        this.mynewdate = mynewdate;
    }

    public String getMynewcontent() {
        return mynewcontent;
    }

    public void setMynewcontent(String mynewcontent) {
        this.mynewcontent = mynewcontent;
    }

    public Integer getMynewsupport() {
        return mynewsupport;
    }

    public void setMynewsupport(Integer mynewsupport) {
        this.mynewsupport = mynewsupport;
    }

    public Integer getMynewcollect() {
        return mynewcollect;
    }

    public void setMynewcollect(Integer mynewcollect) {
        this.mynewcollect = mynewcollect;
    }
}
