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
import com.aircas.hopital.fluid_infusion.ErrorhandleConfiguration;
import com.aircas.hopital.fluid_infusion.ServerResponse;
import com.aircas.hopital.services.DeviceDAOService;
import com.aircas.hopital.services.UserDeviceDAOService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/api/device") 
public class InfusionController {
	@Autowired
	DeviceDAOService deviceService;
	
	@Autowired
	UserDeviceDAOService userDeviceService;
	
	@Autowired
    private ErrorhandleConfiguration errConfig;
	
	@ApiOperation(value="设备状态")
	@ApiResponses({@ApiResponse(code=200, message="OK", response=DeviceDAO.class)})
	@GetMapping("/status")
	@CrossOrigin
    public Object getAllDeviceStatus(){
		ServerResponse res = new ServerResponse("OK", null);
        List<DeviceDAO> devices = deviceService.loadDevicesStatus();
        res.setData(devices);
        return  res;
    }
	
	@GetMapping("/status/{id}")
	@CrossOrigin
	public Object getDeviceById(@PathVariable String id){
		ServerResponse res = new ServerResponse("OK", null);
		UserDeviceDAO obj = userDeviceService.findByDeviceID(id);
		res.setData(obj);
		return obj;
	}
	
	
	@PostMapping("/userDeviceStatus")
	@CrossOrigin
	public Object getAllUserDeviceStatus(@RequestBody Map<String, Integer> params){
		ServerResponse res = new ServerResponse("OK", null);
		Integer currPage = (Integer) params.get("currPage");
		Integer size = (Integer) params.get("size");
		List<UserDeviceDAO> obj = userDeviceService.findAll();
		if (currPage == 0 && size == 0){
			res.setData(obj);
			return res;
		}
		if (currPage * size > obj.size()){
			res.setMessage("OUT_OF_BOUND_EXCEPTION");
			res.setStatus(errConfig.errorCode.get("OUT_OF_BOUND_EXCEPTION"));
			return res;
		}
		obj = obj.subList((currPage-1)*size, currPage * size);
		res.setData(obj);
		return res;
	}

	@GetMapping("/allUserDeviceNum")
	@CrossOrigin
	public Object getAllDeviceNum(){
		ServerResponse res = new ServerResponse("OK", null);
		Object obj = userDeviceService.countSize();
		res.setData(obj);
		return res;
	}
	
	@GetMapping("/alarmUserDevice")
	@CrossOrigin
	public Object getAlarmUserDevice(){
		ServerResponse res = new ServerResponse("OK", null);
		Object obj = userDeviceService.findAlarm();
		res.setData(obj);
		return res;
	}
	
	@PostMapping("/registryDevice")
	@CrossOrigin
	public Object registryDevice(@RequestBody Map<String,String> params){
		String login = params.get("login");
		String deviceId = params.get("device_id");
		
		Integer room = Integer.valueOf(params.get("room"));
		Integer bedNum = Integer.valueOf(params.get("bed_num"));
		return "OK";
	}
	
	@PostMapping("/unregistryDevice")
	@CrossOrigin
	public Object unregistryDevice(@RequestBody Map<String,String> params){
		return "OK";
	}
}
