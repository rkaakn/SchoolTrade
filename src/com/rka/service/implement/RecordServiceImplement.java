package com.rka.service.implement;

import java.util.List;

import com.rka.dao.ItemDao;
import com.rka.dao.RecordDao;
import com.rka.dao.implement.ItemDaoImplement;
import com.rka.dao.implement.RecordDaoImplement;
import com.rka.data.Record;
import com.rka.service.RecordService;

public class RecordServiceImplement implements RecordService {

	@Override
	public List<Record> listRecord() {
		// TODO 自动生成的方法存根
		List<Record> list=null;
		RecordDao recordDao=new RecordDaoImplement();
		list=recordDao.getList();
		return list;
	}

	@Override
	public int delRecord(Record record) {
		// TODO 自动生成的方法存根
		RecordDao recordDao=new RecordDaoImplement();
		int flag=recordDao.delRecord(record);
		return flag;
	}

	@Override
	public int refreshRecord(Record record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int checkRecord() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public List<Record> findRecordByOwnerName(Record record) {
		// TODO 自动生成的方法存根
		RecordDao recordDao=new RecordDaoImplement();
		List<Record> list=null;
		return null;
	}

	@Override
	public List<Record> findRecordByBuyerName(Record record) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int delRecord() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertRecord(Record record) {
		// TODO 自动生成的方法存根
		RecordDao recordDao=new RecordDaoImplement();
		int flag=recordDao.insertRecord(record);
		return flag;
	}

}
