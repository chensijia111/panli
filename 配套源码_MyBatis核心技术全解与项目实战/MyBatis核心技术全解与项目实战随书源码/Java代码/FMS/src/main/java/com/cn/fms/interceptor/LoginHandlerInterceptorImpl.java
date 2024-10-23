package com.cn.fms.interceptor;


import com.cn.fms.pojo.Employee;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * 1、不拦截登录请求login
 * 2、拦截登录以外的所有请求
 * (1)、判断Session中是否有用户;若有则返回true表示放行
 * (2)、判断Session中是否有用户;若没有则返回false表示拦截并转发到登录页面
 */
public class LoginHandlerInterceptorImpl implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求URL
        String url = request.getRequestURI();
        // 假若执行登录则放行
        boolean flag = url.indexOf("login") >= 0 || url.endsWith("/");
        if (flag) {
            return true;
        }
        // 获取Session
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        // 判断Session中是否有用户;若有则返回true表示放行
        if (employee != null) {
            return true;
        }
        // 判断Session中是否有用户;表示拦截并转发到登录页面
        request.getSession().setAttribute("msg", "请您先登录！");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
        requestDispatcher.forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
