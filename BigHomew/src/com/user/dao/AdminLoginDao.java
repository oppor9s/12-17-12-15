package com.user.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Administrtor;
import com.entity.Order;
import com.entity.Producttype;

@Repository
public class AdminLoginDao {
	@Resource
	private SessionFactory sessionFactory;
	//管理员登陆
	public List<Administrtor> login(String name){
		Query query=this.sessionFactory.getCurrentSession().createQuery("from Administrtor where name=?");
		 query.setParameter(0, name);
		 List list=query.list();
		return list;
	}
	//查询产品类型
	public List<Producttype> type(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("from Producttype");
		List<Producttype> list=query.list();
		
		return list;
	}
	//查询订单
	public List<Order> order(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("from Order");
		List<Order> list=query.list();
		return list;
	}
	//增加商品
}
