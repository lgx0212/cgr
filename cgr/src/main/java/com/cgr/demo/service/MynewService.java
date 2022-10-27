package com.cgr.demo.service;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Mynew;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:32
 * description:
 */
public interface MynewService {
    Result mymewmynew(Mynew mynew);
    Result mynew(Mynew mynew);
    Result adminGetAll(Mynew mynew);
    Result selectmynew(Mynew mynew);
    Result selectUserInformationData(Mynew mynew);
    Result mynewbyid(Mynew mynew);
    Result mynewbyuserid(Mynew mynew);
    Result mynewbybabyid(Mynew mynew);
    Result insert(Mynew mynew);
    Result update(Mynew mynew);
    Result updateifopen(Mynew mynew);
    Result delete(Mynew mynew);
}
