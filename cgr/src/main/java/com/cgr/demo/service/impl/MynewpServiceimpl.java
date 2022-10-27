package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Mynew;
import com.cgr.demo.bean.Mynew_p;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.MynewMapper;
import com.cgr.demo.mapper.MynewpMapper;
import com.cgr.demo.service.MynewService;
import com.cgr.demo.service.MynewpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/5 0005 下午 5:09
 * description:
 */
@Service
public class MynewpServiceimpl implements MynewpService {

    @Autowired
    private MynewpMapper mynewpMapper;

    @Override
    public Result selectmynewp(Mynew_p mynew_p) {
        List<Mynew_p> mynewp = mynewpMapper.selectMynewp(mynew_p);
        if (mynewp != null && mynewp.size() > 0) {
            return Result.OK(mynewp);
        }
        return Result.FILE();
    }

    @Override
    public Result selectbabymynewp(Mynew_p mynew_p) {
        List<Mynew_p> mynewp = mynewpMapper.selectBabyMynewp(mynew_p);
        if (mynewp != null && mynewp.size() > 0) {
            return Result.OK(mynewp);
        }
        return Result.FILE();
    }

    @Override
    public Result selectMynewpbyid(Mynew_p mynew_p) {
        List<Mynew_p> mynewp = mynewpMapper.selectMynewpById(mynew_p);
        if (mynewp != null && mynewp.size() > 0) {
            return Result.OK(mynewp);
        }
        return Result.FILE();
    }

    @Override
    public Result mynewp(Mynew_p mynew_p) {

        int row = mynewpMapper.insertMynew_p(mynew_p);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();

    }

    @Override
    public Result deletemynewp(Mynew_p mynew_p) {
        int row = mynewpMapper.deleteMynewP(mynew_p);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
