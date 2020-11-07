package com.zxcc.service;

import com.zxcc.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void testAdd(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        userService.add(user);
    }
}