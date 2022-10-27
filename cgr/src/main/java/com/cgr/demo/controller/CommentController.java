package com.cgr.demo.controller;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Comment;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:37
 * description:
 */

@RequestMapping("comment")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("selectcomment")
    public Result selectComment(Comment comment){
        Result result = commentService.selectComment(comment);
        return result;
    }
    @GetMapping("insertcomment")
    public Result insertComment(Comment comment){
        Result result = commentService.insertComment(comment);
        return result;
    }
    @GetMapping("deletecomment")
    public Result deleteComment(Comment comment){
        Result result = commentService.deleteComment(comment);
        return result;
    }
}
