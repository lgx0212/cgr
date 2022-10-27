package com.cgr.demo.mapper;

import com.cgr.demo.bean.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/16 0016 下午 8:42
 * description:
 */
public interface MessageMapper {
    List<Message> selectmessage(Message message);
    List<Message> selectallmessage(Message message);
    List<Message> selectbymessageid(Message message);
    List<Message> selectMessageNum(Message message);
    List<Message> selectmessagebyuserid(Message message);
    List<Message> selectIfMessage(Message message);
    int insertMessage(Message message);
    int deleteMessage(Message message);
}
