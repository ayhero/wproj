package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.*;

import com.entitys.Resc;
import com.entitys.Role;
@Service("rescDaoImp")
public class RescDaoImp {


	@Resource
	private SessionFactory sessionFactory;
	
	public List<Resc> getRescs(){
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Resc> list=session.createCriteria(Resc.class).addOrder(Order.asc("priority")).list();
		tx.commit();
		session.close();
		return list;
	}
	
	
}
