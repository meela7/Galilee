package org.galilee.dms.service.impl;

import java.util.List;

import org.galilee.dms.dao.RiverDAO;
import org.galilee.dms.model.Rivers;
import org.galilee.dms.service.RiverService;

public class RiverServiceImpl implements RiverService {

	RiverDAO riverDao;

	public void setRiverDao(RiverDAO riverDao) {
		this.riverDao = riverDao;
	}

	@Override
	public void add(Rivers river) {
		// TODO Auto-generated method stub
		this.riverDao.insert(river);
	}

	@Override
	public void update(Rivers river) {
		// TODO Auto-generated method stub
		this.riverDao.update(river);
	}

	@Override
	public void delete(int riverID) {
		// TODO Auto-generated method stub
		Rivers river = this.riverDao.selectByID(riverID);
		this.riverDao.delete(river);
	}
	
	@Override
	public Rivers findByID(int riverID) {
		// TODO Auto-generated method stub
		return this.riverDao.selectByID(riverID);
	}

	@Override
	public List<Rivers> findAll() {
		// TODO Auto-generated method stub
		return this.riverDao.selectAll();
	}


}
