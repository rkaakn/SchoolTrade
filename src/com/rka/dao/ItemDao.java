package com.rka.dao;

import java.util.List;

import com.rka.data.Item;

public interface ItemDao {
	
	public int insertItem(Item item);
	public Item findItem(String id);
	public List<Item> getItem(String name);
	public int delItem(Item item);
	public List<Item> listItem();
	public int delItemByBuyerName(Item item);
	public int delItemByOwnerName(Item item);
	public int updateItem(Item item);
	public List<Item> listItemByName(String name);
}
