package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.model.SiteInfo;
import org.galilee.dms.model.Sites;

public interface SiteService {	
	
	public void add(Sites site);
	public void update(Sites site);	
	public void delete(int siteID);
	public List<Sites> findAll();	
	public Sites findByID(int siteID);
	
	public List<Sites> findByRivers(List<Integer> rIDList);
	public List<Sites> findByIDs(List<Integer> sIDList);
	public List<Sites> findByBasin(String basin);	
	
	public List<SiteInfo> findAllSiteInfo();
	public List<SiteInfo> findInfoByIDs(List<Integer> siIDs);
	public List<SiteInfo> findInfoByRivers(List<Integer> rIDList);
}
