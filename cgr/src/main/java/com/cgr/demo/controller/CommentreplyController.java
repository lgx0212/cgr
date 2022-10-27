package com.cgr.demo.controller;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Comment_reply;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.CommentreplyService;
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

@RequestMapping("commentreply")
@RestController
public class CommentreplyController {
    @Autowired
    private CommentreplyService commentreplyService;
    @GetMapping("commentreply")
    public Result Commentreply(Comment_reply comment_reply){
        Result result = commentreplyService.selectadmin(comment_reply);
        return result;
    }
    @GetMapping("insertreply")
    public Result insertReply(Comment_reply comment_reply){
        Result result = commentreplyService.insertReply(comment_reply);
        return result;
    }
    @GetMapping("delreply")
    public Result delReply(Comment_reply comment_reply){
        Result result = commentreplyService.delReply(comment_reply);
        return result;
    }
}
