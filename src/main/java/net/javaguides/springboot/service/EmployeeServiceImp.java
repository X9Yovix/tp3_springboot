package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository empRepo;

    public EmployeeServiceImp(EmployeeRepository empR) {
        this.empRepo = empR;
    }

    @Override
    public Employee saveEmployee(Employee e) {
        return this.empRepo.save(e);
    }

    @Override
    public List<Employee> getEmployees() {
        return this.empRepo.findAll();
    }

    @Override
    public Employee getEmployeeByID(long id) {
        return this.empRepo.findById(id).orElseThrow();
    }

    @Override
    public Employee updateEmployee(long id, Employee e) {
        Employee emp = getEmployeeByID(id);
        emp.setFirstName(e.getFirstName());
        emp.setLastName(e.getLastName());
        emp.setEmail(e.getEmail());

        this.empRepo.save(emp);

        return emp;
    }

    @Override
    public boolean deleteEmployee(long id) {
        Employee emp = getEmployeeByID(id);
        if (emp != null) {
            this.empRepo.delete(emp);
            return true;
        }
        return false;
    }
}
