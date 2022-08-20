package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
//    查询
    List<User> getAllUser();
//    条件查询
    User getUserByUsername(String username);
//    验证登录
    User checkLogin(String Username,String password);
//    验证登录 参数为map
    User checkLoginByMap(Map<String,Object> map);
//    添加用户信息
    int insertUser(User user);
//    验证登录
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
