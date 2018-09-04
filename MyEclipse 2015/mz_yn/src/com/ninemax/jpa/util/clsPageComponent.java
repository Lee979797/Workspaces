package com.ninemax.jpa.util;

import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.WsbzEntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class clsPageComponent {
    protected int totalSize = 0;
    protected int totalPages = 0;
    protected int pageSize = 20;
    protected int currentPage = 1;
    protected int startIndex = 1;
    protected int firstPage = 1;
    protected int lastPage = 1;
    private String orderbyColum;
    private String orderbyMethod;

    public clsPageComponent() {
    }


    public void setTotalSize(String queryString, Object[] objs) throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createQuery("select count(*) " + queryString);
        for (int i = 0; i < objs.length; i++) {
            query.setParameter(i + 1, objs[i]);
        }
        this.totalSize = Integer.parseInt(query.getSingleResult().toString());
    }

    public void setTotalSize(String queryString, List<Object> queryParams) throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createQuery("select count(*) " + queryString);
        if (queryParams != null) {
            for (int i = 0; i < queryParams.size(); i++) {
                query.setParameter(i + 1, queryParams.get(i));
            }
        }
        this.totalSize = Integer.parseInt(query.getSingleResult().toString());
    }

    public void setNativeTotalSize(String queryString, List<Object> queryParams) throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNativeQuery("select count(*) " + queryString);
        if (queryParams != null) {
            for (int i = 0; i < queryParams.size(); i++) {
                query.setParameter(i + 1, queryParams.get(i));
            }
        }
        this.totalSize = Integer.parseInt(query.getSingleResult().toString());
    }

    public void setOnlineTotalSize(String queryString, List<Object> queryParams) throws Exception {
        Query query = WsbzEntityManagerHelper.getEntityManager().createNativeQuery("select count(*) " + queryString);
        if (queryParams != null) {
            for (int i = 0; i < queryParams.size(); i++) {
                query.setParameter(i + 1, queryParams.get(i));
            }
        }
        this.totalSize = Integer.parseInt(query.getSingleResult().toString());
    }

    public void setTotalSize(String queryString, List<Object> queryParams, int flag) throws Exception {
        EntityManager mg = null;
        if (flag == 1)
            mg = EntityManagerHelper.getEntityManager();
        Query query = mg.createQuery("select count(*) " + queryString);
        if (queryParams != null) {
            for (int i = 0; i < queryParams.size(); i++) {
                query.setParameter(i + 1, queryParams.get(i));
            }
        }
        this.totalSize = Integer.parseInt(query.getSingleResult().toString());
    }

    public final int getTotalSize() {
        return totalSize;
    }

    public final int getPageSize() {
        return pageSize;
    }

    public final void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public final void setTotalPages() {

        totalPages = (totalSize + pageSize - 1) / pageSize;

    }

    public final int getTotalPages() {
        return totalPages;
    }

    public final void setCurrentPage(int currentPage) {

        if (currentPage > lastPage) {
            this.currentPage = lastPage;
        } else {
            this.currentPage = currentPage;
        }
    }

    public final int getCurrentPage() {

        return currentPage;
    }

    public final void setLastPage() {

        this.lastPage = totalPages;
    }

    public final int getLastPage() {
        return this.lastPage;
    }

    public final int getStartIndex() {

        return startIndex;
    }

    public final void setStartIndex(int pageNo) {
        if (pageNo > this.lastPage)
            pageNo = this.currentPage;
        startIndex = (pageNo - 1) * pageSize + 1;
        if (startIndex < 1) {
            startIndex = 1;
        }

    }

    /**
     * �Ƿ�����һҳ
     *
     * @return �Ƿ�����һҳ
     */
    public final boolean hasNextPage() {


        return (currentPage < totalPages);
    }

    /**
     * �Ƿ�����һҳ
     *
     * @return �Ƿ�����һҳ
     */
    public final boolean hasPreviousPage() {

        return (currentPage > 1);
    }


    public String getOrderbyColum() {
        return orderbyColum;
    }


    public void setOrderbyColum(String orderbyColum) {
        this.orderbyColum = orderbyColum;
    }


    public String getOrderbyMethod() {
        return orderbyMethod;
    }


    public void setOrderbyMethod(String orderbyMethod) {
        this.orderbyMethod = orderbyMethod;
    }

}
