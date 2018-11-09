package com.spring.common.service;


import com.alibaba.fastjson.JSON;
import com.spring.common.entity.User;
import org.slf4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-11-08 20:27
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-mybatis.xml"})
public class UserServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Resource
    private UserService userService;

    @Test
    public void test() {
        User user = new User();
        user.setId(3);
        user.setUserName("Jack");
        user.setPassword("000000");
        user.setAge(20);
        //测试插入
        int insert = userService.insert(user);
        Assert.assertEquals(1, insert);
        //测试查询
        User uSel = userService.getUserByID(3);
        Assert.assertEquals("000000", uSel.getPassword());
        logger.info("usel {}",JSON.toJSON(uSel));
    }

    @Test
    public void testMock() {
        //TODO: 希望能用下mock 远程接口 或者内部的远程接口
        User user = new User();
        user.setId(2);
        user.setUserName("Tom");
        user.setPassword("000000");
        user.setAge(20);
        //测试插入
        int insert = userService.insert(user);
        Assert.assertEquals(1, insert);
        //测试查询
        User uSel = userService.getUserByID(1);
        Assert.assertEquals("000000", uSel.getPassword());
        logger.info("usel {}",JSON.toJSON(uSel));
    }

}
