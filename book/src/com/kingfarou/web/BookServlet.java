package com.kingfarou.web;

import com.kingfarou.pojo.Book;
import com.kingfarou.service.BookService;
import com.kingfarou.service.impl.BookServiceImpl;
import com.kingfarou.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 查询图书列表
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询图书列表");
        //调用service层获取数据
        List<Book> bookList = bookService.queryBooks();
        req.setAttribute("books", bookList);
        //数据转发给jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * 添加图书
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("添加图书");
        //解析请求里的键值对到bean对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //保存图书到数据库
        bookService.addBook(book);
        //返回图书列表界面给浏览器
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }
}
