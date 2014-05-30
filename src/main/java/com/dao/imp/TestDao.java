package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.entitys.Role;
import com.entitys.face.Card;

@Service("testDao")
public class TestDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public Card getCard(){
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Card card=(Card) session.load(Card.class, new Long(1));
		return card;
	}
	
	
}
