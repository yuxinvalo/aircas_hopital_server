package com.aircas.hopital.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAORepository extends JpaRepository<UserDAO, Long>{
//	@Modifying
//	@Query("INSERT INTO t ")
//	int addUser(@Param("user") UserDAO user);
}
