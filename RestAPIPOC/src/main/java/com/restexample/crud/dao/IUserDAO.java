package com.restexample.crud.dao;
import java.util.List;

import com.restexample.crud.entities.Users;
public interface IUserDAO {

    List<Users> getAllUsers();
    public String addUser(Users user);
    public String updateUser(String id,Users user);
    public String deleteUser(String userId);
    public  boolean CheckIfUserExists(Users user);
}
 