<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*,java.lang.*,java.util.*" %>
<%@ include file="../jsp/public.jsp"
%>
<%

String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//数据库用户名	
String userName="sa";
//密码
String userPasswd="sa";
//数据库名
String dbName="sa";
//表名
String tableName="t_jgdm";
//联结字符串
//String url="jdbc:microsoft:sqlserver://192.168.1.253:1433/"+dbName+"?user="+userName+"&password="+userPasswd;

              String   url   =   "jdbc:sqlserver://192.168.12.104:1433;databaseName=webcodecs"; 
                String   UserName   =   "sa"; 
                String   PassWord   =   "sa"; 


Class.forName(driverName);
Connection connection= DriverManager.getConnection(url,   UserName,   PassWord);

	
Statement statement = connection.createStatement();

String sql="select * from "+tableName+" where jgdm='686153752'";
ResultSet rs = statement.executeQuery(sql);

//获得数据结果集合

ResultSetMetaData rmeta = rs.getMetaData();

//确定数据集的列数，亦字段数

int numColumns=rmeta.getColumnCount();
rs.next();
String test = rs.getString("jgmc");
out.print(test);
%>