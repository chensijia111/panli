package com.cn.mapper;
//自定义缓存，第三方
import com.cn.pojo.User;

public interface UserEhCacheMapper {
    // 依据id查询用户
    User queryUserById(int id);
}
