package com.cgr.demo.service;

import com.cgr.demo.bean.Mynew;
import com.cgr.demo.bean.Mynew_p;
import com.cgr.demo.bean.Result;
import com.sun.org.apache.regexp.internal.RE;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/5 0005 下午 5:08
 * description:
 */
public interface MynewpService {
    Result selectmynewp(Mynew_p mynew_p);
    Result selectbabymynewp(Mynew_p mynew_p);
    Result selectMynewpbyid(Mynew_p mynew_p);
    Result mynewp(Mynew_p mynew_p);
    Result deletemynewp(Mynew_p mynew_p);
}
