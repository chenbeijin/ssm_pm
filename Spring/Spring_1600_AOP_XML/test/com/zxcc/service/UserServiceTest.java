package com.zxcc.service;

import com.zxcc.model.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.add(new User());

        applicationContext.destroy();
    }
}