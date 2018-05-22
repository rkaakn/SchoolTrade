package com.rka.util;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MyJdbcTemplate extends JdbcTemplate {

	@Override
	public <T> T queryForObject(String sql, Class<T> requiredType) throws DataAccessException {
		// TODO 自动生成的方法存根
		return super.queryForObject(sql, requiredType);
	}

	@Override
	public <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws DataAccessException {
		// TODO 自动生成的方法存根
		return super.queryForObject(sql, rowMapper);
	}

	
}
