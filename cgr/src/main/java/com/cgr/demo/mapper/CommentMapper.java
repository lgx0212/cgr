package com.cgr.demo.mapper;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Comment;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:19
 * description:
 */
public interface CommentMapper {
    List<Comment> selectComment(Comment comment);
    int insertComment(Comment comment);
    int deleteComment(Comment comment);

}
