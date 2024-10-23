package com.cn;

import com.cn.mapper.EngineerMapper;
import com.cn.pojo.Engineer;
import com.cn.service.EngineerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class MyBatisMpmbxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EngineerService engineerService;

    @Test
    public void testGetAllEngineer(){
        // 查询所有工程师
        List<Engineer> engineerList = engineerService.list();
        // 遍历打印查询结果
        for(Engineer engineer:engineerList){
            // 获取工程师id
            Long id = engineer.getId();
            // 获取工程师名字
            String name = engineer.getName();
            // 获取工程师性别
            String gender = engineer.getGender();
            // 获取工程师岁数
            Integer age = engineer.getAge();
            // 打印工程师信息
            System.out.println("id="+id+",name="+name+",gender="+gender+",age="+age);
        }
    }

    @Autowired
    private EngineerMapper engineerMapper;

    @Test
    public void testQueryByAge(){
        // 依据年龄查询工程师
        List<Engineer> engineerList = engineerMapper.queryByAge(27);
        // 遍历打印查询结果
        for(Engineer engineer:engineerList){
            // 获取工程师id
            Long id = engineer.getId();
            // 获取工程师名字
            String name = engineer.getName();
            // 获取工程师性别
            String gender = engineer.getGender();
            // 获取工程师岁数
            Integer age = engineer.getAge();
            // 打印工程师信息
            System.out.println("id="+id+",name="+name+",gender="+gender+",age="+age);
        }
    }

}
