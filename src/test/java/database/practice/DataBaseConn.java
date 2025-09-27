package database.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConn {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-2D0MJJ4C\\SQLEXPRESS;encrypt=true;databaseName=HR_Sample_Database;integratedSecurity=true");
		//Connection conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-2D0MJJ4C\\soura (57);database=HR_Sample_Database");
		
		Statement sta = conn.createStatement();
		
		String sql = "select * from countries";
		
		ResultSet rs = sta.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println(rs.getString("country_id"));
		}
		
		
	}

}
