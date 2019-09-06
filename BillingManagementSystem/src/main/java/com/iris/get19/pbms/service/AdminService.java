package com.iris.get19.pbms.service;

import java.util.List;

import com.iris.get19.pbms.dao.model.DataEntryOperator;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.DeveloperRole;
import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;


public interface AdminService {

	Developer getDeveloper(Developer dev);
	boolean setProjectConfig(ProjectConfiguration projObj);
	List<Project> getAllProjects();
	List<DeveloperRole> getAllRoles();
	boolean setDevAllocate(Developer devObj);
	/*List<Project> getAllProject();
	List<Role> getAllRole();
	List<ProjectConfiguration> getAllProjectConfig();
	List<ProjectConfiguration> getAllProjectConfigNotAllocated();
	List<Developer> getAllDeveloper();
	List<Developer> getDeveloper(List<Developer> dev);
	boolean setProjectConfig(ProjectConfiguration pObj);
	boolean setProjectAllocate(ProjectAllocation pObj);
	List<ProjectAllocation> getAllAllocate();
	ProjectAllocation getConfig(int developerId);
	DataEntryOperator getBill(int developerId, String month,int year);
	double getBill(double perHourBilling, DataEntryOperator deo);
	List<ProjectConfiguration> getAllConfigId(int id);
	Project getProjectById(int id);
	String getProjectName(int id);
	boolean updateProjectConfig(ProjectConfiguration pObj);
	List<Developer> getAllDeveloperNotAllocated();*/
	
	
	

	
}
