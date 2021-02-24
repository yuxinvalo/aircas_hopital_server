package com.aircas.hopital.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAORepository extends JpaRepository<UserDAO, Long>{

}
