package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.UserDetails;

public interface UserDetailsService 
{
	public ResponseEntity<List<UserDetails>> showAllUsers();
	public ResponseEntity<UserDetails> findById(int id);
	public ResponseEntity<String> updateUserDetails(UserDetails userDetails,int id);
	public ResponseEntity<String> delete(int id);
}
