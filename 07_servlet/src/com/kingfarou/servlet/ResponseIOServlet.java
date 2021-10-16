package com.kingfarou.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集解决中文乱码问题
        //方案一
        //设置浏览器编码字符集
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter printWriter = resp.getWriter();
//        //设置浏览器解码字符集
//        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
//        printWriter.write("返回字符串给浏览器");

        //方案二
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("返回中文字符串给浏览器");
    }
}
