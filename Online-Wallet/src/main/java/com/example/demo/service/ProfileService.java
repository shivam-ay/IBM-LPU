package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.entity.Profile;

public interface ProfileService 
{
	public ResponseEntity<List<ProfileDTO>> showAllProfiles();
	public ResponseEntity<ProfileDTO> showById(int id);
	public void updateProfie(Profile profile);
	public void deleteProfile(int id);
	public ResponseEntity<ProfileDTO> getByPhoneNumber(long phoneNumber);
}
