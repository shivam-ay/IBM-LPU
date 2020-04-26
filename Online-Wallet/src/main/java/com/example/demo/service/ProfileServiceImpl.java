package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dao.ProfileDAO;
import com.example.demo.dto.ProfileDTO;
import com.example.demo.entity.Profile;

@Service(value = "profileService")
@EnableTransactionManagement
public class ProfileServiceImpl implements ProfileService
{
	private ProfileDAO profileDAO;
	@Autowired
	public ProfileServiceImpl(ProfileDAO profileDAO)
	{
		this.profileDAO = profileDAO;
	}
	
	@Override
	@Transactional
	public ResponseEntity<List<ProfileDTO>> showAllProfiles() 
	{
		List<ProfileDTO> profiles = new ArrayList<>();
		for(Profile profile : profileDAO.findAll())
		{
			profiles.add(new ProfileDTO(profile.getName(),profile.getPhoneNumber(),profile.getEmail(),profile.isStatus()));
		}
		return ResponseEntity.ok().body(profiles);
	}

	@Override
	@Transactional
	public ResponseEntity<ProfileDTO> showById(int id) 
	{
		Profile fetchProfile = profileDAO.findById(id).get();
		ProfileDTO profile = new ProfileDTO(fetchProfile.getName(),fetchProfile.getPhoneNumber(),fetchProfile.getEmail(),fetchProfile.isStatus());
		return ResponseEntity.ok().body(profile);
	}

	@Override
	@Transactional
	public void updateProfie(Profile profile) 
	{
		if(profileDAO.findByPhoneNumber(profile.getPhoneNumber()).isPresent())
		{
			profileDAO.save(profile);
		}
	}

	@Override
	@Transactional
	public void deleteProfile(int id) 
	{
		profileDAO.delete(profileDAO.findById(id).get());
	}

	@Override
	@Transactional
	public ResponseEntity<ProfileDTO> getByPhoneNumber(long phoneNumber)
	{
		ProfileDTO profile = profileDAO.findByPhoneNumber(phoneNumber).get();
		return ResponseEntity.ok().body(profile);
	}

}
