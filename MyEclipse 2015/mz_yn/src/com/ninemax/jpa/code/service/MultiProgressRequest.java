package com.ninemax.jpa.code.service;

import com.opensymphony.xwork2.inject.Inject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.dispatcher.multipart.JakartaMultiPartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MultiProgressRequest extends JakartaMultiPartRequest {
    static final Log log = LogFactory.getLog(MultiProgressRequest.class);

    @Inject(StrutsConstants.STRUTS_MULTIPART_MAXSIZE)
    public void setMaxSize(String maxSize) {
        this.maxSize = Long.parseLong(maxSize);
    }

    /**
     * Creates a new request wrapper to handle multi-part data using methods
     * adapted from Jason Pell's multipart classes (see class description).
     *
     * @param saveDir        the directory to save off the file
     * @param servletRequest the request containing the multipart
     * @throws java.io.IOException is thrown if encoding fails.
     */
    @Override
    public void parse(HttpServletRequest servletRequest, String saveDir)
            throws IOException {
        ProgressListener listener = new StrutsProgressListener(servletRequest);

        // 使用自己定义的工厂类传入一个listener
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(0);
        if (saveDir != null) {
            factory.setRepository(new File(saveDir));
        }
        try {
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxSize);
            upload.setProgressListener(listener);
            List items = upload
                    .parseRequest(createRequestContext(servletRequest));
            for (Object item1 : items) {
                FileItem item = (FileItem) item1;
                if (log.isDebugEnabled())
                    log.debug("Found item " + item.getFieldName());
                if (item.isFormField()) {
                    log.debug("Item is a normal form field");
                    List<String> values;
                    if (params.get(item.getFieldName()) != null) {
                        values = params.get(item.getFieldName());
                    } else {
                        values = new ArrayList<String>();
                    }

                    // note: see http://jira.opensymphony.com/browse/WW-633
                    // basically, in some cases the charset may be null, so
                    // we're just going to try to "other" method (no idea if
                    // this
                    // will work)
                    String charset = servletRequest.getCharacterEncoding();
                    if (charset != null) {
                        values.add(item.getString(charset));
                    } else {
                        values.add(item.getString());
                    }
                    params.put(item.getFieldName(), values);
                } else {
                    log.debug("Item is a file upload");

                    // Skip file uploads that don't have a file name - meaning
                    // that no file was selected.
                    if (item.getName() == null
                            || item.getName().trim().length() < 1) {
                        log.debug("No file has been uploaded for the field: "
                                + item.getFieldName());
                        continue;
                    }

                    List<FileItem> values;
                    if (files.get(item.getFieldName()) != null) {
                        values = files.get(item.getFieldName());
                    } else {
                        values = new ArrayList<FileItem>();
                    }

                    values.add(item);
                    files.put(item.getFieldName(), values);
                }
            }
        } catch (FileUploadException e) {
            log.error(MultiProgressRequest.class,e);
            errors.add(e.getMessage());
        }
    }

    /**
     * Creates a RequestContext needed by Jakarta Commons Upload.
     *
     * @param req the request.
     * @return a new request context.
     */
    private RequestContext createRequestContext(final HttpServletRequest req) {
        return new RequestContext() {
            public String getCharacterEncoding() {
                return req.getCharacterEncoding();
            }

            public String getContentType() {
                return req.getContentType();
            }

            public int getContentLength() {
                return req.getContentLength();
            }

            public InputStream getInputStream() throws IOException {
                return req.getInputStream();
            }
        };
    }
}
