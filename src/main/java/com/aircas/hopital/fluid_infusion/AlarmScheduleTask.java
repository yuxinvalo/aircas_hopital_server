package com.aircas.hopital.fluid_infusion;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class AlarmScheduleTask {
	@Scheduled(fixedRate=2000)
	private void scanAlarmStatus(){
//		System.out.println("Scheduling.....");
	}
}
