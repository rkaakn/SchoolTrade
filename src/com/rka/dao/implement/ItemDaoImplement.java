package com.rka.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rka.dao.ItemDao;
import com.rka.data.Item;
import com.rka.util.jdTemplate;

public class ItemDaoImplement implements ItemDao {

	@Override
	public int insertItem(Item item) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="insert into item(name,description,OwnerName,price,pic,hasSold) values(?,?,?,?,?,?)";
		try {
			flag=jdbcTemplate.update(sql,item.getName(),item.getDescription(),item.getOwnerName(),item.getPrice(),item.getPic(),0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("执行插入Item失败");
			return -1;
		}
		System.out.println("执行插入Item成功");
		return flag;
	}

	@Override
	public Item findItem(String id) {
		// TODO 自动生成的方法存根
		Item qItem=null;
		String sql="select * from item where itemId=?";
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		try {
			qItem=jdbcTemplate.queryForObject(sql, new ItemRowMapper(),id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("执行查找Item失败");
			return null;
		}
		return qItem;
	}

	@Override
	public List<Item> getItem(String name) {
		// TODO 自动生成的方法存根
		List<Item> list=null;
		String sql="select * from item where name=?";
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		try {
			list=jdbcTemplate.query(sql, new ItemRowMapper(),name);
			System.out.println(list);
			System.out.println("进行查询");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查询失败");
			return null;
		}
		return list;
	}
	@Override
	public int delItem(Item item) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="update item set hasDeleted=1 where itemId=?";
		try {
			flag=jdbcTemplate.update(sql,item.getItemId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("删除Item出现错误");
			return 0;
		}
		return flag;
	}
	
	@Override
	public int delItemByOwnerName(Item item) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="update item set hasDeleted=1 where OwnerName=?";
		try {
			flag=jdbcTemplate.update(sql,item.getOwnerName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("根据所有者删除表内容失败");
			return 0;
		}
		return flag;
	}

	@Override
	public int delItemByBuyerName(Item item) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="update item set hasDeleted=1 where BuyerName=?";
		try {
			flag=jdbcTemplate.update(sql,item.getBuyerName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("根据购买者删除表内容失败");
			return 0;
		}
		return flag;
	}

	@Override
	public List<Item> listItem() {
		// TODO 自动生成的方法存根
		List<Item> list=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from item";
		try {
			list=jdbcTemplate.query(sql, new ItemRowMapper());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("获取Item列表失败");
			return null;
		}
		return list;
	}

	@Override
	public int updateItem(Item item) {
		// TODO 自动生成的方法存根
		int flag=-1;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="update item set hasSold=1 where itemId=?";
		try {
			flag=jdbcTemplate.update(sql,item.getItemId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("更新闲置列表失败");
			return 0;
		}
		return flag;
	}

	@Override
	public List<Item> listItemByName(String name) {
		// TODO 自动生成的方法存根
		List<Item> list=null;
		JdbcTemplate jdbcTemplate=jdTemplate.getJdbcTemplate();
		String sql="select * from item where OwnerName=?";
		try {
			list=jdbcTemplate.query(sql, new ItemRowMapper(),name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("根据用户昵称查询失败");
			return null;
		}
		return list;
	}

}

//创建实现特定接口的RowMapper类
class ItemRowMapper implements RowMapper<Item>{

	@Override
	public Item mapRow(ResultSet resultSet, int num) throws SQLException {
		// TODO 自动生成的方法存根
		Item item=new Item();
		item.setName(resultSet.getString("name"));
		item.setOwnerName(resultSet.getString("OwnerName"));
		item.setDescription(resultSet.getString("description"));
		item.setPrice(resultSet.getFloat("price"));
		item.setPic(resultSet.getString("pic"));
		item.setItemId(resultSet.getInt("itemId"));
		return item;
	}
	
}