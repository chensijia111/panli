package com.cn.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.mapper.PersonMapper;
import com.cn.pojo.Person;
import com.cn.service.PersonService;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
