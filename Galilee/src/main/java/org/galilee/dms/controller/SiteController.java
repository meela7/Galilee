package org.galilee.dms.controller;

import java.util.List;

import org.galilee.dms.model.SiteInfo;
import org.galilee.dms.model.Sites;
import org.galilee.dms.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class SiteController {
	private static final Logger logger = LoggerFactory
			.getLogger(SiteController.class);

	@Autowired
	private SiteService siteService;
	/*
	 * Services - basic site web resource
	 */
	@RequestMapping(value = "/sites", method = RequestMethod.POST)
	public void create(@RequestBody Sites site) {

		this.siteService.add(site);
		logger.debug("add() proces has been called.");
	}	

	@RequestMapping(value = "/sites/{id}", method = RequestMethod.GET)
	public Sites find(@PathVariable("id") int siteID) {

		logger.debug("find() proces has been called.");
		return this.siteService.findByID(siteID);
	}

	@RequestMapping(value = "/sites", method = RequestMethod.PUT)
	public void update(@RequestBody Sites site) {

		logger.debug("update() proces has been called.");
		this.siteService.update(site);
	}
	
	@RequestMapping(value = "/sites", method = RequestMethod.DELETE)
	public void delete(@RequestBody int siteID) {

		this.siteService.delete(siteID);
		logger.info("delete() proces has been called.");
	}	

	/*
	 * Servies - collection site web resource
	 */
	@RequestMapping(value = "/sites", method = RequestMethod.GET)
	public List<Sites> findAll() {

		logger.debug("findAll() proces has been called.");
		return this.siteService.findAll();
	}
	
	@RequestMapping(value = "/rivers/{id}/sites", method = RequestMethod.GET)
	public List<Sites> findByRiver(@PathVariable("id") int riverID) {

		logger.debug("findByRiver() proces has been called.");

		logger.debug("RIVER ID:{}", riverID);
		return this.siteService.findByRiver(riverID);			
	}
/*	
	@RequestMapping(value = "/rivers/{id}/sites", method = RequestMethod.GET)
	public List<Sites> findByRiver(@PathVariable("id") List<Integer> rIDList) {

		logger.debug("findByRiver() proces has been called.");

		logger.debug("RIVERIDS:{}",rIDList);
		return this.siteService.findByRivers(rIDList);				
	}
	*/
	@RequestMapping(value = "/sites", params = "list", method = RequestMethod.GET)
	public List<Sites> findSites(@RequestParam("list") List<Integer> siteIDs) {
		
		logger.debug("findSites() proces has been called.");
		return this.siteService.findByIDs(siteIDs);
	}
		
	@RequestMapping(value = "/sites", params = "name")
	public Sites find(@RequestParam("name") String name) {

		logger.debug("find() proces has been called.");
		return this.siteService.findByName(name);
	}

	@RequestMapping(value = "/sites", params = "basin", method = RequestMethod.GET)
	public List<Sites> findByBasin(@RequestParam("basin") String basin) {

		logger.debug("findByBasin() proces has been called.");
		logger.debug("BASIN:{}",basin);
		return this.siteService.findByBasin(basin);				
	}
	
	@RequestMapping(value = "/sites", params = "midWatershed", method = RequestMethod.GET)
	public List<Sites> findByMid(@RequestParam("midWatershed") String mid) {

		logger.debug("findByMid() proces has been called.");
		logger.debug("MIDWATERSHED:{}",mid);
		return this.siteService.findByMid(mid);				
	}
	
	@RequestMapping(value = "/sites", params = "subWatershed", method = RequestMethod.GET)
	public List<Sites> findBySub(@RequestParam("subWatershed") String sub) {

		logger.debug("findBySub() proces has been called.");
		logger.debug("SUBWATERSHED:{}", sub);
		return this.siteService.findBySub(sub);				
	}
	
	@RequestMapping(value = "/sites", params = {"basin", "classification"}, method = RequestMethod.GET)
	public List<Sites> findByBasinClass(@RequestParam("basin") String basin, @RequestParam("classification") String classification) {

		logger.debug("findByBasin() proces has been called.");

		logger.debug("BASIN:{},CLASSIFICATION:{}",basin, classification);
		return this.siteService.findByBasinClass(basin, classification);				
	}
	
	@RequestMapping(value = "/sites", params = {"basin", "order"}, method = RequestMethod.GET)
	public List<Sites> findByBasinOrder(@RequestParam("basin") String basin, @RequestParam("order") int streamOrder) {

		logger.debug("findByBasin() proces has been called.");

		logger.debug("BASIN:{},STREAMORDER:{}",basin, streamOrder);
		return this.siteService.findByBasinOrder(basin, streamOrder);				
	}
	
	/*
	 * Services - siteInfo 
	 */
	
	@RequestMapping(value = "/siteInfos", method = RequestMethod.GET)
	public List<SiteInfo> findAllSiteInfo() {

		logger.debug("findAllSiteInfo() proces has been called.");
		return this.siteService.findAllSiteInfo();
	}
	
	@RequestMapping(value = "/siteInfos", params = "list", method = RequestMethod.GET)
	public List<SiteInfo> findAllSiteInfos(@RequestParam("list") List<Integer> siIDs) {
		
		logger.debug("findSiteInfos() proces has been called.");
		return this.siteService.findInfoByIDs(siIDs);
	}	

	@RequestMapping(value = "/siteInfos", params = {"basin"}, method = RequestMethod.GET)
	public List<SiteInfo> findSiteInfosByBasin(@RequestParam("basin") String basin) {
		
		logger.debug("findSiteInfoByBasin() proces has been called.");
		return this.siteService.findInfosByBasin( basin);
	}

	@RequestMapping(value = "/rivers/{id}/siteInfos", method = RequestMethod.GET)
	public List<SiteInfo> findInfoByRiver(@PathVariable("id") List<Integer> rIDList) {

		logger.debug("findInfoByRiver() proces has been called.");

		logger.debug("RIVERIDS:{}",rIDList);
		return this.siteService.findInfoByRivers(rIDList);				
	}
}