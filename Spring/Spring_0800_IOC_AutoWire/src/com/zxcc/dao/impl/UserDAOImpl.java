package com.zxcc.dao.impl;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;

public class UserDAOImpl implements UserDAO {

    private int daoId;

    public int getDaoId() {
        return daoId;
    }

    public void setDaoId(int daoId) {
        this.daoId = daoId;
    }

    @Override
    public void save(User u) {
        System.out.println("a UserDAO save!");
    }

    @Override
    public String toString() {
        return "UserDAOImpl{" +
                "daoId=" + daoId +
                '}';
    }
}
