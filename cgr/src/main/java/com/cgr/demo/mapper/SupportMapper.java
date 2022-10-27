package com.cgr.demo.mapper;
import com.cgr.demo.bean.Support;

import java.util.List;

/**
 * projectName: cgr
 *
 * @author: 梁贵轩
 * time: 2021/4/19 0019 下午 4:19
 * description:
 */
public interface SupportMapper {
    List<Support> supportMy(Support support);
    List<Support> selectIfSupport(Support support);
    List<Support> countSupport(Support support);
    List<Support> selectSupportNum(Support support);
    int insertSupport(Support support);
    int deleteSupport(Support support);

}
