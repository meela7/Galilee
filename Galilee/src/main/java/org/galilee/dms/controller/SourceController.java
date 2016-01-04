package org.galilee.dms.controller;

import java.util.List;

import org.galilee.dms.model.Sources;
import org.galilee.dms.service.SourceService;
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
public class SourceController {
	private static final Logger logger = LoggerFactory.getLogger(SourceController.class);
	
	@Autowired
	private SourceService sourceService;
	
	/*
	 * Services - basic source web resources
	 */
	@RequestMapping(value="/sources", method=RequestMethod.POST)
	public Sources create(@RequestBody Sources source){
		sourceService.add(source);
		logger.debug("add() proces has been called.");
        return source;
	}
	
	@RequestMapping(value="/sources/{id}", method=RequestMethod.GET)
	public Sources find(@PathVariable("id") int sourceID){
		Sources source = sourceService.findByID(sourceID);
		logger.debug("find() proces has been called.");
		return source;
	}
	
	@RequestMapping(value="/sources", method=RequestMethod.PUT)
	public Sources update(@RequestBody Sources source){
		sourceService.update(source);
		logger.debug("update() proces has been called.");
        return source;
	}
	
	@RequestMapping(value="/sources", method=RequestMethod.DELETE)
	public void delete(@RequestBody int sourceID){
		this.sourceService.delete(sourceID);
		logger.debug("delete() proces has been called.");
	}
	
	/*
	 * Services - source collection web resources
	 */
	
	@RequestMapping(value="/sources", method=RequestMethod.GET)
	public List<Sources> findAll(){
		List<Sources> sourceList = sourceService.findAll();
		logger.debug("findAll() proces has been called.");
        return sourceList;
	}
	
	@RequestMapping(value="/sources", params="institute", method=RequestMethod.GET)
	public List<Sources> findByInstitute(@RequestParam("institute") String institute){
		
		logger.debug("findByContact() proces has been called.");
        return this.sourceService.findByInstitute(institute);
	}
	
	@RequestMapping(value="/sources", params="contact", method=RequestMethod.GET)
	public List<Sources> findByContact(@RequestParam("contact") String contact){
		
		logger.debug("findByContact() proces has been called.");
        return this.sourceService.findByContact(contact);
	}
}