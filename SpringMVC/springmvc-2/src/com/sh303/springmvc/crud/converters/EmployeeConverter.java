package com.sh303.springmvc.crud.converters;

import com.sh303.springmvc.crud.entities.Department;
import com.sh303.springmvc.crud.entities.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

    @Override
    public Employee convert(String s) {
        if(s != null){
            String [] vals = s.split("-");
            //GG-gg@atguigu.com-0-105
            if(vals != null && vals.length == 4){
                String lastName = vals[0];
                String email = vals[1];
                Integer gender = Integer.parseInt(vals[2]);
                Department department = new Department();
                department.setId(Integer.parseInt(vals[3]));

                Employee employee = new Employee(null, lastName, email, gender, department);
                System.out.println(s + "--convert--" + employee);
                return employee;
            }
        }
        return null;
    }

}
