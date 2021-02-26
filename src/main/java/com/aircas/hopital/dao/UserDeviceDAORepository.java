package com.aircas.hopital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeviceDAORepository extends JpaRepository<UserDeviceDAO, Long>{
	
	@Query("SELECT tud FROM UserDeviceDAO tud INNER JOIN tud.id_device td WHERE td.id=:device_id ORDER BY tud.room ASC")
	UserDeviceDAO findByDeviceID(@Param("device_id") String id);
	
	@Query("SELECT count(tud) FROM UserDeviceDAO tud")
	Integer countSize();
	
	@Query("SELECT tud FROM UserDeviceDAO tud INNER JOIN tud.id_device td WHERE td.alarm = true")
	List<UserDeviceDAO> findAlarmDevice();
}
