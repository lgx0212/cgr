package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/18 0018 下午 5:38
 * description:
 */
public class BigNews {
    private Integer userid;
    private Integer babyid;
    private String bignewcontent;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date bignewdate;
    private Integer bignewid;

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

    public String getBignewcontent() {
        return bignewcontent;
    }

    public void setBignewcontent(String bignewcontent) {
        this.bignewcontent = bignewcontent;
    }

    public Date getBignewdate() {
        return bignewdate;
    }

    public void setBignewdate(Date bignewdate) {
        this.bignewdate = bignewdate;
    }

    public Integer getBignewid() {
        return bignewid;
    }

    public void setBignewid(Integer bignewid) {
        this.bignewid = bignewid;
    }
}
