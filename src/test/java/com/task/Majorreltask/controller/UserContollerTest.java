package com.task.Majorreltask.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.Majorreltask.Controller.UserController;
import com.task.Majorreltask.Model.User;
import com.task.Majorreltask.service.UserService;



@WebMvcTest(UserController.class)

public class UserContollerTest {
	
	


	
	
	  
	
	
	private static final String END_POINT_PATH="/users" ;
	
	
	@Autowired  private MockMvc mockMvc;
	
	@Autowired private ObjectMapper objectMapper ;
	
	@MockBean private UserService userService;
	
	
	

	
	
	
	
    User user1=new User("abcd","abcd#@1234","abcd@gmail.com");
    
 
	
//    Verification for the resource is added or not  
    
	@Test
	
	public void testShouldUserAdded() throws Exception {
		String requestBody=objectMapper.writeValueAsString(user1);
		
		System.out.println("requestBody+" +requestBody  ) ;
		

	     mockMvc.perform(post(END_POINT_PATH) .contentType("application/json") .content(requestBody) ).andExpect(status().isCreated()) .andDo(print());


	}
	
	
	
	 @Test
	 
	    public void testAddUser_Exception() throws Exception {
		 userService = mock(UserService.class);
		 User user1=new User("abcd","abcd#@1234","abcd@gmail.com");
			String requestBody=objectMapper.writeValueAsString(user1);

			
	        
	       
	       UserController userController = new UserController(userService);

	        // Mock the UserService to throw an exception when deleteUser is called
	        Mockito.when(userService.addUser(user1)).thenThrow(new RuntimeException("Something went wrong"));

	        ResponseEntity<User> response = userController.addUser(user1);


	
	    }
	
	
//	Verification for the Home api 
	
	@Test
	
	public void testHomeApi() throws Exception {

		mockMvc.perform(get("/home")) .andExpect(status().is(200)).andDo(print());

		
	}
	
//verification for the 404 status not found,if username not in the Databases
	
  @Test
	public void testShouldReturn404Found() throws Exception {
		


		
//		Mockito.when(userService.getUser("san")).thenThrow(UserNotFoundException.class);
		
		
		mockMvc.perform(get("/users/san")).andExpect(status().isNotFound()).andDo(print());
	}
	
	
//verification for the particular user is accessible or not	
	@Test
	
	public void testGetShouldReturn200OK() throws Exception {
		
		 User user=new User("abcd","abcd#@1234","abcd@gmail.com");
		Mockito.when(userService.getUser("abcd")).thenReturn(user);
		
		
		
		mockMvc.perform(get("/users/abcd")).andExpect(status().isOk()).andExpect(content().contentType("application/json")) .andDo(print());
	}
	
	
	
	 @Test
	 
	    public void testGetUser_Exception() throws Exception {
		 userService = mock(UserService.class);
		 User user1=new User("abcd","abcd#@1234","abcd@gmail.com");
			
	        
	       
	       UserController userController = new UserController(userService);

	        // Mock the UserService to throw an exception when deleteUser is called
	        Mockito.when(userService.getUser("abcd")).thenThrow(new RuntimeException("Something went wrong"));

	        ResponseEntity<User> response = userController.getUser("abcd");


	
	    }
	
	
	
//verification for all the users are accessible or not	
	@Test
	
	public void testGetAllUser() throws Exception {
		List list=new ArrayList<>();
		
		 User user1=new User("abcd","abcd#@1234","abcd@gmail.com");
		 User user2=new User("abcde","abcde#@12345","abcde@gmail.com");
		 User user3=new User("abcdef","abcdefg#@1234","abcdef@gmail.com");
		 
		 list.add(user1);
		 list.add(user2);
		 list.add(user3);
		 
		    
		
		Mockito.when(userService.getAllUsers() ).thenReturn(list);
		
		
		
		
		

		mockMvc.perform(get("/users")).andExpect(status().isOk()).andDo(print());
		
		
		Mockito.verify(userService,times(1)).getAllUsers();
	}
	
	
	
	 @Test
	    public void testGetAllUser_Exception() throws Exception {
		 userService = mock(UserService.class);
		 User user1=new User("abcd","abcd#@1234","abcd@gmail.com");
			
	        
	       
	       UserController userController = new UserController(userService);

	        // Mock the UserService to throw an exception when deleteUser is called
	        Mockito.when(userService.getAllUsers()).thenThrow(new RuntimeException("Something went wrong"));

	        ResponseEntity<List<User>> response = userController.getAllUsers();


	
	    }
	
	
	
	
	
	//verification for the user is successfully updated or not
	@Test
	public void testUpdateUser() throws Exception {
		 User user1=new User("abcd","abcd#@1234","abcd@gmail.com");
		
		Mockito.when(userService.updateUser(user1)).thenReturn(user1);
		
		 String requestBody=objectMapper.writeValueAsString(user1);
		 
		 mockMvc.perform(put("/users").contentType("application/json").content(requestBody)).andExpect(status().isOk()).andDo(print());
		 
		
		 
		 
	}
	
	
	 @Test
	    public void testUpdateUser_Exception() throws Exception {
		 userService = mock(UserService.class);
		 User user1=new User("abcd","abcd#@1234","abcd@gmail.com");
			
	        
	       
	       UserController userController = new UserController(userService);

	        // Mock the UserService to throw an exception when deleteUser is called
	        Mockito.when(userService.updateUser(user1)).thenThrow(new RuntimeException("Something went wrong"));

	        ResponseEntity<User> response = userController.updateUser(user1);


	
	    }
	
	
	
	@Test
	public void testDeleteShouldReturm200() throws Exception {
		User user1=new User("abcd","abcd#@1234","abcd@gmail.com");
	String  username="arun";
//		Mockito.doNothing().when(userService.deleteUser(username));
		Mockito.when(userService.deleteUser("arun") ).thenReturn(user1);

		
		mockMvc.perform(delete("/users/username")).andExpect(status().isOk()).andDo(print());
		
		
		
		
	}
	
	 @Test
	    public void testDeleteUser_Exception() throws Exception {
	        String username = "testUser";
	        
	        userService = mock(UserService.class);
	       UserController userController = new UserController(userService);

	        // Mock the UserService to throw an exception when deleteUser is called
	        Mockito.when(userService.deleteUser(username)).thenThrow(new RuntimeException("Something went wrong"));

	        ResponseEntity<String> response = userController.deleteUser(username);


	
	    }
	
	



	
	
	
	
	
	

}
