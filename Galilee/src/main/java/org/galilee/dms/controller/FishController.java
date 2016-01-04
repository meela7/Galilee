package org.galilee.dms.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class FishController {
	private static final Logger logger = LoggerFactory
			.getLogger(FishController.class);

	@Autowired
	private FishService fishService;
	
	/*
	 * Services - basic fish web resource
	 */		
	@RequestMapping(value = "/fishes", method = RequestMethod.POST)
	public void create(@RequestBody Fishes fish) {

		this.fishService.add(fish);
		logger.debug("add() proces has been called.");
	}

	@RequestMapping(value = "/fishes/{id}", method = RequestMethod.GET)
	public Fishes find(@PathVariable("id") int fishID) {

		logger.debug("find() proces has been called.");
		return this.fishService.findByID(fishID);
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

	/*
	 * Services - collection fish web resource
	 */
	@RequestMapping(value = "/fishes", method = RequestMethod.GET)
	public List<Fishes> findAll() {

		logger.debug("findAll() proces has been called.");		
		return this.fishService.findAll();
	}
	
	@RequestMapping(value = "/fishes", params = {"list"}, method = RequestMethod.GET)
	public List<Fishes> findFishes(@RequestParam("list") List<Integer> fishIDList) {

		logger.debug("findFishes() proces has been called.");
		return this.fishService.findByIDSet(fishIDList);
	}		
	
	@RequestMapping(value = "/fishes", params = {"taxon"}, method = RequestMethod.GET)
	public List<Fishes> searchFishesByTaxon(@RequestParam("taxon") String taxon) {
	
		logger.debug("findEndangered() proces has been called.");
		return this.fishService.findByTaxon(taxon);		
	}
	
	@RequestMapping(value = "/fishes", params = {"class"}, method = RequestMethod.GET)
	public List<Fishes> searchFishesByClass(@RequestParam("class") String name) {
	
		logger.debug("findEndangered() proces has been called.");
		return this.fishService.findByClass(name);		
	}
	
	@RequestMapping(value = "/fishes", params = {"order"}, method = RequestMethod.GET)
	public List<Fishes> searchFishesByOrder(@RequestParam("order") String name) {
	
		logger.debug("findEndangered() proces has been called.");
		return this.fishService.findByOrder(name);		
	}
	
	@RequestMapping(value = "/fishes", params = {"family"}, method = RequestMethod.GET)
	public List<Fishes> searchFishesByFamily(@RequestParam("family") String name) {
	
		logger.debug("findEndangered() proces has been called.");
		return this.fishService.findByFamily(name);		
	}
	
	@RequestMapping(value = "/fishes", params = {"char"}, method = RequestMethod.GET)
	public List<Fishes> searchFishesbyChar(@RequestParam("char") String character) {
		List<Fishes> fishes = new ArrayList<Fishes>();
		logger.debug("findEndangered() proces has been called.");
		if(character.equals("endangered"))	
			fishes = this.fishService.findEndangeredSpecies();
		else if(character.equals("tolerant"))
			fishes = this.fishService.findTolerantSpsecies();
		else if(character.equals("omnivore"))
			fishes = this.fishService.findOmnivoreSpsecies();
		else if(character.equals("insectivore"))
			fishes = this.fishService.findInsectivoreSpsecies();
		else if(character.equals("native"))
			fishes = this.fishService.findNativeSpecies();
		return fishes;
	}
}