package com.aircas.hopital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircas.hopital.dao.UserDeviceDAO;
import com.aircas.hopital.dao.UserDeviceDAORepository;

@Service
public class UserDeviceDAOService {
	@Autowired
	UserDeviceDAORepository userDeviceRepo;
	
	public UserDeviceDAO findByDeviceID(Long id){
		UserDeviceDAO obj = userDeviceRepo.findOne(id);
		return obj;
	}
}
