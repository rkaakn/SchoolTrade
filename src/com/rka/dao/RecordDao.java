package com.rka.dao;

import java.util.List;

import com.rka.data.Record;
import com.rka.data.User;

public interface RecordDao {
	
	public List<Record> getOwnerList(User user);
	public List<Record> getBuyerList(User user);
	public List<Record> getList();
	public Record findRecord(Record record);
	public int delRecord(Record record);
	public int insertRecord(Record record);
}
