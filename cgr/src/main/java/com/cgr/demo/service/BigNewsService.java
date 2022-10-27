package com.cgr.demo.service;

import com.cgr.demo.bean.BigNews;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/18 0018 下午 5:42
 * description:
 */
public interface BigNewsService {
    Result bignews(BigNews bigNews);
    Result allbignews(BigNews bigNews);
    Result updatebignews(BigNews bigNews);
    Result insertbignews(BigNews bigNews);
    Result deletebignews(BigNews bigNews);
}
