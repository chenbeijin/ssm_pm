package com.zxcc.spring;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements BeanFactory{
    private Map<String, Object> beans = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext() throws Exception{
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc = saxBuilder.build(ClassPathXmlApplicationContext.class.getClassLoader().getResourceAsStream("beans.xml"));
        Element rootElement = doc.getRootElement();
        List<Element> beanList = rootElement.getChildren("bean");
        for (int i = 0; i < beanList.size(); i++) {
            Element element = beanList.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            Object o = Class.forName(clazz).newInstance();
            System.out.printf("id = %s; clazz = %s\n", id, clazz);
            beans.put(id, o);

            for (Element propertyElement:(List<Element>)element.getChildren("property")) {
                String name = propertyElement.getAttributeValue("name");//UserDAO
                String bean = propertyElement.getAttributeValue("bean");//u
                Object beanObject = beans.get(bean);//UserDAOImpl instance

                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                System.out.printf("method = %s\n", methodName);

                Method method = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces());//setUserDAO(UserDAO.class);
                method.invoke(o, beanObject);
            }
        }
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }
}
