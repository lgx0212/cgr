package com.cgr.demo.mapper;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Collect;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:19
 * description:
 */
public interface CollectMapper {
   List<Collect> MyCollect(Collect collect);
   List<Collect> selectIfCollect(Collect collect);
   List<Collect> selectCollectNum(Collect collect);
   int insertCollect(Collect collect);
   int deleteCollect(Collect collect);


}
