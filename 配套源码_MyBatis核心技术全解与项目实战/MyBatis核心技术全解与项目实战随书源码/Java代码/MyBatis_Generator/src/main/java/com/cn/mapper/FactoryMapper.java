package com.cn.mapper;

import com.cn.pojo.Factory;
import com.cn.pojo.FactoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryMapper {
    int countByExample(FactoryExample example);

    int deleteByExample(FactoryExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(Factory record);

    int insertSelective(Factory record);

    List<Factory> selectByExample(FactoryExample example);

    Factory selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") Factory record, @Param("example") FactoryExample example);

    int updateByExample(@Param("record") Factory record, @Param("example") FactoryExample example);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);
}