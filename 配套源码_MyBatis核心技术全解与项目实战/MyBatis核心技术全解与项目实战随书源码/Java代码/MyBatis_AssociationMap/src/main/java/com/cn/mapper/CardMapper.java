package com.cn.mapper;

import com.cn.pojo.Card;

public interface CardMapper {
    // 依据id查询身份证
    Card findCardById(Integer id);
}
