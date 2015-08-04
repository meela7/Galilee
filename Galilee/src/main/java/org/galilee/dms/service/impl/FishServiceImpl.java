package org.galilee.dms.service.impl;

import java.util.List;

import org.galilee.dms.dao.FishDAO;
import org.galilee.dms.model.Fishes;
import org.galilee.dms.service.FishService;

public class FishServiceImpl implements FishService {

	FishDAO fishDao;
	
	public void setFishDao(FishDAO fishDao){
		this.fishDao = fishDao;
	}
	
	@Override
	public void add(Fishes fish) {
		// TODO Auto-generated method stub
		this.fishDao.insert(fish);
	}

	@Override
	public void update(Fishes fish) {
		// TODO Auto-generated method stub
		this.fishDao.update(fish);
	}

	@Override
	public void delete(Fishes fish) {
		// TODO Auto-generated method stub
		this.fishDao.delete(fish);
	}

	@Override
	public Fishes findByID(int fishID) {
		// TODO Auto-generated method stub
		
		return this.fishDao.selectByID(fishID);
	}

	@Override
	public List<Fishes> findAll() {
		// TODO Auto-generated method stub
		
		return this.fishDao.selectAll();
	}

}
