package com.iris.get19.pbms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

	@Autowired
	HttpSession session;
	
	
/*	
	
	@RequestMapping(value= {"/","Home"}, method=RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value= {"/login"}, method=RequestMethod.GET)
	public String loginpage() {
		return "login";
	}
	
	@RequestMapping(value= {"logout"}, method=RequestMethod.GET)
	public String logout() {
		session.removeAttribute("userObj");
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value= {"contact"}, method=RequestMethod.GET)
	public String contact() {
		return "contact";
	}
	
	@RequestMapping(value= {"about"}, method=RequestMethod.GET)
	public String about() {
		return "about";
	}*/
}
