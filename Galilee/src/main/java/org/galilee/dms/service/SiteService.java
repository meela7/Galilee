package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.model.Sites;

public interface SiteService {	
	
	public void add(Sites site);
	public void update(Sites site);	
	public void delete(int siteID);
	public Sites findByID(int siteID);
	public List<Sites> findAll();
	public List<Sites> findByRivers(List<Integer> rivers);
	public List<Sites> findByIDs(List<Integer> siteIDs);	
}
