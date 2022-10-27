package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Result;
import com.cgr.demo.bean.Support;
import com.cgr.demo.mapper.AdminMapper;
import com.cgr.demo.mapper.SupportMapper;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.SupportService;
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
public class SupportServiceimpl implements SupportService {

    @Autowired
    private SupportMapper supportMapper;


    @Override
    public Result supportmy(Support support) {
        List<Support> supports = supportMapper.supportMy(support);
        if (supports != null && supports.size() > 0) {
            return Result.OK(supports);
        }
        return Result.FILE();
    }

    @Override
    public Result selectifsupport(Support support) {
        List<Support> supports = supportMapper.selectIfSupport(support);
        if (supports != null && supports.size() > 0) {
            return Result.OK(supports);
        }
        return Result.FILE();
    }

    @Override
    public Result selectsupportnum(Support support) {
        List<Support> supports = supportMapper.selectSupportNum(support);
        if (supports != null && supports.size() > 0) {
            return Result.OK(supports);
        }
        return Result.FILE();
    }

    @Override
    public Result countsupport(Support support) {
        List<Support> supports = supportMapper.countSupport(support);
        if (supports != null && supports.size() > 0) {
            return Result.OK(supports);
        }
        return Result.FILE();
    }

    @Override
    public Result insertsupport(Support support) {
        int row = supportMapper.insertSupport(support);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result deletesupport(Support support) {
        int row = supportMapper.deleteSupport(support);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
