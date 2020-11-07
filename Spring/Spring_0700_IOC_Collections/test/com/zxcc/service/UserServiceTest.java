package com.zxcc.service;

import com.zxcc.dao.UserDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void testAdd(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");

        System.out.println(userDAO.toString());

    }
}