package czimt.edu.cn.rka.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import czimt.edu.cn.rka.dao.NewsDao;
import czimt.edu.cn.rka.entity.Bar;
import czimt.edu.cn.rka.entity.News;
import czimt.edu.cn.rka.util.AccessDbUtil;

public class NewsDaoImpl implements NewsDao {

	public int newsAdd(News news) {
			String sql =" insert into newscontent (titleName,keyWords,contentAbstract,content,addDate,titlebarID,writerID) values (?,?,?,?,?,?,?)";
			String[] param = {
					news.getTitleName(),
					news.getKeyWords(),
					news.getContentAbstract(),
					news.getContent(),
					news.getAddDate(),
					news.getBarID(),
					news.getWriterID()
			};
			return AccessDbUtil.executeUpdateLWQ(sql, param);
			
	}

	public int newsDel(News news) {
		String sql ="delete from newscontent where newID = ?";
		String[] param = {
				news.getNewsID()
		};
		return AccessDbUtil.executeUpdateLWQ(sql, param);
	}

	public int newsEdit(News news) {
		String sql =" update newscontent set titleName=?, keyWords=?, contentAbstract=?, content=?,  addDate=?, titlebarID=?, writerID=? where newID=?";
		String[] param = {
				news.getTitleName(),
				news.getKeyWords(),
				news.getContentAbstract(),
				news.getContent(),
				news.getAddDate(),
				news.getBarID(),
				news.getWriterID(),
				news.getNewsID()
		};
		return AccessDbUtil.executeUpdateLWQ(sql, param);
	}

	public List newsSelect(News news) {
		ResultSet rt = null;
		String sql =" SELECT newscontent.*, titlebar.titleBarID, titlebar.titleBarName, userinfo.userID, userinfo.userRealName ";
		       sql+=" FROM newscontent, titlebar, userinfo ";
		       sql+=" WHERE titlebar.titleBarID = newscontent.titlebarID AND newscontent.writerID=userinfo.userID ";
		       if (news != null) {
		           sql += " AND newscontent.newID = ?";
		           String[] param = {
		    		   news.getNewsID()
		       };
		      rt = AccessDbUtil.executeQueryLWQ(sql, param);
		      }
		       else {
			      rt = AccessDbUtil.executeQueryLWQ(sql, null);

		       }
		List list = new ArrayList();
		try {			
		while(rt.next()){
			news = new News();
			news.setNewsID(rt.getString("newID"));
			news.setTitleName(rt.getString("titleName"));
			news.setKeyWords(rt.getString("keyWords"));
			news.setContentAbstract(rt.getString("contentAbstract"));
			news.setContent(rt.getString("content"));
			news.setAddDate(rt.getString("addDate"));
			news.setBarID(String.valueOf(rt.getInt("titleBarID")));
			news.setWriterID(String.valueOf(rt.getInt("writerID")));
			news.setBarName(rt.getString("titleBarName"));
			news.setWriterName(rt.getString("userRealName"));
			list.add(news);
		}		
		} catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return list;

}

	public News newsSelectbyid(News news) {
		String sql =" SELECT newscontent.*, titlebar.titleBarID, titlebar.titleBarName, userinfo.userID, userinfo.userRealName ";
	       sql+=" FROM newscontent, titlebar, userinfo ";
	       sql+=" WHERE titlebar.titleBarID = newscontent.titlebarID AND newscontent.writerID=userinfo.userID AND newID=? ";
		   String[] param = {
					news.getNewsID()
				};   
	ResultSet rt = AccessDbUtil.executeQueryLWQ(sql,param);
	News news1 = null;
	try {			
		if(rt.next()){
			news1 = new News();
			news1.setNewsID(rt.getString("newID"));
			news1.setTitleName(rt.getString("titleName"));
			news1.setKeyWords(rt.getString("keyWords"));
			news1.setContentAbstract(rt.getString("contentAbstract"));
			news1.setContent(rt.getString("content"));
			news1.setAddDate(rt.getString("addDate"));
			news1.setBarID(String.valueOf(rt.getInt("titleBarID")));
			news1.setWriterID(String.valueOf(rt.getInt("writerID")));
			news1.setBarName(rt.getString("titleBarName"));
			news1.setWriterName(rt.getString("userRealName"));
		}		
		} catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return news1;
	}}
