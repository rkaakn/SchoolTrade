package com.rka.service;

import java.util.List;


import com.rka.data.Record;
import com.rka.data.User;

public interface RecordService {

	public List<Record> listRecord();
	public int delRecord(Record record);
	public int refreshRecord(Record record);
	public int checkRecord();
	public List<Record> findRecordByOwnerName(Record record);
	public List<Record> findRecordByBuyerName(Record record);
	public int delRecord();
	public int insertRecord(Record record);
	
	
	
}
