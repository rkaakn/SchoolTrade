package com.rka.service;

import java.util.List;

import com.rka.data.User;

public interface UserService {

	public User loginUser(User user);
	public int registerUser(User user);
	public List<User> listUser();
	public int updateUser(User user,String account);
	public String getPassword(User user);
	public int checkRegister(User user);
	
}
