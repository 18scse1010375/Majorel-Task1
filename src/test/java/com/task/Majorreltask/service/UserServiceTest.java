package com.task.Majorreltask.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

import com.task.Majorreltask.Controller.UserController;
import com.task.Majorreltask.Model.User;
import com.task.Majorreltask.dao.UserDao;

import org.springframework.test.web.servlet.MockMvc;



@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserService.class)


public class UserServiceTest {
	
	@MockBean
	private UserDao userDao;
	
	
	private UserService userService ;
	
	User user1=new User("arun","arun@123","arun@gmail.com");
	User user2=new User("sanket","sanket@123","sanket@gmail.com");
	User user3=new User("krish","krish@123","krish@gmail.com");

	
	
	
	List<User>mockList=new ArrayList<>();
	

	 
			
			
	
	
	@BeforeEach
	
	void setUp() {
		this.userService=new UserService(userDao);
	}
	

	
//verify dao.finaAll method is equivalent to service.getAllUsers() 

	@Test
	   void getAllUsers() {
		
		mockList.add(user1);
		 mockList.add(user2);
		 mockList.add(user3);
		 
        Mockito.when(userService.getAllUsers()).thenReturn(mockList);
    
  

		 
		
		   userService.getAllUsers();
		   verify(userDao).findAll();
	   }
	
	
	@Test
	
	void TestGetUser() {
		
		userDao = mock(UserDao.class); // Assuming UserDao is the repository interface
        userService = new UserService(userDao);
		User mockUser=new User("arun","arun@123","arun@gmail.com");
		
       Mockito.when(userDao.findById("arun")).thenReturn(Optional.of(mockUser));

        

          User user = userService.getUser("arun");
          
          assertEquals("arun", user.getUsername());

          // Verify that the userDao's findById method was called
          verify(userDao, times(1)).findById("arun");


		
       
//       userService.getUser("arun");
//       verify(userDao).findById("arun").get();
       

		
	}
	
@Test
	
	void TestGetUserThrownException() {
		
		userDao = mock(UserDao.class); // Assuming UserDao is the repository interface
        userService = new UserService(userDao);
		User mockUser=new User("arun","arun@123","arun@gmail.com");
		
		 Mockito.when(userDao.findById("sanket")).thenReturn(Optional.empty());

	        User user = userService.getUser("sanket");

	        assertNull(user);
	        
	        verify(userDao, times(1)).findById("sanket");
        

        

		
       
//       userService.getUser("arun");
//       verify(userDao).findById("arun").get();
       

		
	}
	
	
	
	
	@Test
	
	void TestAddUser() {
		userDao = mock(UserDao.class); // Assuming UserDao is the repository interface
        userService = new UserService(userDao);
        
        User mockUser=new User("arun","arun@123","arun@gmail.com");
        
        Mockito.when(userDao.save(mockUser)).thenReturn(mockUser);
        
        User user=userService.addUser(mockUser);
        
        assertNotNull(user);
        assertEquals("arun", user.getUsername());

        // Verify that the userDao's save method was called with the correct user
        verify(userDao, times(1)).save(user);

        
        
  }
	
	

	@Test
	
	void TestUpdateUser() {
		userDao = mock(UserDao.class); // Assuming UserDao is the repository interface
        userService = new UserService(userDao);
        
        User mockUser=new User("arun","arun@123","arun@gmail.com");
        
        Mockito.when(userDao.save(mockUser)).thenReturn(mockUser);
        
        User user=userService.updateUser(mockUser);
        
        assertNotNull(user);
        assertEquals("arun", user.getUsername());
        assertEquals("arun@123", user.getPassword()); 
        assertEquals("arun@gmail.com", user.getEmail());

        // Verify that the userDao's save method was called with the correct user
        verify(userDao, times(1)).save(user);

        
        
  }
	
@Test
	
	void TestDeleteUser() {
		userDao = mock(UserDao.class); // Assuming UserDao is the repository interface
        userService = new UserService(userDao);
        
        User mockUser=new User("arun","arun@123","arun@gmail.com");
        
        Mockito.when(userDao.findById("arun")).thenReturn(Optional.of(mockUser));


        
        doNothing().when(userDao).delete(mockUser);
        
        User user=userService.deleteUser("arun");
        
        User deletedUser = userService.deleteUser("arun");
        
        assertNotNull(deletedUser);
        assertEquals("arun", deletedUser.getUsername());

     
        
	
	
	
}
	
	
	
	
	
	

}
