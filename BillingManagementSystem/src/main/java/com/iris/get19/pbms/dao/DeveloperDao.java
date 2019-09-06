package com.iris.get19.pbms.dao;

import java.util.List;

import com.iris.get19.pbms.dao.model.DataEntryOperator;
import com.iris.get19.pbms.dao.model.DevAllocation;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;

import java.util.List;



public interface DeveloperDao {
	public boolean setDevAllocate(DevAllocation devObj);
	public List<Developer> getAllDeveloper();
	public boolean setAttendance(DataEntryOperator deoObj);
	public DataEntryOperator getDeoObj(int id, String month, int year);
	/*public List<Developer> getAllDeveloper();
	public List<Developer> getAll();
	public Developer getDeveloper(int id,String pass);
	public boolean setProjectConfig(DevAllocation obj);
	public boolean setAttendance(DataEntryOperator obj);
	public DataEntryOperator getBill(Integer id,String month,int year);
	public List<DevAllocation> getAllAllocate();
	public DevAllocation getConfig(int id);
	public DevAllocation getProAllocationObj(int id);
	public String getDeveloperById(int id);
	public List<Developer> getAllDeveloperNotAllocated();*/
	
	
	
}
