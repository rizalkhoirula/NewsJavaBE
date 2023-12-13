package czimt.edu.cn.rka.util;

import java.sql.*;
import java.util.*;

public class AccessDbUtil {

	/*
	 * 
	 */
	public static Connection getConn(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/newssystem?characterEncoding=latin1";
		String name = "root";
		String password= "";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static int executeUpdateLWQ(String sql,String[] param){

		Connection conn = getConn();
		PreparedStatement pstmt;
		int rtn = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if(param != null){
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i+1, param[i]);
				}
			}
			rtn = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		return rtn;
	}

	public static ResultSet executeQueryLWQ(String sql, String[]param){
		ResultSet rtn = null;
		try {
			Connection conn = getConn();
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(sql);
			if(param != null){
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i+1, param[i]);
				}
			}
			rtn = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rtn;
	}
}


