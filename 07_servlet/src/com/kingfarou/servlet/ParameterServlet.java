package com.kingfarou.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //不要直接访问这个servlet，要通过form.html来跳转
        req.setCharacterEncoding("UTF-8");
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码->" + req.getParameter("password"));
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println("兴趣爱好：" + Arrays.asList(hobbys));
    }
}
