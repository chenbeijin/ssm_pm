package com.zxcc.dao.impl;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;

public class UserDAOImpl implements UserDAO {

    private int daoId;
    private String daoStatus;

    public int getDaoId() {
        return daoId;
    }

    public void setDaoId(int daoId) {
        this.daoId = daoId;
    }

    public String getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(String daoStatus) {
        this.daoStatus = daoStatus;
    }

    @Override
    public void save(User u) {
        System.out.println("a UserDAO save!" + daoId + " " + daoStatus);
    }

}
