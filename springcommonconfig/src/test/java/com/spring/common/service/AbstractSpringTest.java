package com.spring.common.service;

import com.alibaba.fastjson.JSON;
import com.spring.common.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-11-08 20:49
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AbstractSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    private UserService userService;

    @Test
    public void test() {
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
        logger.info(JSON.toJSON(uSel));
    }
}
