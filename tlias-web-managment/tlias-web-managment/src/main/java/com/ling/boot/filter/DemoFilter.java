package com.ling.boot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("demo 拦截到了请求 ... 放行前");
        //放行
        chain.doFilter(request,response);
        System.out.println("demo 拦截到了请求 ... 放行后");
    }

    @Override
    public void destroy() {
        System.out.println("demo destroy 销毁方法");
    }
}
