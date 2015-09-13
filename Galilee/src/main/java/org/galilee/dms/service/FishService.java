package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.model.Fishes;

public interface FishService {	
	
	public void add(Fishes fish);
	public void update(Fishes fish);	
	public void delete(Fishes fish);
	public Fishes findByID(int fishID);
	public List<Fishes> findAll();
	public List<Fishes> findByIDs(List<Integer> fishIDList);
	
}
