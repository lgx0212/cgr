package com.cgr.demo.controller;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Attention;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:37
 * description:
 */

@RequestMapping("attention")
@RestController
public class AttentionController {
    @Autowired
    private AttentionService attentionService;

    @GetMapping("selectifattention")
    public Result selectIfAttention(Attention attention){
        Result result = attentionService.selectifattention(attention);
        return result;
    }
    @GetMapping("attentionmy")
    public Result countAttentionMy(Attention attention){
        Result result = attentionService.countattentionmy(attention);
        return result;
    }
    @GetMapping("myattention")
    public Result countMyAttention(Attention attention){
        Result result = attentionService.countmyattention(attention);
        return result;
    }
    @GetMapping("myattentionnews")
    public Result MyAttentionNews(Attention attention){
        Result result = attentionService.myattentionnews(attention);
        return result;
    }
    @GetMapping("insertattention")
    public Result insertAttention(Attention attention){
        Result result = attentionService.insertattention(attention);
        return result;
    }
    @GetMapping("deleteattentionmy")
    public Result deleteAttention(Attention attention){
        Result result = attentionService.deleteattentionmy(attention);
        return result;
    }
}
