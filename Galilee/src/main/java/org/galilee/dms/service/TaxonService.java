package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.dao.RiverDAO;
import org.galilee.dms.dao.SiteDAO;
import org.galilee.dms.dao.impl.FishDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taxonService")
public class TaxonService {
	SiteDAO siteDao;
	RiverDAO riverDao;
	FishDaoImpl fishDao;

	@Autowired
	public TaxonService() {
	}
	
	

	public SiteDAO getSiteDao() {
		return siteDao;
	}



	public void setSiteDao(SiteDAO siteDao) {
		this.siteDao = siteDao;
	}



	public RiverDAO getRiverDao() {
		return riverDao;
	}



	public void setRiverDao(RiverDAO riverDao) {
		this.riverDao = riverDao;
	}



	public FishDaoImpl getFishDao() {
		return fishDao;
	}



	public void setFishDao(FishDaoImpl fishDao) {
		this.fishDao = fishDao;
	}



	public List<List> getBasin() {
		return siteDao.getBasin();
	}

	public List<String> getWaterSystem() {
		return riverDao.getWaterSystem();
	}

	public List<String> getWterSystemByBasin(String basin) {
		return riverDao.getWaterSystemByBasin(basin);
	}

	public List<String> getSubWtershed(String ws) {
		return riverDao.getSubWatershedByWS(ws);
	}
	
//	public List<Taxon> getFishTaxom(){
//		List<Taxon> ftList = null;
//		for(List<String> taxom : fishDao.getTaxom()){
//			Taxon ft = new Taxon();
//			ft.setClassName(taxom.get(0));
//			ft.setOrder(taxom.get(1));
//			ft.setFamily(taxom.get(2));
//			ft.setSpecies(taxom.get(3));
//			ftList.add(ft);
//		}
//		return ftList;
//	}

}