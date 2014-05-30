package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.imp.RescDaoImp;
import com.dao.imp.RoleDaoImp;
import com.dao.imp.TestDao;
import com.entitys.Resc;
import com.entitys.Role;
import com.entitys.face.Card;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac= new ClassPathXmlApplicationContext("classpath*:Application*.xml");
		TestDao td=(TestDao) ac.getBean("testDao");
		
		Card card=td.getCard();
		System.out.println(card.getId());
		System.out.println(card.getEmployee().getId());
	}

}
