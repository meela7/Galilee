package org.galilee.dms.controller;

import java.util.List;  

import org.galilee.dms.model.Sites;
import org.galilee.dms.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;  

@Controller  
public class SiteController {
	SiteService siteService;
	 
	 @Autowired 
	 public SiteController(SiteService siteService){
		 this.siteService = siteService;
	 }
	  
	 @RequestMapping(value="/site/form", method=RequestMethod.GET)  
	 public ModelAndView getForm(@ModelAttribute Sites site) {  
	  return new ModelAndView("site/inputForm");  
	 }  
	  
	 @RequestMapping("/site/insert")  
	 public ModelAndView registerSite(@ModelAttribute Sites site) {  
		 siteService.insertSite(site);  
	  return new ModelAndView("redirect:/site/list");  
	 }  
	  
	 @RequestMapping("/site/list")  
	 public ModelAndView getList() {  
	  List<Sites> siteList = (List<Sites>)siteService.getList();
	  return new ModelAndView("site/siteList", "siteList", siteList);  
	 }  
	  
	 @RequestMapping("/site/siteInfo")  
	 public ModelAndView getSite(@RequestParam int siteid,  
	   @ModelAttribute Sites site) {  
		 site = siteService.getSite(siteid);
		 return new ModelAndView("site/siteInfo", "site", site);  
	 }
	 
	 @RequestMapping("/site/delete")  
	 public ModelAndView deleteSite(@RequestParam int siteid) {  
		 siteService.deleteSite(siteid);  
		 return new ModelAndView("redirect:/site/list");
	 }  
	  
	 @RequestMapping("/site/edit")  
	 public ModelAndView editSite(@RequestParam int siteid,  
	   @ModelAttribute Sites site) {  
		 site = siteService.getSite(siteid);  
		 return new ModelAndView("site/siteEdit", "site", site);  
	 }  
	  
	 @RequestMapping("/site/update")  
	 public ModelAndView updateSite(@ModelAttribute Sites site) {  
		 siteService.updateSite(site);  
		 return new ModelAndView("redirect:/site/list");  
	 }  
}
