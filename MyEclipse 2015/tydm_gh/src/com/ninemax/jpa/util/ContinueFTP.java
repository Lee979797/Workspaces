package com.ninemax.jpa.util;

import java.io.File;
import java.io.FileOutputStream;      
import java.io.IOException;      
import java.io.InputStream;      
import java.io.OutputStream;      
import java.io.PrintWriter;      
import java.io.RandomAccessFile;      

import org.apache.commons.net.PrintCommandListener;      
import org.apache.commons.net.ftp.FTP;      
import org.apache.commons.net.ftp.FTPClient;      
import org.apache.commons.net.ftp.FTPFile;      
import org.apache.commons.net.ftp.FTPReply;      
      
/** *//**   
* ֧�ֶϵ�������FTPʵ����   
* @author BenZhou  http://www.bt285.cn   
* @version 0.1 ʵ�ֻ����ϵ��ϴ�����   
* @version 0.2 ʵ���ϴ����ؽ��Ȼ㱨   
* @version 0.3 ʵ������Ŀ¼�����������ļ���������Ӷ������ĵ�֧��   
*/    
public class ContinueFTP {      
    public FTPClient ftpClient = new FTPClient();      
          
    public ContinueFTP(){      
        //���ý�������ʹ�õ����������������̨      
        this.ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));      
    }      
          
    /** *//**   
     * ���ӵ�FTP������   
     * @param hostname ������   
     * @param port �˿�   
     * @param username �û���   
     * @param password ����   
     * @return �Ƿ����ӳɹ�   
     * @throws IOException   
     */    
    public boolean connect(String hostname,int port,String username,String password) throws IOException{      
        ftpClient.connect(hostname, port);      
        ftpClient.setControlEncoding("GBK");      
        if(FTPReply.isPositiveCompletion(ftpClient.getReplyCode())){      
            if(ftpClient.login(username, password)){      
                return true;      
            }      
        }      
        disconnect();      
        return false;      
    }      
          
    /** *//**   
     * ��FTP�������������ļ�,֧�ֶϵ��������ϴ��ٷֱȻ㱨   
     * @param remote Զ���ļ�·��   
     * @param local �����ļ�·��   
     * @return �ϴ���״̬   
     * @throws IOException   
     */    
    public void download(String remote,String local) throws IOException{
        //���ñ���ģʽ      
        ftpClient.enterLocalPassiveMode();      
        //�����Զ����Ʒ�ʽ����      
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);      

        //���Զ���ļ��Ƿ����      
        FTPFile[] files = ftpClient.listFiles(new String(remote.getBytes("GBK"),"iso-8859-1"));      
        if(files.length != 1){      
            System.out.println("Զ���ļ�������");      
            return ;
        }      
              
        long lRemoteSize = files[0].getSize();      
        File f = new File(local);      
        //���ش����ļ������жϵ�����      
        if(f.exists()){      
            long localSize = f.length();      
            //�жϱ����ļ���С�Ƿ����Զ���ļ���С      
            if(localSize >= lRemoteSize){      
                System.out.println("�����ļ�����Զ���ļ���������ֹ");      
                return ;
            }      
                  
            //���жϵ�����������¼״̬      
            FileOutputStream out = new FileOutputStream(f,true);      
            ftpClient.setRestartOffset(localSize);      
            InputStream in = ftpClient.retrieveFileStream(new String(remote.getBytes("GBK"),"iso-8859-1"));      
            byte[] bytes = new byte[1024];      
            long step = lRemoteSize /100;      
            long process=localSize /step;      
            int c;      
            while((c = in.read(bytes))!= -1){      
                out.write(bytes,0,c);      
                localSize+=c;      
                long nowProcess = localSize /step;      
                if(nowProcess > process){      
                    process = nowProcess;      
                    if(process % 10 == 0)      
                        System.out.println("���ؽ��ȣ�"+process);      
                    //TODO �����ļ����ؽ���,ֵ�����process������      
                }      
            }      
            in.close();      
            out.close();      
            boolean isDo = ftpClient.completePendingCommand();      
            if(isDo){      
              //TODO true  result = DownloadStatus.Download_From_Break_Success;
            }else {
                //false  result = DownloadStatus.Download_From_Break_Failed;
            }      
        }else {      
            OutputStream out = new FileOutputStream(f);      
            InputStream in= ftpClient.retrieveFileStream(new String(remote.getBytes("GBK"),"iso-8859-1"));      
            byte[] bytes = new byte[1024];      
            long step = lRemoteSize /100;      
            long process=0;      
            long localSize = 0L;      
            int c;      
            while((c = in.read(bytes))!= -1){      
                out.write(bytes, 0, c);      
                localSize+=c;      
                long nowProcess = localSize /step;      
                if(nowProcess > process){      
                    process = nowProcess;      
                    if(process % 10 == 0)      
                        System.out.println("���ؽ��ȣ�"+process);      
                    //TODO �����ļ����ؽ���,ֵ�����process������      
                }      
            }      
            in.close();      
            out.close();      
            boolean upNewStatus = ftpClient.completePendingCommand();
            if(upNewStatus){
                //TODO  result = DownloadStatus.Download_New_Success;
            }else {
                //TODO  result = DownloadStatus.Download_New_Failed;
            }
        }      
    }
          
    /** *//**   
     * �ϴ��ļ���FTP��������֧�ֶϵ�����   
     * @param local �����ļ����ƣ�����·��   
     * @param remote Զ���ļ�·����ʹ��/home/directory1/subdirectory/file.ext���� http://www.guihua.org /subdirectory/file.ext ����Linux�ϵ�·��ָ����ʽ��֧�ֶ༶Ŀ¼Ƕ�ף�֧�ֵݹ鴴�������ڵ�Ŀ¼�ṹ   
     * @return �ϴ����   
     * @throws IOException   
     */    
    public Boolean upload(String local,String remote) throws IOException{
        //����PassiveMode����      
        ftpClient.enterLocalPassiveMode();      
        //�����Զ��������ķ�ʽ����      
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);      
        ftpClient.setControlEncoding("GBK");
        Boolean result;
        //��Զ��Ŀ¼�Ĵ���      
        String remoteFileName = remote;      
        if(remote.contains("/")){      
            remoteFileName = remote.substring(remote.lastIndexOf("/")+1);      
            //����������Զ��Ŀ¼�ṹ������ʧ��ֱ�ӷ���      
            if(!CreateDirecroty(remote, ftpClient)){
                return false;
            }      
        }      
              
        //���Զ���Ƿ�����ļ�      
        FTPFile[] files = ftpClient.listFiles(new String(remoteFileName.getBytes("GBK"),"iso-8859-1"));      
        if(files.length == 1){      
            long remoteSize = files[0].getSize();      
            File f = new File(local);      
            long localSize = f.length();      
            if(remoteSize==localSize){
                return false;
            }else if(remoteSize > localSize){
                return false;
            }      
                  
            //�����ƶ��ļ��ڶ�ȡָ��,ʵ�ֶϵ�����      
            result = uploadFile(remoteFileName, f, ftpClient, remoteSize);      
                  
            //����ϵ�����û�гɹ�����ɾ�����������ļ��������ϴ�      
            if(!result ){
                if(!ftpClient.deleteFile(remoteFileName)){      
                    return false;
                }      
                result = uploadFile(remoteFileName, f, ftpClient, 0);      
            }      
        }else {      
            result = uploadFile(remoteFileName, new File(local), ftpClient, 0);      
        }      
        return result;      
    }      
    /** *//**   
     * �Ͽ���Զ�̷�����������   
     * @throws IOException   
     */    
    public void disconnect() throws IOException{      
        if(ftpClient.isConnected()){      
            ftpClient.disconnect();      
        }      
    }      
          
    /** *//**   
     * �ݹ鴴��Զ�̷�����Ŀ¼   
     * @param remote Զ�̷������ļ�����·��   
     * @param ftpClient FTPClient����   
     * @return Ŀ¼�����Ƿ�ɹ�   
     * @throws IOException   
     */    
    public Boolean CreateDirecroty(String remote,FTPClient ftpClient) throws IOException{
        Boolean status = true;
        String directory = remote.substring(0,remote.lastIndexOf("/")+1);      
        if(!directory.equalsIgnoreCase("/")&&!ftpClient.changeWorkingDirectory(new String(directory.getBytes("GBK"),"iso-8859-1"))){      
            //���Զ��Ŀ¼�����ڣ���ݹ鴴��Զ�̷�����Ŀ¼      
            int start=0;      
            int end = 0;      
            if(directory.startsWith("/")){      
                start = 1;      
            }else{      
                start = 0;      
            }      
            end = directory.indexOf("/",start);      
            while(true){      
                String subDirectory = new String(remote.substring(start,end).getBytes("GBK"),"iso-8859-1");      
                if(!ftpClient.changeWorkingDirectory(subDirectory)){      
                    if(ftpClient.makeDirectory(subDirectory)){      
                        ftpClient.changeWorkingDirectory(subDirectory);      
                    }else {      
                        System.out.println("����Ŀ¼ʧ��");      
                        return false;
                    }      
                }      
                      
                start = end + 1;      
                end = directory.indexOf("/",start);      
                      
                //�������Ŀ¼�Ƿ񴴽����      
                if(end <= start){      
                    break;      
                }      
            }      
        }      
        return status;      
    }      
          
    /** *//**   
     * �ϴ��ļ���������,���ϴ��Ͷϵ�����   
     * @param remoteFile Զ���ļ��������ϴ�֮ǰ�Ѿ�������������Ŀ¼���˸ı�   
     * @param localFile �����ļ�File���������·��   
     * @param processStep ��Ҫ��ʾ�Ĵ�����Ȳ���ֵ   
     * @param ftpClient FTPClient����   
     * @return   
     * @throws IOException   
     */    
    public Boolean uploadFile(String remoteFile,File localFile,FTPClient ftpClient,long remoteSize) throws IOException{
        Boolean status;
        //��ʾ���ȵ��ϴ�      
        long step = localFile.length() / 100;      
        long process = 0;      
        long localreadbytes = 0L;      
        RandomAccessFile raf = new RandomAccessFile(localFile,"r");      
        OutputStream out = ftpClient.appendFileStream(new String(remoteFile.getBytes("GBK"),"iso-8859-1"));      
        //�ϵ�����      
        if(remoteSize>0){      
            ftpClient.setRestartOffset(remoteSize);      
            process = remoteSize /step;      
            raf.seek(remoteSize);      
            localreadbytes = remoteSize;      
        }      
        byte[] bytes = new byte[1024];      
        int c;      
        while((c = raf.read(bytes))!= -1){      
            out.write(bytes,0,c);      
            localreadbytes+=c;      
            if(localreadbytes / step != process){      
                process = localreadbytes / step;      
                System.out.println("�ϴ�����:" + process);      
                //TODO �㱨�ϴ�״̬      
            }      
        }      
        out.flush();      
        raf.close();      
        out.close();      
        boolean result =ftpClient.completePendingCommand();      
        if(remoteSize > 0){      
            status = result;
        }else {      
            status = result;
        }      
        return status;      
    }      
          
    public static void main(String[] args) {      
        ContinueFTP myFtp = new ContinueFTP();      
        try {      
            myFtp.connect("192.168.21.181", 21, "nid", "123");      
//          myFtp.ftpClient.makeDirectory(new String("���Ӿ�".getBytes("GBK"),"iso-8859-1"));      
//          myFtp.ftpClient.changeWorkingDirectory(new String("���Ӿ�".getBytes("GBK"),"iso-8859-1"));      
//          myFtp.ftpClient.makeDirectory(new String("������".getBytes("GBK"),"iso-8859-1"));      
//          System.out.println(myFtp.upload("http://www.5a520.cn /yw.flv", "/yw.flv",5));      
//          System.out.println(myFtp.upload("http://www.5a520.cn /������24.mp4","/����������/������/������24.mp4"));      
//            System.out.println(myFtp.download("/����������/������/������24.mp4", "E:\\������242.mp4"));
            myFtp.disconnect();      
        } catch (IOException e) {      
            System.out.println("����FTP����"+e.getMessage());      
        }      
    }      
}