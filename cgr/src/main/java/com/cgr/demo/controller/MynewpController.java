package com.cgr.demo.controller;

import com.cgr.demo.bean.Mynew;
import com.cgr.demo.bean.Mynew_p;
import com.cgr.demo.bean.Result;
import com.cgr.demo.service.MynewService;
import com.cgr.demo.service.MynewpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * time: 2021/4/5 0005 下午 5:13
 * description:
 */
@RequestMapping("mynewp")
@RestController
public class MynewpController {
    @Resource
    private MynewpService mynewpService;

    @GetMapping("selectmynewp")
    public Result selectMynewp(Mynew_p mynew_p){
        Result result = mynewpService.selectmynewp(mynew_p);
        return result;
    }
    @GetMapping("selectbabymynewp")
    public Result selectBabyMynewp(Mynew_p mynew_p){
        Result result = mynewpService.selectbabymynewp(mynew_p);
        return result;
    }
    @GetMapping("selectmynewpbyid")
    public Result selectMynewpById(Mynew_p mynew_p){
        Result result = mynewpService.selectMynewpbyid(mynew_p);
        return result;
    }
    @GetMapping("deletebabymynewp")
    public Result deleteBabyMynewp(Mynew_p mynew_p){
        Result result = mynewpService.deletemynewp(mynew_p);
        return result;
    }
    @RequestMapping("insert")
    public Result insert(Mynew_p mynew_p, MultipartFile file){
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
        mynew_p.setMynewpimg(imgFile);
        Result result = mynewpService.mynewp(mynew_p);
        return result;
    }
}
