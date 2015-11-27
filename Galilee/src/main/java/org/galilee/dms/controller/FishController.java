package org.galilee.dms.controller;

import java.util.List;

import org.galilee.dms.model.Fishes;
import org.galilee.dms.service.FishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FishController {
	private static final Logger logger = LoggerFactory
			.getLogger(FishController.class);

	@Autowired
	private FishService fishService;

	@RequestMapping(value = "/fishes", method = RequestMethod.POST)
	public void create(@RequestBody Fishes fish) {

		this.fishService.add(fish);
		logger.debug("add() proces has been called.");
	}

	@RequestMapping(value = "/fishes", method = RequestMethod.PUT)
	public void update(@RequestBody Fishes fish) {

		logger.debug("update() proces has been called.");
		logger.debug("IMAGE:{}" + fish.getImageLink());
		this.fishService.update(fish);
	}

	@RequestMapping(value = "/fishes", method = RequestMethod.DELETE)
	public void delete(@RequestBody Fishes fish) {

		this.fishService.delete(fish);
		logger.debug("delete() proces has been called.");
	}

	@RequestMapping(value = "/fishes/{id}", method = RequestMethod.GET)
	public Fishes find(@PathVariable("id") int fishID) {

		logger.debug("find() proces has been called.");
		return this.fishService.findByID(fishID);
	}

	@RequestMapping(value = "/fishes", method = RequestMethod.GET)
	@ResponseBody
	public List<Fishes> findAll() {

		logger.debug("findAll() proces has been called.");
		
		return this.fishService.findAll();
	}
	
	@RequestMapping(value = "/fishes", params = "ids",  method = RequestMethod.GET)
	public List<Fishes> findFishes(@RequestParam("ids") List<Integer> fishIDList) {

		logger.debug("findFishes() proces has been called.");
		return this.fishService.findByIDs(fishIDList);
	}	
	
//	@RequestMapping(value = "/fishes/feature/{id}", method = RequestMethod.GET)
	@RequestMapping(value = "/features/{id}/fishes", method = RequestMethod.GET)
	public Fishes findFishByFeature(@PathVariable("id") int featureID) {

		logger.debug("findFishByFeature() proces has been called.");
		
		return this.fishService.findByID(featureID);
	}
	
	@RequestMapping(value = "/fishes/{id}/endangered", method = RequestMethod.GET)
	public List<Fishes> findEndangered(@PathVariable("id") List<Integer> fishIDList) {
		
		logger.debug("findEndangered() proces has been called.");
		return this.fishService.findEndangered(fishIDList);
	}

}