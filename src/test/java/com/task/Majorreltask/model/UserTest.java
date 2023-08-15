package com.task.Majorreltask.model;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.task.Majorreltask.Model.*;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;



public class UserTest {
	 @InjectMocks
	    private User user;
	 
	 
	 @Test
	    public void testSetUsername() {
	       
	        MockitoAnnotations.openMocks(this);

	  

	        user.setUsername("arun");
	        user.setPassword("arun@123");
	        user.setEmail("arun@gmail.com");

	        // Then
	        assertEquals("arun", user.getUsername());
	        assertEquals("arun@123", user.getPassword()); 
	        assertEquals("arun@gmail.com", user.getEmail());
	    }
	 
	 
	 @Test
	    public void testUserConstructor() {
	        String password = "abc@123";
	        String email = "abc@gmail.com";

	        User user = new User(password, email);

	        assertEquals(password, user.getPassword());
	        assertEquals(email, user.getEmail());
	    } 
	 
	 
	 @Test
	    public void testToString() {
	        String username = "abc";
	        String password = "abc@123";
	        String email = "abc@gmail.com";

	        User user = new User(username, password, email);

	        String expectedToString = "User [username=" + username + ", password=" + password + ", email=" + email + "]";
	        assertEquals(expectedToString, user.toString());
	    }
	 
	 
	 
	 
	 
	}
	 
	 

	