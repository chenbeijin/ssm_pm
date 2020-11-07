package com.zxcc.service;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;

import javax.annotation.Resource;

public class UserService {
    private UserDAO userDAO;

    public void init(){
        System.out.println("init");
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Resource
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(User u){
        userDAO.save(u);
    }

    public UserService(UserDAO userDAO){
        super();
        this.userDAO = userDAO;
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
