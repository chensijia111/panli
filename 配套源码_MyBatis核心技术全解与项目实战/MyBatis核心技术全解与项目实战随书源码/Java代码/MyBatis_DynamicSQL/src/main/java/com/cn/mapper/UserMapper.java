package com.cn.mapper;

import com.cn.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 测试动态SQL语句if
    List<User> queryUserWithIf(@Param("username") String username, @Param("password") String password);

    // 测试动态SQL语句where
    List<User> queryUserWithWhere(@Param("username") String username, @Param("password") String password);

    // 测试动态SQL语句choose
    List<User> queryUserWithChoose(@Param("username") String username, @Param("password") String password);

    // 测试动态SQL语句set
    int updateUserWithSet(@Param("user") User user);

    // 测试动态SQL语句trim
    int updateUserWithTrim(User user);

    // 测试动态SQL语句bind
    List<User> queryUserWithBind(@Param("username") String username);

    // 测试foreach遍历List
    List<User> queryUserWithForeach1(@Param("userIDList") List<Integer> userIDList);

    // 测试foreach遍历数组
    List<User> queryUserWithForeach2(@Param("userIDArray") int[] userIDArray);

    // 测试foreach与Map的使用
    List<User> queryUserWithForeach3(@Param("userMap") Map<String ,Object> userMap);

    // 测试include
    List<User> queryUserWithInclude(@Param("username") String username, @Param("password") String password);
}