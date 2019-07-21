package com.edu.gupao.vip.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JdbcTemplate类
 *
 * @author wangjixue
 * @date 2019-07-21 23:19
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate() {
    }

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) throws Exception {
        // 1. 获取连接
        Connection conn = this.getConnection();
        // 2. 创建语句集
        PreparedStatement ps = this.createPrepareStatement(conn, sql);
        // 3. 执行语句集
        ResultSet rs = this.executeQuery(ps, values);
        // 4. 处理结果集
        List<?> result = this.paresResultSet(rs, rowMapper);
        // 5. 关闭结果集
        this.closeResultSet(rs);
        // 6. 关闭语句集
        this.closePrepareStatement(ps);
        // 7. 关闭连接
        this.closeConnection(conn);
        return result;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePrepareStatement(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<?> paresResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> list = new ArrayList();
        int rowNum = 1;
        while (rs.next()) {
            list.add(rowMapper.mapRow(rs, rowNum++));
        }

        return list;
    }


    private PreparedStatement createPrepareStatement(Connection con, String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    private Connection getConnection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet executeQuery(PreparedStatement ps, Object[] values) {
        ResultSet resultSet = null;
        try {
            for (int i = 0; i < values.length; i++) {

                ps.setObject(i, values[i]);
            }
            resultSet = ps.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;

    }
}
