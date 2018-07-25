package com.restexample.crud.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restexample.crud.dao.IUserDAO;
import com.restexample.crud.entities.Users;
import com.restexample.crud.exceptions.InvalidDateException;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	//service method to retrieve all users
	@Override
	public List<Users> getAllUsers() {
		return (List<Users>) userDAO.getAllUsers();
	}

	//service method to check whether an active user with same email already exists
	@Override
	public boolean addUser(Users user) {
		if (userDAO.CheckIfUserExists(user)) {
	    	   return false;
	       } 
		else 
			return true;
	}

    //service method to create user
	@Override
	public String createUser(Users user) {
	
		if(user.getBirthDate().after(new Date())) {
			String message = "Invalid date.Date should not be future date";
    	    throw new InvalidDateException(message);
		}
		String	id=userDAO.addUser(user);
		return id;	
	}
	
	//service method to update users pin code and birth date
	@Override
	public String updateUser(String id, Users user) {
		if(user.getBirthDate().after(new Date())) {
			String message = "Invalid date.Date should not be future date";
    	    throw new InvalidDateException(message);
		}
		
		String msg=userDAO.updateUser(id, user);
		return msg;
	}	
	
	//service method to deactivate user
	@Override
	public String deleteUser(String userId) {
		String msg=userDAO.deleteUser(userId);
		return msg;
	}
	
}
