package org.galilee.dms.service.impl;

import java.util.List;

import org.galilee.dms.dao.SiteDAO;
import org.galilee.dms.model.SiteInfo;
import org.galilee.dms.model.Sites;
import org.galilee.dms.service.SiteService;

public class SiteServiceImpl implements SiteService {

	SiteDAO siteDao;
	
	public void setSiteDao(SiteDAO siteDao){
		this.siteDao = siteDao;
	}
	
	@Override
	public void add(Sites site) {
		// TODO Auto-generated method stub
		
		this.siteDao.insert(site);
	}

	@Override
	public void update(Sites site) {
		// TODO Auto-generated method stub
		
		this.siteDao.update(site);
	}

	@Override
	public void delete(int siteID) {
		// TODO Auto-generated method stub
		
		Sites site = this.siteDao.selectByID(siteID);
		this.siteDao.delete(site);
	}

	@Override
	public List<Sites> findAll() {
		// TODO Auto-generated method stub
		
		return this.siteDao.selectAll();
	}

	@Override
	public Sites findByID(int siteID){
		return this.siteDao.selectByID(siteID);
	}

	@Override
	public List<Sites> findByRivers(List<Integer> riverIDs) {
		// TODO Auto-generated method stub
		return this.siteDao.selectByRiverIDs(riverIDs);
	}

	@Override
	public List<Sites> findByIDs(List<Integer> siteIDs) {
		return this.siteDao.selectByIDs(siteIDs);
	}

	@Override
	public List<Sites> findByBasin(String basin) {
		
		return this.siteDao.selectByBasin(basin);
	}

	@Override
	public List<SiteInfo> findAllSiteInfo() {
		return this.siteDao.selectAllSiteInfo();
	}
	
	@Override
	public List<SiteInfo> findInfoByIDs(List<Integer> sIDs) {
		return this.siteDao.selectInfoByIDs(sIDs);
	}

	@Override
	public List<SiteInfo> findInfoByRivers(List<Integer> rIDList) {
		// TODO Auto-generated method stub
		return this.siteDao.selectInfoByRivers(rIDList);
	}

}
