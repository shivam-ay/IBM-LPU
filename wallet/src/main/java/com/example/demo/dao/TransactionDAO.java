package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.Transaction;

public interface TransactionDAO 
{
	public List<Transaction> getAllTransactions(int accountId);
	public List<Transaction> getByDate(LocalDate start,LocalDate end);
}
