package com.atguigu.mybatis.test;

import com.atguigu.mybatis.utils.SqlSessionUtils;
import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }

    /*
    Mybatis 获取参数值的两种方式
    ${} 实质上是 sql拼接 加单引号
    #{} 实质上是 占位符赋值

    */


    @Test
    public void testJDBC() throws Exception {
        String username="admin";
        Class.forName("");
        Connection connection = DriverManager.getConnection("","","");
        PreparedStatement ps = connection.prepareStatement("select * form t_user where username=?");
        ps.setString(1,username);

    }
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin","123456");

        System.out.println(user);
    }
    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");map.put("password","123456");
        User user = mapper.checkLoginByMap(map);

        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        System.out.println(mapper.insertUser(new User(null,"李四","234567",23,"女","435@qq")));
    }
    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin","123456");

        System.out.println(user);
    }
}
