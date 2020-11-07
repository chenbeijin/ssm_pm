package com.zxcc.dao.impl;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public void save(User u) {
        System.out.println("a UserDAO save!");
    }

}
