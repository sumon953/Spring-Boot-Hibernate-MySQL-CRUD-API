package com.springboot.crud.springbootcroudwithmysql.controller;


import com.springboot.crud.springbootcroudwithmysql.model.Employee;
import com.springboot.crud.springbootcroudwithmysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //Get Employees;
    @GetMapping("/employee")
    public List<Employee> get()
    {
         return employeeService.get();
    }


    //Post Employee;
    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employeeObj)
    {
      employeeService.save(employeeObj);
      return employeeObj;
    }


    //Update Employee;
    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employeeObj)
    {
        employeeService.save(employeeObj);
        return employeeObj;
    }



    //Get Employee;
    @GetMapping("/employee/{id}")
    @ResponseBody
    public Employee get(@PathVariable int id)
    {
        Employee employeeObj = employeeService.get(id);
        if (employeeObj == null)
        {
            throw new RuntimeException("Employee Has been deleted with id "+id+"is not found.");
        }
        return employeeObj;
        //return employeeService.get(id);
    }


    //Delete Employee;
    @DeleteMapping("/employee/{id}")
    @ResponseBody
    public String delete(@PathVariable int id)
    {
        employeeService.delete(id);
        return "Employee Has been deleted with id: "+id;
    }



}
