package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/26 0026 下午 7:49
 * description:
 */
public class Growth {
    private Integer userid;
    private Integer babyid;
    private Integer growthid;
    private double growthheight;
    private double growthweight;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date growthdate;

    public Integer getGrowthid() {
        return growthid;
    }

    public void setGrowthid(Integer growthid) {
        this.growthid = growthid;
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

    public double getGrowthheight() {
        return growthheight;
    }

    public void setGrowthheight(double growthheight) {
        this.growthheight = growthheight;
    }

    public double getGrowthweight() {
        return growthweight;
    }

    public void setGrowthweight(double growthweight) {
        this.growthweight = growthweight;
    }

    public Date getGrowthdate() {
        return growthdate;
    }

    public void setGrowthdate(Date growthdate) {
        this.growthdate = growthdate;
    }
}
