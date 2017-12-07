package com.user.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.LoginUser;
import com.user.dao.AddUserDao;
@Service
public class AddUserService {
	@Resource
	private AddUserDao adduserDao;
	public void adduser(LoginUser loginUser){
		adduserDao.save(loginUser);
	}
	
	public List<LoginUser> findName(String name){
		 List<LoginUser> list=adduserDao.findByName(name);
		 return list;
	}
}
