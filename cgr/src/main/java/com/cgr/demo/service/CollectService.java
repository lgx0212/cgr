package com.cgr.demo.service;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Collect;
import com.cgr.demo.bean.Result;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:21
 * description:
 */
public interface CollectService {
    Result mycollect(Collect collect);
    Result insertcollect(Collect collect);
    Result selectifcollect(Collect collect);
    Result selectcollectnum(Collect collect);
    Result deletecollect(Collect collect);
}
