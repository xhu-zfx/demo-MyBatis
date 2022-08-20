package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class SQLMapperTest {
    @Test
    public void testSQLMapperByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> a = mapper.getUserByLike("a");
        System.out.println(a);
    }
    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.deleteMore("1,2,4"));

    }
    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        System.out.println(mapper.getUserByTableName("t_user"));

    }
    @Test
    public void testJDBC() throws Exception {
        Class.forName("");
        Connection connection = DriverManager.getConnection("","","");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        preparedStatement.getGeneratedKeys();
    }
    @Test
    public void testInserUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "王五", "123", 23, "女", "123@163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
