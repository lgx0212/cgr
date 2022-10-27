package com.cgr.demo.service;

import com.cgr.demo.bean.Result;
import com.cgr.demo.bean.User;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/24 0024 下午 8:25
 * description:
 */
public interface UserService {
    Result Users(User user);
    Result user(User user);
    Result selectuser(User user);
    Result selectuserbyname(User user);
    Result selectuserbyusername(User user);
    Result ifuser(User user);
    Result insert(User user);
    Result update(User user);
    Result adminUpdate(User user);
    Result updateImg(User user);
    Result delete(User user);
    Result updatePassword(User user);

}
