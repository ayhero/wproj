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
import com.entitys.face.Financial_Income;
import com.entitys.face.Service;
import com.entitys.face.User;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac= new ClassPathXmlApplicationContext("classpath*:Application*.xml");
		TestDao td=(TestDao) ac.getBean("testDao");
		/**
		User user=(User) td.getObject(new User());
		System.out.println(user.getId());
		System.out.println(user.getUser_Info().getAddress());
		System.out.println(user.getCards().iterator().next().getId());
		
		Card card=(Card) td.getCard();
		System.out.println(card.getUser().getId());
		
		Service service=(Service)td.getObject(new Service());
		System.out.println(service.getId());
		System.out.println(service.getType().getId());
		System.out.println(service.getType().getGroup().getTypes().size());
		*/
		Financial_Income fi=(Financial_Income) td.getObject(new Financial_Income());
		System.out.println(fi.getId());
		System.out.println(fi.getConsume().getId());
		System.out.println(fi.getEmployee().getId());
		System.out.println(fi.getType().getId());
		
	}

}
