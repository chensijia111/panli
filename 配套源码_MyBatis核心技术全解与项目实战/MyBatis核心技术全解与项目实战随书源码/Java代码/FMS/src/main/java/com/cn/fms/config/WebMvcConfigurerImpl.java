package com.cn.fms.config;

import com.cn.fms.interceptor.LoginHandlerInterceptorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

    // 配置项目启动后默认打开的页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    // 配置登录拦截器
    @Bean
    public LoginHandlerInterceptorImpl getInterceptor(){
        return new LoginHandlerInterceptorImpl();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 需要拦截的路径，即必须登录后才可访问的路径
        String[] addPathPatterns = {"/**"};

        // 排除拦截的路径，即不必登录亦可访问
        String[] excludePathPatterns = {"/static/summernote/**","/static/Bootstrap/**","/static/css/**","/static/fonts/**","/static/images/**","/static/js/**","/static/resources/upload/**"};

        InterceptorRegistration interceptorRegistration = registry.addInterceptor(getInterceptor());
        interceptorRegistration.addPathPatterns(addPathPatterns);
        interceptorRegistration.excludePathPatterns(excludePathPatterns);
    }

    // 配置资源映射，防止图片上传后不可及时更新
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadAbsolutePath = "E:\\Dropbox\\phoenix\\monograph\\FMS\\src\\main\\resources\\static\\upload\\";
        String resourceLocations = "file:"+uploadAbsolutePath;
        String uploadPath = "/static/upload/**";
        registry.addResourceHandler(uploadPath).addResourceLocations(resourceLocations);
    }
}
