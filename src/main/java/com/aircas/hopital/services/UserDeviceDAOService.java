package com.aircas.hopital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircas.hopital.dao.UserDeviceDAO;
import com.aircas.hopital.dao.UserDeviceDAORepository;

@Service
public class UserDeviceDAOService {
	@Autowired
	UserDeviceDAORepository userDeviceRepo;
	
	public UserDeviceDAO findByDeviceID(String id){
		UserDeviceDAO obj = userDeviceRepo.findByDeviceID(id);
		return obj;
	}
	
	public List<UserDeviceDAO> findAll(){
		return userDeviceRepo.findAll();
	}
	
	public Integer countSize(){
		return userDeviceRepo.countSize();
	}
	
	public List<UserDeviceDAO> findAlarm(){
		return userDeviceRepo.findAlarmDevice();
	}
}
