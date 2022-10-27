package com.cgr.demo.mapper;

import com.cgr.demo.bean.User;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/24 0024 下午 8:25
 * description:
 */
public interface UserMapper {
    List<User> User(User user);
    List<User> queryUser(User user);
    List<User> selectUser(User user);
    List<User> adminSelectUserByName(User user);
    List<User> adminSelectUserByUsername(User user);
    List<User> ifUser(User user);
    int insertUser(User user);
    int updateUser(User user);
    int adminUpdateUser(User user);
    int updateUserImg(User user);
    int deleteUser(User user);
    int updateUserPassword(User user);
}
