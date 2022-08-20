package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
/*
    MyBatis面向接口编程的两个一致
    1 映射文件的namespace要和mapper接口的全类名保持一致
    2 映射文件的sql语句的id要和mapper接口中的方法一致
 */
    int insertUser();
    void updateUser();
    void deleteUser();
    User getUserById();

    List<User> queryAllUser();
}
