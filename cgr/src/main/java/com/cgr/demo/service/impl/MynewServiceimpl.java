package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Mynew;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.BabyMapper;
import com.cgr.demo.mapper.MynewMapper;
import com.cgr.demo.service.MynewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/26 0026 下午 4:06
 * description:
 */
@Service
public class MynewServiceimpl implements MynewService {
    @Autowired
    private MynewMapper mynewMapper;

    @Override
    public Result mymewmynew(Mynew mynew) {
        List<Mynew> mynews = mynewMapper.getAll();
        if (mynews != null && mynews.size() > 0) {
            return Result.OK(mynews);
        }
        return Result.FILE();
    }

    @Override
    public Result mynew(Mynew mynew) {
        List<Mynew> mynews = mynewMapper.queryMynew(mynew);
        if (mynews != null && mynews.size() > 0) {
            return Result.OK(mynews);
        }
        return Result.FILE();
    }

    @Override
    public Result adminGetAll(Mynew mynew) {
        List<Mynew> mynews = mynewMapper.adminGetAll(mynew);
        if (mynews != null && mynews.size() > 0) {
            return Result.OK(mynews);
        }
        return Result.FILE();
    }

    @Override
    public Result selectmynew(Mynew mynew) {
        List<Mynew> mynews = mynewMapper.selectMynew(mynew);
        if (mynews != null && mynews.size() > 0) {
            return Result.OK(mynews);
        }
        return Result.FILE();
    }

    @Override
    public Result selectUserInformationData(Mynew mynew) {
        List<Mynew> mynews = mynewMapper.selectUserInformationData(mynew);
        if (mynews != null && mynews.size() > 0) {
            return Result.OK(mynews);
        }
        return Result.FILE();
    }

    @Override
    public Result mynewbyid(Mynew mynew) {
        List<Mynew> mynews = mynewMapper.selectByMynewId(mynew);
        if (mynews != null && mynews.size() > 0) {
            return Result.OK(mynews);
        }
        return Result.FILE();
    }

    @Override
    public Result mynewbyuserid(Mynew mynew) {
        List<Mynew> mynews = mynewMapper.selectByUserId(mynew);
        if (mynews != null && mynews.size() > 0) {
            return Result.OK(mynews);
        }
        return Result.FILE();
    }

    @Override
    public Result mynewbybabyid(Mynew mynew) {
        List<Mynew> mynews = mynewMapper.selectByBabyId(mynew);
        if (mynews != null && mynews.size() > 0) {
            return Result.OK(mynews);
        }
        return Result.FILE();
    }

    @Override
    public Result insert(Mynew mynew) {
        int row = mynewMapper.insertMynew(mynew);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result update(Mynew mynew) {
        int row = mynewMapper.updateMynew(mynew);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result updateifopen(Mynew mynew) {
        int row = mynewMapper.updateMynewifopen(mynew);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result delete(Mynew mynew) {
        int row = mynewMapper.deleteMynew(mynew);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

}
