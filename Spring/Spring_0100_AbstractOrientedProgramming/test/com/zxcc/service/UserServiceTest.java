package com.zxcc.service;

import com.zxcc.model.User;
import com.zxcc.spring.BeanFactory;
import com.zxcc.spring.ClassPathXmlApplicationContext;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void testAdd() throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext();

        UserService userService = (UserService) beanFactory.getBean("userService");
        User user = new User();
        userService.add(user);
    }
}