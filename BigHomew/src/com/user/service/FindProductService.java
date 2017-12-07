package com.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.Shopcar;
import com.user.dao.FindProductDao;

@Service

public class FindProductService {
	@Resource 
	private FindProductDao findProductDao;
	
	public List<Product> findAll(){
		return findProductDao.findAll();
	}
	public List<Product> findByPage(int pageNum, int pageSize){
		return	findProductDao.find4Page(pageNum, pageSize);
	}
	public long fianCount(){
		return findProductDao.findCount();
	}
	public List<Product> findById(int id){
		return findProductDao.findById(id);
	}
	public List<Shopcar> findByUserName(String username){
		return findProductDao.findByUserName(username);
	}
	public void delete(int id){
		findProductDao.delete(id);
	}
	public List<Shopcar> findshopcarcount(int id){
		return findProductDao.findshopcarcount(id);
	}
	public List<Product> findyproducttype(String type){
		return findProductDao.findbyproducttype(type);
	}
	public void deleteproduct(int id){
		findProductDao.deleteproduct(id);
	}
}
