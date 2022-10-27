package com.cgr.demo.controller;

import com.cgr.demo.bean.Result;
import com.cgr.demo.bean.User;
import com.cgr.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/24 0024 下午 8:30
 * description:
 */
@RequestMapping("users")
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("allusers")
    public Result allUser(User user){
        Result result = userService.Users(user);
        return result;
    }
    @GetMapping("users")
    public Result User(User user){
        Result result = userService.user(user);
        return result;
    }
    @GetMapping("selectusers")
    public Result selectUser(User user){
        Result result = userService.selectuser(user);
        return result;
    }
    @GetMapping("selectusersbyname")
    public Result selectUserByName(User user){
        Result result = userService.selectuserbyname(user);
        return result;
    }
    @GetMapping("selectusersbyusername")
    public Result selectUserByUsername(User user){
        Result result = userService.selectuserbyusername(user);
        return result;
    }
    @GetMapping("ifusers")
    public Result ifUser(User user){
        Result result = userService.ifuser(user);
        return result;
    }
    @GetMapping("insert")
    public Result insert(User user){
        Result result = userService.insert(user);
        return result;
    }
    @GetMapping("update")
    public Result update(User user){
        Result result = userService.update(user);
        return result;
    }
    @GetMapping("adminupdate")
    public Result adminUpdate(User user){
        Result result = userService.adminUpdate(user);
        return result;
    }
    @RequestMapping("updateimg")
    public Result updateImg(User user, MultipartFile file){
        String imgFile = null;
        if(file.isEmpty()){
            imgFile="/img/123.jpg";
        }else {
            String newFile = UUID.randomUUID()+"-"+file.getOriginalFilename();
            File f = new File("e:/proj_img" , newFile);
            if(!f.getParentFile().exists()){
                f.mkdirs() ;
            }
            try {
                file.transferTo(f);
                imgFile="/upfile/"+newFile;
            }
            catch (IOException e){
                e. printStackTrace();
            }
        }
        user.setUserimg(imgFile);
        Result result = userService.updateImg(user);
        return result;
    }
    @GetMapping("delete")
    public Result delete(User user){
        Result result = userService.delete(user);
        return result;
    }
    @GetMapping("updatepassword")
    public Result updatepassword(User user){
        Result result = userService.updatePassword(user);
        return result;
    }
}
