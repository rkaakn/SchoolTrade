package com.rka.dao;

import java.util.List;

import com.rka.data.User;

public interface UserDao {
	public int insertUser(User user);
	public User checkUser(User user);
	public User findUser(User user);
	public int deleteUser(User user);
	public List<User> listUser();
	public int updateUser(User user,String account);
	public String getPassword(User tempuser);
	public int checkRegister(User user);
}


