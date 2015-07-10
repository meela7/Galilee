package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.dao.RiverDAO;
import org.galilee.dms.model.Rivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("riverService")
public class RiverService {
	RiverDAO riverDao; 
	
	@Autowired  
	public RiverService(RiverDAO riverDao) {
		this.riverDao = riverDao;
	}
	
	public int insertRiver(Rivers river) {
		return riverDao.insertRiver(river);  
	}

	public List<Rivers> getList() {
		return riverDao.getList();  
	}

	public int deleteRiver(int rid) {
		return riverDao.deleteRiver(rid);  
	}

	public Rivers getRiver(int rid) {
		return riverDao.getRiver(rid);  
	}

	public int updateRiver(Rivers river) {
		return riverDao.updateRiver(river);  
	}
}
