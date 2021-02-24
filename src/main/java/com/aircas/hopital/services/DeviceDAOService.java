package com.aircas.hopital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircas.hopital.dao.DeviceDAO;
import com.aircas.hopital.dao.DeviceDAORepository;

@Service
public class DeviceDAOService {
	@Autowired
	private DeviceDAORepository deviceRepo;
	
	public List<DeviceDAO> loadDevicesStatus(){
		List<DeviceDAO> list = deviceRepo.findAll();
		return list;
	}
}
