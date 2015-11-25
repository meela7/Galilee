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
public class RiverController {
	private static final Logger logger = LoggerFactory.getLogger(RiverController.class);
	
	@Autowired
	private RiverService riverService;
	
	@RequestMapping(value="/rivers", method=RequestMethod.POST)
	public void create(@RequestBody Rivers river){
		
		this.riverService.add(river);
		logger.info("add() proces has been called.");
	}

	@RequestMapping(value="/rivers", method=RequestMethod.GET)
	public List<Rivers> findAll(){
		
		logger.info("findAll() proces has been called.");
        return this.riverService.findAll();
	}

	@RequestMapping(value="/rivers/{id}", method=RequestMethod.GET)
	public Rivers find(@PathVariable("id") int riverID){
		
		logger.info("find() proces has been called.");
		return this.riverService.findByID(riverID);
	}
	
	@RequestMapping(value="/rivers", method=RequestMethod.PUT)
	public void update(@RequestBody Rivers river){
		
		this.riverService.update(river);
		logger.info("update() proces has been called.");
	}
	
	@RequestMapping(value="/rivers", method=RequestMethod.DELETE)
	public void delete(@RequestBody int riverID){
		
		this.riverService.delete(riverID);
		logger.info("delete() proces has been called.");
	}	
	
	@RequestMapping(value="/rivers", params="id", method=RequestMethod.GET)
	public List<Rivers> findRivers(@RequestParam("id") List<Integer> riverIDs){
		
		logger.info("findRivers() proces has been called.");
        return this.riverService.findByIDs(riverIDs);
	}
	
}