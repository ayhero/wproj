package com.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.imp.RescDaoImp;
import com.dao.imp.RoleDaoImp;
import com.dao.imp.TestDao;
import com.entitys.Resc;
import com.entitys.Role;
import com.entitys.face.Card;
import com.entitys.face.Employee;
import com.entitys.face.Financial_Income;
import com.entitys.face.Product;
import com.entitys.face.Service;
import com.entitys.face.User;
import com.entitys.face.User_Info;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac= new ClassPathXmlApplicationContext("classpath*:Application*.xml");
		TestDao td=(TestDao) ac.getBean("testDao");
		SessionFactory sf=(SessionFactory) ac.getBean("sessionFactory");
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		User u=new User();
		u.setName("新名字");
		session.save(u);
		tx.commit();
		session.close();
		
		
		List users=td.getList(User.class);
		for(Object o : users){
			User us=(User)o;
			System.out.println(us.getName());
			Iterator<Card> cards=us.getCards().iterator();
			while(cards.hasNext()){
				System.out.println(cards.next().getId()+"--"+cards.next().getMoney());
				
			}
		}
		
		Card card=(Card) td.getCard();
		System.out.println(card.getUser().getId());
		
		Service service=(Service)td.getObject(new Service());
		System.out.println(service.getId());
		System.out.println(service.getType().getId());
		System.out.println(service.getType().getGroup().getTypes().size());
		System.out.println(service.getOrderlists().size());

		Financial_Income fi=(Financial_Income) td.getObject(new Financial_Income());
		System.out.println(fi.getId());
		System.out.println(fi.getConsume().getId());
		System.out.println(fi.getEmployee().getId());
		System.out.println(fi.getType().getId());
		
		Employee emp=(Employee) td.getObject(new Employee());
		System.out.println(emp.getId());
		System.out.println(emp.getDepartment().iterator().next().getDepartment().getName());
		System.out.println(emp.getDepartment().iterator().next().getPost().getName());
		
		Product prod=(Product) td.getObject(new Product());
		System.out.println(prod.getName());
		System.out.println(prod.getDamage_Products().size());
		System.out.println(prod.getOrderlist());
	}

}
