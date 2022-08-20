package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testMybatis() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
//        自动提交事务
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        int result=userMapper.insertUser();
//        手动提交事务
//        sqlSession.commit();
        System.out.println(result);
    }
    @Test
    public void testUpdate() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser();
    }
    @Test
    public void testDelete() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
    }
    @Test
    public void testCRUD() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //System.out.println(userMapper.getUserById());
        List<User> list=userMapper.queryAllUser();
        list.forEach(user -> System.out.println(user));
    }
}
