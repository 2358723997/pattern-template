package com.edu.gupao.vip.pattern.template.jdbc;

import java.sql.ResultSet;

/**
 * RowMapper接口
 *
 * ORM映射定制化的接口
 *
 * @author wangjixue
 * @date 2019-07-21 23:16
 */
public interface RowMapper<T> {

    T mapRow (ResultSet resultSet, int rowNum) throws Exception;
}
