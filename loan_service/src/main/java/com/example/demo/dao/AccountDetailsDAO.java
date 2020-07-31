package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AccountDetails;

@Repository(value = "accountDetailsDAO")
public interface AccountDetailsDAO extends JpaRepository<AccountDetails, Long>
{
	
}
