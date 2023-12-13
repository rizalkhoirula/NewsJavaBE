package czimt.edu.cn.rka.dao;

import java.util.List;

import czimt.edu.cn.rka.entity.UserInfo;

public interface UserDao {
/*	
	user Logined method
	param : user
	return : UserInfo
*/	
	public UserInfo UserLogin(UserInfo user);
	/*	
	user regist
	param : user
	return : int
*/	
	public int userRegist(UserInfo user);
	/*	
	update userPassword
	param : user
	return : int
*/	
	public int updatePass(UserInfo user);
	/*	
	query user list
	param : user
	return : UserList
*/	
	public List findUser(UserInfo user);

	public int deleteUser(UserInfo user);
}
