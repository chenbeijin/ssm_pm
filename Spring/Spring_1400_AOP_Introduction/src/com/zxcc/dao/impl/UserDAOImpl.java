package com.zxcc.dao.impl;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public void save(User u) {
        //Hibernate
        //JDBC
        //XML
        //NetWork
        System.out.println("a UserDAO save!");
    }

    @Override
    public void delete() {
        System.out.println("save delete!");
    }

}
