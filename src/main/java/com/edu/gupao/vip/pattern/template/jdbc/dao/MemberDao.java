package com.edu.gupao.vip.pattern.template.jdbc.dao;

import com.edu.gupao.vip.pattern.template.jdbc.JdbcTemplate;
import com.edu.gupao.vip.pattern.template.jdbc.RowMapper;
import com.edu.gupao.vip.pattern.template.jdbc.entity.Member;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

/**
 * MemberDao类
 *
 * @author wangjixue
 * @date 2019-07-22 00:10
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() throws Exception{
        String sql = "select * from user";
        List<?> list = super.executeQuery(sql, new RowMapper<Member>() {

            public Member mapRow(ResultSet resultSet, int rowNum) throws Exception {
                Member member = new Member();
                //字段过多，原型模式
               deepClone(member.getClass(),resultSet);
                return member;
            }

            private void deepClone(Class<?> destClazz, ResultSet resultSet) throws Exception {
                List<Field> destFields =getAllFields(destClazz);
                for (Field destField : destFields) {
                    destField.setAccessible(true);
                    destField.set(Member.class,resultSet.getString(destField.getName()));
                }
            }

            private List<Field> getAllFields(Class<?> destClazz) {
                Field[] fields = destClazz.getDeclaredFields();
                List<Field> fieldList = Arrays.asList(fields);
                if(destClazz.getSuperclass()!=null){
                    List<Field> allFields = getAllFields(destClazz.getSuperclass());
                    fieldList.addAll(allFields);
                }
                return fieldList;
            }
        }, null);
        return list;
    }
}
