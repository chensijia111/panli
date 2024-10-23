package com.cn.mapper;

import com.cn.pojo.Province;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ProvinceMapper {
    // 依据id查询省份
    @Select("select * from province where p_id = #{id}")
    @Results({
            @Result(id = true,column = "p_id",property = "pId"),
            @Result(column = "p_name",property = "pName"),
            @Result(column = "p_id",property = "cityList",
                    many = @Many(select = "com.cn.mapper.CityMapper.findCityByProvinceId"))
    })
    Province findProvinceById(Integer id);
}
