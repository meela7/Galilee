package org.galilee.dms.service.impl;

import java.util.ArrayList;
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
	public Sites findByName(String siteName) {
		return this.siteDao.selectByColumn("SiteName", siteName).get(0);
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
		
		return this.siteDao.selectByRiverColumn("Basin", basin);
	}	

	@Override
	public List<Sites> findByMid(String mid) {
		
		return this.siteDao.selectByRiverColumn("MidWatershed", mid);
	}
	
	@Override
	public List<Sites> findBySub(String sub) {
		
		return this.siteDao.selectByRiverColumn("SubWatershed", sub);
	}
	
	@Override
	public List<Sites> findByRiver(String river) {
		
		return this.siteDao.selectByRiverColumn("RiverName", river);
	}
	
	@Override
	public List<Sites> findByBasinClass(String basin, String classification) {
		
		return this.siteDao.selectByBasinClass(basin, classification);
	}
	
	@Override
	public List<Sites> findByBasinOrder(String basin, int streamOrder) {
		
		return this.siteDao.selectByBasinOrder(basin, streamOrder);
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
		
		List<Sites> siteList = this.siteDao.selectByRiverIDs(rIDList);
		List<Integer> sIDList = new ArrayList<Integer>();
		for(Sites s: siteList)
			sIDList.add(s.getSiteID());
		return this.siteDao.selectInfoByIDs(sIDList);
	}

	@Override
	public List<SiteInfo> findInfosByBasin(List<Integer> siIDs, String basin) {
		List<Sites> siteList = this.siteDao.selectByRiverColumn("Basin", basin);
		List<Integer> sIDList = new ArrayList<Integer>();
		for(Sites s: siteList)
			sIDList.add(s.getSiteID());
		return this.siteDao.selectInfoByIDs(sIDList);
	}


}
