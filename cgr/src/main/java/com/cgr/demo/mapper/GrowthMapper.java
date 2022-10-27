package com.cgr.demo.mapper;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Growth;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:31
 * description:
 */
public interface GrowthMapper {
    List<Growth> queryGrowth(Growth growth);
    List<Growth> selectGrowth(Growth growth);
    List<Growth> selectGrowthEchart(Growth growth);
    int insertGrowth(Growth growth);
    int updateGrowth(Growth growth);
    int deleteGrowth(Growth growth);
}
