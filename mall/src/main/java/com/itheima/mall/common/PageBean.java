package com.itheima.mall.common;

import java.util.List;

/**
 * 分页对象
 */
public class PageBean<T> {

    private long totalCount;//总记录数
    private long totalPage;//总页数
    private long currentPage;//当前页码
    private long pageSize;//每页显示的条数

    private List<T> list;//每页显示的数据集合

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
