package com.cn.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cn.pojo.User;

public interface UserParameterMapper {
    // 传递单个普通类型参数
    User queryUserById(Integer id);

    // 传递多个普通类型参数
    List<User> queryUsersByUsernameAndGender(String username, String gender);

    // 结合@Param注解传递多个普通类型参数
    List<User> queryUsersByUsernameOrGender(@Param("username") String u, @Param("gender") String g);

    // 传递单个pojo作为参数
    int insertUser(User user);

    // 传递多个pojo作为参数
    List<User> queryUsersByTwoUser(User firstUser, User secondUser);

    // 结合@Param注解传递多个pojo作为参数
    List<User> queryUsersByTwoUserWithParam(@Param("firstUser")User fu, @Param("secondUser")User su);

    // 传递Map类型参数
    List<User> queryUsersByMap(Map<String, Object> paramMap);

    // 传递List类型参数
    List<User> queryUsersByList(@Param("idList") List<Integer> list);

    // 传递Array类型参数
    List<User> queryUsersByArray(@Param("idArray") int[] array);
}