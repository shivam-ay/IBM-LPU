package com.example.demo.dao;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.WalletAccount;

public interface AccountDAO 
{
	public WalletAccount getAccountDetails(int id);
}
