package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/5/4 0004 下午 7:59
 * description:
 */
public class Comment {
    private Integer mynewid;
    private Integer commentuserid;
    private String commentcontent;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date commentdate;
    private Integer commentid;
    private List<User> users;
    private List<Comment_reply> comment_replies;

    public List<Comment_reply> getComment_replies() {
        return comment_replies;
    }

    public void setComment_replies(List<Comment_reply> comment_replies) {
        this.comment_replies = comment_replies;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getMynewid() {
        return mynewid;
    }

    public void setMynewid(Integer mynewid) {
        this.mynewid = mynewid;
    }

    public Integer getCommentuserid() {
        return commentuserid;
    }

    public void setCommentuserid(Integer commentuserid) {
        this.commentuserid = commentuserid;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }
}
