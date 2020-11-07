package com.zxcc.service;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(User u){
        userDAO.save(u);
    }
}
