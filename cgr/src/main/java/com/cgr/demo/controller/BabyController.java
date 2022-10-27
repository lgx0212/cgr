package com.cgr.demo.controller;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.BabyService;
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
 * time: 2021/3/25 0025 下午 11:37
 * description:
 */

@RequestMapping("baby")
@RestController
public class BabyController {
    @Resource
    private BabyService babyService;
    @GetMapping("baby")
    public Result Baby(Baby baby){
        Result result = babyService.baby(baby);
        return result;
    }
    @GetMapping("selectbaby")
    public Result selectBaby(Baby baby){
        Result result = babyService.selectbaby(baby);
        return result;
    }
    @GetMapping("checkedbaby")
    public Result checkedBaby(Baby baby){
        Result result = babyService.checkedbaby(baby);
        return result;
    }
    @GetMapping("selectbabyitem")
    public Result selectBabyItem(Baby baby){
        Result result = babyService.selectbabyItem(baby);
        return result;
    }
    @GetMapping("insert")
    public Result insert(Baby baby){
        Result result = babyService.insert(baby);
        return result;
    }
    @RequestMapping("insertimg")
    public Result insertimg(Baby baby, MultipartFile file){
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
        baby.setBabyimg(imgFile);
        Result result = babyService.insertImg(baby);
        return result;
    }
    @GetMapping("update")
    public Result update(Baby baby){
        Result result = babyService.update(baby);
        return result;
    }
    @RequestMapping("updateimg")
    public Result updateimg(Baby baby, MultipartFile file){
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
        baby.setBabyimg(imgFile);
        Result result = babyService.updateimg(baby);
        return result;
    }
    @RequestMapping("updatebackimg")
    public Result updateBackimg(Baby baby, MultipartFile file){
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
        baby.setBabybackimg(imgFile);
        Result result = babyService.updatebackImg(baby);
        return result;
    }
    @GetMapping("updatename")
    public Result updatename(Baby baby){
        Result result = babyService.updateName(baby);
        return result;
    }
    @GetMapping("defaultbabychecked")
    public Result defaultBabyChecked(Baby baby){
        Result result = babyService.defaultbabychecked(baby);
        return result;
    }
    @GetMapping("updatechecked")
    public Result updatechecked(Baby baby){
        Result result = babyService.updateChecked(baby);
        return result;
    }
    @GetMapping("delete")
    public Result delete(Baby baby){
        Result result = babyService.delete(baby);
        return result;
    }
}
