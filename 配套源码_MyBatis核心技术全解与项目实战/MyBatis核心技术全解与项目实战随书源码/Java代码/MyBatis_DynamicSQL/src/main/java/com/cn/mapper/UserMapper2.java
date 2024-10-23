package com.cn.mapper;

import com.cn.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper2 {
    List<User> queryWithIf(@Param("username") String username,
                           @Param("password") String password);
    List<User> queryWithWhere(@Param("username") String username,
                           @Param("password") String password);
    List<User> queryWithChoose(@Param("username") String username,
                           @Param("password") String password);
}
