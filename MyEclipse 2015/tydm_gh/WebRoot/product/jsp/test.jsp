<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*,java.lang.*,java.util.*" %>
<%@ include file="../jsp/public.jsp"
%>
<%

String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//���ݿ��û���	
String userName="sa";
//����
String userPasswd="sa";
//���ݿ���
String dbName="sa";
//����
String tableName="t_jgdm";
//�����ַ���
//String url="jdbc:microsoft:sqlserver://192.168.1.253:1433/"+dbName+"?user="+userName+"&password="+userPasswd;

              String   url   =   "jdbc:sqlserver://192.168.12.104:1433;databaseName=webcodecs"; 
                String   UserName   =   "sa"; 
                String   PassWord   =   "sa"; 


Class.forName(driverName);
Connection connection= DriverManager.getConnection(url,   UserName,   PassWord);

	
Statement statement = connection.createStatement();

String sql="select * from "+tableName+" where jgdm='686153752'";
ResultSet rs = statement.executeQuery(sql);

//������ݽ������

ResultSetMetaData rmeta = rs.getMetaData();

//ȷ�����ݼ������������ֶ���

int numColumns=rmeta.getColumnCount();
rs.next();
String test = rs.getString("jgmc");
out.print(test);
%>