package com.kingfarou.service.impl;

import com.kingfarou.dao.BookDao;
import com.kingfarou.dao.impl.BookDaoImpl;
import com.kingfarou.pojo.Book;
import com.kingfarou.pojo.PageQuery;
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

    @Override
    public PageQuery<Book> pageQuery(long currentPage, Integer pageSize) {
        PageQuery<Book> pageQuery = new PageQuery<>();
        pageQuery.setCurrentPage(currentPage);
        pageQuery.setPageSize(pageSize);
        //图书总数
        long sum = bookDao.queryBookCount();
        pageQuery.setSum(sum);
        //总页数
        long pageCount = sum/pageSize;
        if(sum % pageSize > 0){
            pageCount+=1;
        }
        pageQuery.setPageCount(pageCount);
        //当前页数据
        List<Book> books = bookDao.page(currentPage, pageSize);
        pageQuery.setItems(books);
        return pageQuery;
    }
}
