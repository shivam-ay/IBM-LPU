package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoanDetails;

@Repository(value = "loanDetailsDAO")
public interface LoanDetailsDAO extends JpaRepository<LoanDetails, Long>
{

}
