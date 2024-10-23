package com.cn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.pojo.Engineer;
import com.cn.service.EngineerService;
import com.cn.mapper.EngineerMapper;
import org.springframework.stereotype.Service;

/**
* @author yy
* @description 针对表【t_engineer】的数据库操作Service实现
* @createDate 2023-01-30 20:47:07
*/
@Service
public class EngineerServiceImpl extends ServiceImpl<EngineerMapper, Engineer>
    implements EngineerService{

}




