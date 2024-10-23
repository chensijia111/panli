package com.cn.mapper;

import com.cn.pojo.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CityMapper {
    // 依据省份id查询城市
    @Select("select * from city where p_id = #{id}")
    List<City> findCityByProvinceId(Integer id);
}
