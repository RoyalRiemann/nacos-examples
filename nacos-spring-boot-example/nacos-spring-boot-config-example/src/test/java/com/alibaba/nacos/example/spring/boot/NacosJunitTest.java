package com.alibaba.nacos.example.spring.boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.example.spring.boot.content.User;
import com.alibaba.nacos.example.spring.boot.controller.ConfigController;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ligm
 * @version 1.0
 * @date 2022/2/20 23:44
 */
@SpringBootTest()
@RunWith(value = SpringRunner.class)
public class NacosJunitTest {

    @NacosInjected
    ConfigService configService;

    @Autowired
    ConfigController configController;

    @Test
    public void testConfig() throws Exception {
        final String dataId = "example";
        final String group = "example";
        int i = 0;
        configService.addListener(dataId, group, new AbstractListener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println(">>>>>>>>addListener received:" + configInfo);
            }
        });

        while (true) {
            try {
                i++;
                Thread.sleep(5000);
                configService.publishConfig(dataId, group, "This is " + i + " times changed");
            } catch (Exception e) {

            }
        }
    }

    @Test
    public void testConverter() throws Exception {
        final String dataId = "example";
        final String group = "example";
        User user = new User();
        user.setName("zhangsan");
        user.setAge(27);
        configService.publishConfig(dataId, group, JSON.toJSONString(user));

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
        }
    }
}
