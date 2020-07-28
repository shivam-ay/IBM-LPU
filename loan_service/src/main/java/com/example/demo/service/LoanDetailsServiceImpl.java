package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoanDetailsDAO;
import com.example.demo.entity.LoanDetails;

@Service(value = "loanDetailsService")
public class LoanDetailsServiceImpl implements LoanDetailsService
{

	@Autowired
	private LoanDetailsDAO loanDetailsDAO;
	@Override
	public void createLoanRequest(LoanDetails loanDetails)
	{
		loanDetailsDAO.save(loanDetails);
	}

	@Override
	public List<LoanDetails> showLoanDetails() 
	{
		return loanDetailsDAO.findAll();
	}

}
