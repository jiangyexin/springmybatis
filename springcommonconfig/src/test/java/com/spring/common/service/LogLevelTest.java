package com.spring.common.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-11-09 10:49
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-mybatis.xml"})
public class LogLevelTest {
    private static final Logger logger = LoggerFactory.getLogger(LogLevelTest.class);

    @Test
    public void testLogLevel() {
        //输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL
        logger.debug("log debug");
        logger.info("log info");
        logger.warn("log warn");
        logger.error("log error");
    }
}
