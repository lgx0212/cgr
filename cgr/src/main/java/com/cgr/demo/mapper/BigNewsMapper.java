package com.cgr.demo.mapper;

import com.cgr.demo.bean.BigNews;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/18 0018 下午 5:40
 * description:
 */
public interface BigNewsMapper {
    List<BigNews> selectbignew(BigNews bigNews);
    List<BigNews> selectAllbignew(BigNews bigNews);
    int updateBigNews(BigNews bigNews);
    int insertBigNews(BigNews bigNews);
    int deletebignew(BigNews bigNews);
}
