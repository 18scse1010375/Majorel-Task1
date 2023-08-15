package com.task.Majorreltask.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.Majorreltask.Model.User;
import com.task.Majorreltask.service.*;

@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
		
	}

	
	
	@GetMapping("/home")
	public String home() {
		return "This is Home Page " ;
	}
	
	
	
	@GetMapping("/users")
	
	public ResponseEntity<List<User>> getAllUsers(){
		try {
		
			return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
			
		}
		
		catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
	}
	
	@GetMapping("/users/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username   ) {
		
 
          try {
        	  User user=userService.getUser(username);
        	  if(user==null) {
            	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        	  }
        	  
        	  return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(username));
          }
          
          catch(Exception e) {
        	  System.out.println(e);
        	  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        	  
          }
		
	}
	
	
	@PostMapping("/users")
	
	public ResponseEntity<User> addUser(@RequestBody  User user){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
			
		}
		catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			
		}
	}
	
	
	
	@PutMapping("/users")
	
	public ResponseEntity<User> updateUser(@RequestBody User user){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
		}
		
		catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

			
		}
		
		
	}
	
	
 @DeleteMapping("/users/{username}")
	
	public ResponseEntity<String> deleteUser(@PathVariable("username") String username ){
		try {
			 System.out.println("Deleted Course are :" + userService.deleteUser(username) )    ;
			return ResponseEntity.ok("Course has Been Deleted") ;
		}
		
		catch(Exception e) {
			System.out.println(e);
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

			
		}
		
		
	}
	
	
	
	
	

	
	
	
	
	
	

}
