package com.zxcc.dao.impl;

import com.zxcc.model.User;

public class UserDAOImpl2 extends UserDAOImpl{

    @Override
    public void save(User u){
        System.out.println("save start...");
        super.save(u);
    }
}
