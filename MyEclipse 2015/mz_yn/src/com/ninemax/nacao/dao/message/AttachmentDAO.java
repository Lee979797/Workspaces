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
   
    String uploadPath =CommonPropertiesUtil.getValue("common.properties", "filepath");;//系统指定文件存储路径

    /**
     * 删除一组文件
     *
     * @param filePath 文件路径数组
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
     * 删除单个文件
     *
     * @param filePath 单个文件路径
     */
    public void deleteFile(String filePath) {
        if (filePath != null && !"".equals(filePath)) {
            String[] path = new String[]{filePath};
            deleteFile(path);
        }
    }

    /**
     * 保存附件相关信息
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
     * 获取公告对应附件
     *
     * @param uuid String
     * @return 附件信息列表
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
     * 获取附件信息
     *
     * @param fileId
     * @return 附件信息
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
     * 删除单个文件
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
     * 正式附件
     * 第1部查询集合
     *
     * @param ids     String
     * @param fileIds String
     * @return 附件信息列表
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
     * 临时附件
     * -- 第1步先提交确认上传的附件 - 改成正式的公告对应附件
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
     * 临时附件
     * 第2步：复制文件 到 指定目录
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
     * 临时附件
     * 第3步：删除 表 无用数据
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
     * 正式附近操作
     * -- 第1步 删除附件数据项，查询集合
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
     * 正式附近操作
     * -- 第2步 删除附件数据项。
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
     * 正式附近操作
     * -- 第3步 删除附件-物理删除
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
