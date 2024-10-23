package com.cn.mapper;

import java.util.List;
import java.util.Map;

import com.cn.pojo.User;
import org.apache.ibatis.annotations.MapKey;

public interface UserQueryMapper {
    // 依据id查询用户
    User queryUserById(Integer id);
    // 查询所有用户
    List<User> queryAllUser();
    // 获取用户数量
    Integer getUserCount();
    // 依据id查询用户并将员工信息封装至Map
    Map<String, Object> queryUserMapById(Integer id);
    // 查询所有用户并将每个用户均存放于同一个Map
    @MapKey("id")
    Map<Integer, Object> queryAllUserMap();
    // 模糊查询
    List<User> queryUsersByLike(String username);
}


