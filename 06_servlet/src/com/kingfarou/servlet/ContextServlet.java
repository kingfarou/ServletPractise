package com.kingfarou.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println("context的username->" + servletContext.getInitParameter("username"));
        System.out.println("context的password->" + servletContext.getInitParameter("password"));

        System.out.println("工程路径：" + servletContext.getContextPath());

        System.out.println("工程部署在服务器的绝对路径：" + servletContext.getRealPath("/"));
    }
}
