package com.kingfarou.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求重定向，旧地址
 */
public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response1收到了请求，需要重定向到response2");
        //方案一
//        resp.setStatus(302);
//        resp.setHeader("Location", "http://localhost:8080/07_servlet/response2");

        //方案二
        resp.sendRedirect("/07_servlet/response2");
    }
}
