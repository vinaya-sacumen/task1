package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Services {
    private List<Employee> employees= new ArrayList<>(Arrays.asList(
            new Employee(1,12345678,"vi@1234"),
            new Employee(2,456789,"r@dtr")
    ));




    public List<Employee> getAllEmployees(){
        return employees;
    }
    public Employee getEmployee(long no)
    {
        return employees.stream().filter(t->t.getNo()==(no)).findFirst().get();
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    public void updateEmployee(Employee employee, long no) {
        for(int i=0;i<employees.size();i++)
        {
            Employee e=employees.get(i);
            if(e.getNo()==(no)){
                employees.set(i,employee);
                return;
            }
        }
    }

    public void deleteEmployee(long no) {
        employees.removeIf(e->e.getNo()==(no));
    }
}
