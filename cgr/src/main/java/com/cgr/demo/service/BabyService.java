package com.cgr.demo.service;

import com.cgr.demo.bean.Baby;
import com.cgr.demo.bean.Result;
import com.cgr.demo.bean.User;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/3/25 0025 下午 11:32
 * description:
 */
public interface BabyService {
    Result baby(Baby baby);
    Result selectbaby(Baby baby);
    Result checkedbaby(Baby baby);
    Result selectbabyItem(Baby baby);
    Result insert(Baby baby);
    Result insertImg(Baby baby);
    Result update(Baby baby);
    Result updateimg(Baby baby);
    Result updatebackImg(Baby baby);
    Result updateName(Baby baby);
    Result defaultbabychecked(Baby baby);
    Result updateChecked(Baby baby);
    Result delete(Baby baby);
}
