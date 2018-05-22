package com.rka.service.implement;

import java.util.List;

import com.rka.dao.ItemDao;
import com.rka.dao.implement.ItemDaoImplement;
import com.rka.data.Item;
import com.rka.service.ItemService;

public class ItemServiceImplement implements ItemService {

//	@Override
	public List<Item> listItem(String name) {
		// TODO 自动生成的方法存根
		ItemDao itemDao=new ItemDaoImplement();
		List<Item> list=itemDao.getItem(name);
		return list;
	}

	@Override
	public int uploadItem(Item item) {
		// TODO 自动生成的方法存根
		ItemDao itemDao=new ItemDaoImplement();
		int flag=itemDao.insertItem(item);
		return flag;
	}

	@Override
	public List<Item> listItembyName(String name) {
		// TODO 自动生成的方法存根
		ItemDao itemDao=new ItemDaoImplement();
		List<Item> list=itemDao.listItemByName(name);
		return list;
	}

	@Override
	public int updateItem(Item item) {
		// TODO 自动生成的方法存根
		ItemDao itemDao=new ItemDaoImplement();
		int flag=itemDao.updateItem(item);
		return flag;
	}

	@Override
	public Item getItem(String id) {
		// TODO 自动生成的方法存根
		ItemDao itemDao=new ItemDaoImplement();
		Item qItem=itemDao.findItem(id);
		return qItem;
	}

}
