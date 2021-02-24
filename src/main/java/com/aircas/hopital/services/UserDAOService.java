package com.aircas.hopital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircas.hopital.dao.UserDAO;
import com.aircas.hopital.dao.UserDAORepository;

@Service
public class UserDAOService {
	@Autowired
	private UserDAORepository userRepo;
	
	public List<UserDAO> list(){
		return userRepo.findAll();
	}
}
