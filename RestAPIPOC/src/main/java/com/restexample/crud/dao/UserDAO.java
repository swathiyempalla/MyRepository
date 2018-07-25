package com.restexample.crud.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restexample.crud.entities.Users;
import com.restexample.crud.exceptions.UserNotFoundException;
import com.restexample.crud.util.RandomStringGenerator;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	//To add user
	@Override
	public String addUser(Users user) {
   
	String genString=RandomStringGenerator.randomAlphaNumeric(5);
    	Users userobj=new Users();
		userobj.setId(genString);
		userobj.setfName(user.getfName());
		userobj.setlName(user.getlName());
		userobj.setEmail(user.getEmail());
		userobj.setPinCode(user.getPinCode());
		userobj.setActive(true);
		userobj.setBirthDate(user.getBirthDate());
		entityManager.persist(userobj);	
		return genString;
	
	
	}

	//To update pin code and birth date of user
	@Override
	public String updateUser(String id,Users user) {
		Users user1 = entityManager.find(Users.class,id);
		if(user1==null) {
			String message="Unable to update. User with "+id+" not found";
			throw new UserNotFoundException(id,message);
		}
		user1.setPinCode(user.getPinCode());
		user1.setBirthDate(user.getBirthDate());
		entityManager.flush();
		String message="USER_UPDATED_SUCCESSFULLY";
		return message;
		
	}

	//To Deactivate User
	@Override
	public String deleteUser(String userId) {
		Users userobj=entityManager.find(Users.class, userId);
		if(userobj==null) {
			String message="Unable to delete.User with id "+userId+" not found";
			throw new UserNotFoundException(userId,message);
		}
		userobj.setActive(false);
		entityManager.flush();
		String message="USER_DEACTIVATED_SUCCESSFULLY";
		return message;
	}

    
	//To retrieve all users
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUsers() {
		String hql="from Users";
		return (List<Users>) entityManager.createQuery(hql).getResultList();

	}

	//To check whether active user exists with same email id
	@Override
	public boolean CheckIfUserExists(Users user) {
		int count=0;
		List<Users> userList=getAllUsers();
		for(Users user1:userList) {
			if(user1.isActive() && user1.getEmail().equalsIgnoreCase(user.getEmail())) {
				System.out.println("An active user with same email id exists already");
				++count;
			}
		}
			return count>0?true:false;
	}	
	
	}
