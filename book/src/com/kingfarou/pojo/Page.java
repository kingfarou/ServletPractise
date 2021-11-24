package com.kingfarou.pojo;

import java.util.List;

public class Page<T> {

    public static final int PAGE_SIZE = 4;//每页数据量

    private long pageNo;//当前页码
    private int pageSize;//每页数据量
    private long pageTotal;//总页数
    private long pageTotalCount;//总数据量
    private List<T> items;//当前页数据

    public Page() {
    }

    public Page(long pageNo, int pageSize, long pageTotal, long pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public long getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(long pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }
}
