package com.cn.mapper;

import com.cn.pojo.Customer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CustomerMapper {
    // 查询客户
    @Select("select * from customer where c_id = #{id}")
    Customer queryCustomerById(Integer id);

    // 插入客户
    @Insert("insert into customer(c_name,c_age) values (#{cName},#{cAge})")
    int insertCustomer(Customer customer);

    // 更新客户
    @Update("update customer set c_name=#{cName},c_age=#{cAge} where c_id=#{cId}")
    int updateCustomer(Customer customer);

    // 删除客户
    @Delete("delete from customer where c_id=#{id}")
    int deleteCustomerById(Integer id);
}
