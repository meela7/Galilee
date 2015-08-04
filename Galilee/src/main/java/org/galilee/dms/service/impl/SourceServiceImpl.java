package org.galilee.dms.service.impl;

import java.util.List;

import org.galilee.dms.dao.SourceDAO;
import org.galilee.dms.model.Sources;
import org.galilee.dms.service.SourceService;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl implements SourceService {
	
	SourceDAO sourceDao;

	public void setSourceDao(SourceDAO sourceDao) {
		this.sourceDao = sourceDao;
	}

	@Override
	public void add(Sources source) {
		// TODO Auto-generated method stub	
		
		this.sourceDao.insert(source);
	}

	@Override
	public void update(Sources source) {
		// TODO Auto-generated method stub
		
		this.sourceDao.update(source);
	}
	
	@Override
	public void delete(int sourceID) {
		// TODO Auto-generated method stub
		Sources source = this.sourceDao.selectByID(sourceID);
		this.sourceDao.delete(source);
	}

	@Override
	public Sources findByID(int sourceID) {
		// TODO Auto-generated method stub
		
		return this.sourceDao.selectByID(sourceID);
	}
	
	@Override
	public List<Sources> findAll() {
		// TODO Auto-generated method stub
		
		return this.sourceDao.selectAll();
	}
	
}
