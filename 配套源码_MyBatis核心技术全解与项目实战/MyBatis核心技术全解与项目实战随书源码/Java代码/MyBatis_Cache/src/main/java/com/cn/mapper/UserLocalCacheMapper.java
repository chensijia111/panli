package com.cn.mapper;
//一级缓存,系统更新自己会带

import com.cn.pojo.User;

import java.util.List;

public interface UserLocalCacheMapper {
    // 依据id查询用户
    User queryUserById(int id);
    // 更新用户
    int updateUser(User user);
}
