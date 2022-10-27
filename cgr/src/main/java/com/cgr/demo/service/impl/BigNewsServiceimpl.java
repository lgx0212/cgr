package com.cgr.demo.service.impl;

import com.cgr.demo.bean.BigNews;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.BigNewsMapper;
import com.cgr.demo.service.BigNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/18 0018 下午 5:47
 * description:
 */
@Service
public class BigNewsServiceimpl implements BigNewsService {
    @Autowired
    private BigNewsMapper bigNewsMapper;
    @Override
    public Result bignews(BigNews bigNews) {
        List<BigNews> bigNews1 = bigNewsMapper.selectbignew(bigNews);
        if (bigNews1 != null && bigNews1.size() > 0) {
            return Result.OK(bigNews1);
        }
        return Result.FILE();
    }

    @Override
    public Result allbignews(BigNews bigNews) {
        List<BigNews> bigNews1 = bigNewsMapper.selectAllbignew(bigNews);
        if (bigNews1 != null && bigNews1.size() > 0) {
            return Result.OK(bigNews1);
        }
        return Result.FILE();
    }

    @Override
    public Result updatebignews(BigNews bigNews) {
        int row = bigNewsMapper.updateBigNews(bigNews);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result insertbignews(BigNews bigNews) {
        int row = bigNewsMapper.insertBigNews(bigNews);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result deletebignews(BigNews bigNews) {
        int row = bigNewsMapper.deletebignew(bigNews);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
