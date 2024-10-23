package com.cn.mapper;

import com.cn.pojo.Engineer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author yy
* @description 针对表【t_engineer】的数据库操作Mapper
* @createDate 2023-01-30 20:47:07
* @Entity com.cn.pojo.Engineer
*/
@Repository
public interface EngineerMapper extends BaseMapper<Engineer> {
    List<Engineer> queryByAge(@Param("age") Integer age);
}




