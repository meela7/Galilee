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
	@RequestMapping(value = "/site/create", method = RequestMethod.POST)
	public void create(@RequestBody Sites site) {

		this.siteService.add(site);
		logger.debug("add() proces has been called.");
	}	

	@RequestMapping(value = "/site/{id}", method = RequestMethod.GET)
	public Sites find(@PathVariable("id") int siteID) {

		logger.debug("find() proces has been called.");
		return this.siteService.findByID(siteID);
	}

	@RequestMapping(value = "/site/update", method = RequestMethod.POST)
	public void update(@RequestBody Sites site) {

		logger.debug("update() proces has been called.");
		this.siteService.update(site);
	}

	@RequestMapping(value = "/site/delete", method = RequestMethod.POST)
	public void delete(@RequestBody int siteID) {

		this.siteService.delete(siteID);
		logger.info("delete() proces has been called.");
	}
	
	@RequestMapping(value = "/sites", method = RequestMethod.GET)
	public List<Sites> findAll() {

		logger.debug("findAll() proces has been called.");
		return this.siteService.findAll();
	}
	
	@RequestMapping(value = "/siteInfos", method = RequestMethod.GET)
	public List<SiteInfo> findAllSiteInfo() {

		logger.debug("findAll() proces has been called.");
		return this.siteService.findAllSiteInfo();
	}

	@RequestMapping(value = "/sites/{id}", method = RequestMethod.GET)
	public List<Sites> findSites(@PathVariable("id") List<Integer> siteIDs) {
		
		logger.debug("findAll() proces has been called.");
		return this.siteService.findByIDs(siteIDs);
	}
	
	@RequestMapping(value = "/siteInfos/{id}", method = RequestMethod.GET)
	public List<SiteInfo> findSiteInfos(@PathVariable("id") List<Integer> siIDs) {
		
		logger.debug("findAll() proces has been called.");
		return this.siteService.findInfoByIDs(siIDs);
	}
	
/*
 * search Site By Site Column
 */	
	@RequestMapping(value = "/sites/basin/{basin}", method = RequestMethod.GET)
	public List<Sites> findByBasin(@PathVariable("basin") String basin) {

		logger.debug("findByBasin() proces has been called.");

		logger.debug("BASIN:{}",basin);
		return this.siteService.findByBasin(basin);				
	}
	
//	@RequestMapping(value = "/sites/basin/{basin}/{division}", method = RequestMethod.GET)
//	public List<Sites> findByBasin(@PathVariable("basin") String basin, @PathVariable("division") String division) {
//
//		logger.debug("findByBasin() proces has been called.");
//
//		logger.debug("Division:{}",division);
//		return this.siteService.findByBasinDiv(division);				
//	}
	
/*
 * search Site By River	Column
 */
	// parse riverID string to array and get List<Sites> by riverIDs 
	@RequestMapping(value = "/sites/river/{id}", method = RequestMethod.GET)
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
}