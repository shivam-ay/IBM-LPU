package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dto.Transaction;
import com.example.demo.entity.WalletAccount;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountDAO accountDAO;
	@Override
	public ResponseEntity<WalletAccount> getAccountDetails(int id) 
	{
		return ResponseEntity.ok().body(accountDAO.getAccountDetails(id));
	}

}
