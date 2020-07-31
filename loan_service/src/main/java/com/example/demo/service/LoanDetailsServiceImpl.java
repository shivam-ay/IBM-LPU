package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDetailsDAO;
import com.example.demo.dao.LoanDetailsDAO;
import com.example.demo.entity.LoanDetails;
import com.example.demo.entity.LoanDetails.status;
import com.example.demo.exception.AccountNotFoundException;

@Service(value = "loanDetailsService")
public class LoanDetailsServiceImpl implements LoanDetailsService
{

	@Autowired
	private LoanDetailsDAO loanDetailsDAO;
	@Autowired
	private AccountDetailsDAO accountDetailsDAO;
	@Override
	public void createLoanRequest(LoanDetails loanDetails)
	{
		double emi = (loanDetails.getLoanAmount()*loanDetails.getInterestRate()*(Math.pow((1+loanDetails.getInterestRate()),(loanDetails.getDuration()/12)))/(Math.pow((1+loanDetails.getInterestRate()), ((loanDetails.getDuration()/12)-1))));
		loanDetails.setEmi(emi);
		if(accountDetailsDAO.findById(loanDetails.getAccountNumber()).isEmpty())
		{
			throw new AccountNotFoundException("Account does not exist");
		}
		if(accountDetailsDAO.findById(loanDetails.getAccountNumber()).get().getCustomerDetails().getCreditScore()<300)
		{
			loanDetails.setLoanStatus(status.valueOf("rejected"));
		}
		if((accountDetailsDAO.findById(loanDetails.getAccountNumber()).get().getCustomerDetails().getCustomerFirstName()+" "+
			accountDetailsDAO.findById(loanDetails.getAccountNumber()).get().getCustomerDetails().getCustomerLastName())
			.equals(loanDetails.getCustomerName()))
		{
			loanDetailsDAO.save(loanDetails);
		}
		else
		{
			throw new AccountNotFoundException("No Account found with the details entered");
		}
	}

	@Override
	public ResponseEntity<List<LoanDetails>> showLoanDetails() 
	{
		return ResponseEntity.ok().body(loanDetailsDAO.findAll());
	}

	@Override
	public void deleteLoanRequest(long id) 
	{
		if(loanDetailsDAO.findById(id).isPresent())
		{
			loanDetailsDAO.delete(loanDetailsDAO.findById(id).get());
		}
		else
		{
			throw new AccountNotFoundException("Account does not exixst");
		}
	}

	@Override
	public ResponseEntity<List<LoanDetails>> showLoanByStatus(status loanStatus) 
	{
		return ResponseEntity.ok().body(loanDetailsDAO.findByLoanStatus(loanStatus));
	}

}
