package com.iris.get19.pbms.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.iris.get19.pbms.dao.customvalid.MinZero;*/



//import com.iris.get19.pbms.dao.customvalid.MinZero;

@Entity
@Table(name="ProjectConfig")
public class ProjectConfiguration {
	@Id
	@GeneratedValue
	@Column(name="configid")
	private int configurationId;
	
	@Column(name="perHourBilling")
	//@Min(1)
	private int perHourBilling;
	
	@Column(name="location")
	private String location;
	
	@ManyToOne
	@JoinColumn(name="projectid")
	Project projectObj;
	
	@ManyToOne
	@JoinColumn(name="roleid")
	DeveloperRole roleObj;

	public int getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(int configurationId) {
		this.configurationId = configurationId;
	}

	public int getPerHourBilling() {
		return perHourBilling;
	}

	public void setPerHourBilling(int perHourBilling) {
		this.perHourBilling = perHourBilling;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Project getProjectObj() {
		return projectObj;
	}

	public void setProjectObj(Project projectObj) {
		this.projectObj = projectObj;
	}

	public DeveloperRole getRoleObj() {
		return roleObj;
	}

	public void setRoleObj(DeveloperRole roleObj) {
		this.roleObj = roleObj;
	}

	
	
}
