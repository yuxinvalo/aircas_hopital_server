package com.aircas.hopital.fluid_infusion;

import java.util.List;

import com.aircas.hopital.dao.UserDeviceDAO;

public class Tools {
	public static String list2Str(List<UserDeviceDAO> userDevice){
		String strBuilder = "";
		for(Object ele : userDevice){
			try{
				strBuilder = strBuilder + ele.toString();
			} catch (Exception e){}
		}
		return strBuilder;
	}
	
	public static long getTimeStamp(){
		long time = System.currentTimeMillis();
		return time/1000;
	}
}
