package com.cn.mapper;

import com.cn.pojo.Job;
import com.cn.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobMapper {
    List<Job> queryJobWithIf(@Param("kind") String kind,
                              @Param("product") Integer product,
                              @Param("property") String property,
                              @Param("adress") String adress);
    List<Job> queryJobWithwhere(@Param("kind") String kind,
                             @Param("product") Integer product,
                             @Param("property") String property,
                             @Param("adress") String adress);
}
