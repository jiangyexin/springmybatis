package com.spring.common.dao;

import com.spring.common.entity.User;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-11-08 17:46
 **/
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
