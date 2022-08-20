package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {
//    模糊查询
    List<User> getUserByLike(@Param("username") String username);
//    批量删除
    int deleteMore(@Param("ids") String ids);
    List<User> getUserByTableName(@Param("tableName") String tableName);
    int insertUser(User user);
}
