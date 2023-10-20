package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee e);

    List<Employee> getEmployees();

    Employee getEmployeeByID(long id);

    Employee updateEmployee(long id, Employee e);

    boolean deleteEmployee(long id);
}
