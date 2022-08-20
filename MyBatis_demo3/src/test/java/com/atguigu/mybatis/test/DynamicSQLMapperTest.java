package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        List<Emp> list = sqlSession.getMapper(DynamicSQLMapper.class).
                getEmpByCondition(new Emp(null, "张三", 23, "", ""));
        System.out.println(list);
    }
    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        List<Emp> list = sqlSession.getMapper(DynamicSQLMapper.class).
                getEmpByChoose(new Emp(null, "", null,null , ""));
        System.out.println(list);
    }
    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        int i = sqlSession.getMapper(DynamicSQLMapper.class).deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(i);
    }
    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        List<Emp> list = Arrays.asList(
                new Emp(null, "a", 23, "男", "123@qq.com"),
                new Emp(null, "a", 23, "男", "123@qq.com"),
                new Emp(null, "a", 23, "男", "123@qq.com"));
        System.out.println(sqlSession.getMapper(DynamicSQLMapper.class).insertMoreByList(list));;
    }
}
