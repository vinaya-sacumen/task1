package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
/* this is the controller class used to map the values */
@RestController
public class Hello {
    @Autowired
    private static Services services;
   // @Autowired
   // private Services services;
   // @Autowired // this annotation used to inject the object of Service class automaticaly
    //private Services services;
    @RequestMapping("/values")
    public static List<Employee> getAllEmployees() // here getting the details of all employee
    {
        return services.getAllEmployees();
    }

    @RequestMapping("/values/{no}")
    public static Employee getEmployee(@PathVariable long no)//getting the details of single employee based on no
    {
        return services.getEmployee(no);
    }
    @RequestMapping(method=RequestMethod.POST,value="/values")
    public void addEmployee(@RequestBody Employee employee){ //adding another employee details
        services.addEmployee(employee);
    }
    @RequestMapping(method=RequestMethod.PUT,value="/values/{no}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable long no){ //updating the employee details based on no
        services.updateEmployee(employee,no);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/values/{no}")

    public void deleteEmployee(@PathVariable long no){// deleting employee details based on no
        services.deleteEmployee(no);
    }



}
