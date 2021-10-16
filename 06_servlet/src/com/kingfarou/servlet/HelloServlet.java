package com.kingfarou.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("执行构造方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet别名：" + servletConfig.getServletName());
        System.out.println("username：" + servletConfig.getInitParameter("username"));
        System.out.println("数据库url：" + servletConfig.getInitParameter("url"));
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String method = httpServletRequest.getMethod();
        if("GET".equals(method)){
            doGet(servletRequest, servletResponse);
        } else if("POST".equals(method)){
            doPost(servletRequest, servletResponse);
        }
    }

    private void doGet(ServletRequest servletRequest, ServletResponse servletResponse){

    }

    private void doPost(ServletRequest servletRequest, ServletResponse servletResponse){

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
