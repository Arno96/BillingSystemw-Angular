package com.iris.get19.pbms.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.get19.pbms.dao.RoleDao;
import com.iris.get19.pbms.dao.model.DeveloperRole;

@Component
@Repository(value="roleDao")
@Transactional
public class RoleDaoImpl implements RoleDao{
	@Autowired
	private SessionFactory sessionFactory;//To get session factory from dbconfig.java file

	@Override
	public List<DeveloperRole> getAllRole() {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from DeveloperRole");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/*public List<DeveloperRole> getAllRole() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from Role");
			if (q.getResultList()!=null) {
				System.out.println("Not null");
				return q.list();
			} else {
				System.out.println("Null");
				return null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}*/
}
