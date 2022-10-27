package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Collect;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.AdminMapper;
import com.cgr.demo.mapper.CollectMapper;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.CollectService;
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
public class CollectServiceimpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;


    @Override
    public Result mycollect(Collect collect) {
        List<Collect> collects = collectMapper.MyCollect(collect);
        if (collects != null && collects.size() > 0) {
            return Result.OK(collects);
        }
        return Result.FILE();
    }

    @Override
    public Result insertcollect(Collect collect) {
        int row = collectMapper.insertCollect(collect);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result selectifcollect(Collect collect) {
        List<Collect> collects = collectMapper.selectIfCollect(collect);
        if (collects != null && collects.size() > 0) {
            return Result.OK(collects);
        }
        return Result.FILE();
    }

    @Override
    public Result selectcollectnum(Collect collect) {
        List<Collect> collects = collectMapper.selectCollectNum(collect);
        if (collects != null && collects.size() > 0) {
            return Result.OK(collects);
        }
        return Result.FILE();
    }

    @Override
    public Result deletecollect(Collect collect) {
        int row = collectMapper.deleteCollect(collect);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
