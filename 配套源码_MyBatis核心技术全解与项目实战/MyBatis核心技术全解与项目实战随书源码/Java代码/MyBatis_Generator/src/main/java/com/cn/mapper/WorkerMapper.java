package com.cn.mapper;

import com.cn.pojo.Worker;
import com.cn.pojo.WorkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkerMapper {
    int countByExample(WorkerExample example);

    int deleteByExample(WorkerExample example);

    int deleteByPrimaryKey(Integer wId);

    int insert(Worker record);

    int insertSelective(Worker record);

    List<Worker> selectByExample(WorkerExample example);

    Worker selectByPrimaryKey(Integer wId);

    int updateByExampleSelective(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByExample(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
}