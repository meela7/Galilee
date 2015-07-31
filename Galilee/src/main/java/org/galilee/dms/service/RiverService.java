package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.model.Rivers;

public interface RiverService {	
	void create(Rivers river);
	List<Rivers> read();
	void update(Rivers river);	
	void delete(Rivers river);
	Rivers getByID(int riverID);
}
