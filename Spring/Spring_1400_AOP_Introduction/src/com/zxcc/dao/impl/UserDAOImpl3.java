package com.zxcc.dao.impl;

import com.zxcc.aop.LogInterceptor;
import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;

public class UserDAOImpl3 implements UserDAO {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void save(User u) {
        new LogInterceptor().beforeMethod(null);
        userDAO.save(u);
    }

    @Override
    public void delete() {

    }
}
