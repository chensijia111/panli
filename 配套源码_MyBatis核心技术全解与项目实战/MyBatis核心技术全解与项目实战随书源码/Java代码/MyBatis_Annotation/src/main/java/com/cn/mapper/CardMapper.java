package com.cn.mapper;

import com.cn.pojo.Card;
import org.apache.ibatis.annotations.Select;

public interface CardMapper {
    // 依据id查询身份证
    @Select("select * from card where id = #{id}")
    Card findCardById(Integer id);
}
