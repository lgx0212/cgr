package com.cgr.demo.controller;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Mynew;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.BabyService;
import com.cgr.demo.service.MynewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/26 0026 下午 4:09
 * description:
 */
@RequestMapping("mynew")
@RestController
public class MynewController {
    @Autowired
    private MynewService mynewService;
    @GetMapping("mynew")
    public Result Mynew(Mynew mynew){
        Result result = mynewService.mynew(mynew);
        return result;
    }
    @GetMapping("mynewmynew")
    public Result Mynewmynew(Mynew mynew){
        Result result = mynewService.mymewmynew(mynew);
        return result;
    }
    @GetMapping("admingetall")
    public Result adminGetAll(Mynew mynew){
        Result result = mynewService.adminGetAll(mynew);
        return result;
    }
    @GetMapping("selectmynew")
    public Result selectMynew(Mynew mynew){
        Result result = mynewService.selectmynew(mynew);
        return result;
    }
    @GetMapping("selectuserinformationdata")
    public Result selectUserInformationData(Mynew mynew){
        Result result = mynewService.selectUserInformationData(mynew);
        return result;
    }
    @GetMapping("selectmynewbyid")
    public Result selectMynewbyid(Mynew mynew){
        Result result = mynewService.mynewbyid(mynew);
        return result;
    }
    @GetMapping("selectmynewbyuserid")
    public Result selectMynewbyuserid(Mynew mynew){
        Result result = mynewService.mynewbyuserid(mynew);
        return result;
    }
    @GetMapping("selectmynewbybabyid")
    public Result selectMynewbybabyid(Mynew mynew){
        Result result = mynewService.mynewbybabyid(mynew);
        return result;
    }
    @GetMapping("insert")
    public Result insert(Mynew mynew){
        Result result = mynewService.insert(mynew);
        return result;
    }
    @GetMapping("update")
    public Result update(Mynew mynew){
        Result result = mynewService.update(mynew);
        return result;
    }
    @GetMapping("updateifopen")
    public Result updateIfOpen(Mynew mynew){
        Result result = mynewService.updateifopen(mynew);
        return result;
    }
    @GetMapping("delete")
    public Result delete(Mynew mynew){
        Result result = mynewService.delete(mynew);
        return result;
    }
}
