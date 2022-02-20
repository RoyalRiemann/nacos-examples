package com.alibaba.nacos.example.spring.boot.controller;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.example.spring.boot.content.User;
import com.alibaba.nacos.example.spring.boot.converter.UserConverter;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
@NacosPropertySource(dataId = "example",groupId = "example",autoRefreshed = true)
public class ConfigController {

    @NacosValue(value = "${appKeys:wx202202020202}", autoRefreshed = true)
    private String appKeys;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return appKeys;
    }

    @NacosConfigListener(dataId = "example",groupId = "example",converter = UserConverter.class)
    public void onEvent(User user){
        System.out.println(">>>>>>>>received:"+user);
    }
}