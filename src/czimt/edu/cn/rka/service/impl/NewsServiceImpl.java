package czimt.edu.cn.rka.service.impl;

import java.util.List;

import czimt.edu.cn.rka.dao.NewsDao;
import czimt.edu.cn.rka.dao.impl.NewsDaoImpl;
import czimt.edu.cn.rka.entity.News;
import czimt.edu.cn.rka.service.NewsService;

public class NewsServiceImpl implements NewsService {

	public int newsAdd(News news) {
		// TODO Auto-generated method stub
		NewsDao newsDao = new NewsDaoImpl();
		return newsDao.newsAdd(news);
	}

	public int newsDel(News news) {
		// TODO Auto-generated method stub
		NewsDao newsDao = new NewsDaoImpl();
		return newsDao.newsDel(news);
	}

	public int newsEdit(News news) {
		// TODO Auto-generated method stub
		NewsDao newsDao = new NewsDaoImpl();
		return newsDao.newsEdit(news);
	}

	public List newsSelect(News news) {
		// TODO Auto-generated method stub
		NewsDao newsDao = new NewsDaoImpl();
		return newsDao.newsSelect(news);
	}

	public News newsSelectbyid(News news) {
		// TODO Auto-generated method stub
		NewsDao newsDao = new NewsDaoImpl();
		return newsDao.newsSelectbyid(news);
	}

}
