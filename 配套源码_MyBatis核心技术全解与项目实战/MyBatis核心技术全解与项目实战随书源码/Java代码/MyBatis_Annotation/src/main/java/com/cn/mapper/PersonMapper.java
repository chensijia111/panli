package com.cn.mapper;

import com.cn.pojo.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    // 依据id查询人
    @Select("select * from person where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "mark",property = "card",
                    one = @One(select = "com.cn.mapper.CardMapper.findCardById"))
    })
    Person findPersonById(Integer id);
}
