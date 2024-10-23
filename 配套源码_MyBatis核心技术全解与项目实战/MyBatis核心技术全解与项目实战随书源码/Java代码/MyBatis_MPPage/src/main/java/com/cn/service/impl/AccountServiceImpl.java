package com.cn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mapper.AccountMapper;
import com.cn.pojo.Account;
import com.cn.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
