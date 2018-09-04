package com.ninemax.jpa.code.service;


import com.jspsmart.upload.*;
import com.ninemax.jpa.code.action.IssueCertificateAction;
import com.ninemax.jpa.code.bus.TJgdmSaveBus;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.util.CodeAssignClient;
import com.ninemax.jpa.util.Constants;
import com.ninemax.jpa.util.PropertiesUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CodeAssignServlet extends HttpServlet implements javax.servlet.Servlet {
    private static Logger log = Logger.getLogger(IssueCertificateAction.class);
    /**
     *
     */
    private static final long serialVersionUID = -7093794606949924842L;
    
    private String rootPath = "";

    private String tempFileSaveDir = "";

    private String jumpTo = "./visitor-inner.jsp";

    private ServletConfig config;

    /**
     * Constructor of the object.
     */
    public CodeAssignServlet() {
        super();
        PropertiesUtils.loadFile("unifyorgcode.properties");
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws javax.servlet.ServletException if an error occurs
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
        String path = config.getInitParameter("temp-file-save-dir");
        if (null == path || path.equals("")) {
            path = config.getServletContext().getContextPath();
        }
        tempFileSaveDir = path;
        rootPath = config.getServletContext().getRealPath("/");
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * The doPost method of the servlet. <br>
     * <p/>
     * This method is called when a form has its tag value method equals to
     * post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws javax.servlet.ServletException if an error occurred
     * @throws java.io.IOException            if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("stype");
        Map<String, String> parameters = new HashMap<String, String>();
         String[][] uploadFiles = new String[2][];
        String rs = null;
        try {
            if (type.equals("only-text")) {

                String codeType = request.getParameter(Constants.CodeType);//9
                System.out.println(codeType);
                System.out.println(request.getParameter(Constants.IsRepeatedFlag));//0
                //������
                if ("1".equals(codeType)) {
                    parameters.put(Constants.OrganizationName, request.getParameter(Constants.OrganizationName));
                    parameters.put(Constants.RegisterNumber, request.getParameter(Constants.RegisterNumber));
                    parameters.put(Constants.OrganizationAddress, request.getParameter(Constants.OrganizationAddress));
                    parameters.put(Constants.CodeType, codeType);
                    parameters.put(Constants.IsRepeatedFlag, request.getParameter(Constants.IsRepeatedFlag));
                } else {
                    String id = request.getParameter("id");
                    TJgdmSaveBus saveBus = new TJgdmSaveBus(); 
                    TJgdmSave jgdmSave = saveBus.findById(Integer.valueOf(id));
                    //�������л�ȡ����
                    String orgName = jgdmSave.getJgmc();
                    String regNum = jgdmSave.getXjwh();//lvwei 20171212  zch��Ϊѡ���ĺ�
                    String orgAddress = jgdmSave.getJgdz();
                    parameters.put(Constants.OrganizationName, orgName);
                    parameters.put(Constants.RegisterNumber, regNum);
                    parameters.put(Constants.OrganizationAddress, orgAddress);
                    parameters.put(Constants.CodeType, "B".equals(jgdmSave.getJglx()) ? "0" : codeType);
                    parameters.put(Constants.IsRepeatedFlag, request.getParameter(Constants.IsRepeatedFlag));
                }


            } else if (type.equals("add-xml")) {

                SmartUpload mySmartUpload = new SmartUpload();
                mySmartUpload.initialize(config, request, response);// Initialization
                mySmartUpload.upload();// Upload
                //�������л�ȡ����
                Request req = mySmartUpload.getRequest();
                String orgName = req.getParameter(Constants.OrganizationName);
                String regNum = req.getParameter(Constants.RegisterNumber);
                String orgAddress = req.getParameter(Constants.OrganizationAddress);
                String codeType = req.getParameter(Constants.CodeType);
                String isRepeated = req.getParameter(Constants.IsRepeatedFlag);
                String xmlFilePath = "";
                File myFile = null;
                myFile = mySmartUpload.getFiles().getFile(0);
                if (!myFile.isMissing()) {
                    String fileName = myFile.getFileName();
                    xmlFilePath = tempFileSaveDir + fileName;
                    myFile.saveAs(xmlFilePath);
                }

                //��װ���������ʽӿ������룬���õ�JSON��ʽ���ַ������

                parameters.put(Constants.OrganizationName, orgName);
                parameters.put(Constants.RegisterNumber, regNum);
                parameters.put(Constants.OrganizationAddress, orgAddress);
                parameters.put(Constants.CodeType, codeType);
                parameters.put(Constants.IsRepeatedFlag, isRepeated);
                uploadFiles = new String[2][];
                uploadFiles[0] = new String[]{Constants.XmlFile, rootPath + xmlFilePath};
                java.io.File file = new java.io.File(xmlFilePath);
                if (file.exists()) {
                    file.delete();
                }


            } else if (type.equals("add-xml-tiff")) {
                try {
                    SmartUpload mySmartUpload = new SmartUpload();
                    mySmartUpload.initialize(config, request, response);// Initialization
                    mySmartUpload.upload();// Upload
                    //�������л�ȡ����
                    Request req = mySmartUpload.getRequest();
                    String orgName = req.getParameter(Constants.OrganizationName);
                    String regNum = req.getParameter(Constants.RegisterNumber);
                    String orgAddress = req.getParameter(Constants.OrganizationAddress);
                    String codeType = req.getParameter(Constants.CodeType);
                    String isRepeated = req.getParameter(Constants.IsRepeatedFlag);

                    //��ȡ�ϴ��ļ���������
                    String xmlFilePath = "";
                    String tiffFilePath = "";
                    File myFile = null;
                    Files files = mySmartUpload.getFiles();
                    //��ȡxml�ļ�
                    myFile = files.getFile(0);
                    if (!myFile.isMissing()) {
                        String fileName = myFile.getFieldName();
                        xmlFilePath = tempFileSaveDir + fileName;
                        myFile.saveAs(xmlFilePath);
                    }
                    //��ȡtif�ļ�
                    myFile = files.getFile(1);
                    if (!myFile.isMissing()) {
                        String fileName = myFile.getFieldName();
                        tiffFilePath = tempFileSaveDir + fileName;
                        myFile.saveAs(tiffFilePath);
                    }

                    //��װ���������ʽӿ������룬���õ�JSON��ʽ���ַ������
                    parameters.put(Constants.OrganizationName, orgName);
                    parameters.put(Constants.RegisterNumber, regNum);
                    parameters.put(Constants.OrganizationAddress, orgAddress);
                    parameters.put(Constants.CodeType, codeType);
                    parameters.put(Constants.IsRepeatedFlag, isRepeated);
                    uploadFiles = new String[2][];
                    uploadFiles[0] = new String[]{Constants.XmlFile, rootPath + xmlFilePath};
                    uploadFiles[1] = new String[]{Constants.TiffFile, rootPath + tiffFilePath};
                    java.io.File file = new java.io.File(xmlFilePath);
                    if (file.exists()) {
                        file.delete();
                    }
                    file = new java.io.File(tiffFilePath);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (SmartUploadException e) {
                    e.printStackTrace();
                }
            } else if (type.equals("confirm")) {
                String code = request.getParameter(Constants.ConfirmCode);
                parameters.put(Constants.ConfirmCode, code);
            }
            rs = new CodeAssignClient().assign(PropertiesUtils.getValue("url").toString(), type, parameters, uploadFiles[0], uploadFiles[1]);

        } catch (Exception e) {
            log.error(CodeAssignServlet.class, e);
            rs = "{flag:'3',info:'�����쳣'}";
        }
        this.sendJsonStr(request, response, rs, type);
    }


   /* private void doAddXmlApply(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //�����д��request��Ȼ��ת�������ҳ��
        request.setAttribute("result", rs);
        request.setAttribute("stype", "add-xml");
        request.getRequestDispatcher(jumpTo).forward(request, response);

    }

    public void doAddXmlTiffApply(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {


            //�����д��request��Ȼ��ת�������ҳ��
            request.setAttribute("result", rs);
            request.setAttribute("stype", "add-xml-tiff");
            request.getRequestDispatcher(jumpTo).forward(request, response);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

    }

    private void doConfirmCodeAssign(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //�������л�ȡ����

        //���ʽӿ�ִ�и���ȷ�ϣ����õ�JSON��ʽ���ַ������
        String rs;
        try {
            rs = new CodeAssignClient().assign(PropertiesUtils.getValue("url").toString(), "confirm", parameters);
        } catch (IOException e) {
            rs = "{flag:'3',info:'��������쳣,�����ԣ�'}";
        }

        //String rs="{flag:'0',info:'ȷ�ϳɹ�'}";
        //��������ַ�����ʽ���ظ�client��AJAX���ʣ�
        this.sendJsonStr(response, rs);
    }*/

    private void sendJsonStr(HttpServletRequest request, HttpServletResponse response, String result, String type) throws IOException, ServletException {
//		response.setContentType("application/x-json");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-language", "UTF-8");
        if (type != null && type.contains("add-xml")) {
            request.setAttribute("result", result);
            request.setAttribute("stype", type);
            request.getRequestDispatcher(jumpTo).forward(request, response);
            return;
        }
        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }

}
