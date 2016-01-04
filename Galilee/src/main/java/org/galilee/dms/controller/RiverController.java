package org.galilee.dms.controller;

import java.util.List;

import org.galilee.dms.model.Rivers;
import org.galilee.dms.service.RiverService;
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
public class RiverController {
	private static final Logger logger = LoggerFactory.getLogger(RiverController.class);
	
	@Autowired
	private RiverService riverService;
	
	/*
	 * Services - basic river web resources
	 */
	@RequestMapping(value="/rivers", method=RequestMethod.POST)
	public void create(@RequestBody Rivers river){
		
		this.riverService.add(river);
		logger.info("add() process has been called.");
	}

	@RequestMapping(value="/rivers/{id}", method=RequestMethod.GET)
	public Rivers find(@PathVariable("id") int riverID){
		
		logger.info("find() process has been called.");
		return this.riverService.findByID(riverID);
	}
	
	@RequestMapping(value="/rivers", method=RequestMethod.PUT)
	public void update(@RequestBody Rivers river){
		
		this.riverService.update(river);
		logger.info("update() process has been called.");
	}
	
	@RequestMapping(value="/rivers", method=RequestMethod.DELETE)
	public void delete(@RequestBody int riverID){
		
		this.riverService.delete(riverID);
		logger.info("delete() process has been called.");
	}
	
	/*
	 * Services - river collection web resource
	 */	

	@RequestMapping(value="/rivers", method=RequestMethod.GET)
	public List<Rivers> findAll(){
		
		logger.info("findAll() process has been called.");
        return this.riverService.findAll();
	}
	
	@RequestMapping(value="/rivers", params="list", method=RequestMethod.GET)
	public List<Rivers> findByIDList(@RequestParam("list") List<Integer> riverIDs){
		
		logger.info("findByIDList() proces has been called.");
        return this.riverService.findByIDs(riverIDs);
	}
	
	@RequestMapping(value="/rivers", params="basin", method=RequestMethod.GET)
	public List<Rivers> findByBasin(@RequestParam("basin") String basin){
		
		logger.info("findByBasin() process has been called.");
        return this.riverService.findByBasin(basin);
	}
	
	@RequestMapping(value="/rivers", params="midWatershed", method=RequestMethod.GET)
	public List<Rivers> findByMid(@RequestParam("midWatershed") String mid){
		
		logger.info("findByMid() process has been called.");
        return this.riverService.findByMid(mid);
	}
	
	@RequestMapping(value="/rivers", params="subWatershed", method=RequestMethod.GET)
	public List<Rivers> findBySub(@RequestParam("subWatershed") String sub){
		
		logger.info("findBySub() process has been called.");
        return this.riverService.findBySub(sub);
	}
	
	@RequestMapping(value="/rivers", params="classification", method=RequestMethod.GET)
	public List<Rivers> findByClass(@RequestParam("classification") String classification){
		
		logger.info("findByClass() process has been called.");
        return this.riverService.findByClassification(classification);
	}
	
	@RequestMapping(value="/rivers", params= {"basin", "classification"}, method=RequestMethod.GET)
	public List<Rivers> findByBasinNClass(@RequestParam("basin") String basin, @RequestParam("classification") String classification){
		
		logger.info("findByBasinNClass() process has been called.");
        return this.riverService.findByBasinNClass(basin, classification);
	}
}