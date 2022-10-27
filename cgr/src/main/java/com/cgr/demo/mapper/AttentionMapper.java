package com.cgr.demo.mapper;

import com.cgr.demo.bean.Attention;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/22 0022 下午 5:10
 * description:
 */
public interface AttentionMapper {
    List<Attention> selectIfAttention(Attention attention);
    List<Attention> countAttentionMy(Attention attention);
    List<Attention> countMyAttention(Attention attention);
    List<Attention> MyAttentionNews(Attention attention);
    int insertAttention(Attention attention);
    int deleteAttentionMy(Attention attention);
}
