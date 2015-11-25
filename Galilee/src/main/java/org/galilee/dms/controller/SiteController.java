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
public class SiteController {
	private static final Logger logger = LoggerFactory
			.getLogger(SiteController.class);

	@Autowired
	private SiteService siteService;
/*
 * CRUD
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
	
	@RequestMapping(value = "/sites", params = "name")
	public Sites find(@RequestParam("name") String name) {

		logger.debug("find() proces has been called.");
		return this.siteService.findByName(name);
	}
	
	@RequestMapping(value = "/sites", method = RequestMethod.GET)
	public List<Sites> findAll() {

		logger.debug("findAll() proces has been called.");
		return this.siteService.findAll();
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
	
	@RequestMapping(value = "/siteInfos", method = RequestMethod.GET)
	public List<SiteInfo> findAllSiteInfo() {

		logger.debug("findAllSiteInfo() proces has been called.");
		return this.siteService.findAllSiteInfo();
	}

	@RequestMapping(value = "/sites", params = "ids", method = RequestMethod.GET)
	public List<Sites> findSites(@RequestParam("ids") List<Integer> siteIDs) {
		
		logger.debug("findSites() proces has been called.");
		return this.siteService.findByIDs(siteIDs);
	}
	
	@RequestMapping(value = "/siteInfos", params = "ids", method = RequestMethod.GET)
	public List<SiteInfo> findSiteInfos(@RequestParam("ids") List<Integer> siIDs) {
		
		logger.debug("findSiteInfos() proces has been called.");
		return this.siteService.findInfoByIDs(siIDs);
	}
	
/*
 * search
 */	
	@RequestMapping(value = "/sites", params = "basin", method = RequestMethod.GET)
	public List<Sites> findByBasin(@RequestParam("basin") String basin) {

		logger.debug("findByBasin() proces has been called.");

		logger.debug("BASIN:{}",basin);
		return this.siteService.findByBasin(basin);				
	}
	
	@RequestMapping(value = "/sites", params = "mid", method = RequestMethod.GET)
	public List<Sites> findByMid(@RequestParam("mid") String mid) {

		logger.debug("findByMid() proces has been called.");

		logger.debug("MIDWATERSHED:{}",mid);
		return this.siteService.findByMid(mid);				
	}
	
	@RequestMapping(value = "/sites", params = "sub", method = RequestMethod.GET)
	public List<Sites> findBySub(@RequestParam("sub") String sub) {

		logger.debug("findBySub() proces has been called.");

		logger.debug("SUBWATERSHED:{}", sub);
		return this.siteService.findBySub(sub);				
	}
	
	@RequestMapping(value = "/sites", params = "river", method = RequestMethod.GET)
	public List<Sites> findByRiver(@RequestParam("river") String river) {

		logger.debug("findByRiver() proces has been called.");

		logger.debug("RIVER:{}", river);
		return this.siteService.findByRiver(river);				
	}
	
	@RequestMapping(value = "/siteInfos", params = {"ids", "basin"}, method = RequestMethod.GET)
	public List<SiteInfo> findSiteInfosByBasin(@RequestParam("ids") List<Integer> siIDs, @RequestParam("basin") String basin) {
		
		logger.debug("findAll() proces has been called.");
		return this.siteService.findInfosByBasin(siIDs, basin);
	}
		
/*
 * search Site By River	Column
 */
	// parse riverID string to array and get List<Sites> by riverIDs 
	@RequestMapping(value = "/rivers/{id}/sites", method = RequestMethod.GET)
	public List<Sites> findByRiver(@PathVariable("id") List<Integer> rIDList) {

		logger.debug("findByRiver() proces has been called.");

		logger.debug("RIVERIDS:{}",rIDList);
		return this.siteService.findByRivers(rIDList);				
	}
	
	@RequestMapping(value = "/siteInfos/river/{id}", method = RequestMethod.GET)
	public List<SiteInfo> findInfoByRiver(@PathVariable("id") List<Integer> rIDList) {

		logger.debug("findInfoByRiver() proces has been called.");

		logger.debug("RIVERIDS:{}",rIDList);
		return this.siteService.findInfoByRivers(rIDList);				
	}
/*
 * search Site By Two River	Column
 */
	@RequestMapping(value = "/sites", params = {"basin", "cassification"}, method = RequestMethod.GET)
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
}