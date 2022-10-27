package com.cgr.demo.mapper;

import com.cgr.demo.bean.Baby;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:31
 * description:
 */
public interface BabyMapper {
    List<Baby> queryBaby(Baby baby);
    List<Baby> selectBaby(Baby baby);
    List<Baby> checkedBaby(Baby baby);
    List<Baby> selectBabyItem(Baby baby);
    int insertBaby(Baby baby);
    int insertBabyImg(Baby baby);
    int updateBaby(Baby baby);
    int updateBabyImg(Baby baby);
    int updateBabyBackImg(Baby baby);
    int updateBabyName(Baby baby);
    int defaultBabyChecked(Baby baby);
    int updateBabyChecked(Baby baby);
    int deleteBaby(Baby baby);
}
