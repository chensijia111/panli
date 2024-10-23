package com.cn.mapper;

import com.cn.pojo.User;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Repository
public interface UserMapper extends BaseMapper<User> {
    // 依据id查询用户
    User findUserById(Long id);
}
