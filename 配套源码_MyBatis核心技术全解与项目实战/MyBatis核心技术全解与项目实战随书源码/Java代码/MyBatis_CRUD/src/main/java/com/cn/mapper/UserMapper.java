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
}
