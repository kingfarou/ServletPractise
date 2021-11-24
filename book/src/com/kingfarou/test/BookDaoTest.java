package com.kingfarou.test;

import com.kingfarou.dao.BookDao;
import com.kingfarou.dao.impl.BookDaoImpl;
import com.kingfarou.pojo.Book;
import com.kingfarou.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "如何认识富婆", "小白脸", new BigDecimal(8888), 9999, 1, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22, "教你认识富婆", "小白脸", new BigDecimal(8888.98), 9999, 1, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(20));
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookDao.queryBooks();
        for(Book book : bookList){
            System.out.println(book);
        }
    }

    @Test
    public void queryForBookTotalCount() {
        System.out.println("图书总数->" + bookDao.queryForBookTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> bookList = bookDao.queryForPageItems(8L, Page.PAGE_SIZE);
        for(Book book : bookList){
            System.out.println(book);
        }
    }
}