package com.cgr.demo.bean;

import com.cgr.demo.utils.Constants;

/**
 * projectName: jxc
 *
 * @author: 梁贵轩
 * time: 2020/11/24 0024 上午 10:41
 * description:
 */
public class Result {
    /**
     * 状态码
     */
    private int ret = Constants.RET_FAIL;
    /**
     * 返回提示信息
    */
    private String mag;
    /**
     * 返回对象数据
     */
    private Object data = null;

    public Result(int ret, String mag, Object data) {
        this.ret = ret;
        this.mag = mag;
        this.data = data;
    }

    public static Result OK(){
        return new Result(Constants.RET_OK,null,null);
    }
    public static Result OK(String msg){
        return new Result(Constants.RET_OK,msg,null);
    }
    public static Result OK(Object data){
        return new Result(Constants.RET_OK,null,data);
    }
    public static Result OK(String msg,Object data){
        return new Result(Constants.RET_OK,msg,data);
    }

    public static Result FILE(){
        return new Result(Constants.RET_FAIL,null,null);
    }
    public static Result FILE(String msg){
        return new Result(Constants.RET_FAIL,msg,null);
    }
    public static Result FILE(Object data){
        return new Result(Constants.RET_FAIL,null,data);
    }
    public static Result FILE(String msg,Object data){
        return new Result(Constants.RET_FAIL,msg,data);
    }



    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
