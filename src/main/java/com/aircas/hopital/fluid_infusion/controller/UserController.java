package com.aircas.hopital.fluid_infusion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aircas.hopital.dao.UserDAO;
import com.aircas.hopital.services.UserDAOService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDAOService userSevice;

    /**
     * 获取示例数据库 t_user 的全部信息 
     * @return 返回 json 数据
     * */
    @GetMapping("/users")
    public Object getUsers(){
        List<UserDAO> users = userSevice.list();
        return  users;
    }

}
