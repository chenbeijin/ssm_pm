package com.sh303.springmvc.crud.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SpringMVCTestExceptionHandler {


    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception exception){
        System.out.println("-----> 出异常了 : " + exception);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", exception);
        return mv;
    }
}
