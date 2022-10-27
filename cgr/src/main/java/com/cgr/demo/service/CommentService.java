package com.cgr.demo.service;

import com.cgr.demo.bean.Comment;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:21
 * description:
 */
public interface CommentService {
    Result selectComment(Comment comment);
    Result insertComment(Comment comment);
    Result deleteComment(Comment comment);
}
