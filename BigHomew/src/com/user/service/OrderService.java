package com.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Order;
import com.user.dao.OrderDao;

@Service
public class OrderService {
	
	@Resource
	private OrderDao orderDao;
	public void addOrder(Order order){
		orderDao.save(order);
	}
}
