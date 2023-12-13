package czimt.edu.cn.rka.service.impl;

import java.util.List;

import czimt.edu.cn.rka.dao.BarDao;
import czimt.edu.cn.rka.dao.impl.BarDaoImpl;
import czimt.edu.cn.rka.entity.Bar;
import czimt.edu.cn.rka.service.BarService;

public class BarServiceImpl implements BarService {

	public int barAdd(Bar bar) {
		// TODO Auto-generated method stub
		BarDao barDao = new BarDaoImpl();
		return barDao.barAdd(bar);
	}

	public int barDel(Bar bar) {
		// TODO Auto-generated method stub
		BarDao barDao = new BarDaoImpl();
		return barDao.barDel(bar);
	}

	public int barEdit(Bar bar) {
		// TODO Auto-generated method stub
		BarDao barDao = new BarDaoImpl();
		return barDao.barEdit(bar);
	}

	public List barSelect(Bar bar) {
		// TODO Auto-generated method stub
		BarDao barDao = new BarDaoImpl();
		return barDao.barSelect(bar);
	}

	public Bar barSelectbyid(Bar bar) {
		// TODO Auto-generated method stub
		BarDao barDao = new BarDaoImpl();
		return barDao.barSelectbyid(bar);
	}

}