package com.cn.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mapper.DiskMapper;
import com.cn.pojo.Disk;
import com.cn.service.DiskService;
import org.springframework.stereotype.Service;

@Service
@DS("slave1")
public class DiskServiceImpl extends ServiceImpl<DiskMapper, Disk> implements DiskService {

}
