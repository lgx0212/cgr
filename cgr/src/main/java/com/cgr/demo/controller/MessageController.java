package com.cgr.demo.controller;

import com.cgr.demo.bean.Growth;
import com.cgr.demo.bean.Message;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.MessageService;
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
@RequestMapping("message")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("selectmessage")
    public Result selectmessage(Message message){
        Result result = messageService.selectmessage(message);
        return result;
    }
    @GetMapping("selectallmessage")
    public Result selectAllmessage(Message message){
        Result result = messageService.allmessage(message);
        return result;
    }
    @GetMapping("selectbymessageid")
    public Result selectbymessageid(Message message){
        Result result = messageService.bymessageid(message);
        return result;
    }
    @GetMapping("selectmessagenum")
    public Result selectMessageNum(Message message){
        Result result = messageService.selectmessagenum(message);
        return result;
    }
    @GetMapping("selectbyuserid")
    public Result selectbyuserid(Message message){
        Result result = messageService.selectbyuserid(message);
        return result;
    }

    @GetMapping("deletemessage")
    public Result deletemessage(Message message){
        Result result = messageService.deletemessage(message);
        return result;
    }
    @GetMapping("insertmessage")
    public Result insertMessage(Message message){
        Result result = messageService.insertmessage(message);
        return result;
    }
    @GetMapping("selectifmessage")
    public Result selectIfMessage(Message message){
        Result result = messageService.selectifmessage(message);
        return result;
    }

}
