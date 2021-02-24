package com.aircas.hopital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeviceDAORepository extends JpaRepository<UserDeviceDAO, Long>{
	
}
