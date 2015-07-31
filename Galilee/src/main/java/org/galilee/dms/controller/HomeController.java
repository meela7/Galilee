package org.galilee.dms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * redirect to index page.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "galilee";
	}
	
	/**
	 * redirect to static pgae.
	 */
	
//	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
//	   public String redirect() {
//	     
//	      return "redirect:/test/index.html";
//	   }
}
