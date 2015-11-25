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

		this.fishDao.insert(fish);
	}

	@Override
	public void update(Fishes fish) {

		
		this.fishDao.update(fish);
	}

	@Override
	public void delete(Fishes fish) {

		this.fishDao.delete(fish);
	}

	@Override
	public Fishes findByID(int fishID) {
		
		return this.fishDao.selectByID(fishID);
	}

	@Override
	public List<Fishes> findAll() {
		
		return this.fishDao.selectAll();
	}

	@Override
	public List<Fishes> findByIDs(List<Integer> fishIDList) {
		return this.fishDao.selectByIDs(fishIDList);
	}

	@Override
	public List<Fishes> findEndangered(List<Integer> fishIDList) {
		
		return this.fishDao.selectEndangered(fishIDList);
	}

}
