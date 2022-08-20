package com.atguigu.mybatis.mapper;



import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    //    查询所有的员工信息

    List<Emp> getAllEmp();
    Emp getEmpAndDept(@Param("eid") Integer eid);
//    分步查询
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);
    //    通过分步查询查询部门以及部门中所有的员工信息
//    分步查询第二步 根据did查询员工信息
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
