package org.galilee.dms.service.impl;

import java.util.List;

import org.galilee.dms.dao.FeatureDAO;
import org.galilee.dms.model.Features;
import org.galilee.dms.service.FeatureService;

public class FeatureServiceImpl implements FeatureService {

	FeatureDAO featureDao;
	
	public void setFeatureDao(FeatureDAO featureDao){
		this.featureDao = featureDao;
	}

	@Override
	public void add(Features feature) {
		// TODO Auto-generated method stub
		this.featureDao.insert(feature);
	}

	@Override
	public void update(Features feature) {
		// TODO Auto-generated method stub
		this.featureDao.update(feature);
	}

	@Override
	public void delete(Features feature) {
		// TODO Auto-generated method stub
		
		this.featureDao.delete(feature);
	}

	@Override
	public Features findByID(int featureID) {
		// TODO Auto-generated method stub		
		
		return this.featureDao.selectByID(featureID);
	}

	@Override
	public List<Features> findAll() {
		// TODO Auto-generated method stub
		return this.featureDao.selectAll();
	}
	
}
