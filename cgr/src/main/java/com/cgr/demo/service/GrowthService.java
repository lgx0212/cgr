package com.cgr.demo.service;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Growth;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:32
 * description:
 */
public interface GrowthService {
    Result growth(Growth growth);
    Result selectgrowth(Growth growth);
    Result selectgrowthechart(Growth  growth);
    Result insert(Growth growth);
    Result update(Growth growth);
    Result delete(Growth growth);
}
