package com.aircas.hopital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aircas.hopital.dao.UserDAO;
import com.aircas.hopital.dao.UserDAORepository;

@Service
public class UserDAOService {
	@Autowired
	private UserDAORepository userRepo;
	
	public List<UserDAO> list(){
		return userRepo.findAll();
	}
	
	public UserDAO addOrUpdateUser(UserDAO user){
		UserDAO userSaved = userRepo.save(user);
		return userSaved;
	}
	
	public int login(String login, String password){
		int count = userRepo.loginUser(login, password);
		return count;
	}
	
	public List<UserDAO> findByLogin(String login){
		List<UserDAO> targetUser = userRepo.findByLogin(login);
		return targetUser;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void updateUser(UserDAO user){
		userRepo.updateUserInfo(user.getName(), user.getPhone(), user.getLogin());
	}
	
	public void deleteUser(Long id){
		userRepo.delete(id);
	}
	
	public List<UserDAO> findByPhone(String phone){
		List<UserDAO> targetUser = userRepo.findByPhone(phone);
		return targetUser;
	}
}
