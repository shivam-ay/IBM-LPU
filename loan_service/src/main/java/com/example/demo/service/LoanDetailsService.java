package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.LoanDetails;
import com.example.demo.entity.LoanDetails.status;

public interface LoanDetailsService 
{
	public void createLoanRequest(LoanDetails loanDetails);
	public ResponseEntity<List<LoanDetails>> showLoanDetails();
	public void deleteLoanRequest(long id);
	public ResponseEntity<List<LoanDetails>> showLoanByStatus(status loanStatus);
}
