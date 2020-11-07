package com.zxcc.service;

import com.zxcc.dao.UserDAO;
import com.zxcc.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Scope("prototype")
@Component("userService")
public class UserService {
    private UserDAO userDAO;

    @PostConstruct //构造方法完成之后
    public void init(){
        System.out.println("init");
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Resource(name = "userDAOImpl")
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

    @PreDestroy //容器销毁之前
    public void destroy(){
        System.out.println("destroy");
    }
}
