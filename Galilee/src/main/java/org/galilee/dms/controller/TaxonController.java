package org.galilee.dms.controller;

import java.util.List;
import org.galilee.dms.service.TaxonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaxonController {
	TaxonService taxonService;

	@Autowired
	public TaxonController(TaxonService taxonService) {
		this.taxonService = taxonService;
	}

	@RequestMapping("/basin")
	public ModelAndView getBasin() {
		List<List> basins = (List<List>) taxonService.getBasin();
		return new ModelAndView("river/basin", "basin", basins);
	}

	// @RequestMapping("/watersystem")
	// public ModelAndView getWaterSystem() {
	// List<String> ws = (List<String>) basinService.getWaterSystem();
	// return new ModelAndView("river/watersystem", "watersystem",ws);
	// }

	@RequestMapping("/watersystem")
	public ModelAndView getWaterSystem(@RequestParam String basin) {
		List<String> ws = (List<String>) taxonService.getWterSystemByBasin(basin);
		return new ModelAndView("river/watersystem", "watersystem", ws);
	}
	
	@RequestMapping("/subwatershed")
	public ModelAndView getSubWatershed(@RequestParam String ws) {
		List<String> subWS = (List<String>) taxonService.getSubWtershed(ws);
		return new ModelAndView("river/subwatershed", "subWS", subWS);
	}
	
	@RequestMapping("/river/taxom")
	public ModelAndView getRiverTaxom() {
		List<List> taxon = (List<List>) taxonService.getBasin();
		return new ModelAndView("river/basin", "basin", taxon);
	}
	
//	@RequestMapping("/fish/taxom")
//	public ModelAndView getFishTaxom() {
//		List<Taxon> fish = (List<Taxon>) taxonService.getFishTaxon();
//		return new ModelAndView("fish/taxom", "fish", fish);
//	}
}
