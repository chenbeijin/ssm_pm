package com.sh303.ssm_pm.controller;

import com.sh303.ssm_pm.entity.SysLog;
import com.sh303.ssm_pm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; // 开始时间
    private Class clazz;    // 访问的类
    private Method method;  // 访问的方法

    /**
     * 前置通知 主要获取开启时间，执行的类是哪一个，执行的是哪一个方法
     *
     * @param joinPoint
     */
    @Before("execution(* com.sh303.ssm_pm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        try {
            visitTime = new Date();// 当前时间
            clazz = joinPoint.getTarget().getClass(); // 具体访问时间
            String methodName = joinPoint.getSignature().getName(); // 获取访问的方法的名称
            Object[] args = joinPoint.getArgs();  // 获取访问的方法的参数

            // 获取具体执行方法的method对象
            if (args == null || args.length == 0) {
                method = clazz.getMethod(methodName);
            } else {
                Class[] clazzArgs = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    clazzArgs[i] = args[i].getClass();
                }
                method = clazz.getMethod(methodName, clazzArgs);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After("execution(* com.sh303.ssm_pm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        long time = new Date().getTime() - visitTime.getTime(); // 获取访问时长

        String url = "";
        // 获取url
        if (clazz != null && method != null && clazz != LogAop.class) {
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                // 类上的注解中value的值
                String[] classValue = classAnnotation.value();
                // 方法上的注解中value的值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }
            }
        }

        // 获取ip地址
        String ip = request.getRemoteAddr();

        // 获取当前操作的用户
        SecurityContext context = SecurityContextHolder.getContext();   // 从上下文中获取当前登录的用户

        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        // 进行封装
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(time);
        sysLog.setVisitTime(visitTime);
        sysLog.setMethod("[类名] " + clazz.getName() + "[方法名]" + method.getName());
        sysLog.setIp(ip);
        sysLog.setUrl(url);
        sysLog.setUsername(username);

        // 调用Service完成操作
        try {
            sysLogService.save(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
