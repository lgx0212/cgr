package com.cgr.demo.mapper;

import com.cgr.demo.bean.Mynew;
import com.cgr.demo.bean.Mynew_p;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/5 0005 下午 5:07
 * description:
 */
public interface MynewpMapper {
    List<Mynew_p> selectMynewp(Mynew_p mynew_p);
    List<Mynew_p> selectBabyMynewp(Mynew_p mynew_p);
    List<Mynew_p> selectMynewpById(Mynew_p mynew_p);
    int insertMynew_p(Mynew_p mynew_p);
    int deleteMynewP(Mynew_p mynew_p);
}
