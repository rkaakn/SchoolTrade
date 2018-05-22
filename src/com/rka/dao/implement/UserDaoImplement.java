package com.rka.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rka.dao.UserDao;
import com.rka.data.User;
import com.rka.util.jdTemplate;

public class UserDaoImplement implements UserDao {

	public UserDaoImplement() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public int insertUser(User user) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql1="insert into User(name,account,password,email) values(?,?,?,?);";
		try{
			flag=jdbcTemplate.update(sql1,user.getName(),user.getAccount(),user.getPassword(),user.getEmail());
			}catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
				System.out.println("执行插入操作出现错误");
				return 0;
		}
		System.out.println("新增用户操作成功");
		return flag;
	}

	@Override
	public User checkUser(User user) {
		// TODO 自动生成的方法存根
		User qUser=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from user where account=? and password=?";
		try {
			qUser=jdbcTemplate.queryForObject(sql, new UserRowMapper(),user.getAccount(),user.getPassword());
			System.out.println("成功检验用户");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("检验是否存在用户出现错误");
			return null;
		}
		return qUser;
	}

	@Override
	public User findUser(User user) {
		// TODO 自动生成的方法存根
		User qUser=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from user where account=?";
		try {
			qUser=jdbcTemplate.queryForObject(sql, new UserRowMapper(),user.getAccount());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查找用户出现错误");
			return null;
		}
		return qUser;
	}

	@Override
	public int deleteUser(User user) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="delete from user where account=?";
		try{
		flag=jdbcTemplate.update(sql,user.getAccount());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("删除用户出现错误");
			return 0;
		}
		return flag;
	}

	@Override
	public List<User> listUser() {
		// TODO 自动生成的方法存根
		List<User> list=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from user";
		try{
			list=jdbcTemplate.query(sql, new UserRowMapper());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查询user表用户失败");
			return null;
		}
		return list;
	}

	@Override
	public int updateUser(User user, String account) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="update user set name=?,email=?,password=? where account=?";
		try {
			flag=jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getPassword(),account);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("修改用户信息失败");
			return 0;
		}
		return flag;
	}

	@Override
	public String getPassword(User tempuser) {
		// TODO 自动生成的方法存根
		String password="";
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from user where name=? and email=?";
		
		try{
			User user=jdbcTemplate.queryForObject(sql,new UserRowMapper(),tempuser.getName(),tempuser.getEmail());
			password=user.getPassword();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查询密码失败");
			return "";
		}
		return password;
	}

	@Override
	public int checkRegister(User user) {
		// TODO 自动生成的方法存根
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from user where name=?";
		List<User> list=null;
		try {
			list=jdbcTemplate.query(sql, new UserRowMapper(),user.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("检验是否存在重复用户名失败");
		}
		if(!list.isEmpty()){
			System.out.println("存在重复账号");
			return 1;
		}else{
			System.out.println("可以进行注册");
			return 0;
		}
	}

}

//创建实现特定接口的RowMapper类

class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet resultSet, int num) throws SQLException {
		// TODO 自动生成的方法存根
		User user=new User();
		String account=resultSet.getString("account");
		String password=resultSet.getString("password");
		String email=resultSet.getString("email");
		String name=resultSet.getString("name");
		user.setAccount(account);
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		return user;
	}
	
}
