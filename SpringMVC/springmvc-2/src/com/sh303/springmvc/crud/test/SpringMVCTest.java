package com.sh303.springmvc.crud.test;

import com.sh303.springmvc.crud.dao.EmployeeDao;
import com.sh303.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping(value = "/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") Integer i){
        String [] vals = new String[10];
        System.out.println(vals[i]);
        return "success";
    }

    @RequestMapping(value = "/testDefaultHandlerExceptionResolver", method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver(){
        System.out.println("testDefaultHandlerExceptionResolver...");
        return "success";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "测试")
    @RequestMapping(value = "/testRespopnseStatusExceptionResolver")
    public String testRespopnseStatusExceptionResolver(@RequestParam(value = "i") Integer i){
        if(i == 13){
            throw new UserNameNotMatchPasswordException();
        }
        System.out.println("testRespopnseStatusExceptionResolver...");
        return "success";
    }

    /*@ExceptionHandler({RuntimeException.class})
    public ModelAndView handleArithmeticException2(Exception exception){
        System.out.println("[出异常了] : " + exception);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", exception);
        return mv;
    }*/

    /**
     * 1. 在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数，该参数即对应发生的异常对象
     * 2. @ExceptionHandler 方法的入参中不能传入 Map, 若希望把异常信息传导到页面上，需要使用 ModelAndView 作为返回值
     * 3. @ExceptionHandler 方法标记的异常有优先级的问题
     * 4. @ControllerAdvice: 如果在当前 Handler 中找不到 @ExceptionHandler 方法来出来当前方法出现的异常,
     * 则将去 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常.
     */
   /* @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception exception){
        System.out.println("出异常了 : " + exception);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", exception);
        return mv;
    }*/

    @RequestMapping(value = "/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") Integer i){
        System.out.println("result : " + (10 / i));
        return "success";
    }

    @RequestMapping(value = "/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("desc : " + desc);
        System.out.println("OriginalFilename : " + file.getOriginalFilename());
        System.out.println("InputStream : " + file.getInputStream());
        return "success";
    }

    //和配置文件<!--<mvc:view-controller path="/i18n" view-name="i18n"/>-->一样
    @RequestMapping("/i18n2")
    public String testI18n2(Locale locale){
        String val = messageSource.getMessage("i18n.password", null, locale);
        System.out.println(val);
        return "i18n2";
    }

    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        String val = messageSource.getMessage("i18n.user", null, locale);
        System.out.println(val);
        return "i18n";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
        byte [] body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String boby){
        System.out.println(boby);
        return "hello world! " + new Date();
    }

    @ResponseBody
    @RequestMapping(value = "/testJosn")
    public Collection<Employee> testJosn(){
        return employeeDao.getAll();
    }

    @RequestMapping(value = "/testConversionServiceConverer")
    public String testConverter(@RequestParam(value = "employee")Employee employee){
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
