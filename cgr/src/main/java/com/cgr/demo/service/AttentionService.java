package com.cgr.demo.service;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Attention;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:21
 * description:
 */
public interface AttentionService {
    Result insertattention(Attention attention);
    Result countattentionmy(Attention attention);
    Result countmyattention(Attention attention);
    Result myattentionnews(Attention attention);
    Result selectifattention(Attention attention);
    Result deleteattentionmy(Attention attention);
}
