package org.galilee.dms.dao;

import java.util.List;

import org.galilee.dms.model.Sites;

public interface SiteDAO {
	
	public Sites insert(Sites site);
	public Sites update(Sites site);
	public void delete(Sites site);
	public Sites selectByID(int siteID);
	public List<Sites> selectByIDs(List<Integer> siteIDs);
	public List<Sites> selectAll();
	public List<Sites> selectByRiverID(List<Integer> riverIDs);
	
}
