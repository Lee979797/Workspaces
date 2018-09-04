package com.ninemax.nacao.dao.message;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ninemax.jdbc.dao.DataAccess;
import sun.jdbc.rowset.CachedRowSet;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.util.CommonPropertiesUtil;
import com.ninemax.jpa.util.FileHelp;
import com.ninemax.nacao.to.message.AttachmentTO;

public class AttachmentDAO {
   
    String uploadPath =CommonPropertiesUtil.getValue("common.properties", "filepath");;//ϵͳָ���ļ��洢·��

    /**
     * ɾ��һ���ļ�
     *
     * @param filePath �ļ�·������
     */
    public void deleteFile(String[] filePath) {
        if (filePath != null && filePath.length > 0) {
            for (String path : filePath) {
                String realPath = uploadPath + path;
                File delfile = new File(realPath);
                if (delfile.exists()) {
                    delfile.delete();
                }
            }
        }
    }

    /**
     * ɾ�������ļ�
     *
     * @param filePath �����ļ�·��
     */
    public void deleteFile(String filePath) {
        if (filePath != null && !"".equals(filePath)) {
            String[] path = new String[]{filePath};
            deleteFile(path);
        }
    }

    /**
     * ���渽�������Ϣ
     *
     * @param at AttachmentTO
     * @return
     */
    public int saveAttachmentInfo(AttachmentTO at) {
        int result = 0;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "insert into t_attachment ("
                + "file_name,"
                + "save_name,"
                + "message_ids,"
                + "info3"
                + ") values ("
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(at.getFileName()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(at.getSaveName()) + "',"
                + "'" + com.ninemax.jpa.util.clsStringTool.convertNull(at.getMessage_ids()) + "',"
                + "'false'"
                + ")";
        String returnValue = "";
        try {
            result = dataAccessObject.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ��ȡ�����Ӧ����
     *
     * @param uuid String
     * @return ������Ϣ�б�
     */
    public List<AttachmentTO> getAttachmentInfoList(String uuid) {
        List<AttachmentTO> list = new ArrayList<AttachmentTO>();
        DataAccess dataAccessObject = new DataAccess();
        String sql = "select file_id,file_name,save_name,file_path,message_ids from  t_attachment where message_ids = "
                + "'" + uuid + "'";
        try {
            CachedRowSet rs = dataAccessObject.query(sql);
            while (rs.next()) {
                AttachmentTO attachmentTO = new AttachmentTO();
                attachmentTO.setFileId(String.valueOf(rs.getInt("file_id")).trim());
                attachmentTO.setFileName(rs.getString("file_name").trim());
                attachmentTO.setSaveName(rs.getString("save_name").trim());
                attachmentTO.setMessage_ids(rs.getString("message_ids").trim());
                list.add(attachmentTO);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * ��ȡ������Ϣ
     *
     * @param fileId
     * @return ������Ϣ
     */
    public AttachmentTO getAttachmentInfo(String fileId) {
        List<AttachmentTO> list = new ArrayList<AttachmentTO>();
        DataAccess dataAccessObject = new DataAccess();
        String sql = "select file_id,file_name,save_name,file_path,message_ids,info3 from  t_attachment where file_id = "
                + "" + fileId + "";
        try {
            CachedRowSet rs = dataAccessObject.query(sql);
            while (rs.next()) {
                AttachmentTO attachmentTO = new AttachmentTO();
                attachmentTO.setFileId(String.valueOf(rs.getInt("file_id")).trim());
                attachmentTO.setFileName(rs.getString("file_name").trim());
                attachmentTO.setSaveName(rs.getString("save_name").trim());
                attachmentTO.setMessage_ids(rs.getString("message_ids").trim());
                attachmentTO.setInfo3(rs.getString("info3").trim());
                list.add(attachmentTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    /**
     * ɾ�������ļ�
     *
     * @param fileId
     * @return
     */
    public int deleteAttachmenInfo(String fileId) {
        int result = 0;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "delete from t_attachment  where file_id = '" + fileId + "'";

        try {
            result = dataAccessObject.execute(sql);
        } catch (Exception e) {
            result = 1;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ��ʽ����
     * ��1����ѯ����
     *
     * @param ids     String
     * @param fileIds String
     * @return ������Ϣ�б�
     */
    public List<AttachmentTO> getDeleteAttachmentList(String ids, String fileIds) {
        List<AttachmentTO> list = new ArrayList<AttachmentTO>();
        DataAccess dataAccessObject = new DataAccess();
        String sql = "select file_id,file_name,save_name,file_path,message_ids from t_attachment where "
                + " message_ids = '" + ids + "' "
                + " and file_id not in(" + fileIds + ")";
        try {
            CachedRowSet rs = dataAccessObject.query(sql);
            while (rs.next()) {
                AttachmentTO attachmentTO = new AttachmentTO();
                attachmentTO.setFileId(String.valueOf(rs.getInt("file_id")).trim());
                attachmentTO.setFileName(rs.getString("file_name").trim());
                attachmentTO.setSaveName(rs.getString("save_name").trim());
                attachmentTO.setMessage_ids(rs.getString("message_ids").trim());
                list.add(attachmentTO);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * ��ʱ����
     * -- ��1�����ύȷ���ϴ��ĸ��� - �ĳ���ʽ�Ĺ����Ӧ����
     */
    public int submitAttachmen(String fileIds, String fileNames, String uuid, String ids) {
        int result = 0;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "update t_attachment set message_ids = '" + ids + "',info3 = 'true'  where "
                + " message_ids = '" + uuid + "'  and "
                + " file_id in (" + fileIds + ")";
        String returnValue = "";
        try {
            result = dataAccessObject.execute(sql);
        } catch (Exception e) {
            result = 1;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ��ʱ����
     * ��2���������ļ� �� ָ��Ŀ¼
     *
     * @param saveName
     * @return
     */
    public int copyFiles(String saveName[]) {
        String savePath = CommonPropertiesUtil.getValue("common.properties", "filepath");;
        String oldPath = savePath + "uploadsTempFolder\\";
        int result = 0;
        for (int i = 0; i < saveName.length; i++) {
            FileHelp.copyFile(oldPath + saveName[i], savePath + saveName[i]);
        }
        return result;
    }

    /**
     * ��ʱ����
     * ��3����ɾ�� �� ��������
     */
    public int deleteAttachmenInfoList(String fileIds, String uuid, String ids) {
        int result = 0;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "delete from t_attachment  where message_ids = '" + uuid
                + "'  and "
                + " file_id not in (" + fileIds + ")";
        String returnValue = "";
        try {
            result = dataAccessObject.execute(sql);
        } catch (Exception e) {
            result = 3;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ��ʽ��������
     * -- ��1�� ɾ�������������ѯ����
     */
    public int modDeleteAttachmen(String fileIds) {

        int result = 0;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "delete from t_attachment where "
                + " file_id in (" + fileIds + ")";
        String returnValue = "";
        try {
            result = dataAccessObject.execute(sql);
        } catch (Exception e) {
            result = 1;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ��ʽ��������
     * -- ��2�� ɾ�����������
     */
    public int modDeleteAttachmenInfo(String fileIds) {
        int result = 0;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "delete from t_attachment where "
                + " file_id in (" + fileIds + ")";
        String returnValue = "";
        try {
            result = dataAccessObject.execute(sql);
        } catch (Exception e) {
            result = 1;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ��ʽ��������
     * -- ��3�� ɾ������-����ɾ��
     */
    public int modDeleteAttachmenFiles(List<AttachmentTO> atList) {
        int result = 0;
        for (AttachmentTO at : atList) {
            try {
                FileHelp.removeFile(uploadPath + at.getSaveName());
            } catch (Exception e) {
                result = 1;
                e.printStackTrace();
            }
        }
        return result;
    }
}
