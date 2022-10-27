package com.cgr.demo.service.impl;

import com.cgr.demo.bean.Result;
import com.cgr.demo.bean.User;
import com.cgr.demo.mapper.UserMapper;
import com.cgr.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/24 0024 下午 8:27
 * description:
 */
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result Users(User user) {
        List<User> users = userMapper.User(user);
        if (users != null && users.size() > 0) {
            return Result.OK(users);
        }
        return Result.FILE();
    }

    @Override
    public Result user(User user) {
        List<User> users = userMapper.queryUser(user);
        if (users != null && users.size() > 0) {
            return Result.OK(users);
        }
        return Result.FILE();
    }

    @Override
    public Result selectuser(User user) {
        List<User> users = userMapper.selectUser(user);
        if (users != null && users.size() > 0) {
            return Result.OK(users);
        }
        return Result.FILE();
    }

    @Override
    public Result selectuserbyname(User user) {
        List<User> users = userMapper.adminSelectUserByName(user);
        if (users != null && users.size() > 0) {
            return Result.OK(users);
        }
        return Result.FILE();
    }

    @Override
    public Result selectuserbyusername(User user) {
        List<User> users = userMapper.adminSelectUserByUsername(user);
        if (users != null && users.size() > 0) {
            return Result.OK(users);
        }
        return Result.FILE();
    }

    @Override
    public Result ifuser(User user) {
        List<User> users = userMapper.ifUser(user);
        if (users != null && users.size() > 0) {
            return Result.OK(users);
        }
        return Result.FILE();
    }

    @Override
    public Result insert(User user) {
        int row = userMapper.insertUser(user);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result update(User user) {
        int row = userMapper.updateUser(user);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result adminUpdate(User user) {
        int row = userMapper.adminUpdateUser(user);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result updateImg(User user) {
        int row = userMapper.updateUserImg(user);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result delete(User user) {
        int row = userMapper.deleteUser(user);
        if(row>0){
            return  Result.OK();
        }
        return Result.FILE();
    }

    @Override
    public Result updatePassword(User user) {
        int row = userMapper.updateUserPassword(user);
        if(row>0){
            return Result.OK();
        }
        return Result.FILE();
    }
}
