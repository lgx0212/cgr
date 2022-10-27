package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Growth;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.BabyMapper;
import com.cgr.demo.mapper.GrowthMapper;
import com.cgr.demo.service.BabyService;
import com.cgr.demo.service.GrowthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:33
 * description:
 */
@Service
public class GrowthServiceimpl implements GrowthService {
    @Autowired
    private GrowthMapper growthMapper;


    @Override
    public Result growth(Growth growth) {
        List<Growth> growths = growthMapper.queryGrowth(growth);
        if (growths != null && growths.size() > 0) {
            return Result.OK(growths);
        }
        return Result.FILE();
    }

    @Override
    public Result selectgrowth(Growth growth) {
        List<Growth> growths = growthMapper.selectGrowth(growth);
        if (growths != null && growths.size() > 0) {
            return Result.OK(growths);
        }
        return Result.FILE();
    }

    @Override
    public Result selectgrowthechart(Growth growth) {
        List<Growth> growths = growthMapper.selectGrowthEchart(growth);
        if (growths != null && growths.size() > 0) {
            return Result.OK(growths);
        }
        return Result.FILE();
    }

    @Override
    public Result insert(Growth growth) {
        int row = growthMapper.insertGrowth(growth);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result update(Growth growth) {
        int row = growthMapper.updateGrowth(growth);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result delete(Growth growth) {
        int row = growthMapper.deleteGrowth(growth);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
