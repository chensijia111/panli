package com.cn.mapper;

import com.cn.pojo.Province;

public interface ProvinceMapper {
    // 依据id查询省份方式1
    Province findProvinceById1(Integer id);
    // 依据id查询省份方式2
    Province findProvinceById2(Integer id);
    Province findProvinceById3(Integer id);
}
