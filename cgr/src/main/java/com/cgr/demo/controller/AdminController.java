package com.cgr.demo.controller;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Growth;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.AdminService;
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

@RequestMapping("admin")
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("selectadmin")
    public Result selectAdmin(Admin admin){
        Result result = adminService.selectadmin(admin);
        return result;
    }
}
