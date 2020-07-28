package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LoanDetails;

public interface LoanDetailsService 
{
	public void createLoanRequest(LoanDetails loanDetails);
	public List<LoanDetails> showLoanDetails();
}
