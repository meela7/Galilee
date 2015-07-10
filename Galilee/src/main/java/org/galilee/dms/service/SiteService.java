package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.dao.SiteDAO;
import org.galilee.dms.model.Sites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("siteService")
public class SiteService {
	SiteDAO siteDao; 
	
	@Autowired  
	public SiteService(SiteDAO siteDao) {
		this.siteDao = siteDao;
	}
	
	public int insertSite(Sites site) {
		return siteDao.insertSite(site);  
	}

	public List<Sites> getList() {
		return siteDao.getList();  
	}

	public int deleteSite(int siteid) {
		return siteDao.deleteSite(siteid);  
	}

	public Sites getSite(int siteid) {
		return siteDao.getSite(siteid);  
	}

	public int updateSite(Sites site) {
		return siteDao.updateSite(site);  
	}
}
