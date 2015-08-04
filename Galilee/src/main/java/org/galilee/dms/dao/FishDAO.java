package org.galilee.dms.dao;

import java.util.List;

import org.galilee.dms.model.Fishes;

public interface FishDAO {
	
	public Fishes insert(Fishes fish);
	public Fishes update(Fishes fish);
	public void delete(Fishes fish);
	public Fishes selectByID(int fishID);
	public List<Fishes> selectAll();
	
}