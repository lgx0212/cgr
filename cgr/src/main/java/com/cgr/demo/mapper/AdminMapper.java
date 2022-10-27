package com.cgr.demo.mapper;

import com.cgr.demo.bean.Admin;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:19
 * description:
 */
public interface AdminMapper {
    List<Admin> selectadmin(Admin admin);

}
