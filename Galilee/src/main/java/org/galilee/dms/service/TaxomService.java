package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.dao.RiverDAO;
import org.galilee.dms.dao.impl.FishDaoImpl;
import org.galilee.dms.model.Taxon;
import org.galilee.dms.model.Basin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TaxomService")
public class TaxomService {
	RiverDAO riverDao;
	FishDaoImpl fishDao;

	@Autowired
	public TaxomService(RiverDAO riverDao) {
		this.riverDao = riverDao;
	}

	public List<String> getBasin() {
		return riverDao.getBasin();
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

	public List<Basin> getRiverTaxom() {
		return riverDao.getTaxom();
	}
	
	public List<Taxon> getFishTaxom(){
		List<Taxon> ftList = null;
		for(List<String> taxom : fishDao.getTaxom()){
			Taxon ft = new Taxon();
			ft.setClassName(taxom.get(0));
			ft.setOrder(taxom.get(1));
			ft.setFamily(taxom.get(2));
			ft.setSpecies(taxom.get(3));
			ftList.add(ft);
		}
		return ftList;
	}

}