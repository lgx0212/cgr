package com.cgr.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/5/10 0010 下午 7:24
 * description:
 */
public class Comment_reply {
    private Integer commentreplyid;
    private Integer commentreplycommentid;
    private Integer commentreplysanduserid;
    private Integer commentreplyreceiveuserid;
    private String commentreplycontent;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date commentreplydate;
    private List<User> users1;
    private List<User> users2;

    public List<User> getUsers1() {
        return users1;
    }

    public void setUsers1(List<User> users1) {
        this.users1 = users1;
    }

    public List<User> getUsers2() {
        return users2;
    }

    public void setUsers2(List<User> users2) {
        this.users2 = users2;
    }

    public Integer getCommentreplyid() {
        return commentreplyid;
    }

    public void setCommentreplyid(Integer commentreplyid) {
        this.commentreplyid = commentreplyid;
    }

    public Integer getCommentreplycommentid() {
        return commentreplycommentid;
    }

    public void setCommentreplycommentid(Integer commentreplycommentid) {
        this.commentreplycommentid = commentreplycommentid;
    }

    public Integer getCommentreplysanduserid() {
        return commentreplysanduserid;
    }

    public void setCommentreplysanduserid(Integer commentreplysanduserid) {
        this.commentreplysanduserid = commentreplysanduserid;
    }

    public Integer getCommentreplyreceiveuserid() {
        return commentreplyreceiveuserid;
    }

    public void setCommentreplyreceiveuserid(Integer commentreplyreceiveuserid) {
        this.commentreplyreceiveuserid = commentreplyreceiveuserid;
    }

    public String getCommentreplycontent() {
        return commentreplycontent;
    }

    public void setCommentreplycontent(String commentreplycontent) {
        this.commentreplycontent = commentreplycontent;
    }

    public Date getCommentreplydate() {
        return commentreplydate;
    }

    public void setCommentreplydate(Date commentreplydate) {
        this.commentreplydate = commentreplydate;
    }
}
