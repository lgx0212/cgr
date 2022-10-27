package com.cgr.demo.controller;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Collect;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.CollectService;
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

@RequestMapping("collect")
@RestController
public class CollectController {
    @Autowired
    private CollectService collectService;
    @GetMapping("mycollect")
    public Result MyCollect(Collect collect){
        Result result = collectService.mycollect(collect);
        return result;
    }
    @GetMapping("selectifcollect")
    public Result selectIfCollect(Collect collect){
        Result result = collectService.selectifcollect(collect);
        return result;
    }
    @GetMapping("selectcollectnum")
    public Result selectCollectNum(Collect collect){
        Result result = collectService.selectcollectnum(collect);
        return result;
    }
    @GetMapping("insertcollect")
    public Result insertCollect(Collect collect){
        Result result = collectService.insertcollect(collect);
        return result;
    }
    @GetMapping("deletecollect")
    public Result deleteCollect(Collect collect){
        Result result = collectService.deletecollect(collect);
        return result;
    }

}
