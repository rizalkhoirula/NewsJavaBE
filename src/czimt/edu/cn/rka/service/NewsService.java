package czimt.edu.cn.rka.service;
import java.util.List;

import czimt.edu.cn.rka.entity.*;

public interface NewsService {

	public int newsAdd(News news);
	
	public int newsDel(News news);
	
	public int newsEdit(News news);
	
	public List newsSelect(News news);
	
	public News newsSelectbyid(News news2);

}
