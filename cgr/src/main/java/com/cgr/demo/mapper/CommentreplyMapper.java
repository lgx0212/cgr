package com.cgr.demo.mapper;


import com.cgr.demo.bean.Comment_reply;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:19
 * description:
 */
public interface CommentreplyMapper {
    List<Comment_reply> selectadmin(Comment_reply comment_reply);
    int insertReply(Comment_reply comment_reply);
    int delReply(Comment_reply comment_reply);

}
