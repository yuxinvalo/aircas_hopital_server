package com.aircas.hopital.fluid_infusion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GenSQLData {
	public static String generateUserSQL(int num, int startId, String tableName){
		String sql = "";
		String login = "";
		String name = "";
		String password = "toto";
		String lastLoginTime = "";
		String phone = "";
		String charac = "桂花桃儿涛香兰向天阿翔歌维思洁笑添雨鱼语玉琼琴建其琪一二麦娣文蔚薇溪戏喜落阿星心新"
				+ "醒欣馨甄珍仔镜有小肖婷庭静景净晶夏霞清情芹青丝寺诗世红鸿虹胜过男";
		String[] characs = charac.split("");
		String[] phoneHeader = {"135", "132", "137", "138", "139", "158", "157", "155", "159"};
		Random rand = new Random();
		for (int i = startId; i <= num + startId; ++i){
			login = gen6Login(i);
			login = login + Integer.toString(rand.nextInt(89)+ 10);
			name = characs[rand.nextInt(characs.length)] + characs[rand.nextInt(characs.length)];
			lastLoginTime = genRandomDateTime();
			phone = phoneHeader[rand.nextInt(phoneHeader.length)] + login;
			sql = sql + "INSERT INTO " + tableName + " VALUES (" + i + ", '" + login + "', '"
					+ name +"', '" + password + "', '" + lastLoginTime + "', '"
					+ phone + "');\n"; 
//			System.out.println(sql);
		}
		return sql;
	}
	
	public static String genDevice(int num, String tableName){
		String sql = "";
		String deviceHeader = "TCB-";
		String deviceName = "";
		int[] freqies = {20, 30, 40, 50, 60, 70, 80};
		Random rand = new Random();
		for(int i = 1; i <= num; ++i){
			deviceName = deviceHeader + genDeviceSuffix(i);
			int freq = freqies[rand.nextInt(freqies.length)];
			int progress = rand.nextInt(100);
			int power = rand.nextInt(100);
			int ipSuffix = i % 20;
			int routeSuffixTemp = i/20;
			String routeSuffix = "";
			if (routeSuffixTemp > 253){
				routeSuffix = "1." + Integer.toString(routeSuffixTemp-253);
			} else {
				routeSuffix = "0." + Integer.toString(routeSuffixTemp);
			}
			String ip_device = "192.168.0." + Integer.toString(ipSuffix);
			String ip_route = "10.0." + routeSuffix;
			boolean alarm = false;
			if (progress > 90){
				alarm = true;
			}
			sql = sql + "INSERT INTO " + tableName + " VALUES ('" + deviceName + "', " 
					+ freq + ", " + progress + ", " + power + ", '" + ip_device + "', '"
					+ ip_route + "', " + alarm + ");\n";
		}
		
		return sql;
	}
	
	public static String genNurseDevice(int userSize, int devSize, String tableName){
		Random rand = new Random();
		String sql = "";
		for(int i = 1; i <= devSize; ++i){
			int nurseId = rand.nextInt(userSize)+1;
			String devId = "TCB-" + genDeviceSuffix(i);
			int bed_num = (i % 20) + 1;
			int room = (i/20) + 1;
			sql = sql + "INSERT INTO " + tableName + " VALUES (" + i + ", " + nurseId + ", '" 
					+ devId + "', " + bed_num + ", " + room + ");\n";
		}
		return sql;
	}
	
	public static String genDeviceSuffix(int index){
		String res = "";
		String[] header = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		if (index > header.length * 500){
			try {
				throw new Exception("Too big..");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int mod = index % 500;
		int rate = index/500;
		res = res + header[rate] + Integer.toString(mod);
		return res;
	}
	
	public static String genRandomDateTime(){
		Random rand   =   new   Random();
		SimpleDateFormat   format   =   new   SimpleDateFormat( "yyyy-MM-dd hh:mm:ss");
		Calendar   cal   =   Calendar.getInstance();
		cal.set(2020, 0, 1);
		long start = cal.getTimeInMillis();
		cal.set(2021, 2, 1);
		long end = cal.getTimeInMillis();
		Date d = new Date(start + (long)(rand.nextDouble() * (end - start)));
		return format.format(d);
	}
	
	public static String gen6Login(int num){
		String res = Integer.toString(num);
		int delta = 6 - res.length();
		if (delta < 0){
			return res.substring(res.length()-6, res.length());
		} else {
			for (int i = 0; i < delta; ++i){
				res = "0" + res;
			}
			return res;
		}
	}
	
	public static void main(String[] args){
//		System.out.println(GenSQLData.generateUserSQL(300, 1, "t_user"));
//		System.out.println(GenSQLData.genDevice(1000, "t_device"));
//		System.out.println(GenSQLData.genNurseDevice(300, 1000, "t_user_device"));
		
	}
}
