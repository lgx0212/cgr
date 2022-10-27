package com.cgr.demo.mapper;

import com.cgr.demo.bean.Message_c;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/20 0020 下午 2:37
 * description:
 */
public interface MessagecMapper {
    int insertMessageContent(Message_c message_c);
    int deleteMessageC(Message_c message_c);
    int deleteMessageCbyid(Message_c message_c);
    int deleteMessageCbynum(Message_c message_c);
    int deleteMessageCbyContentid(Message_c message_c);
    int updateState(Message_c message_c);
}
