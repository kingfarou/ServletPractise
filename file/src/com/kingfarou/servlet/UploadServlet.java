package com.kingfarou.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断上传的数据是否是多段的数据，文件上传一定是多段的数据
        if(ServletFileUpload.isMultipartContent(req)){
            //创建ServletFileUpload对象
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //解析，得到多段数据，每一段就是一个fileItem
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                for(FileItem fileItem : fileItemList){
                    if(fileItem.isFormField()){
                        System.out.println("字段名->" + fileItem.getFieldName() + "，值->" + fileItem.getString("UTF-8"));
                    } else {
                        System.out.println("字段名->" + fileItem.getFieldName() + "，文件名->" + fileItem.getName());
                        System.out.println("文件类型->" + fileItem.getContentType());
                        File uploadTarget = new File("E:\\JavaWeb\\practise\\JavaWeb_2\\file\\web\\WEB-INF\\haha.png");
                        fileItem.write(uploadTarget);
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {

        }
    }
}
