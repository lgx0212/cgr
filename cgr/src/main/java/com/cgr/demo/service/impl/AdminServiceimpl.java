package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.AdminMapper;
import com.cgr.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:22
 * description:
 */
@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Result selectadmin(Admin admin) {
        List<Admin> admins = adminMapper.selectadmin(admin);
        if (admins != null && admins.size() > 0) {
            return Result.OK(admins);
        }
        return Result.FILE();
    }
}
