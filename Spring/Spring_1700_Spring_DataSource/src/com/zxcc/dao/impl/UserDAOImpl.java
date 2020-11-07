package com.zxcc.dao.impl;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component(value = "userDAOImpl")
public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(User u){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.createStatement().executeUpdate("insert into tb_user values(null , 123, 123, 'beijin')");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("a UserDAO save!");
    }

}
