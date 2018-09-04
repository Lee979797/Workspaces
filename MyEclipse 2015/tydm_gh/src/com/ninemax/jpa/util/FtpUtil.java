package com.ninemax.jpa.util;

import com.ninemax.jpa.code.model.SFwqpz;
import com.ninemax.jpa.code.service.ProgressInfo;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 13-1-17
 * Time: 下午5:06
 */
public class FtpUtil {
    private static Logger log = Logger.getLogger(FtpUtil.class);
    private static BASE64Encoder encoder = new BASE64Encoder();
    private FtpClient ftpClient;
    private static SFwqpz sFwqpz;

    static {

        EntityManagerHelper.excute(new Runnable() {
            @Override
            public void run() {
                sFwqpz = (SFwqpz) ThamsEntityManagerHelper.getEntityManager().createQuery("select model from SFwqpz model").getSingleResult();
            }
        });
    }

    public Boolean connectServer(String path)
            throws Exception {
        if (sFwqpz == null) {
            EntityManagerHelper.excute(new Runnable() {
                @Override
                public void run() {
                    sFwqpz = (SFwqpz) ThamsEntityManagerHelper.getEntityManager().createQuery("select model from SFwqpz model").getSingleResult();
                }
            });
        }

        path = path.replace("\\", "/");
        return this.connectServer(sFwqpz.getServeraddr(), Integer.valueOf(sFwqpz.getPort()), sFwqpz.getUsername(), sFwqpz.getPasswd(), sFwqpz.getSavedbname() + "/" + path);
    }

    public Boolean connectServer(String server, String user, String password, String path)
            throws Exception {
        return this.connectServer(server, 21, user, password, path);
    }

    public Boolean connectServer(String server, int port, String user, String password, String path)
            throws Exception {
        if (this.ftpClient == null || !this.ftpClient.serverIsOpen())
            this.ftpClient = new FtpClient();
        try {
            this.ftpClient.openServer(server, port);
            this.ftpClient.login(user, password);
            if (path.length() == 0)
                return true;
            try {
                this.ftpClient.cd(path);
            } catch (FileNotFoundException fnfe) {
                createDir(path);
                this.ftpClient.cd(path);
            }

            this.ftpClient.binary();
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    public Boolean upload(String file, String name, HttpSession session)
            throws Exception {
        TelnetOutputStream os = null;
        ByteArrayInputStream is = null;
        try {
            os = this.ftpClient.put(name);
            is = new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(URLDecoder.decode(file, "UTF-8")));
            byte[] bytes = new byte[1024];
            int c;
            int len = 0;
            while ((c = is.read(bytes)) != -1) {
                os.write(bytes, 0, c);
                len += c;
                session.setAttribute("progressInfo", new ProgressInfo(file.length(), len, 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (is != null)
                is.close();
            if (os != null) {
                os.close();
            }
        }
        return true;
    }

    public Boolean upload(File file, String name, HttpSession session)
            throws Exception {
        TelnetOutputStream os = null;
        InputStream is = null;
        try {
            os = this.ftpClient.put(name);
            is = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int c;
            int len = 0;
            while ((c = is.read(bytes)) != -1) {
                os.write(bytes, 0, c);
                len += c;
                session.setAttribute("progressInfo", new ProgressInfo(file.length(), len, 0));
            }
        } catch (Exception e) {
            return false;
        } finally {
            if (is != null)
                is.close();
            if (os != null) {
                os.close();
            }
        }
        return true;
    }

    public boolean download(String name, OutputStream os) throws Exception {
        TelnetInputStream is = null;
        try {
            is = this.ftpClient.get(name);
            os = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int c;
            while ((c = is.read(bytes)) != -1) {
                os.write(bytes, 0, c);
            }
        } catch (IOException e) {
            return false;
            // throw new Exception("从Ftp服务器下载文件错误，或电子档案未找到！");
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null)
                os.close();
        }
        return true;
    }

    private File make(String fileName) throws IOException {
        String tempPath = UserPropertiesData.getValueByPropertyName("tempPath");
        File file = new File(tempPath);
        if (!file.exists())
            file.mkdir();

        file = new File(tempPath + "/" + fileName);
        if (!file.exists())
            file.createNewFile();
        return file;
    }

    public void download(String name, File file) throws Exception {
        TelnetInputStream is = null;
        OutputStream os = new FileOutputStream(file);
        try {
            is = this.ftpClient.get(name);
            byte[] bytes = new byte[1024];
            int c;
            while ((c = is.read(bytes)) != -1) {
                os.write(bytes, 0, c);
            }
            os.flush();
        } catch (IOException e) {
            os.write(new byte[1024], 0, 10);
            os.flush();
            log.error(FtpUtil.class, e);
        } finally {
            if (is != null) {
                is.close();
            }
            os.close();
        }
    }

    public List getFileList(String path) throws Exception {
        List list = new ArrayList();
        try {
            BufferedReader dis = new BufferedReader(
                    new InputStreamReader(this.ftpClient.nameList(path)));

            String filename = "";
            while ((filename = dis.readLine()) != null)
                list.add(filename);
        } catch (Exception e) {
            throw new Exception("查找文件列表错误！");
        }
        return list;
    }

    public void closeServer()
            throws Exception {
        try {
            if (this.ftpClient != null && this.ftpClient.serverIsOpen()) {
                this.ftpClient.closeServer();
            }

        } catch (Exception e) {
        }
    }

    public boolean createDir(String dir)
            throws Exception {
        try {
            this.ftpClient.ascii();
            StringTokenizer s = new StringTokenizer(dir, "/");

            String pathName = this.ftpClient.pwd();
            while (s.hasMoreElements()) {
                pathName = pathName + "/" + s.nextElement();
                pathName = pathName.replace("//", "/");
                this.ftpClient.sendServer("MKD " + pathName + "\r\n");
                this.ftpClient.readServerResponse();
            }
            this.ftpClient.binary();
            return true;
        } catch (Exception e) {
            throw new Exception("ftp创建文件夹失败");
        }
    }

    public boolean deleteDir(String dir)
            throws Exception {
        try {
            this.ftpClient.ascii();
            String pathName = this.ftpClient.pwd();

            pathName = pathName + dir;

            this.ftpClient.sendServer("XRMD " + pathName + "\r\n");

            this.ftpClient.binary();

            return true;
        } catch (Exception e) {
            throw new Exception("ftp删除文件夹错误");
        }
    }

    public boolean deleteFile(String dir, String fileName)
            throws Exception {
        try {
            this.ftpClient.ascii();

            String pathName = this.ftpClient.pwd();

            pathName = pathName + dir;
            pathName = pathName + "/" + fileName;
            List list = getFileList(pathName);
            if (list.size() == 1) {
                this.ftpClient.sendServer("DELE " + pathName + "\r\n");
                this.ftpClient.binary();
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new Exception("ftp删除文件错误" + e.getMessage());
        }
    }

    public boolean deleteFile(String dir)
            throws Exception {
        try {
            this.ftpClient.ascii();

            String pathName = this.ftpClient.pwd();

            pathName = pathName + dir;
            List list = getFileList(pathName);
            if (list.size() == 1) {
                this.ftpClient.sendServer("DELE " + pathName + "\r\n");
                this.ftpClient.binary();
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new Exception("ftp删除文件错误");
        }
    }

    public static SFwqpz getSFwqpz() {
        if (sFwqpz == null) {
            sFwqpz = (SFwqpz) ThamsEntityManagerHelper.getEntityManager().createQuery("select model from SFwqpz model").getSingleResult();
        }
        return sFwqpz;
    }
}
