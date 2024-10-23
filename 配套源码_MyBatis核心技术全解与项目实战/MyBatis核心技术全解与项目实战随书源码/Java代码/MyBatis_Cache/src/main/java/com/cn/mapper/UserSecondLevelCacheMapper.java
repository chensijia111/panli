package com.cn.mapper;
//二级缓存
import com.cn.pojo.User;

public interface UserSecondLevelCacheMapper {
    // 依据id查询用户
    User queryUserById(int id);
    // 更新用户
    int updateUser(User user);
}
