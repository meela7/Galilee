package org.galilee.dms.controller;

import java.util.List;  

import org.galilee.dms.model.Rivers;
import org.galilee.dms.service.RiverService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;  

@Controller  
public class RiverController {
	RiverService riverService;
	 
	 @Autowired 
	 public RiverController(RiverService riverService){
		 this.riverService = riverService;
	 }
	  
	 @RequestMapping(value="/river/form", method=RequestMethod.GET)  
	 public ModelAndView getForm(@ModelAttribute Rivers river) {  
	  return new ModelAndView("river/inputForm");  
	 }  
	  
	 @RequestMapping("/river/insert")  
	 public ModelAndView registerSite(@ModelAttribute Rivers river) {  
		 riverService.insertRiver(river);  
	  return new ModelAndView("redirect:/river/list");  
	 }  
	  
	 @RequestMapping("/river/list")  
	 public ModelAndView getList() {  
	  List<Rivers> riverList = (List<Rivers>)riverService.getList();
	  return new ModelAndView("river/riverList", "riverList", riverList);  
	 }  
	  
	 @RequestMapping("/river/riverInfo")  
	 public ModelAndView getRiver(@RequestParam int rid,  
	   @ModelAttribute Rivers river) {  
		 river = riverService.getRiver(rid);
		 return new ModelAndView("river/riverInfo", "river", river);  
	 }
	 
	 @RequestMapping("/river/delete")  
	 public ModelAndView deleteRiver(@RequestParam int rid) {  
		 riverService.deleteRiver(rid);  
		 return new ModelAndView("redirect:/river/list");
	 }  
	  
	 @RequestMapping("/river/edit")  
	 public ModelAndView editRiver(@RequestParam int rid,  
	   @ModelAttribute Rivers river) {  
		 river = riverService.getRiver(rid);  
		 return new ModelAndView("river/riverEdit", "river", river);  
	 }  
	  
	 @RequestMapping("/river/update")  
	 public ModelAndView updateRiver(@ModelAttribute Rivers river) {  
		 riverService.updateRiver(river);  
		 return new ModelAndView("redirect:/river/list");  
	 }  
}
