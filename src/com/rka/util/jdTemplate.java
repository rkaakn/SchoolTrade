package com.rka.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdTemplate {
	
	public jdTemplate() {
		// TODO 自动生成的构造函数存根
	}
	public static JdbcTemplate getJdbcTemplate(){
		ApplicationContext context=new ClassPathXmlApplicationContext("jdbc.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		return jdbcTemplate;
	}
}
