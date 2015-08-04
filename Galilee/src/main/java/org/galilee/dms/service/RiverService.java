package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.model.Rivers;

public interface RiverService {	
	
	public void add(Rivers river);	
	public void update(Rivers river);	
	public void delete(int riverID);
	public Rivers findByID(int riverID);
	public List<Rivers> findAll();
	
}
