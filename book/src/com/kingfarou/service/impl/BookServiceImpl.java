package com.kingfarou.service.impl;

import com.kingfarou.dao.BookDao;
import com.kingfarou.dao.impl.BookDaoImpl;
import com.kingfarou.pojo.Book;
import com.kingfarou.service.BookService;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
