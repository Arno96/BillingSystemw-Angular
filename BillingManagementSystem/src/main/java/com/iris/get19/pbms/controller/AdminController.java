package com.iris.get19.pbms.controller;

import java.util.List;

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
import com.iris.get19.pbms.dao.model.DeveloperRole;
import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;
import com.iris.get19.pbms.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	HttpSession session;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value= "/submitProjectConfig",method=RequestMethod.POST)
	public boolean submitConfig(@RequestBody ProjectConfiguration projObj) {
		
		/*if(checkSession(map)) {
			return new ModelAndView("login");
		}*/
		boolean saved = adminService.setProjectConfig(projObj);
		return saved;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value= "/getProjects",method=RequestMethod.GET)
	public ResponseEntity<List<Project>> getAllProject(@RequestBody ProjectConfiguration projObj) {
		
		/*if(checkSession(map)) {
			return new ModelAndView("login");
		}*/
		return new ResponseEntity<List<Project>>(adminService.getAllProjects(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value= "/getRoles",method=RequestMethod.GET)
	public ResponseEntity<List<DeveloperRole>> getAllRole(@RequestBody DeveloperRole roleObj) {
		
		/*if(checkSession(map)) {
			return new ModelAndView("login");
		}*/
		return new ResponseEntity<List<DeveloperRole>>(adminService.getAllRoles(),HttpStatus.OK);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value= "/addDevAllocate",method=RequestMethod.POST)
	public boolean devAllocate(@RequestBody Developer devObj) {
		boolean saved=adminService.setDevAllocate(devObj);
		return saved;
	}
	
/*	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DeveloperDao developerDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	HttpSession session;
	

	
	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("userObj")==null) {
			map.addAttribute("msg","Session doesnt exist.. Login First");
			return true;
		}
		return false;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView adminExceptionHandle(Exception e)
	{
		ModelAndView mv = new ModelAndView("errorException");
		//mv.addObject("msg","Error has been ocurred");
		mv.addObject("msg",e);
		return mv;
	}
	@RequestMapping(value= {"AddProj"},method=RequestMethod.GET)
	public String viewAdmin(ModelMap map) {
		
		if(checkSession(map)) {
			return "login";
		}
		List<ProjectConfiguration> projCon = adminService.getAllProjectConfig();
		map.addAttribute("configList", projCon);
		List<Project> projectList = adminService.getAllProject();
		ProjectConfiguration projectObj = new ProjectConfiguration();
		Role roleObj = new Role();
		List<Role> rolesList = adminService.getAllRole();
		map.addAttribute("pObj", projectObj);
		map.addAttribute("rObj",roleObj);
		map.addAttribute("proj", projectList);
		map.addAttribute("role",rolesList);
		return "AddProject";
	}
	
	@RequestMapping(value= {"AddDev"},method=RequestMethod.GET)
	public String addDev(ModelMap map)
	{
		if(checkSession(map)) {
			return "login";
		}
		ProjectAllocation paObj=new ProjectAllocation();
		map.addAttribute("pObj", paObj);
		
		List<ProjectConfiguration> projCon = adminService.getAllProjectConfigNotAllocated();
		map.addAttribute("projCon", projCon);
		List<Developer> devl = adminService.getAllDeveloperNotAllocated();
		map.addAttribute("devl",devl);
		return "ViewDev";
	}
	
	@RequestMapping(value= {"submitConfig"},method=RequestMethod.GET)
	public ModelAndView submitConfig(@Valid @ModelAttribute(name="pObj") ProjectConfiguration pObj,ModelMap map) {
		
		if(checkSession(map)) {
			return new ModelAndView("login");
		}
		
		
		boolean saved = adminService.setProjectConfig(pObj);
		map.addAttribute("msg","Project Configuration Successful");
		if(saved) {
			ModelAndView mv=new ModelAndView("redirect:http://localhost:9696/BillingSystem/AddProj");
			mv.addObject("msg","Configuration Added Succesfully..");
			return mv;
		} else {
			return new ModelAndView("AddProject");
		}
	}
	
	@RequestMapping(value= {"updateConfig"},method=RequestMethod.POST)
	public ModelAndView updateConfig(@ModelAttribute(name="pObj") ProjectConfiguration pObj, ModelMap map) {
		
		if(checkSession(map)) {
			return new ModelAndView("login");
		}
		
		boolean saved = adminService.updateProjectConfig(pObj);
		if(saved) {
			ModelAndView mv=new ModelAndView("redirect:http://localhost:9696/BillingSystem/AddProj");
			mv.addObject("msg","Configuration Edited Succesfully..");
			return mv;
		}
		else {
			ModelAndView mv=new ModelAndView("redirect:http://localhost:9696/BillingSystem/AddProj");
			mv.addObject("msg","Configuration Edited Unsucessfully..");
			return new ModelAndView("AddProject");
		}
	}
	@RequestMapping(value= {"submitAllocate"},method=RequestMethod.GET)
	public ModelAndView submitAllocate(@ModelAttribute(name="pObj") ProjectAllocation pObj, ModelMap map) {
		
		if(checkSession(map)) {
			return new ModelAndView("login");
		}
		
		boolean saved = adminService.setProjectAllocate(pObj);
		if(saved) {
			ModelAndView mv=new ModelAndView("redirect:http://localhost:9696/BillingSystem/AddDev");
			mv.addObject("msg","Developer Allocated Succesfully..");
			return mv;
		} else {
			return new ModelAndView("ViewDev");
		}
	}
	
	@RequestMapping(value= {"DevBilling"},method=RequestMethod.GET)
	public String DevBill(ModelMap map)
	{
		if(checkSession(map)) {
			return "login";
		}
		List<ProjectAllocation> dList = adminService.getAllAllocate();
		map.addAttribute("devL", dList);
		return "DevForm";
	}
	
	@RequestMapping(value= {"projectBilling"},method=RequestMethod.GET)
	public String ProjBill(ModelMap map)
	{
		if(checkSession(map)) {
			return "login";
		}
		List<Project> pList = adminService.getAllProject();
		map.addAttribute("pList", pList);
		return "ProjForm";
	}
	
	@RequestMapping(value= {"Bill"},method=RequestMethod.GET)
	public String DevBills(@RequestParam String month,@RequestParam int developerId,@RequestParam int year,ModelMap map)
	{
		if(checkSession(map)) {
			return "login";
		}
		ProjectAllocation configObj = adminService.getConfig(developerId);
		double perHourBilling=configObj.getPcObj() .getPER_HOUR_BILLING();
		String name = developerDao.getDeveloperById(developerId);
		map.addAttribute("name", name);
		DataEntryOperator deo=adminService.getBill(developerId, month,year);
		System.out.println(deo.getfullDay());
		double bill = adminService.getBill(perHourBilling,deo);
		map.addAttribute("bill",bill);
		map.addAttribute("de", developerId);
		map.addAttribute("mo",month);
		map.addAttribute("y",year);
		return "devDetail";
		
	}
	@RequestMapping(value= {"BillProj"},method=RequestMethod.GET)
	public String billingProject(@RequestParam(name="projectId") int id,@RequestParam(name="month") String month,@RequestParam(name="year") int year,ModelMap map) {
		
		if(checkSession(map)) {
			return "login";
		}
		try {
			System.out.println(id + month);
			double bill = 0;
			List<ProjectConfiguration> projConfigList=adminService.getAllConfigId(id);
		
			String name = adminService.getProjectName(id);
			map.addAttribute("name",name);
			map.addAttribute("month", month);
			int count = 0;
			List<Double> sum = new ArrayList<Double>();
			List<ProjectAllocation> obj = new ArrayList<ProjectAllocation>();
			for(ProjectConfiguration configObj: projConfigList)
			{
				int cid = configObj.getCONFIGURATION_ID();
				int perHourBilling = configObj.getPER_HOUR_BILLING();
				ProjectAllocation proAllocate = developerDao.getProAllocationObj(cid);
				int developerId = proAllocate.getdObj().getDeveloperId();
				DataEntryOperator deo=developerDao.getBill(developerId, month,year);
				double halfDay=deo.gethalfDay()*4.5;
				double fullDay=deo.getfullDay()*9;
				bill+=(halfDay*perHourBilling+fullDay*perHourBilling);
				double x = (halfDay*perHourBilling+fullDay*perHourBilling);
				sum.add(x);
				map.addAttribute("bills", sum);
				count++;
				obj.add(proAllocate);
			}
			map.addAttribute("bill", bill);
			map.addAttribute("count", count);
			map.addAttribute("devl", obj);
			return "ProjectBilling";
		}
		catch(Exception e) {
			return "error";
		}
	}
	@RequestMapping(value= {"homePage"},method=RequestMethod.GET)
	public String homePage(ModelMap map) {
		if(checkSession(map)) {
			return "login";
		}
		return "adminDashboard";
	}

	@RequestMapping(value="/updateOption/{CONFIGURATION_ID}",method=RequestMethod.GET)
	public String updateConfiguration(@PathVariable int CONFIGURATION_ID,ModelMap map){
		
		if(checkSession(map)) {
			return "login";
		}
		ProjectConfiguration pcOb=projectDao.getProjectConfig(CONFIGURATION_ID);
		System.out.println("In updateOption"+pcOb.getCONFIGURATION_ID()+" "+pcOb);
		map.addAttribute("pcOb",pcOb);
		 
		List<Project> projectList = adminService.getAllProject();
		Role roleObj = new Role();
		List<Role> rolesList = adminService.getAllRole();
			
		map.addAttribute("rObj",roleObj);
		map.addAttribute("proj", projectList);
		map.addAttribute("role",rolesList);
	     return "getUpdateProjectConfig";             
	}
	
	@RequestMapping(value="/deleteOption/{CONFIGURATION_ID}",method=RequestMethod.GET)
	public ModelAndView deleteConfiguration(@PathVariable int CONFIGURATION_ID,ModelMap map)
	{
		if(checkSession(map)) {
			return new ModelAndView("login");
		}
		boolean del = projectDao.deleteProjectConfig(CONFIGURATION_ID);
		if(del){
			ModelAndView mv=new ModelAndView("redirect:http://localhost:9696/BillingSystem/AddProj");
			mv.addObject("msg","Configuration Deleted Succesfully..");
			return mv;
		}
		else
			return new ModelAndView("admin");         
	}*/
}
