package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Comment;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.AdminMapper;
import com.cgr.demo.mapper.CommentMapper;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.CommentService;
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
public class CommentServiceimpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Result selectComment(Comment comment) {
        List<Comment> comments = commentMapper.selectComment(comment);
        if (comments != null && comments.size() > 0) {
            return Result.OK(comments);
        }
        return Result.FILE();
    }

    @Override
    public Result insertComment(Comment comment) {
        int row = commentMapper.insertComment(comment);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result deleteComment(Comment comment) {
        int row = commentMapper.deleteComment(comment);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
