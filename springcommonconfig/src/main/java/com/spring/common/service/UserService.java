package com.spring.common.service;

import com.spring.common.entity.User;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-11-08 20:19
 **/
public interface UserService {
    User getUserByID(int id);

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
