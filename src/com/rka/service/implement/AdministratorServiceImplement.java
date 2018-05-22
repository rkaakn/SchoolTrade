package com.rka.service.implement;

import com.rka.dao.AdministratorDao;
import com.rka.dao.implement.AdministratorDaoImplement;
import com.rka.data.Administrator;
import com.rka.service.AdministratorService;

public class AdministratorServiceImplement implements AdministratorService {

	@Override
	public Administrator login(Administrator administrator) {
		// TODO 自动生成的方法存根
		AdministratorDao administratorDao=new AdministratorDaoImplement();
		Administrator administrator2=administratorDao.find(administrator);
		return administrator2;
	}

}
