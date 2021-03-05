package com.aircas.hopital.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAORepository extends JpaRepository<UserDAO, Long>{
//	@Modifying
//	@Query("INSERT INTO t ")
//	int addUser(@Param("user") UserDAO user);
	
	@Query("SELECT count(td) FROM UserDAO td WHERE td.login=:login AND td.password=:password")
	int loginUser(@Param("login") String login, @Param("password") String password);
	
	@Query("SELECT td FROM UserDAO td WHERE td.login=:login")
	List<UserDAO> findByLogin(@Param("login") String login);
	
	@Modifying
	@Query("UPDATE UserDAO td SET td.name=:name, td.phone=:phone WHERE td.login=:login")
	void updateUserInfo(@Param("name") String name, @Param("phone") String phone, @Param("login") String login);
	
	@Query("SELECT td FROM UserDAO td WHERE td.phone=:phone")
	List<UserDAO> findByPhone(@Param("phone") String phone);
}
