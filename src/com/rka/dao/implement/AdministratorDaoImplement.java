package com.rka.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rka.dao.AdministratorDao;
import com.rka.data.Administrator;
import com.rka.data.Item;
import com.rka.util.jdTemplate;

public class AdministratorDaoImplement implements AdministratorDao {

	@Override
	public int insert(Administrator administrator) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Administrator find(Administrator administrator) {
		// TODO 自动生成的方法存根
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		Administrator administrator2=null;
		String sql="select * from administrator where account=? and password=?";
		try {
			administrator2=jdbcTemplate.queryForObject(sql, new AdministratorRowMapper(),administrator.getAccount(),administrator.getPassword());
			System.out.println("管理员进行登录操作");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查询administrator表失败");
			return null;
		}
		return administrator2;
	}

}

//创建实现特定接口的RowMapper类
class AdministratorRowMapper implements RowMapper<Administrator>{

	@Override
	public Administrator mapRow(ResultSet resultSet, int num) throws SQLException {
		// TODO 自动生成的方法存根
		Administrator administrator=new Administrator();
		administrator.setAccount(resultSet.getString("account"));
		administrator.setPassword(resultSet.getString("password"));
		return administrator;
	}
	
}