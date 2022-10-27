package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/24 0024 下午 8:16
 * description:
 */
public class User {
    private Integer userid;
    private String username;
    private String usersex;
    private String userusername;
    private String userpassword;
    private String userimg;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date userbrith;
    private String usermyspaceimg;
    private Message message;
    private Mynew mynew;
    private Attention attention;

    public Attention getAttention() {
        return attention;
    }

    public void setAttention(Attention attention) {
        this.attention = attention;
    }

    public Mynew getMynew() {
        return mynew;
    }

    public void setMynew(Mynew mynew) {
        this.mynew = mynew;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getUsermyspaceimg() {
        return usermyspaceimg;
    }

    public void setUsermyspaceimg(String usermyspaceimg) {
        this.usermyspaceimg = usermyspaceimg;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserusername() {
        return userusername;
    }

    public void setUserusername(String userusername) {
        this.userusername = userusername;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public Date getUserbrith() {
        return userbrith;
    }

    public void setUserbrith(Date userbrith) {
        this.userbrith = userbrith;
    }
}
