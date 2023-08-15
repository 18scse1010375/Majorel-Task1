package com.task.Majorreltask.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Majorreltask.Model.*;
import com.task.Majorreltask.dao.UserDao;


@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
		public List<User> getAllUsers(){
		return userDao.findAll();
	}
		
		
		
		
		public UserService(UserDao dao) {
			this.userDao=dao;
			
		}
	
	
	public User getUser(String username) {
		try {
			return userDao.findById(username).get();
		}
		catch(Exception e) {
			System.out.println("No such Element Found") ;
			
			return null;
		}
	}
	
	
	
	public User addUser(User user) {
		userDao.save(user);
		return user;
	}
	
	
	public User updateUser(User targetuser) {
		  userDao.save(targetuser);
		  
		  return targetuser;
		}
		

		
	
	
	
public User deleteUser(String username) {
	User user=userDao.findById(username).get();
	  User copy=user;
	  userDao.delete(user);
  return copy;
	  

}
	

}

