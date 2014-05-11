package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import com.entitys.Role;
@Service("roleDaoImp")
public class RoleDaoImp {

	@Resource
	private SessionFactory sessionFactory;
	
	public Role getRole(){
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Role role=(Role) session.load(Role.class, new Long(1));
		return role;
	}
	
	public List<Role> getRoles(){
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Role> list=session.createCriteria(Role.class).createCriteria("rescs").addOrder(Order.asc("priority")).list();
		tx.commit();
		session.close();
		return list;
	}
	
	
}
