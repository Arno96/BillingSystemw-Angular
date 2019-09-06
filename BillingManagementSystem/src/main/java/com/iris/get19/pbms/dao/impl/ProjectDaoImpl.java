package com.iris.get19.pbms.dao.impl;


import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.model.DevAllocation;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;


@Component
@Repository(value="projectDao")
@Transactional
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Developer getDeveloper(Developer dev) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from Developer where id=:x and password=:y");
			q.setParameter("x", dev.getDeveloperId());
			q.setParameter("y", dev.getPassword());
			return (Developer) q.getResultList().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean setProjectConfig(ProjectConfiguration projObj) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(projObj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Project> getAllProjects() {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from Project");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

/*	@Autowired
	private SessionFactory sessionFactory;//To get session factory from dbconfig.java file
	
	
	public List<Project> getAllProject() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from Project");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public Project getProjectById(int projectId)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Project c=session.get(Project.class, projectId);
			return c;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public boolean setProjectConfig(ProjectConfiguration obj) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(obj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<ProjectConfiguration> getAllProjectConfig() {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProjectConfiguration");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	

	//@Override
	public List<ProjectConfiguration> getAllProjectConfigNotAllocated() {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession(); 
			Query q=session.createQuery("from ProjectConfiguration where CONFIGURATION_ID not in(select pcObj.CONFIGURATION_ID from ProjectAllocation)");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public boolean setProjectAllocate(DevAllocation obj) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(obj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<ProjectConfiguration> getAllConfigId(int id) {

		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProjectConfiguration where projectid=:p");
			q.setParameter("p", id);
			q.getResultList();
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}


	@Override
	public 	ProjectConfiguration getProjectConfig(int id) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			ProjectConfiguration p = session.get(ProjectConfiguration.class, id);
			return p;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean updateProjectConfig(ProjectConfiguration pObj) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(pObj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean deleteProjectConfig(int id) {
		try
		{
			
			System.out.println("Configuration Id in controller : "+id);
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("delete from ProjectConfiguration where configid=:p");
			q.setParameter("p", id);
			q.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}*/
}


