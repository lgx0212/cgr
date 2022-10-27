package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Message;
import com.cgr.demo.bean.Mynew_p;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.MessageMapper;
import com.cgr.demo.mapper.MynewpMapper;
import com.cgr.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/16 0016 下午 8:43
 * description:
 */
@Service
public class MessageServiceimpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Result selectmessage(Message message) {
        List<Message> messages = messageMapper.selectmessage(message);
        if (messages != null && messages.size() > 0) {
            return Result.OK(messages);
        }
        return Result.FILE();
    }

    @Override
    public Result allmessage(Message message) {
        List<Message> messages = messageMapper.selectallmessage(message);
        if (messages != null && messages.size() > 0) {
            return Result.OK(messages);
        }
        return Result.FILE();
    }

    @Override
    public Result bymessageid(Message message) {
        List<Message> messages = messageMapper.selectbymessageid(message);
        if (messages != null && messages.size() > 0) {
            return Result.OK(messages);
        }
        return Result.FILE();
    }

    @Override
    public Result selectmessagenum(Message message) {
        List<Message> messages = messageMapper.selectMessageNum(message);
        if (messages != null && messages.size() > 0) {
            return Result.OK(messages);
        }
        return Result.FILE();
    }

    @Override
    public Result deletemessage(Message message) {
        int row = messageMapper.deleteMessage(message);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result selectbyuserid(Message message) {
        List<Message> messages = messageMapper.selectmessagebyuserid(message);
        if (messages != null && messages.size() > 0) {
            return Result.OK(messages);
        }
        return Result.FILE();
    }

    @Override
    public Result insertmessage(Message message) {
        int row = messageMapper.insertMessage(message);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result selectifmessage(Message message) {
        List<Message> messages = messageMapper.selectIfMessage(message);
        if (messages != null && messages.size() > 0) {
            return Result.OK(messages);
        }
        return Result.FILE();
    }
}
