package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
//@WebMvcTest(Hello.class)
//@SpringBootTest
public class Testclass {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    Services service;
    @InjectMocks
    Hello hello;
    List<Employee> result=new ArrayList(Arrays.asList(1,12345678,"vi@1234"));
    @Test
    public void getAllEmployeestest() throws Exception
    {
        Mockito.when(service.getAllEmployees()).thenReturn(result);
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/values")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        List<Employee> lst=service.getAllEmployees();
        Mockito.verify(service).getAllEmployees();
        Assert.assertEquals(lst,mvcResult);
    }



    Employee result1=new Employee(1,12345678,"vi@234");
    @Test
    public void getEmployeetest() throws Exception
    {
        Mockito.when(service.getEmployee(1)).thenReturn(result1);
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/values/1")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Employee emp=service.getEmployee(1);
        Mockito.verify(service).getEmployee(1);
        Assert.assertEquals(emp,mvcResult);
    }


Employee result2=new Employee(1,12345678,"vi@234");
    @Test
    public void postEmployeeTest() throws Exception
    {
         Mockito.when(service.addEmployee(new Employee(4,12345,"@vind"))).thenReturn(result2);
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/values")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Employee emp=service.addEmployee();
        Mockito.verify(service).addEmployee();
        Assert.assertEquals(emp,mvcResult);
    }


     String result3=new Employee(1,12345678,"vi@234");
    @Test
    public void updateEmployee() throws Exception
    {
         Mockito.when(service.updateEmployee(1)).thenReturn(result3);
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.put("/values/1")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Employee emp=service.updateEmployee(1);
        Mockito.verify(service).updateEmployee(1);
        Assert.assertEquals(emp,mvcResult);

    }
    
 String result4=new Employee(1,12345678,"vi@234");
    @Test
    public void deleteEmployee() throws Exception
    {
        Mockito.when(service.deleteEmployee(1)).thenReturn(result4);
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.delete("/values/1")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Employee emp=service.deleteEmployee(1);
        Mockito.verify(service).getEmployee(1);
        Assert.assertEquals(emp,mvcResult);

    }



}
