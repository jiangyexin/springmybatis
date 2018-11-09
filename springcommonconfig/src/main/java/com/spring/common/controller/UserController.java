package com.spring.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.common.entity.User;
import com.spring.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-11-08 21:18
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String toIndex(HttpServletRequest request) {
        Map<String, Object> returnMap = new HashMap<>();
        int userId;
        try {
            userId = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            returnMap.put("message", "参数错误");
            logger.error("参数错误");
            return JSONObject.toJSONString(returnMap);
        }
        User user = userService.getUserByID(userId);
        if (user == null) {
            returnMap.put("message", "没查到");
            logger.info("没有查到");
            return JSONObject.toJSONString(returnMap);
        }
        String retStr = JSONObject.toJSONString(user);
        logger.info(retStr);
        return retStr;
    }
}
