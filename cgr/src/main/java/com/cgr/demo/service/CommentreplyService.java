package com.cgr.demo.service;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Comment_reply;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:21
 * description:
 */
public interface CommentreplyService {
    Result selectadmin(Comment_reply comment_reply);
    Result insertReply(Comment_reply comment_reply);
    Result delReply(Comment_reply comment_reply);
}
