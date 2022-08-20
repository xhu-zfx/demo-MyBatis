package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
//分步查询第二步 根据did查询员工对应部门
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

//    获取部门以及部门中所有员工信息
    Dept getDeptAndEmp(@Param("did") Integer did);
//    通过分步查询查询部门以及部门中所有的员工信息
//    分步查询第一步 查询部门信息
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
