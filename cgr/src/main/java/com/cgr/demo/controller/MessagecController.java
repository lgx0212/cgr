package com.cgr.demo.controller;

import com.cgr.demo.bean.Message;
import com.cgr.demo.bean.Message_c;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.MessageService;
import com.cgr.demo.service.MessagecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/16 0016 下午 8:47
 * description:
 */
@RequestMapping("messagec")
@RestController
public class MessagecController {
    @Autowired
    private MessagecService messagecService;

    @GetMapping("insertmessagecontent")
    public Result insertMessageContent(Message_c message_c){
        Result result = messagecService.insertmessagecontent(message_c);
        return result;
    }
    @GetMapping("deletemessagec")
    public Result deletemessagec(Message_c message_c){
        Result result = messagecService.deletemessagec(message_c);
        return result;
    }
    @GetMapping("deletemessagecbyid")
    public Result deletemessagecbyid(Message_c message_c){
        Result result = messagecService.deletemessagecbyid(message_c);
        return result;
    }
    @GetMapping("deletemessagecbynum")
    public Result deleteMessageCbynum(Message_c message_c){
        Result result = messagecService.deletemessageCbynum(message_c);
        return result;
    }
    @GetMapping("deletemessagecbycontentid")
    public Result deleteMessageCbyContentid(Message_c message_c){
        Result result = messagecService.deletemessageCbyContentid(message_c);
        return result;
    }
    @GetMapping("updatestate")
    public Result updateState(Message_c message_c){
        Result result = messagecService.updateState(message_c);
        return result;
    }

}
