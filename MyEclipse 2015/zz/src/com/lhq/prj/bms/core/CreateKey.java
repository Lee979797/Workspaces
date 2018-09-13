package com.lhq.prj.bms.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CreateKey {

	public String executeProcdure(String procName, String tableName) throws
		ClassNotFoundException, SQLException {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;dataBaseName=zz","isa", "isa");
			CallableStatement calls = con.prepareCall("{call " + procName +"(?,?)}");
			calls.setString(1, tableName);
			calls.registerOutParameter(2, Types.VARCHAR);//如果有输出参数，必须进行注册
			calls.execute();
			return calls.getString(2);
	}
}


