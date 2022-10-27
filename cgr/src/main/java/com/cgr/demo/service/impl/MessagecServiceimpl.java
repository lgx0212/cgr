package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Message;
import com.cgr.demo.bean.Message_c;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.MessageMapper;
import com.cgr.demo.mapper.MessagecMapper;
import com.cgr.demo.service.MessageService;
import com.cgr.demo.service.MessagecService;
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
public class MessagecServiceimpl implements MessagecService {
    @Autowired
    private MessagecMapper messagecMapper;


    @Override
    public Result insertmessagecontent(Message_c message_c) {
        int row = messagecMapper.insertMessageContent(message_c);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result deletemessagec(Message_c message_c) {
        int row = messagecMapper.deleteMessageC(message_c);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result deletemessagecbyid(Message_c message_c) {
        int row = messagecMapper.deleteMessageCbyid(message_c);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result deletemessageCbynum(Message_c message_c) {
        int row = messagecMapper.deleteMessageCbynum(message_c);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result deletemessageCbyContentid(Message_c message_c) {
        int row = messagecMapper.deleteMessageCbyContentid(message_c);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result updateState(Message_c message_c) {
        int row = messagecMapper.updateState(message_c);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
