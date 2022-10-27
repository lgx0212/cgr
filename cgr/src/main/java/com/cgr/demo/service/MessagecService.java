package com.cgr.demo.service;

import com.cgr.demo.bean.Message_c;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/16 0016 下午 8:43
 * description:
 */
public interface MessagecService {
    Result insertmessagecontent(Message_c message_c);
    Result deletemessagec(Message_c message_c);
    Result deletemessagecbyid(Message_c message_c);
    Result deletemessageCbynum(Message_c message_c);
    Result deletemessageCbyContentid(Message_c message_c);
    Result updateState(Message_c message_c);
}
