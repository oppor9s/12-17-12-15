package com.user.dao;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.entity.Order;
@Repository
public class OrderDao {
		@Resource
		private SessionFactory sessionFactory;

		  public void save(Order order)  {
				Session session = sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(order);
				tx.commit();
				session.close();
			}
	
	}

