package com.zxcc.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 日志连接器
 * JDK动态代理
 */

public class LogInterceptor implements InvocationHandler {
    private Object target;  //被代理的对象


    public void beforeMethod(Method method){
        System.out.println(method.getName() + " start..");
    }

    /**
     * 调用任何方法前，都调用beforeMethod方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod(method);
        method.invoke(target, args);
        return null;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
