package com.iris.get19.pbms.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.service.AdminService;

@RestController
public class LoginController {
	
	@Autowired 
	private AdminService adminService;
	@Autowired
	HttpSession session;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/validateRole",method=RequestMethod.POST)
	public ResponseEntity<?> validateRole(@RequestBody Developer dev) {
		Developer devObj = adminService.getDeveloper(dev);
		if(devObj==null){
			return new ResponseEntity<String>("null",HttpStatus.UNAUTHORIZED);
		} 
		else {
			session.setAttribute("userObj",devObj );
			return new ResponseEntity<Developer>(devObj,HttpStatus.OK);
		}
	}
/*	@Autowired 
	private DeveloperDao developerDao;
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="validateRole",method=RequestMethod.POST)
	public String validateRole(@RequestParam(value="id") Integer id,@RequestParam("pwd") String pass, Model map) {
		Developer devobj = developerDao.getDeveloper(id,pass);
		if(devobj==null){
			map.addAttribute("msg", "Invalid Credentials.");
			return "login";
		} else {
			
			session.setAttribute("userObj",devobj );
			if(devobj.getRole().equals("Admin")){
				map.addAttribute(devobj);
				
				return "adminDashboard";
			}
			else if(devobj.getRole().equals("DEO")){
				System.out.print("asdjkbfd +"+devobj);
				map.addAttribute("userObj",devobj);
				return "DataEntry";
			}
		}
		return null;
	}*/
}
