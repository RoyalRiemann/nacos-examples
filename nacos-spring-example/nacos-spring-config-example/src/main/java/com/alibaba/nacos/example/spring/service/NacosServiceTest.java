package com.alibaba.nacos.example.spring.service;

import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import org.junit.Test;

/**
 * @author ligm
 * @version 1.0
 * @date 2022/2/20 21:56
 */
public class NacosServiceTest {

    @Test
    public void testService() throws Exception {
        NamingService naming = NamingFactory.createNamingService("127.0.0.1:8488");
        naming.registerInstance("nacos.test.3", "11.11.11.11", 8888, "TEST1");
    }

}
