package com.rka.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rka.dao.RecordDao;
import com.rka.data.Record;
import com.rka.data.User;
import com.rka.util.jdTemplate;

public class RecordDaoImplement implements RecordDao {

	@Override
	public List<Record> getOwnerList(User user) {
		// TODO 自动生成的方法存根
		List<Record> list=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from record where OwnerName=?";
		try {
			list=jdbcTemplate.query(sql, new RecordRowMapper(),user.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查找record表失败");
			return null;
		}
		return list;
	}

	@Override
	public List<Record> getBuyerList(User user) {
		// TODO 自动生成的方法存根
		List<Record> list=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from record where BuyerName=?";
		try {
			list=jdbcTemplate.query(sql, new RecordRowMapper(),user.getName());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查找record表失败");
			return null;
		}
		return list;
	}

	@Override
	public List<Record> getList() {
		// TODO 自动生成的方法存根
		List<Record> list=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from record where hasDeleted=0";
		try {
			list=jdbcTemplate.query(sql, new RecordRowMapper());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查找record表失败");
			return null;
		}
		return list;
	}

	@Override
	public Record findRecord(Record record) {
		// TODO 自动生成的方法存根
		Record qRecord=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from record where RecordId=?";
		try {
			qRecord=jdbcTemplate.queryForObject(sql, new RecordRowMapper(),record.getRecordId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查找特定记录表失败");
			return null;
		}
		return qRecord;
	}

	@Override
	public int delRecord(Record record) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="update record set hasDeleted=1 where RecordId=?";
		try {
			flag=jdbcTemplate.update(sql,record.getRecordId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("删除表失败");
			return 0;
			
		}
		return flag;
	}

	@Override
	public int insertRecord(Record record) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="insert into record(checkinDate,name,itemId,OwnerName,BuyerName) values(?,?,?,?,?)";
		try {
			flag=jdbcTemplate.update(sql,record.getCheckinDate(),record.getName(),record.getItemId(),record.getOwnerName(),record.getBuyerName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("插入record失败");
			return 0;
		}
		return flag;
	}

}

//创建实现特定接口的RowMapper类
class RecordRowMapper implements RowMapper<Record>{

	@Override
	public Record mapRow(ResultSet resultSet, int num) throws SQLException {
		// TODO 自动生成的方法存根
		Record record=new Record();
		record.setBuyerName(resultSet.getString("BuyerName"));
		record.setOwnerName(resultSet.getString("OwnerName"));
		record.setName(resultSet.getString("name"));
		record.setCheckinDate(resultSet.getDate("checkinDate"));
		record.setRecordId(resultSet.getInt("recordId"));
		record.setItemId(resultSet.getInt("itemId"));
		return record;
	}
	
}
