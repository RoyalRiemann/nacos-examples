package com.alibaba.nacos.example.spring.boot.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.convert.NacosConfigConverter;
import com.alibaba.nacos.example.spring.boot.content.User;

/**
 * @author ligm
 * @version 1.0
 * @date 2022/2/21 0:21
 */
public class UserConverter implements NacosConfigConverter<User> {

    @Override
    public boolean canConvert(Class<User> targetType) {
        return true;
    }

    @Override
    public User convert(String config) {
        return JSON.parseObject(config, User.class);
    }
}
