package com.cn;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.cn.mpg.entity.Doctor;
import com.cn.mpg.mapper.DoctorMapper;
import com.cn.mpg.service.IDoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class MyBatisMpGeneratorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testMybatisPlusGenerator() {
        // 数据库地址
        String url = "jdbc:mysql://localhost:3306/mybatisplusdb?characterEncoding=utf-8&userSSL=false";
        // 连接数据库所需的用户名
        String username = "root";
        // 连接数据库所需的密码
        String password = "root";
        // 数据表名称
        String tableName = "t_doctor";
        // 作者
        String author = "谷哥的小弟";
        // 获取项目路径
        String projectDir = System.getProperty("user.dir");
        // 代码生成路径
        String outputDir = projectDir+"/src/main/java/";
        // 设置父包名
        String parent = "com.cn";
        // 设置模块名
        String moduleName = "mpg";
        // 映射文件生成路径
        String xmlPath = projectDir + "/src/main/resources/mapper/";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author(author)
                            // 开启 swagger 模式
                            //.enableSwagger()
                            // 覆盖已生成文件
                            .fileOverride()
                            // 指定输出目录
                            .outputDir(outputDir);
                })
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent(parent)
                            // 设置父包模块名
                            .moduleName(moduleName)
                            // 设置映射文件生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, xmlPath));
                })
                .strategyConfig(builder -> {
                    // 设置数据表名称
                    builder.addInclude(tableName)
                            // 设置过滤表前缀
                            .addTablePrefix("t_", "c_");
                })
                // 配置Freemarker引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    @Autowired
    private DoctorMapper doctorMapper;

    @Test
    public void testSelectAllDoctor() {
        // 查询所有医生
        List<Doctor> employeeList = doctorMapper.selectList(null);
        // 遍历打印所有医生
        for(Doctor doctor:employeeList){
            System.out.println(doctor);
        }
    }

    @Autowired
    private IDoctorService doctorService;
    @Test
    public void testSelectDoctorByID() {
        // 医生id
        String doctorID = "1";
        // 依据id查询医生
        Doctor doctor = doctorService.getById(doctorID);
        // 打印查询结果
        System.out.println(doctor);
    }

}
