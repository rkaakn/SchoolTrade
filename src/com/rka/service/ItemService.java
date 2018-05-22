package com.rka.service;

import java.util.List;

import com.rka.data.Item;

public interface ItemService {
	
	public List<Item> listItem(String name);
	public int uploadItem(Item item);
	public List<Item> listItembyName(String name);
	public int updateItem(Item item);
	public Item getItem(String id);
	
}
