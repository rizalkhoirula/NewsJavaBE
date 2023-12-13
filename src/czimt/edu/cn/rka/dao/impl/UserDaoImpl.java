package czimt.edu.cn.rka.dao.impl;
import czimt.edu.cn.rka.*;
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import czimt.edu.cn.rka.util.AccessDbUtil;
import czimt.edu.cn.rka.dao.UserDao;
import czimt.edu.cn.rka.entity.UserInfo;

public class UserDaoImpl implements UserDao {

	public UserInfo UserLogin(UserInfo user) {
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/newssystem";
//		String name = "root";
//		String password= "";
//		Connection conn = null;
//		ResultSet rtn = null;
//		UserInfo userLogined = null;
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, name, password);
//			String sql ="select * from userinfo where userPassword = ? and userLoginName=?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, user.getUserPassword());
//			pstmt.setString(2, user.getUserLoginName());
//			rtn = pstmt.executeQuery();
//			while(rtn.next()){
//				userLogined = new UserInfo();
//				userLogined.setUserRealName(rtn.getString("userRealName"));
//				userLogined.setUserLoginName(rtn.getString("UserLoginName"));
//				userLogined.setTel(rtn.getString("tel"));
//				userLogined.setFimallyAddress(rtn.getString("fimallyAddress"));
//				userLogined.setRegDate(rtn.getString("regDate"));
//				userLogined.setSex(rtn.getString("sex"));
//				userLogined.setEmail(rtn.getString("email"));	
//				userLogined.setBirth(rtn.getString("birth"));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String sql =" select * from userinfo where userPassword = ? and userLoginName=?";
		String[] param = {
				user.getUserPassword(),
				user.getUserLoginName(),
		};
		ResultSet rs = AccessDbUtil.executeQueryLWQ(sql, param);
		UserInfo userLogined = null;
		try {			
		while(rs.next()){
			userLogined = new UserInfo();
			userLogined.setUserID(rs.getString("userID"));
			userLogined.setUserRealName(rs.getString("userRealName"));
			userLogined.setUserLoginName(rs.getString("UserLoginName"));
			userLogined.setTel(rs.getString("tel"));
			userLogined.setFimallyAddress(rs.getString("fimallyAddress"));
			userLogined.setRegDate(rs.getString("regDate"));
			userLogined.setSex(rs.getString("sex"));
			userLogined.setEmail(rs.getString("email"));	
			userLogined.setBirth(rs.getString("birth"));
		}		
		} catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return userLogined;
		}
	

	public List findUser(UserInfo user) {
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/newssystem";
//		String name = "root";
//		String password= "";
//		Connection conn = null;
//		ResultSet rtn = null;
//		UserInfo userLogined = null;
		List list = new ArrayList();
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, name, password);
//			String sql ="select * from userinfo";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			//pstmt.setString(1, user.getUserPassword());
//			//pstmt.setString(2, user.getUserLoginName());
//			rtn = pstmt.executeQuery();
//			while(rtn.next()){
//				userLogined = new UserInfo();
//				userLogined.setUserRealName(rtn.getString("userRealName"));
//				userLogined.setUserLoginName(rtn.getString("UserLoginName"));
//				userLogined.setTel(rtn.getString("tel"));
//				userLogined.setFimallyAddress(rtn.getString("fimallyAddress"));
//				userLogined.setRegDate(rtn.getString("regDate"));
//				userLogined.setSex(rtn.getString("sex"));
//				userLogined.setEmail(rtn.getString("email"));	
//				userLogined.setBirth(rtn.getString("birth"));
//				list.add(userLogined);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String sql =" select * from userinfo";
		ResultSet rt = AccessDbUtil.executeQueryLWQ(sql,null);
		UserInfo userLogined = null;
		try {			
		while(rt.next()){
			userLogined = new UserInfo();
			userLogined.setUserRealName(rt.getString("userRealName"));
			userLogined.setUserLoginName(rt.getString("UserLoginName"));
			userLogined.setTel(rt.getString("tel"));
			userLogined.setFimallyAddress(rt.getString("fimallyAddress"));
			userLogined.setRegDate(rt.getString("regDate"));
			userLogined.setSex(rt.getString("sex"));
			userLogined.setEmail(rt.getString("em	ail"));	
			userLogined.setBirth(rt.getString("birth"));
			list.add(userLogined);
		}		
		} catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return list;
	}

	public int updatePass(UserInfo user) {
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/newssystem";
//		String name = "root";
//		String password= "";
//		Connection conn = null;
//		int rtn = 0;
//		try{
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, name, password);
//			String sql ="select * from userinfo";
//			PreparedStatement pstmt = conn.prepareStatement(sql);	
//			pstmt.setString(1,user.getUserID());
//			pstmt.setString(2, user.getUserPassword());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		AccessDbUtil util = new AccessDbUtil();
		String sql =" update userinfo set userPassword=? where userid=?";
		String[] param = {
				user.getUserPassword(),
				user.getUserID()
		};
		return AccessDbUtil.executeUpdateLWQ(sql, param);
	}

	public int userRegist(UserInfo user) {
//		AccessDbUtil util = new AccessDbUtil();
		String sql =" insert into userinfo (userRealName,userLoginName,userPassword,regDate) values (?,?,?,?)";
		String[] param = {
				user.getUserRealName(),
				user.getUserLoginName(),
				user.getUserPassword(),
				user.getRegDate()
		};
		return AccessDbUtil.executeUpdateLWQ(sql, param);
		
	}
	

	public int deleteUser(UserInfo user) {
		String sql ="delete from userinfo where userid = ?";
		String[] param = {
				user.getUserID()
		};
		return AccessDbUtil.executeUpdateLWQ(sql, param);
	}

	/**
	 * @param args
	 */

}
