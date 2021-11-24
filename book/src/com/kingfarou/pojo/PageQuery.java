package com.kingfarou.pojo;

import java.util.List;

public class PageQuery<T> {

    public static final int PAGE_SIZE = 4;//每页数据量

    private long currentPage;//当前页码
    private int pageSize;//每页数据量
    private long pageCount;//总页数
    private long sum;//总数据量
    private List<T> items;//当前页数据

    public PageQuery() {
    }

    public PageQuery(long currentPage, int pageSize, long pageCount, long sum, List<T> items) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.sum = sum;
        this.items = items;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
