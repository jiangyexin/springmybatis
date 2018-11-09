package com.spring.common.entity;

import lombok.Data;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-11-08 17:49
 **/
@Data
public class User {
    private Integer id;

    private String userName;

    private String password;

    private Integer age;
}
