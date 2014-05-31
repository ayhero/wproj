package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.entitys.Role;
import com.entitys.face.Card;
import com.entitys.face.User;

@Service("testDao")
public class TestDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public Card getCard(){
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Card card=(Card) session.load(Card.class, new Long(1));
		tx.commit();
		session.close();
		return card;
	}
	
	public Object getObject(Object c){
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Object obj= session.load(c.getClass(), new Long(1));
		tx.commit();
		session.close();
		return obj;
	}
	
	public List<Object> getList(Object c){
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Object> objs= session.createCriteria(c.getClass()).list();
		tx.commit();
		session.close();
		return objs;
	}
	
	
	public void saveObject(Object obj){
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(obj);
		tx.commit();
		session.close();
		
	}
	
	
}
