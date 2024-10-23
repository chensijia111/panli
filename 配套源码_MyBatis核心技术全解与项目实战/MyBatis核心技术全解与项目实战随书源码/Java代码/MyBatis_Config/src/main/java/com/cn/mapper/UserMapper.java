package com.cn.mapper;

import com.cn.pojo.User;

import java.util.List;

public interface UserMapper {
    // 依据id查询用户
    User queryUserById(int id);
    // 查询所有用户
    List<User> queryAllUser();
    // 插入用户
    int insertUser(User user);
    // 更新用户
    int updateUser(User user);
    // 删除用户
    int deleteUserById(Integer id);
    // 插入用户并获取自增长的ID(方式一)
    int insertUserGetID1(User user);
    // 插入用户并获取自增长的ID(方式二)
    int insertUserGetID2(User user);
}
