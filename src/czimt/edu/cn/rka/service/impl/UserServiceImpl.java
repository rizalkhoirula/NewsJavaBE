package czimt.edu.cn.rka.service.impl;

import java.util.List;

import czimt.edu.cn.rka.dao.UserDao;
import czimt.edu.cn.rka.dao.impl.UserDaoImpl;
import czimt.edu.cn.rka.entity.UserInfo;
import czimt.edu.cn.rka.service.UserService;


public class UserServiceImpl implements UserService {
	
	public UserInfo UserLogin(UserInfo user) {
		
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.UserLogin(user);
	}

	public List findUser(UserInfo user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.findUser(user);
	}

	public int updatePass(UserInfo user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.updatePass(user);
	}

	public int userRegist(UserInfo user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.userRegist(user);
	}

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */


	public int deleteUser(UserInfo user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.deleteUser(user);
	}

}
