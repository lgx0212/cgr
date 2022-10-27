package com.cgr.demo.service;

import com.cgr.demo.bean.Message;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/16 0016 下午 8:43
 * description:
 */
public interface MessageService {
    Result selectmessage(Message message);
    Result allmessage(Message message);
    Result bymessageid(Message message);
    Result selectmessagenum(Message message);
    Result deletemessage(Message message);
    Result selectbyuserid(Message message);
    Result insertmessage(Message message);
    Result selectifmessage(Message message);
}
