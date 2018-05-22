package com.rka.data;

import org.springframework.stereotype.Controller;

@Controller("administrator")
public class Administrator {

	private String account;
	private String password;
	public Administrator() {
		// TODO 自动生成的构造函数存根
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
