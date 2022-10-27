package com.cgr.demo.mapper;
import com.cgr.demo.bean.Mynew;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:31
 * description:
 */
public interface MynewMapper {
    List<Mynew> queryMynew(Mynew mynew);
    List<Mynew> selectMynew(Mynew mynew);
    List<Mynew> adminGetAll(Mynew mynew);
    List<Mynew> getAll();
    List<Mynew> selectUserInformationData(Mynew mynew);
    List<Mynew> selectByMynewId(Mynew mynew);
    List<Mynew> selectByUserId(Mynew mynew);
    List<Mynew> selectByBabyId(Mynew mynew);
    int insertMynew(Mynew mynew);
    int updateMynew(Mynew mynew);
    int updateMynewifopen(Mynew mynew);
    int deleteMynew(Mynew mynew);
}
