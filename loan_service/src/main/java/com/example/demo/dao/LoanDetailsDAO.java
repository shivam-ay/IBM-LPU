package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoanDetails;
import com.example.demo.entity.LoanDetails.status;

@Repository(value = "loanDetailsDAO")
public interface LoanDetailsDAO extends JpaRepository<LoanDetails, Long>
{
	@Query
	public List<LoanDetails> findByLoanStatus(status loanStatus);
}
