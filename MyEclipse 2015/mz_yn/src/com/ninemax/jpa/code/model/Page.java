package com.ninemax.jpa.code.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * User: yzhhui
 * Date: 12-8-8
 * Time: ÏÂÎç5:05
 */
public class Page {
    private int pageSize = 20;
    private int totalPage = 0;
    private int totalRecord = 0;
    private int currentPage = 1;
    private String orderByField;
    private String orderByType;
    private List<BeanAttribute> showAttributes;
    private List<Map<Object, Object>> dataMaps;

    public void makeShowAttribute(String dm, String mc, AttributeType lx) {
        if (showAttributes == null)
            showAttributes = new ArrayList<BeanAttribute>();
        showAttributes.add(new BeanAttribute(dm, mc, lx));
    }

    public Page() {
        pageSize = 20;
        currentPage = 1;
    }

    public Page(int size) {
        if (size < 1)
            size = 1;
        pageSize = size;
        currentPage = 1;
    }

    public Page(int size, List<BeanAttribute> showAttributes) {
        if (size < 1)
            size = 1;
        pageSize = size;
        currentPage = 1;
        this.showAttributes = showAttributes;
    }

    public Page(int size, BeanAttribute... attributes) {
        if (size < 1)
            size = 1;
        pageSize = size;
        currentPage = 1;
        this.showAttributes = new ArrayList<BeanAttribute>();
        Collections.addAll(this.showAttributes, attributes);
    }

    public int getPageSize() {
        if (pageSize < 1)
            pageSize = 1;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1)
            pageSize = 1;
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        if (totalPage < 0)
            totalPage = 0;
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        if (totalPage < 0)
            totalPage = 0;
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        if (totalRecord < 0) {
            totalRecord = 0;
            currentPage = 0;
        }
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        if (this.totalRecord != 0) {
            totalPage = totalRecord / pageSize + (totalRecord % pageSize == 0 ? 0 : 1);
        } else {
            totalPage = 0;
        }

    }

    public int getCurrentPage() {
        if (currentPage < 1)
            currentPage = 1;
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage < 1)
            currentPage = 1;
        this.currentPage = currentPage;
    }

    public Boolean getHasNext() {
        return currentPage < totalPage;
    }

    public Boolean getHasPre() {
        return currentPage > 1;
    }

    public int getStartRecord() {
        return (currentPage - 1) * pageSize;
    }

    public String getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }

    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    public enum AttributeType {
        show,
        sort,
        opt
    }

    public class BeanAttribute {
        private String dm;
        private String mc;
        private AttributeType lx;

        public BeanAttribute(String dm, String mc, AttributeType lx) {
            this.dm = dm;
            this.mc = mc;
            this.lx = lx;
        }

        public String getDm() {
            return dm;
        }

        public void setDm(String dm) {
            this.dm = dm;
        }

        public String getMc() {
            return mc;
        }

        public void setMc(String mc) {
            this.mc = mc;
        }

        public AttributeType getLx() {
            return lx;
        }

        public void setLx(AttributeType lx) {
            this.lx = lx;
        }
    }

    public List<Map<Object, Object>> getDataMaps() {
        return dataMaps;
    }

    public void setDataMaps(List<Map<Object, Object>> dataMaps) {
        this.dataMaps = dataMaps;
    }

    public List<BeanAttribute> getShowAttributes() {
        return showAttributes;
    }

    public void setShowAttributes(List<BeanAttribute> showAttributes) {
        this.showAttributes = showAttributes;
    }
}
