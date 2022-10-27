package com.cgr.demo.controller;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Growth;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.BabyService;
import com.cgr.demo.service.GrowthService;
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

@RequestMapping("growth")
@RestController
public class GrowthController {
    @Autowired
    private GrowthService growthService;
    @GetMapping("growth")
    public Result Growth(Growth growth){
        Result result = growthService.growth(growth);
        return result;
    }
    @GetMapping("selectgrowth")
    public Result selectGrowth(Growth growth){
        Result result = growthService.selectgrowth(growth);
        return result;
    }
    @GetMapping("selectgrowthechart")
    public Result selectGrowthEchart(Growth growth){
        Result result = growthService.selectgrowthechart(growth);
        return result;
    }
    @GetMapping("insert")
    public Result insert(Growth growth){
        Result result = growthService.insert(growth);
        return result;
    }
    @GetMapping("update")
    public Result update(Growth growth){
        Result result = growthService.update(growth);
        return result;
    }
    @GetMapping("delete")
    public Result delete(Growth growth){
        Result result = growthService.delete(growth);
        return result;
    }
}
