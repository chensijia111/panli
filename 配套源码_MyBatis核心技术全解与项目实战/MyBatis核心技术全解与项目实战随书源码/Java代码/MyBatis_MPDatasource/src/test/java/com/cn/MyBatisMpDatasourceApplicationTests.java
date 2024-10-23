package com.cn;

import com.cn.pojo.Disk;
import com.cn.pojo.Mouse;
import com.cn.pojo.Person;
import com.cn.service.DiskService;
import com.cn.service.MouseService;
import com.cn.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisMpDatasourceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private PersonService personService;

    @Autowired
    private DiskService diskService;

    @Autowired
    private MouseService mouseService;

    @Test
    public void testGetAllPerson(){
        // 查询所有Person
        List<Person> personList = personService.list();
        // 遍历打印查询结果
        for(Person person:personList){
            System.out.println(person);
        }
    }

    @Test
    public void testGetAllDisk(){
        // 查询所有Disk
        List<Disk> diskList = diskService.list();
        // 遍历打印查询结果
        for(Disk disk:diskList){
            System.out.println(disk);
        }
    }

    @Test
    public void testGetAllMouse(){
        // 查询所有Mouse
        List<Mouse> mouseList = mouseService.list();
        // 遍历打印查询结果
        for(Mouse mouse:mouseList){
            System.out.println(mouse);
        }
    }

}
