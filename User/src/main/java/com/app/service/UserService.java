package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.UserDao;
import com.app.models.User;

@Component
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	
  //add
	public User  addUser(User u) {
		System.out.println("Add service user");
	
	return dao.save(u);
	}

   //get user by id
	public Optional<User> getUserById(Long id) {
		
		return dao.findById(id);
	}

	//get all users
	public List<User> getAllUsers() {
		
		return dao.findAll();	
				}

	//update
	public User updateUserById(Long i, User updatedUser) throws Exception {
		
	User existingUser = dao.findById(i)
			.orElseThrow(() -> new Exception("Not Found"+i));
		
	 
		existingUser.setName(updatedUser.getName());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setPassword(updatedUser.getPassword());
		existingUser.setAddress(updatedUser.getAddress());
		return dao.save(existingUser);
		
	}

	//delete
	public void deleteUserById(Long i) throws Exception {
		
		if(dao.existsById(i))
		{
			dao.deleteById(i);
		}
		else throw new Exception("User Not found" +i);
	}
 
}
