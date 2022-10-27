package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Attention;
import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Result;
import com.cgr.demo.mapper.AdminMapper;
import com.cgr.demo.mapper.AttentionMapper;
import com.cgr.demo.service.AdminService;
import com.cgr.demo.service.AttentionService;
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
public class AttentionServiceimpl implements AttentionService {

    @Autowired
    private AttentionMapper attentionMapper;

    @Override
    public Result insertattention(Attention attention) {
        int row = attentionMapper.insertAttention(attention);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result countattentionmy(Attention attention) {
        List<Attention> attentions = attentionMapper.countAttentionMy(attention);
        if (attentions != null && attentions.size() > 0) {
            return Result.OK(attentions);
        }
        return Result.FILE();
    }

    @Override
    public Result countmyattention(Attention attention) {
        List<Attention> attentions = attentionMapper.countMyAttention(attention);
        if (attentions != null && attentions.size() > 0) {
            return Result.OK(attentions);
        }
        return Result.FILE();
    }

    @Override
    public Result myattentionnews(Attention attention) {
        List<Attention> attentions = attentionMapper.MyAttentionNews(attention);
        if (attentions != null && attentions.size() > 0) {
            return Result.OK(attentions);
        }
        return Result.FILE();
    }

    @Override
    public Result selectifattention(Attention attention) {
        List<Attention> attentions = attentionMapper.selectIfAttention(attention);
        if (attentions != null && attentions.size() > 0) {
            return Result.OK(attentions);
        }
        return Result.FILE();
    }

    @Override
    public Result deleteattentionmy(Attention attention) {
        int row = attentionMapper.deleteAttentionMy(attention);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
