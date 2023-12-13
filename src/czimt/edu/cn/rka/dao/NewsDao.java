package czimt.edu.cn.rka.dao;
import java.util.List;

import czimt.edu.cn.rka.entity.*;

public interface NewsDao {

	public int newsAdd(News news);
	
	public int newsDel(News news);
	
	public int newsEdit(News news);
	
	public List newsSelect(News news);
	
	public News newsSelectbyid(News news);
}
