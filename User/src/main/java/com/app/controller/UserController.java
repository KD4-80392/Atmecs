package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//create
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		
		 try{
			
			return userservice.addUser(user);
		 } catch (Exception e) {
			System.out.println(e);
		}
		 return null;
		
	}
	
	//get all users
	@GetMapping("/get")
	public List<User> getAllUsers(){
		try {
			
			return userservice.getAllUsers();
		}catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}
	
	//get by id
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable Long id){
		try {
		Optional<User> user = userservice.getUserById(id);
		return user.orElse(null);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		 return null;
		}
		
	//update
    @PutMapping("/update/{id}")
    public User updateUserByid(@PathVariable Long id, @RequestBody User updatedUser)
    { try {
    	return userservice.updateUserById(id, updatedUser);
   	 
    }catch (Exception e) {
	System.out.println(e);
	}
   	 return null;
    }
	
	//delete
    @DeleteMapping("/del/{id}")
    public void deleteUserById(@PathVariable Long id ) {
    	try {
    		
    		userservice.deleteUserById(id);
    	}catch (Exception e) {
			System.out.println(e);
		}
    }

	}
	
	

