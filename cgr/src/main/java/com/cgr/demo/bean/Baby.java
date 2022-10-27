package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:29
 * description:
 */
public class Baby {
    private Integer userid;
    private Integer babyid;
    private String babyname;
    private String babysex;
    private String babyimg;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date babybrith;
    private Integer babychecked;
    private String babybackimg;

    public String getBabybackimg() {
        return babybackimg;
    }

    public void setBabybackimg(String babybackimg) {
        this.babybackimg = babybackimg;
    }

    public Integer getBabychecked() {
        return babychecked;
    }

    public void setBabychecked(Integer babychecked) {
        this.babychecked = babychecked;
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

    public String getBabyname() {
        return babyname;
    }

    public void setBabyname(String babyname) {
        this.babyname = babyname;
    }

    public String getBabysex() {
        return babysex;
    }

    public void setBabysex(String babysex) {
        this.babysex = babysex;
    }

    public String getBabyimg() {
        return babyimg;
    }

    public void setBabyimg(String babyimg) {
        this.babyimg = babyimg;
    }

    public Date getBabybrith() {
        return babybrith;
    }

    public void setBabybrith(Date babybrith) {
        this.babybrith = babybrith;
    }
}
