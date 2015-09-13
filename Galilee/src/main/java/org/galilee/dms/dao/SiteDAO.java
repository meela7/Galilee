package org.galilee.dms.dao;

import java.util.List;

import org.galilee.dms.model.SiteInfo;
import org.galilee.dms.model.Sites;

public interface SiteDAO {
	
	public Sites insert(Sites site);
	public Sites update(Sites site);
	public void delete(Sites site);
	public List<Sites> selectAll();	
	public Sites selectByID(int siteID);
	
	public List<Sites> selectByIDs(List<Integer> siteIDs);	
	public List<Sites> selectByRiverIDs(List<Integer> riverIDs);
	public List<Sites> selectByBasin(String basin);
	
	public List<SiteInfo> selectAllSiteInfo();
	public List<SiteInfo> selectInfoByIDs(List<Integer> infoIDs);
	public List<SiteInfo> selectInfoByRivers(List<Integer> riverIDs); 
}
