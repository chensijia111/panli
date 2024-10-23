package com.cn.mapper;

import com.cn.pojo.City;
import java.util.List;

public interface CityMapper {
    // 依据省份id查询城市
    List<City> findCityByProvinceId(Integer id);
}
