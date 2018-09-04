package com.ninemax.jdbc.dao;


import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.sql.Connection;
import java.util.List;


public class clsPageComponent {
    private static Logger log = Logger.getLogger(clsPageComponent.class);
    protected int totalSize = 0;
    protected int totalPages = 0;
    protected int pageSize = 20;
    protected int currentPage = 1;
    protected int startIndex = 1;
    protected int firstPage = 1;
    protected int lastPage = 1;
    protected String defaultOrderByField;
    protected String orderByContent;

    private DataAccess dataAccessObject = null;
    private String dataSourceName = null;

    public clsPageComponent() {
    }

    public final String getDataSourceName() {
        return dataSourceName;
    }

    public final void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public void setTotalSize(String sql) throws Exception {

        dataAccessObject = new DataAccess();

        CachedRowSet rs = null;
        try {

            String SQL = "select count(*) as NUM from ( " + sql + ") counting";
            rs = dataAccessObject.query(SQL);
            if (rs.next()) {
                totalSize = rs.getInt("NUM");
            }
            rs.close();

        } catch (Exception e) {

            totalSize = 0;
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * @param sql
     * @param parameterslist
     * @throws Exception
     * @author haojy
     */
    public void setTotalSize(String sql, List parameterslist) throws Exception {

        dataAccessObject = new DataAccess();

        CachedRowSet rs = null;
        try {

            String SQL = "select count(*) as num from ( " + sql + ") counting";

            rs = dataAccessObject.query(SQL, parameterslist);
            if (rs.next()) {
                totalSize = rs.getInt("NUM");
            }
            rs.close();

        } catch (Exception e) {

            totalSize = 0;
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
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

    public String getDefaultOrderByField() {
        return defaultOrderByField;
    }

    public void setDefaultOrderByField(String defaultOrderByField) {
        this.defaultOrderByField = defaultOrderByField;
    }

    public String getOrderByContent() {
        return orderByContent;
    }

    public void setOrderByContent(String orderByContent) {
        this.orderByContent = orderByContent;
    }


    public final boolean hasNextPage() {


        return (currentPage < totalPages);
    }


    public final boolean hasPreviousPage() {

        return (currentPage > 1);
    }


    public CachedRowSet getResultList(String sql) throws Exception {

        dataAccessObject = new DataAccess();
        String SQL = getSQLString(sql);
        CachedRowSet set = dataAccessObject.query(SQL);
        return set;

    }

    @SuppressWarnings("unchecked")
    public CachedRowSet getResultList(String sql, List parameterslist) throws Exception {

        dataAccessObject = new DataAccess();
        String SQL = getSQLString(sql);
        return dataAccessObject.executeQuery(SQL, parameterslist);

    }

    /**
     * zhaoxun add ÓÃÓÚÌØÊâÅÅÐò
     *
     * @param sql
     * @return
     */
    public CachedRowSet getResultListSpeical(String sql) throws Exception {
        dataAccessObject = new DataAccess();
        String SQL = getSQLStringSpecial(sql);
        return dataAccessObject.query(SQL);
    }

    private String getSQLStringSpecial(String sql) {

        String SQL = "";
        String reorderByContent = "";

        if (orderByContent.indexOf("desc") != -1) {
            reorderByContent = orderByContent.replace("desc", "asc");
        }
        if (orderByContent.indexOf("asc") != -1) {
            reorderByContent = orderByContent.replace("asc", "desc");
        }

        if (currentPage == 1) {
            SQL += " SELECT * FROM  ( SELECT Top " + pageSize + " * FROM (SELECT Top " + (startIndex + pageSize - 1) + " * FROM (" + sql + ") tt0 order by  case tt0." + orderByContent + ") tt1 order by case tt1." + reorderByContent + ") tt2 order by case tt2." + orderByContent;

            return SQL;
        }
        if (currentPage == lastPage) {

            int num = 0;
            try {
                num = totalSize % pageSize;

            } catch (Exception e) {
                num = pageSize;
                log.error("error", e);
                throw new RuntimeException(e.getMessage(), e);

            }
            SQL += " SELECT * FROM  ( SELECT Top " + num + " * FROM (SELECT Top " + (startIndex + pageSize - 1) + " * FROM (" + sql + ") tt0 order by case tt0." + orderByContent + ") tt1 order by case tt1." + reorderByContent + ") tt2 order by case tt2." + orderByContent;

        } else {
            SQL += " SELECT * FROM  ( SELECT Top " + pageSize + " * FROM (SELECT Top " + (startIndex + pageSize - 1) + " * FROM (" + sql + ") tt0 order by case tt0." + orderByContent + ") tt1 order by case tt1." + reorderByContent + ") tt2 order by case tt2." + orderByContent;
        }

        return SQL;
    }


    public CachedRowSet getResultList(String sql, String dbType, Connection conn) throws Exception {

        DataAccess dataAccessObject = new DataAccess();
        String SQL = getSQLString(sql, dbType);
        return dataAccessObject.query(SQL);

    }

    public String getSQLString(String sql) {
        //String SQL = "";

        String SQL = getSQLString(sql, "SqlServer");
        /*if(clsStringTool.isEmpty(orderByContent)){
                  SQL = "SELECT TOP "+pageSize+" * FROM (SELECT ROW_NUMBER() OVER (ORDER BY "+defaultOrderByField+") AS RowNumber,* FROM ("+sql+") b) a WHERE RowNumber > "+pageSize*(currentPage-1)+" "+orderByContent;
              }else{
                  SQL = "SELECT TOP "+pageSize+" * FROM (SELECT ROW_NUMBER() OVER ("+orderByContent+") AS RowNumber,* FROM ("+sql+") b) a WHERE RowNumber > "+pageSize*(currentPage-1);
              }*/

        return SQL;
    }


    public String getSQLString(String sql, String dbType) {

        String SQL = "";
        if (dbType.equals("Oracle")) {
            SQL = "select * from (select a.*,rownum row_num from"
                    + "(" + sql + ") a) b where b.row_num between " + startIndex + " and " + (startIndex +
                    pageSize - 1) + " ";

        } else if (dbType.equals("MySql")) {
            SQL += sql + " limit " + (startIndex - 1) + "," + (startIndex + pageSize - 1) + " ";
        } else if (dbType.indexOf("SqlServer") > -1) {


            String reorderByContent = "";

            if (orderByContent.indexOf("desc") != -1) {
                reorderByContent = orderByContent.replace("desc", "asc");
            }
            if (orderByContent.indexOf("asc") != -1) {
                reorderByContent = orderByContent.replace("asc", "desc");
            }


            /*			if(currentPage==1)
                   {
                       SQL += " SELECT * FROM  ( SELECT Top "+pageSize+" * FROM (SELECT Top "+(startIndex + pageSize-1)+" * FROM ("+sql+") tt0 order by tt0."+orderByContent+") tt1 order by tt1."+reorderByContent +") tt2 order by tt2."+orderByContent;

                       return SQL;
                   }*/

            if (currentPage == lastPage && lastPage > 1) {

                int num = 0;
                try {
                    num = totalSize % pageSize;
                    if (num == 0) {
                        num = pageSize;
                    }

                } catch (Exception e) {
                    num = pageSize;
                    log.error("error", e);
                    throw new RuntimeException(e.getMessage(), e);

                }
                SQL += " SELECT * FROM  ( SELECT Top " + num + " * FROM (SELECT Top " + (startIndex + pageSize - 1) + " * FROM (" + sql + ") tt0 order by tt0." + orderByContent + ") tt1 order by tt1." + reorderByContent + ") tt2 order by tt2." + orderByContent;

            } else {
                SQL += " SELECT * FROM  ( SELECT Top " + pageSize + " * FROM (SELECT Top " + (startIndex + pageSize - 1) + " * FROM (" + sql + ") tt0 order by tt0." + orderByContent + ") tt1 order by tt1." + reorderByContent + ") tt2 order by tt2." + orderByContent;
            }
            //SQL += " SELECT * FROM  ( SELECT Top "+pageSize+" * FROM (SELECT Top "+(startIndex + pageSize-1)+" * FROM ("+sql+") tt0 order by tt0."+orderByContent+") tt1 order by tt1."+reorderByContent +") tt2 order by tt2."+orderByContent;
            // SQL += "SELECT Top "+pageSize+" * FROM (SELECT Top "+(startIndex + pageSize-1)+" * FROM ("+sql+") tt0 order by tt0."+orderByContent+")  tt2 order by tt2."+orderByContent;


        }
        return SQL;


    }


}
