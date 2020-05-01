package com.example.demo.Service;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.WalletAccount;

public interface AccountService 
{
	public ResponseEntity<WalletAccount> getAccountDetails(int id);
}
