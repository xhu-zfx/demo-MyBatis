package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {
    @Test
    public void getAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        List<Emp> list = sqlSession.getMapper(EmpMapper.class).getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }
    @Test
    public void getEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Emp emp = sqlSession.getMapper(EmpMapper.class).getEmpAndDept(1);
        System.out.println(emp);
    }
    @Test
    public void getEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Emp emp = sqlSession.getMapper(EmpMapper.class).getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpName());
        System.out.println("++++++++++++++++++++++");
        System.out.println(emp.getDept());
    }
    @Test
    public void getDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Dept dept = sqlSession.getMapper(DeptMapper.class).getDeptAndEmp(1);
        System.out.println(dept);
    }
    @Test
    public void getDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Dept dept = sqlSession.getMapper(DeptMapper.class).getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }
}
