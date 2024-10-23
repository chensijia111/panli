package com.cn.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mapper.MouseMapper;
import com.cn.pojo.Mouse;
import com.cn.service.MouseService;
import org.springframework.stereotype.Service;

@Service
@DS("slave2")
public class MouseServiceImpl extends ServiceImpl<MouseMapper, Mouse> implements MouseService {

}
