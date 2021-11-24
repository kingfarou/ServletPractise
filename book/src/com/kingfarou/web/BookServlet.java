package com.kingfarou.web;

import com.kingfarou.pojo.Book;
import com.kingfarou.pojo.PageQuery;
import com.kingfarou.service.BookService;
import com.kingfarou.service.impl.BookServiceImpl;
import com.kingfarou.utils.WebUtils;

import javax.servlet.ServletException;
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
        //返回图书列表界面给浏览器，重定向防止表单重复提交
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    /**
     * 删除图书
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("删除图书");
        //获取图书id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //删除
        bookService.deleteBookById(id);
        //返回图书列表给浏览器
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    /**
     * 获取图书详情
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("获取图书详情");
        //获取请求参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //查询图书详情给
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    /**
     * 更新图书信息
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("修改图书信息");
        //获取请求参数
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //查询图书详情给
        bookService.updateBook(book);
        //返回jsp界面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //界面提供：当前页码，每页数据量
        long currentPage = WebUtils.parseInt(req.getParameter("currentPage"), 1);
        Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), PageQuery.PAGE_SIZE);
        //数据库返回：总页数，当前页数据，总数据量
        PageQuery<Book> pageQuery = bookService.pageQuery(currentPage, pageSize);
        //请求转发
        req.setAttribute("pageQuery", pageQuery);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
