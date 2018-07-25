package com.restexample.crud;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.restexample.crud.entities.Users;
import com.restexample.crud.exceptions.UserNotFoundException;
import com.restexample.crud.service.IUserService;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApipocApplicationTests {
	
	@Autowired
	private IUserService userService;
	
	@Rule
	public ExpectedException e=ExpectedException.none();
	@Test
    public void deactivateSuccess() {
    	String result=userService.deleteUser("Lzo3r");
    	assertEquals("USER_DEACTIVATED_SUCCESSFULLY",result);
    }
	@Test
    public void UpdateSuccess() {
		Users user=new Users();
		user.setfName("Fname");
		user.setlName("Lname");
		user.setEmail("test@gmail.com");
		user.setPinCode(123456);
		user.setBirthDate(new Date());
    	String result=userService.updateUser("Lzo3r", user);
    	assertEquals("USER_UPDATED_SUCCESSFULLY",result);
    }
	@Test
    public void deactivateFailure() throws UserNotFoundException{
		e.expectMessage("Unable to delete.User with id 456 not found");
    	userService.deleteUser("456");
    }
	@Test
    public void updateFailure() throws UserNotFoundException{
		e.expectMessage("Unable to update. User with Lzr not found");
		Users user=new Users();
		user.setfName("Fname");
		user.setlName("Lname");
		user.setEmail("test@gmail.com");
		user.setPinCode(123456);
		user.setBirthDate(new Date());
    	userService.updateUser("Lzr", user);
    }
	@Test
    public void CreateSuccess() {
		Users user=new Users();
		user.setfName("Mary");
		user.setlName("Williams");
		user.setEmail("mary77@gmail.com");
		user.setPinCode(807655);
		user.setBirthDate(new Date());
    	String result=userService.createUser(user);
    	Assert.assertNotNull(result);
 
    }
}
