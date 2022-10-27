package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Comment_reply;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.AdminMapper;
import com.cgr.demo.mapper.CommentreplyMapper;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.CommentreplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:22
 * description:
 */
@Service
public class CommentreplyServiceimpl implements CommentreplyService {

    @Autowired
    private CommentreplyMapper commentreplyMapper;

    @Override
    public Result selectadmin(Comment_reply comment_reply) {
        List<Comment_reply> comment_replies = commentreplyMapper.selectadmin(comment_reply);
        if (comment_replies != null && comment_replies.size() > 0) {
            return Result.OK(comment_replies);
        }
        return Result.FILE();
    }

    @Override
    public Result insertReply(Comment_reply comment_reply) {
        int row = commentreplyMapper.insertReply(comment_reply);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result delReply(Comment_reply comment_reply) {
        int row = commentreplyMapper.delReply(comment_reply);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
