package com.cgr.demo.controller;

import com.cgr.demo.bean.BigNews;
import com.cgr.demo.bean.Message;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.BigNewsService;
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
@RequestMapping("bignew")
@RestController
public class BigNewsController {
    @Autowired
    private BigNewsService bigNewsService;

    @GetMapping("bignew")
    public Result selectAllBigNew(BigNews bigNews){
        Result result = bigNewsService.allbignews(bigNews);
        return result;
    }
    @GetMapping("selectbignew")
    public Result selectBigNew(BigNews bigNews){
        Result result = bigNewsService.bignews(bigNews);
        return result;
    }
    @GetMapping("updatebignew")
    public Result updateBigNew(BigNews bigNews){
        Result result = bigNewsService.updatebignews(bigNews);
        return result;
    }
    @GetMapping("insertbignew")
    public Result insertBigNew(BigNews bigNews){
        Result result = bigNewsService.insertbignews(bigNews);
        return result;
    }
    @GetMapping("deletebignew")
    public Result deleteBigNew(BigNews bigNews){
        Result result = bigNewsService.deletebignews(bigNews);
        return result;
    }

}
