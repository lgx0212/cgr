package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Result;
import com.cgr.demo.bean.User;
import com.cgr.demo.mapper.BabyMapper;
import com.cgr.demo.service.BabyService;
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
public class BabyServiceimpl implements BabyService {
    @Autowired
    private BabyMapper babyMapper;

    @Override
    public Result baby(Baby baby) {
        List<Baby> babys = babyMapper.queryBaby(baby);
        if (babys != null && babys.size() > 0) {
            return Result.OK(babys);
        }
        return Result.FILE();
    }

    @Override
    public Result selectbaby(Baby baby) {
        List<Baby> babys = babyMapper.selectBaby(baby);
        if (babys != null && babys.size() > 0) {
            return Result.OK(babys);
        }
        return Result.FILE();
    }

    @Override
    public Result checkedbaby(Baby baby) {
        List<Baby> babys = babyMapper.checkedBaby(baby);
        if (babys != null && babys.size() > 0) {
            return Result.OK(babys);
        }
        return Result.FILE();
    }

    @Override
    public Result selectbabyItem(Baby baby) {
        List<Baby> babys = babyMapper.selectBabyItem(baby);
        if (babys != null && babys.size() > 0) {
            return Result.OK(babys);
        }
        return Result.FILE();
    }

    @Override
    public Result insert(Baby baby) {
        int row = babyMapper.insertBaby(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result insertImg(Baby baby) {
        int row = babyMapper.insertBabyImg(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result update(Baby baby) {
        int row = babyMapper.updateBaby(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result updateimg(Baby baby) {
        int row = babyMapper.updateBabyImg(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result updatebackImg(Baby baby) {
        int row = babyMapper.updateBabyBackImg(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result updateName(Baby baby) {
        int row = babyMapper.updateBabyName(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result defaultbabychecked(Baby baby) {
        int row = babyMapper.defaultBabyChecked(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result updateChecked(Baby baby) {
        int row = babyMapper.updateBabyChecked(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result delete(Baby baby) {
        int row = babyMapper.deleteBaby(baby);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
