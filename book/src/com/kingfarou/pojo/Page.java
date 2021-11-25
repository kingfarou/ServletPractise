package com.kingfarou.pojo;

import java.util.List;

/**
 * 分页查找的结果
 */
public class Page<T> {

    public static final Integer DEFAULT_PAGE_SIZE = 4;

    private Integer pageNo;//当前页码
    private Integer pageSize;//每页数据量
    private Integer pageTotalCount;//总页数
    private Integer sum;//总数据量
    private List<T> items;//当前页数据

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotalCount, Integer sum, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.sum = sum;
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
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
                ", pageTotalCount=" + pageTotalCount +
                ", sum=" + sum +
                ", items=" + items +
                '}';
    }
}
