package com.zxcc.service;

import com.zxcc.aop.LogInterceptor;
import com.zxcc.dao.UserDAO;
import com.zxcc.dao.impl.UserDAOImpl;
import com.zxcc.model.User;
import com.zxcc.spring.BeanFactory;
import com.zxcc.spring.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class UserServiceTest {

    @Test
    public void testAdd() throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext();

        UserService userService = (UserService) beanFactory.getBean("userService");
        User user = new User();
        userService.add(user);
    }

    @Test
    public void testProxy(){
        UserDAO userDAO = new UserDAOImpl();

        LogInterceptor logInterceptor = new LogInterceptor();
        logInterceptor.setTarget(userDAO);
                                                                                                    // ^^^^ new Class[]{UserDAO.class}  或 userDAO.getClass().getInterfaces()
        UserDAO userDAOProxy = (UserDAO) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), new Class[]{UserDAO.class}, logInterceptor);
        System.out.println(userDAOProxy.getClass());
        userDAOProxy.delete();
        userDAOProxy.save(new User());
    }

    /**
     * class $Proxy4 implements UserDao
     * {
     *     save(User user){
     *         Method method = UserDAO.getClass().getMethod()
     *         logInterceptor.invoke(this, method, user);
     *     }
     * }
     */
}