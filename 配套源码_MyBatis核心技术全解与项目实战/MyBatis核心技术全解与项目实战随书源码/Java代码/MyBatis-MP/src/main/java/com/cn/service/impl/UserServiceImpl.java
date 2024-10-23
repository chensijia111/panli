package com.cn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mapper.UserMapper;
import com.cn.pojo.User;
import com.cn.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

