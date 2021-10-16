package com.kingfarou.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("请求方式->" + req.getMethod());
        //不包括ip、端口号，只从工程名开始的url部分
        System.out.println("uri->" + req.getRequestURI());
        //完整的url
        System.out.println("url->" + req.getRequestURL());
    }
}
