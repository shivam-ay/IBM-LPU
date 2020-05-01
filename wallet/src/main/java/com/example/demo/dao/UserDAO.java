package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.UserDetails;
import com.example.demo.entity.User;

public interface UserDAO 
{
	public List<UserDetails> showAllUsers();
	public User findById(int id);
	public String updateUserDetails(UserDetails userDetails,int id);
	public String delete(int id);
}
