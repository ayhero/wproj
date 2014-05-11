package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.imp.RescDaoImp;
import com.dao.imp.RoleDaoImp;
import com.entitys.Resc;
import com.entitys.Role;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac= new ClassPathXmlApplicationContext("classpath*:Application*.xml");
		RescDaoImp rdi=(RescDaoImp) ac.getBean("rescDaoImp");
		
		List<Resc> list=rdi.getRescs();
		for(Resc resc : list){
			Set<Role> set=resc.getRoles();
			Iterator<Role> it=set.iterator();
			while(it.hasNext()){
				Role role=it.next();
				System.out.println(resc.getRes_string()+"-"+role.getName());
			}
			
		}
		

	}

}
