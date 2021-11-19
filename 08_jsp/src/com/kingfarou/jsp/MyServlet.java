package com.kingfarou.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"zh_CN\">");
        printWriter.println("<head>");
        printWriter.println("    <meta charset=\"UTF-8\">");
        printWriter.println("    <title>Title</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("    <p>我是一个html页面</p>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
