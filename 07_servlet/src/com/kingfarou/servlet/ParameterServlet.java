package com.kingfarou.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码->" + req.getParameter("password"));
        String[] hobbys = req.getParameterValues("hobby");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hobbys[0]);
        for(int i = 1; i < hobbys.length; i++){
            stringBuilder.append("、");
            stringBuilder.append(hobbys[i]);
        }
        System.out.println("兴趣爱好：" + stringBuilder.toString());
    }
}
