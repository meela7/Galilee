package org.galilee.dms.controller;

import java.util.List;

import org.galilee.dms.model.Features;
import org.galilee.dms.service.FeatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FeatureController.class);

	@Autowired
	private FeatureService featureService;

	@RequestMapping(value = "/feature/create", method = RequestMethod.POST)
	public void create(@RequestBody Features feature) {

		this.featureService.add(feature);
		logger.info("add() proces has been called.");
	}

	@RequestMapping(value = "/feature/update", method = RequestMethod.POST)
	public void update(@RequestBody Features feature) {

		logger.info("update() proces has been called.");
		this.featureService.update(feature);
	}

	@RequestMapping(value = "/feature/delete", method = RequestMethod.POST)
	public void delete(@RequestBody Features feature) {

		this.featureService.delete(feature);
		logger.info("delete() proces has been called.");
	}

	@RequestMapping(value = "/feature/{id}", method = RequestMethod.GET)
	public Features find(@PathVariable("id") int featureID) {

		logger.info("find() proces has been called.");
		return this.featureService.findByID(featureID);
	}

	@RequestMapping(value = "/features", method = RequestMethod.GET)
	public List<Features> findAll() {

		logger.info("findAll() proces has been called.");
		return this.featureService.findAll();
	}

}