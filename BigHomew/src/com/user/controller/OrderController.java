package com.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Order;
import com.entity.Shopcar;
import com.user.service.FindProductService;
import com.user.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource 
	private OrderService orderService;
	@Resource
	private FindProductService findProductService;
	//展示到订单页面
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String findByI(Model model,HttpSession session){
		List<Shopcar> list=findProductService.findByUserName((String) session.getAttribute("name"));
		model.addAttribute("list",list);
		return "order";
	}
	//生成订单，并存到数据库
	@RequestMapping(value="/makeorder",method=RequestMethod.GET)
	public String makeorder(HttpSession session){
		List<Shopcar> list=findProductService.findByUserName((String) session.getAttribute("name"));
		int sumprice=0;
		for(int i=0;i<list.size();i++){
			sumprice+=list.get(i).getCount()*list.get(i).getPrice();
		}
		String name=(String) session.getAttribute("name");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time =df.format(new Date());
		Order order = new Order();
		order.setTime(time);
		order.setUserName(name);
		order.setSumprice(sumprice);
		orderService.addOrder(order);
		return "";
		
	}
}
