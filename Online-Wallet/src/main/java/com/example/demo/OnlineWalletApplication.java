package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ProfileDAO;
import com.example.demo.entity.Profile;

@SpringBootApplication
public class OnlineWalletApplication implements CommandLineRunner
{
	private ProfileDAO profileDAO;
	@Autowired
	public OnlineWalletApplication(ProfileDAO profileDAO)
	{
		this.profileDAO = profileDAO;
	}
	public static void main(String[] args) 
	{
		SpringApplication.run(OnlineWalletApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		profileDAO.save(new Profile("shivam",945592551,"shivamyadav6205@gmail.com",true));
		profileDAO.save(new Profile("Kirti",912556335,"KSKV6205@gmail.com",true));
	}

}
