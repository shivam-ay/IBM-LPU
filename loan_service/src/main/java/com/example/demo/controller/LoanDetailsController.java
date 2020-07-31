package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoanDetails;
import com.example.demo.entity.LoanDetails.status;
import com.example.demo.service.LoanDetailsService;

@RestController
@RequestMapping("/api")
public class LoanDetailsController 
{
	@Autowired
	private LoanDetailsService loanDetailsService;
	
	@GetMapping("/loanDetails")
	public ResponseEntity<List<LoanDetails>> showLoanDetails()
	{
		return loanDetailsService.showLoanDetails();
	}
	
	@PostMapping("/loanDetails")
	public void createLoanRequest(@RequestBody LoanDetails loanDetails)
	{
		loanDetailsService.createLoanRequest(loanDetails);
	}
	
	@GetMapping("loanDetailsByLoanStatus/{loanStatus}")
	public ResponseEntity<List<LoanDetails>> showByLoanStatus(@PathVariable String loanStatus)
	{
		status st = status.valueOf(loanStatus.toLowerCase());
		return loanDetailsService.showLoanByStatus(st);
	}
}
