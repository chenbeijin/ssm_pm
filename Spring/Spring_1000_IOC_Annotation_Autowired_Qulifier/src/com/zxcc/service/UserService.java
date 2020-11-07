package com.zxcc.service;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserService {
    private UserDAO userDAO;

    public void init(){
        System.out.println("init");
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Autowired
    public void setUserDAO(@Qualifier("u") UserDAO userDAO) {
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
