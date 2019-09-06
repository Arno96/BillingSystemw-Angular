package com.iris.get19.pbms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.model.DataEntryOperator;
import com.iris.get19.pbms.dao.model.DevAllocation;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.DeveloperRole;
import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;
import com.iris.get19.pbms.service.AdminService;
import com.iris.get19.pbms.dao.RoleDao;


@Component
@Repository(value="adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired 
	private ProjectDao projectDao;
	@Autowired 
	private RoleDao roleDao;
	@Autowired
	private DeveloperDao developerDao;
	
	
	@Override
	public Developer getDeveloper(Developer dev) {
		return projectDao.getDeveloper(dev);
	}


	@Override
	public boolean setProjectConfig(ProjectConfiguration projObj) {
		return projectDao.setProjectConfig(projObj);
	}


	@Override
	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}


	@Override
	public List<DeveloperRole> getAllRoles() {
		return roleDao.getAllRole();
	}


	@Override
	public boolean setDevAllocate(DevAllocation devObj) {
			return developerDao.setDevAllocate(devObj);
	}


	@Override
	public List<Developer> getAllDevelopers() {
		return developerDao.getAllDeveloper();
	}


	

	@Override
	public double getBill(int id, String month, int year) {
		DevAllocation devObj=projectDao.getDevAlObj(id);
		double perHourBilling=devObj.getPcObj() .getPerHourBilling();
		//String name = developerDao.getDeveloperById(developerId);
		//map.addAttribute("name", name);
		DataEntryOperator deo=developerDao.getDeoObj(id, month,year);
		System.out.println(deo.getfullDay());
		double bill = (deo.getfullDay()*9+deo.gethalfDay()*4.5)*perHourBilling;
		return bill;
	}
	@Override
	public List<ProjectConfiguration> getAllProjectConfig() {
		return projectDao.getAllProjectConfig();
	}
	@Override
	public List<ProjectConfiguration> getAllConfigId(int id) {
		return projectDao.getAllConfigId(id);
	}

	@Override
	public String getProjectName(int id) {
		Project p = projectDao.getProjectById(id);
		System.out.println(p);
		String name = p.getProjectName();
		return name;
	}
	
	@Override
	public double getProjBill(int id, String month, int year) {
		/*if(checkSession(map)) {
			return "login";
		}*/
		try {
			System.out.println(id + month);
			double bill = 0;
			List<ProjectConfiguration> projConfigList= projectDao.getAllConfigIds(id);
		
			//String name =getProjectName(id);
			
			int count = 0;
			//List<Double> sum = new ArrayList<Double>();
			//List<DevAllocation> obj = new ArrayList<DevAllocation>();
			for(ProjectConfiguration configObj: projConfigList)
			{
				int cid = configObj.getConfigurationId();
				System.out.println(cid);
				System.out.println("inside loop");
				DevAllocation devObj=projectDao.getDevAlObjByConfigId(cid);
				System.out.println("inside loop1");
				double perHourBilling=devObj.getPcObj() .getPerHourBilling();
				System.out.println("inside loop2");
				int Id = devObj.getdObj().getDeveloperId();
				System.out.println("inside loop3");
				DataEntryOperator deo=developerDao.getDeoObj(Id, month,year);
				System.out.println("inside loop4");
				System.out.println(deo.getfullDay());
				System.out.println("inside loop5");
			    bill += (deo.getfullDay()*9+deo.gethalfDay()*4.5)*perHourBilling;
				
				count++;
				
			}
			
			return bill;
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
		return 0;
	}


	

/*	@Autowired 
	private ProjectDao projectDao;
	
	@Autowired 
	private RoleDao roleDao;
	
	@Autowired
	private DeveloperDao developerDao;

	
	@Override
	public List<Project> getAllProject() {
		return projectDao.getAllProject();
	}

	@Override
	public List<Role> getAllRole() {
		return roleDao.getAllRole();
	}

	@Override
	public List<ProjectConfiguration> getAllProjectConfig() {
		return projectDao.getAllProjectConfig();
	}

	@Override
	public List<Developer> getAllDeveloper() {
		return developerDao.getAllDeveloper();
	}
	
	/*List<Developer> getDeveloperByRole(String role){
		
	}

	@Override
	public List<Developer> getDeveloper(List<Developer> dev) {
		List<Developer> devL = new ArrayList<Developer>();
		for(Developer d : dev)
		{
			if(d.getRole().equals("Developer")) {
				
				devL.add(d);
			}
		}
		return devL;
	}

	@Override
	public boolean setProjectConfig(ProjectConfiguration pObj) {
		boolean save = projectDao.setProjectConfig(pObj);
		return save;
	}

	@Override
	public boolean setProjectAllocate(ProjectAllocation pObj) {
		boolean save = projectDao.setProjectAllocate(pObj);
		return save;
	}

	@Override
	public List<ProjectAllocation> getAllAllocate() {
		return developerDao.getAllAllocate();
	}

	@Override
	public ProjectAllocation getConfig(int developerId) {
		return developerDao.getConfig(developerId);
	}

	@Override
	public DataEntryOperator getBill(int developerId, String month,int year) {
		return developerDao.getBill(developerId, month,year);
	}

	@Override
	public double getBill(double perHourBilling, DataEntryOperator deo) {
		double halfDay=deo.gethalfDay()*4.5;
		double fullDay=deo.getfullDay()*9;
		double bill=((halfDay*perHourBilling)+(fullDay*perHourBilling));
		return bill;
	}

	@Override
	public List<ProjectConfiguration> getAllConfigId(int id) {
		return projectDao.getAllConfigId(id);
	}

	@Override
	public Project getProjectById(int id) {
		return projectDao.getProjectById(id);
	}

	@Override
	public String getProjectName(int id) {
		Project p = projectDao.getProjectById(id);
		System.out.println(p);
		String name = p.getProjectName();
		return name;
	}

	@Override
	public boolean updateProjectConfig(ProjectConfiguration pObj) {
		return projectDao.updateProjectConfig(pObj);
	}

	@Override
	public List<ProjectConfiguration> getAllProjectConfigNotAllocated() {
		return projectDao.getAllProjectConfigNotAllocated();
	}

	@Override
	public List<Developer> getAllDeveloperNotAllocated() {
		return developerDao.getAllDeveloperNotAllocated();
	}

	*/
}
