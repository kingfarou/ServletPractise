package com.kingfarou.test;

import com.kingfarou.pojo.Book;
import com.kingfarou.pojo.Page;
import com.kingfarou.service.BookService;
import com.kingfarou.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "一夜暴富指南", "卡耐基", new BigDecimal(999988), 111111, 1, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(25, "六脉神剑", "金庸", new BigDecimal(12), 999999, 1, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(2));
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookService.queryBooks();
        for(Book book : bookList){
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(2, 4);
        System.out.println(page);
    }
}