package org.galilee.dms.controller;

import java.util.List;

import org.galilee.dms.model.Taxon;
import org.galilee.dms.model.Basin;
import org.galilee.dms.service.TaxomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaxomController {
	TaxomService taxomService;

	@Autowired
	public TaxomController(TaxomService taxomService) {
		this.taxomService = taxomService;
	}

	@RequestMapping("/basin")
	public ModelAndView getBasin() {
		List<String> basins = (List<String>) taxomService.getBasin();
		return new ModelAndView("river/basin", "basin", basins);
	}

	// @RequestMapping("/watersystem")
	// public ModelAndView getWaterSystem() {
	// List<String> ws = (List<String>) basinService.getWaterSystem();
	// return new ModelAndView("river/watersystem", "watersystem",ws);
	// }

	@RequestMapping("/watersystem")
	public ModelAndView getWaterSystem(@RequestParam String basin) {
		List<String> ws = (List<String>) taxomService.getWterSystemByBasin(basin);
		return new ModelAndView("river/watersystem", "watersystem", ws);
	}
	
	@RequestMapping("/subwatershed")
	public ModelAndView getSubWatershed(@RequestParam String ws) {
		List<String> subWS = (List<String>) taxomService.getSubWtershed(ws);
		return new ModelAndView("river/subwatershed", "subWS", subWS);
	}
	
	@RequestMapping("/river/taxom")
	public ModelAndView getRiverTaxom() {
		List<Basin> river = (List<Basin>) taxomService.getRiverTaxom();
		return new ModelAndView("river/taxom", "river", river);
	}
	
	@RequestMapping("/fish/taxom")
	public ModelAndView getFishTaxom() {
		List<Taxon> fish = (List<Taxon>) taxomService.getFishTaxom();
		return new ModelAndView("fish/taxom", "fish", fish);
	}
}
