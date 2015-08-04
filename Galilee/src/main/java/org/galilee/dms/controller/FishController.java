package org.galilee.dms.controller;

import java.util.List;

import org.galilee.dms.model.Fishes;
import org.galilee.dms.service.FishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FishController {
	private static final Logger logger = LoggerFactory
			.getLogger(FishController.class);

	@Autowired
	private FishService fishService;

	@RequestMapping(value = "/fish/create", method = RequestMethod.POST)
	public void create(@RequestBody Fishes fish) {

		this.fishService.add(fish);
		logger.info("add() proces has been called.");
	}

	@RequestMapping(value = "/fish/update", method = RequestMethod.POST)
	public void update(@RequestBody Fishes fish) {

		logger.info("update() proces has been called.");
		this.fishService.update(fish);
	}

	@RequestMapping(value = "/fish/delete", method = RequestMethod.POST)
	public void delete(@RequestBody Fishes fish) {

		this.fishService.delete(fish);
		logger.info("delete() proces has been called.");
	}

	@RequestMapping(value = "/fish/{id}", method = RequestMethod.GET)
	public Fishes find(@PathVariable("id") int fishID) {

		logger.info("find() proces has been called.");
		return this.fishService.findByID(fishID);
	}

	@RequestMapping(value = "/fishes", method = RequestMethod.GET)
	public List<Fishes> findAll() {

		logger.info("findAll() proces has been called.");
		return this.fishService.findAll();
	}
	
	
	@RequestMapping(value = "/fish/feature/{id}", method = RequestMethod.GET)
	public Fishes findFishByFeature(@PathVariable("id") int featureID) {

		logger.info("findFishByFeature() proces has been called.");
		
		return this.fishService.findByID(featureID);
	}

}