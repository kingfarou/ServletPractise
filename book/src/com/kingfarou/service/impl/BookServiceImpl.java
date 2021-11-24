package com.kingfarou.service.impl;

import com.kingfarou.dao.BookDao;
import com.kingfarou.dao.impl.BookDaoImpl;
import com.kingfarou.pojo.Book;
import com.kingfarou.pojo.Page;
import com.kingfarou.service.BookService;

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
    public Page<Book> page(long pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //图书总数
        long sum = bookDao.queryForBookTotalCount();
        page.setPageTotalCount(sum);
        //总页数
        long pageCount = sum/pageSize;
        if(sum % pageSize > 0){
            pageCount+=1;
        }
        page.setPageTotal(pageCount);
        //当前页数据
        //根据当前页码计算起始位置
        long begin = (pageNo - 1) * pageSize;
        List<Book> books = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(books);
        return page;
    }
}
