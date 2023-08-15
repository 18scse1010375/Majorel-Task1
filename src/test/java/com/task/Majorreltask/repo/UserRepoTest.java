package com.task.Majorreltask.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.Majorreltask.Model.User;
import com.task.Majorreltask.dao.UserDao;
import com.task.Majorreltask.service.UserService;

import java.util.*;


@SpringBootTest
public class UserRepoTest {
	
	

   @Autowired
  private UserDao userDao;
   
   
   
   
   
   
//   verification for the user is successfully is added or not in the Database
   
   @Test
   void isUserAdded() {
	   
	   User user=new User("abcde","abcde@123" , "abc@gmail.com"  ) ;
         userDao.save(user);
	     
	     
	  Boolean actual= userDao.existsById(user.getUsername());
	    assertThat(actual).isTrue();
	     
	    
	 }
   
 
//   verification for the user is successfully deleted or not from the Database
   
   @Test
   void isUserDeleted() {
	   
	   User user=new User("abcde","abcde@123" , "abc@gmail.com"  ) ;
	   
	   userDao.save(user);
	   
	    User p= userDao.findById("abcde").get();
	    
	      userDao.delete(p);
	      
	      
	     Boolean actual=userDao.existsById("abcde");
	     assertThat(actual).isFalse();   
	      
}
   
   
 
//   verify for the user is successfully updated or not from the databases
   
   @Test
   
   void isUserUpdated() {
	   
	   User user=new User("abcde","abcde@123" , "abc@gmail.com"  ) ;
	   
	   userDao.save(user);
	   
	   boolean actual=user.getPassword().equals("abcde@123") && user.getEmail().equals("abc@gmail.com");
	   
	   assertThat(actual).isTrue();
	   
   }
   
   
   
   
   
   
	   




}
