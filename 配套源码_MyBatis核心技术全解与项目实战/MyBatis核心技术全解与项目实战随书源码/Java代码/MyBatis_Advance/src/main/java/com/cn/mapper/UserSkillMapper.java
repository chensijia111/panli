package com.cn.mapper;

import com.cn.pojo.User;

public interface UserSkillMapper {
    // 插入用户并获取自增长的ID(方式一)
    int insertUserGetID1(User user);
    // 插入用户并获取自增长的ID(方式二)
    int insertUserGetID2(User user);
    // 传递表名
    Integer getCount(String tableName);
    // 批量删除
    Integer deleteMore(String ids);
}


