package com.aircas.hopital.fluid_infusion.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aircas.hopital.dao.DeviceDAO;
import com.aircas.hopital.dao.UserDeviceDAO;
import com.aircas.hopital.services.DeviceDAOService;
import com.aircas.hopital.services.UserDeviceDAOService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/info") 
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
	public Object getDeviceById(@PathVariable String id){
		UserDeviceDAO obj = userDeviceService.findByDeviceID(id);
		return obj;
	}
	
	@PostMapping("/userDeviceStatus")
	@CrossOrigin
	public Object getAllUserDeviceStatus(@RequestBody Map<String, Integer> params){
		Integer currPage = (Integer) params.get("currPage");
		Integer size = (Integer) params.get("size");
		List<UserDeviceDAO> obj = userDeviceService.findAll();
		if (currPage == 0 && size == 0){
			return obj;
		}
		
		obj = obj.subList((currPage-1)*size, currPage * size);
		return obj;
	}
	
	@GetMapping("/allUserDeviceNum")
	@CrossOrigin
	public Object getAllDeviceNum(){
		Object obj = userDeviceService.countSize();
		return obj;
	}
	
	@GetMapping("/alarmUserDevice")
	@CrossOrigin
	public Object getAlarmUserDevice(){
		Object obj = userDeviceService.findAlarm();
		return obj;
	}
	
}
