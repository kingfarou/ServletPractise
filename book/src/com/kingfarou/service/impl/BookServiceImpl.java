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
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        //需要返回：当前页数据，总数据量，总页数
        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //当前页数据
        Integer offset = (pageNo - 1) * pageSize;
        List<Book> bookList = bookDao.page(offset, pageSize);
        page.setItems(bookList);
        //总数据量
        Integer sum = bookDao.queryBookSum();
        page.setSum(sum);
        //总页数：通过总数据量算出来的
        int pageTotalCount = sum/pageSize;
        if(sum % pageSize > 0){
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);
        //返回
        return page;
    }
}
