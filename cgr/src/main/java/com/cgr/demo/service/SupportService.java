package com.cgr.demo.service;

import com.cgr.demo.bean.Admin;
import com.cgr.demo.bean.Result;
import com.cgr.demo.bean.Support;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:21
 * description:
 */
public interface SupportService {
    Result supportmy(Support support);
    Result selectifsupport(Support support);
    Result selectsupportnum(Support support);
    Result countsupport(Support support);
    Result insertsupport(Support support);
    Result deletesupport(Support support);
}
