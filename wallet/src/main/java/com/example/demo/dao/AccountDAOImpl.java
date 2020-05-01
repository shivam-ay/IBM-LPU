package com.example.demo.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.Service.UserDetailsService;
import com.example.demo.entity.WalletAccount;
import com.example.demo.exception.UserNotFoundException;

@Repository(value = "accountDAO")
public class AccountDAOImpl implements AccountDAO
{
	@Autowired
	private EntityManager em;
	
	@Autowired
	private UserDetailsService userService;
	@Override
	public WalletAccount getAccountDetails(int id)
	{
		if(userService.findById(id)!=null)
		{
			return em.find(WalletAccount.class, id);
		}
		else
			throw new UserNotFoundException("No such account exists");
	}
	
}
