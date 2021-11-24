package com.kingfarou.dao;

import com.kingfarou.pojo.Book;

import java.util.List;

public interface BookDao {

    /**
     * 新增一本书
     * @param book
     */
    public void addBook(Book book);

    /**
     * 根据id删除一本书
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 更新一本书的信息
     * @param book 会获取对象里的id属性，由id属性决定更新哪本书
     * @return
     */
    public int updateBook(Book book);

    /**
     * 获取指定id的书本
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 获取所有书本
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 查询图书总数
     * @return
     */
    long queryBookCount();

    /**
     * 分页获取图书列表
     * @param currentPage 当前页码
     * @param pageSize 每页数据量
     * @return
     */
    List<Book> page(Long currentPage, Integer pageSize);
}
