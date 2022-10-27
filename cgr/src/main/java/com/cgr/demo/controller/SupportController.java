package com.cgr.demo.controller;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Result;
import com.cgr.demo.bean.Support;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.SupportService;
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

@RequestMapping("support")
@RestController
public class SupportController {
    @Autowired
    private SupportService supportService;
    @GetMapping("supportmy")
    public Result SupportMy(Support support){
        Result result = supportService.supportmy(support);
        return result;
    }
    @GetMapping("selectifsupport")
    public Result selectIfSupport(Support support){
        Result result = supportService.selectifsupport(support);
        return result;
    }
    @GetMapping("selectsupportnum")
    public Result selectSupportNum(Support support){
        Result result = supportService.selectsupportnum(support);
        return result;
    }
    @GetMapping("countsupport")
    public Result countSupport(Support support){
        Result result = supportService.countsupport(support);
        return result;
    }
    @GetMapping("insertsupport")
    public Result insertSupport(Support support){
        Result result = supportService.insertsupport(support);
        return result;
    }
    @GetMapping("deletesupport")
    public Result deleteSupport(Support support){
        Result result = supportService.deletesupport(support);
        return result;
    }
}
