package com.restexample.crud.service;

import java.util.List;

import com.restexample.crud.entities.Users;

public interface IUserService {
     List<Users> getAllUsers();
     boolean addUser(Users user);
     public String updateUser(String id,Users user);
     public String deleteUser(String userId);
     public String createUser(Users user);
}
