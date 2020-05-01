package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDetails;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;

@Service(value = "userService")
@EnableTransactionManagement
public class UserDetailsServiceImpl implements UserDetailsService
{
	private UserDAO userDAO;
	@Autowired
	public UserDetailsServiceImpl(UserDAO userDAO)
	{
		super();
		this.userDAO = userDAO;
	}

	@Override
	public ResponseEntity<List<UserDetails>> showAllUsers() 
	{
		return ResponseEntity.ok().body(userDAO.showAllUsers());
	}

	@Override
	public ResponseEntity<UserDetails> findById(int id)
	{
		if(userDAO.findById(id)!=null)
		{
			User user = userDAO.findById(id);
			UserDetails userDetails = new UserDetails(user.getFirstname(),user.getLastname(),user.getEmail(),user.getPhoneNumber());
			return ResponseEntity.ok().body(userDetails);
		}
		else
			throw new UserNotFoundException("No user with this id "+id);
	}

	@Override
	@Transactional
	public ResponseEntity<String> updateUserDetails(UserDetails userDetails,int id) 
	{
		if(userDAO.findById(id)!=null)
			return ResponseEntity.ok().body(userDAO.updateUserDetails(userDetails,id));
		else
			throw new UserNotFoundException("No user with this id "+id);
	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(int id) 
	{
		if(userDAO.findById(id)!=null)
			return ResponseEntity.ok().body(userDAO.delete(id));
		else
			throw new UserNotFoundException("No user with this id "+id);
	}

}
