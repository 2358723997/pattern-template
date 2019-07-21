package com.edu.gupao.vip.pattern.template.jdbc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Member类
 *
 * @author wangjixue
 * @date 2019-07-22 00:09
 */
@Setter
@Getter
public class Member {

    private String userName;
    private String password;
    private int age;

    public Member() {
    }
}
