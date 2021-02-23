package com.springboot.crud.springbootcroudwithmysql.service;


import com.springboot.crud.springbootcroudwithmysql.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> get();

    Employee get(int id);

    void save(Employee employee);

    void delete(int id);

}
