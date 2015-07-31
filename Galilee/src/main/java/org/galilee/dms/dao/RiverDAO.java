package org.galilee.dms.dao;

import java.util.List;

import org.galilee.dms.model.Rivers;

public interface RiverDAO {
	
	void create(Rivers river);
	List<Rivers> read();
	void update(Rivers river);
	void delete(Rivers river);
	Rivers getByID(int riverID);
}
