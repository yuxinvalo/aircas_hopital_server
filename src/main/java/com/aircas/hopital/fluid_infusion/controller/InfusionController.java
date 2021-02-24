package com.aircas.hopital.fluid_infusion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aircas.hopital.dao.DeviceDAO;
import com.aircas.hopital.dao.UserDeviceDAO;
import com.aircas.hopital.services.DeviceDAOService;
import com.aircas.hopital.services.UserDeviceDAOService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/action") 
public class InfusionController {
	@Autowired
	DeviceDAOService deviceService;
	
	@Autowired
	UserDeviceDAOService userDeviceService;
	
	@GetMapping("/deviceStatus")
    public Object getAllDeviceStatus(){
        List<DeviceDAO> devices = deviceService.loadDevicesStatus();
        return  devices;
    }
	
	@GetMapping("/device/{id}")
	public Object getDeviceById(@PathVariable Long id){
		UserDeviceDAO obj = userDeviceService.findByDeviceID(id);
		return obj;
	}
	
}
