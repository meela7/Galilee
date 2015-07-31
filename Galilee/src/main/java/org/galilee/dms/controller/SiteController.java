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
	private static final Logger logger = LoggerFactory.getLogger(SiteController.class);
	
	@Autowired
	private SiteService siteService;
	
	@RequestMapping(value="/site/create", method=RequestMethod.POST)
	public Sites create(@RequestBody Sites site){
		
		this.siteService.add(site);
		logger.info("add() proces has been called.");
		return site;
	}
	
	@RequestMapping(value="/site/update", method=RequestMethod.POST)
	public Sites update(@RequestBody Sites site){
		
		logger.info("update() proces has been called.");
		return this.siteService.update(site);
	}
	
	@RequestMapping(value="/site/delete", method=RequestMethod.POST)
	public void delete(@RequestBody int siteID){
		
		this.siteService.delete(siteID);
		logger.info("delete() proces has been called.");
	}
	
	@RequestMapping(value="/site/{id}", method=RequestMethod.GET)
	public Sites find(@PathVariable("id") int siteID){
		
		logger.info("find() proces has been called.");
		return this.siteService.findByID(siteID);
	}
	
	@RequestMapping(value="/sites", method=RequestMethod.GET)
	public List<Sites> findAll(){
		
		logger.info("findAll() proces has been called.");
        return this.siteService.findAll();
	}
	
	@RequestMapping(value="/sites/page/{id}", method=RequestMethod.GET)
	public List<Sites> findByPage(@PathVariable("id") int pageNum){
		
		logger.info("findByPage() proces has been called.");
        return this.siteService.findAll();
	}
}