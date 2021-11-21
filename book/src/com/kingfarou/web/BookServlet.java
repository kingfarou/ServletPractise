package com.kingfarou.web;

import com.kingfarou.pojo.Book;
import com.kingfarou.service.BookService;
import com.kingfarou.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("查询图书列表");
        List<Book> bookList = bookService.queryBooks();
        request.setAttribute("books", bookList);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
