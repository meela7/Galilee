package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.model.Sites;

public interface SiteService {	
	
	public Sites add(Sites site);
	public Sites update(Sites site);	
	public void delete(int siteID);
	public Sites findByID(int siteID);
	public List<Sites> findAll();
	
}
