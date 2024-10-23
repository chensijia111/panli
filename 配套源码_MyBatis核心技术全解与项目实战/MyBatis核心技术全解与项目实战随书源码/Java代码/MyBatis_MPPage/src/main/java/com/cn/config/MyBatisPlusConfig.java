package com.cn.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        // 创建拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 创建分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 添加分页插件
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        // 创建乐观锁插件
        OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor = new OptimisticLockerInnerInterceptor();
        // 添加乐观锁
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor);
        return interceptor;
    }
}

