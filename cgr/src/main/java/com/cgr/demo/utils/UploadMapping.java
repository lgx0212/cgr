package com.cgr.demo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * projectName: demo
 *
 * @author: 梁贵轩
 * time: 2020/12/31 0031 下午 12:26
 * description:
 */
@Configuration
public class UploadMapping implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upfile/**").addResourceLocations("file:e:/proj_img/");
    }
}
