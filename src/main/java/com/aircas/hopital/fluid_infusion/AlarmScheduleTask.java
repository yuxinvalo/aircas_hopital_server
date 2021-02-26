package com.aircas.hopital.fluid_infusion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.aircas.hopital.dao.DeviceDAO;
import com.aircas.hopital.dao.UserDeviceDAO;
import com.aircas.hopital.services.DeviceDAOService;
import com.aircas.hopital.services.UserDeviceDAOService;

@Configuration
@EnableScheduling
public class AlarmScheduleTask {
	@Autowired
	DeviceDAOService deviceServ;
	
	@Autowired
	UserDeviceDAOService userDevServ;
	
	@Scheduled(fixedRate=10000)
	private void scanAlarmStatus(){
//		DeviceDAOService deviceServ = new DeviceDAOService();
//		UserDeviceDAOService userDevServ = new UserDeviceDAOService();
//		List<DeviceDAO> devices = deviceServ.loadDevicesStatus();
//		List<UserDeviceDAO> userDevice = new ArrayList<UserDeviceDAO>();
//		for (DeviceDAO device : devices){
//			if (device.isAlarm()){
//				UserDeviceDAO target = userDevServ.findByDeviceID(device.getId());
//				target.getId_user().setPassword("");
//				userDevice.add(target);
//			}
//		}
//		System.out.println("Found ALARM Device: " + Tools.list2Str(userDevice));
	}
}
