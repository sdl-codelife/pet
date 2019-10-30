package com.sdl.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
    private List<T> list;  //传入的数据  in
    private int totalRows;//总行数
    private int pageNo = 1;//当前页数，默认为1  in
    private int pageSize;//每页显示行数      in
    private int totalPage;//总页数

    public List<T> getList() {
        return list;
    }

    public List setList(List<T> list, int pageNo) {
        this.list = list;
        this.setPageSize(6);
        this.setTotalRows(list.size());
        this.setPageNo(pageNo);
        List<Object> returnList = new ArrayList<>();
        for (int i = (this.getPageNo() - 1) * this.getPageSize(); i < (this.getPageNo() * this.getPageSize()) && i < list.size(); i++) {
            returnList.add(list.get(i));
        }
        return returnList;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        //总页数totalpage等于总行数totalRows除以页面大小pagesize
        this.totalRows = totalRows;
        this.totalPage = totalRows % pageSize == 0 ? totalRows / pageSize : (totalRows / pageSize + 1);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //页数为空或小于0时等于1
        if (0 == pageNo || pageNo < 0 || null == this.getPageNo()) {
            this.pageNo = 1;
            //页数大于最大页数时等于最大页数
        } else if (pageNo > this.totalPage && this.totalPage > 0) {
            this.pageNo = totalPage;
        } else {
            this.pageNo = pageNo;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

}
