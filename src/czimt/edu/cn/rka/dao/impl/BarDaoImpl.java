package czimt.edu.cn.rka.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import czimt.edu.cn.rka.dao.BarDao;
import czimt.edu.cn.rka.entity.Bar;
import czimt.edu.cn.rka.entity.UserInfo;
import czimt.edu.cn.rka.util.AccessDbUtil;

public class BarDaoImpl implements BarDao {

	public int barAdd(Bar bar) {
		String sql =" insert into titlebar (titleBarName,createDate,createorID,yxx) values (?,?,?,?)";
		String[] param = {
				bar.getBarName(),
				bar.getCreateDate(),
				bar.getCreateorID(),
				bar.getYxx()
		};
		return AccessDbUtil.executeUpdateLWQ(sql, param);
		
	}
	
	

	public int barDel(Bar bar) {
		String sql ="delete from titlebar where titleBarID = ?";
		String[] param = {
				bar.getBarID()
		};
		return AccessDbUtil.executeUpdateLWQ(sql, param);
	}

	public int barEdit(Bar bar) {
		String sql =" update titlebar set titleBarName=?, createorID=?, createDate=?, yxx=? where titleBarID=?";
		String[] param = {
				bar.getBarName(),
				bar.getCreateorID(),
				bar.getCreateDate(),
				bar.getYxx(),
				bar.getBarID()
		};
		return AccessDbUtil.executeUpdateLWQ(sql, param);
	}

	public List barSelect(Bar bar) {
		// TODO Auto-generated method stub
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/newssystem?autoReconnect=true&useSSL=false";
//		String name = "root";
//		String password ="";
//		String sql =" select * from titlebar ";
//		String[] param = null;
//		ResultSet rs = AccessDbUtil.executeQueryLWQ(sql, param);
//		Bar bar1 = null;
		List list = new ArrayList();
//		try {
//			while(rs.next())
//			{
//				bar1 = new Bar();
//				bar1.setBarName(rs.getString("titleBarName"));
//				bar1.setCreateDate(rs.getString("createDate"));
//				bar1.setYxx(rs.getString("yxx"));
//				int barid = rs.getInt("titleBarID");
//				bar1.setBarID(String.valueOf(barid));
//				int creatorID = rs.getInt("createorID");
//				bar1.setCreateorID(String.valueOf(creatorID));
//				list.add(bar1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String sql =" select titleBarID,titleBarName,creatorID,createDate, ";
			   sql+= " case when yxx='1' then 'Effective' ";
			   sql+= "       when yxx='0' then 'Invalid' ";
			   sql+= " end as yxxName, userinfo.userRealName ";
			   sql+= " from titlebar,userinfo ";
			   sql+= " where titlebar.creatorID = userinfo.userID ";
		ResultSet rt = AccessDbUtil.executeQueryLWQ(sql,null);
		Bar bar1 = null;
		try {			
		while(rt.next()){
			bar1 = new Bar();
			bar1.setBarName(rt.getString("titleBarName"));
			bar1.setCreateDate(rt.getString("createDate"));
			bar1.setYxx(rt.getString("yxxName"));
			bar1.setBarID(rt.getString("titleBarID"));
			bar1.setCreateorID(rt.getString("creatorID"));
			list.add(bar1);
		}		
		} catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return list;
	}



	public Bar barSelectbyid(Bar bar) {
		String sql =" select titleBarID,titleBarName,creatorID,createDate, ";
		   sql+= " case when yxx='1' then 'Effective' ";
		   sql+= "       when yxx='0' then 'Invalid' ";
		   sql+= " end as yxxName, userinfo.userRealName ";
		   sql+= " from titlebar,userinfo ";
		   sql+= " where titlebar.creatorID = userinfo.userID AND titleBarID=? ";
		   String[] param = {
					bar.getBarID()
				};   
	ResultSet rt = AccessDbUtil.executeQueryLWQ(sql,param);
	Bar bar1 = null;
	try {			
		if(rt.next()){
			bar1 = new Bar();
			bar1.setBarName(rt.getString("titleBarName"));
			bar1.setCreateDate(rt.getString("createDate"));
			bar1.setYxx(rt.getString("yxxName"));
			bar1.setBarID(rt.getString("titleBarID"));
			bar1.setCreateorID(rt.getString("creatorID"));
		}		
		} catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return bar1;
	}}