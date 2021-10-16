package com.kingfarou.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        if(username == null || "".equals(username)){
            System.out.println("servlet2审核不通过：缺少参数");
            return;
        }

        String key = (String)req.getAttribute("key");
        if(key == null || "".equals(key)){
            System.out.println("servlet2审核不通过：缺少servlet认证");
            return;
        }

        System.out.println("servlet2审核通过，servlet1认证内容：" + key);
    }
}
