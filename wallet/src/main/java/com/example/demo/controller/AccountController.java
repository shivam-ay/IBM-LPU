package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AccountService;
import com.example.demo.entity.WalletAccount;

@RestController
public class AccountController 
{
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<WalletAccount> getAccountDetails(@PathVariable int id)
	{
		return accountService.getAccountDetails(id);
	}
}
