package com.aircas.hopital.fluid_infusion.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aircas.hopital.dao.UserDAO;
import com.aircas.hopital.fluid_infusion.ErrorhandleConfiguration;
import com.aircas.hopital.fluid_infusion.ServerResponse;
import com.aircas.hopital.services.UserDAOService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDAOService userService;
    
    @Autowired
    private ErrorhandleConfiguration errConfig;

    /**
     * 获取示例数据库 t_user 的全部信息 
     * @return 返回 json 数据
     * */
    @GetMapping("/users")
    public Object getUsers(){
        List<UserDAO> users = userService.list();
        for (int i = 0; i < users.size(); ++i){ users.get(i).setPassword("");}
        ServerResponse res = new ServerResponse("OK", users);
        return  res;
    }
    
    @PostMapping("/registry")
    @CrossOrigin
    public Object addUsers(@RequestBody Map<String, String> user){
    	ServerResponse res = new ServerResponse("OK", null);
    	String login = user.get("login");
    	String phone = user.get("phone");
    	List<UserDAO> targetUser = userService.findByLogin(login);
    	if (targetUser.size() != 0){
    		Integer code = errConfig.getErrorCode().get("USER_EXIST_EXCEPTION");
    		res.setMessage("USER_EXIST_EXCEPTION");
    		res.setStatus(code);
    		return res;
    	}
    	List<UserDAO> targetUserPhone = userService.findByPhone(phone);
    	if (targetUserPhone.size() != 0){
    		Integer code = errConfig.getErrorCode().get("PHONE_EXIST_EXCEPTION");
    		res.setMessage("PHONE_EXIST_EXCEPTION");
    		res.setStatus(code);
    		return res;
    	}
    	UserDAO userObj = new UserDAO();
    	String name = user.get("name");
    	String password = user.get("password");
    	userObj.setLogin(login);
    	userObj.setName(name);
    	userObj.setPassword(password);
    	userObj.setPhone(phone);
    	userObj.setLast_login_time(new Date());
    	UserDAO userSaved = userService.addOrUpdateUser(userObj);
    	if (userSaved != null){
    		res.setMessage("OK");
    	} else {
    		res.setMessage("USER_REGISTRY_EXCEPTION");
    		res.setStatus(errConfig.errorCode.get("USER_REGISTRY_EXCEPTION"));
    	}
    	return res;
    }
    
    @PostMapping("/login")
    @CrossOrigin
    public Object login(@RequestBody Map<String, String> user){
    	ServerResponse res = new ServerResponse("OK", null);
    	String login = user.get("login");
    	String password = user.get("password");
    	int count = userService.login(login, password);
    	if (count != 1){
    		res.setMessage("USER_LOGIN_FAILED");
    		res.setStatus(errConfig.errorCode.get("USER_LOGIN_FAILED"));
    	}
    	return res;
    }

    @PostMapping("/update")
    @CrossOrigin
    public Object update(@RequestBody Map<String, String> user){
    	ServerResponse res = new ServerResponse("OK", null);
    	String login = user.get("login");
    	String phone = user.get("phone");
    	List<UserDAO> targetUser = userService.findByLogin(login);
    	if (targetUser.size() == 0){
    		res.setMessage("USER_NON_EXIST_EXCEPTION");
    		res.setStatus(errConfig.errorCode.get("USER_NON_EXIST_EXCEPTION"));
    		return res;
    	}
    	List<UserDAO> targetUsepPhone = userService.findByPhone(phone);
    	if (targetUsepPhone.size() != 0){
    		res.setMessage("UPDATE_PHONE_EXIST_EXCEPTION");
    		res.setStatus(errConfig.errorCode.get("UPDATE_PHONE_EXIST_EXCEPTION"));
    		return res;
    	}
    	UserDAO oldUser = targetUser.get(0);
    	String name = user.get("name");
    	oldUser.setName(name);
    	oldUser.setPhone(phone);
    	UserDAO userUpdated = userService.addOrUpdateUser(oldUser);;
    	if (userUpdated.getName().equals(name) && userUpdated.getPhone().equals(phone)){
    		userUpdated.setPassword("");
    		res.setData(userUpdated);
    	} else {
    		res.setMessage("USER_UPDATE_EXCEPTION");
    		res.setStatus(errConfig.errorCode.get("USER_UPDATE_EXCEPTION"));
    	}
    	return res;
    }
    
    @PostMapping("/updatePass")
    @CrossOrigin
    public Object updatePass(@RequestBody Map<String, String> changePassParam){
    	ServerResponse res = new ServerResponse("OK", null);
    	String login = changePassParam.get("login");
    	String oldPass = changePassParam.get("oldPassword");
    	String newPass = changePassParam.get("newPassword");
    	List<UserDAO> targetUser = userService.findByLogin(login);
    	if (!targetUser.get(0).getPassword().equals(oldPass)){
    		res.setMessage("PASSWORD_NOT_MATCH");
    		res.setStatus(errConfig.errorCode.get("PASSWORD_NOT_MATCH"));
    	} else {
    		UserDAO oldUser = targetUser.get(0);
        	oldUser.setPassword(newPass);
        	userService.addOrUpdateUser(oldUser);
    	}
    	return res;
    }
    
    @PostMapping("/delete")
    @CrossOrigin
    public Object delete(@RequestBody Map<String, String> user){
    	ServerResponse res = new ServerResponse("OK", null);
    	String login = user.get("login");
    	String password = user.get("password");
    	List<UserDAO> targetUser = userService.findByLogin(login);
    	if (targetUser.size() == 1 && targetUser.get(0).getPassword().equals(password)){
    		userService.deleteUser(targetUser.get(0).getId());
    	} else {
    		res.setMessage("DEL_USER_PASS_NOT_MATCH");
    		res.setStatus(errConfig.errorCode.get("DEL_USER_PASS_NOT_MATCH"));
    	}
    	return res;
    }
}
