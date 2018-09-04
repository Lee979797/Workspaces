package com.ninemax.jpa.code.service;

import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.http.HttpServletRequest;

/**
 * User: zhhuiyan
 * Date: 12-12-18
 * Time: обнГ1:12
 */
public class StrutsProgressListener implements ProgressListener {
    public StrutsProgressListener(HttpServletRequest request) {
        this.request = request;
    }

    private HttpServletRequest request;

    @Override
    public void update(long readedBytes, long totalBytes, int currentItem) {
        request.getSession().setAttribute("progressInfo", new ProgressInfo(totalBytes, readedBytes, currentItem));
    }
}
