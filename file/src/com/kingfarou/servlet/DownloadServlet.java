package com.kingfarou.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件下载");

        String fileName = "zhangliang.jpg";
        String filePath = "/file/" + fileName;

        ServletContext servletContext = getServletContext();
        //设置数据类型
        System.out.println("mime->" + servletContext.getMimeType(filePath));
        resp.setContentType(servletContext.getMimeType(filePath));
        //告诉浏览器文件的处理方式是下载（其他的处理方式有例如直接打开）
        System.out.println("disposition->" + "attachment; filename=" + fileName);
        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        //流的方式是传输文件
        InputStream inputStream = servletContext.getResourceAsStream(filePath);
        OutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
    }
}
