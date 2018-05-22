package com.rka.service.implement;

import java.util.List;

import com.rka.dao.UserDao;
import com.rka.dao.implement.UserDaoImplement;
import com.rka.data.User;
import com.rka.service.UserService;

public class UserServiceImplement implements UserService {

	@Override
	public User loginUser(User user) {
		// TODO 自动生成的方法存根
		UserDao userDao=new UserDaoImplement();
		User checkuser=userDao.checkUser(user);
		return checkuser;
	}

	@Override
	public int registerUser(User user) {
		// TODO 自动生成的方法存根
		UserDao userDao=new UserDaoImplement();
		int flag=userDao.insertUser(user);
		return flag;
	}

	@Override
	public List<User> listUser() {
		// TODO 自动生成的方法存根
		UserDao userDao=new UserDaoImplement();
		List<User> list=userDao.listUser();
		return list;
	}

	@Override
	public int updateUser(User user, String account) {
		// TODO 自动生成的方法存根
		UserDao userDao=new UserDaoImplement();
		int flag=userDao.updateUser(user, account);
		return flag;
	}

	@Override
	public String getPassword(User user) {
		// TODO 自动生成的方法存根
		UserDao userDao=new UserDaoImplement();
		String password=userDao.getPassword(user);
		return password;
	}

	@Override
	public int checkRegister(User user) {
		// TODO 自动生成的方法存根
		UserDao userDao=new UserDaoImplement();
		int flag=userDao.checkRegister(user);
		return flag;
	}

}
