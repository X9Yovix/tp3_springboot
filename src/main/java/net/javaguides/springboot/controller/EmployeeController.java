package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EmployeeController {

    private EmployeeService empService;

    public EmployeeController(EmployeeService empS) {
        this.empService = empS;
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e) {
        return new ResponseEntity<Employee>(this.empService.saveEmployee(e), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return this.empService.getEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(this.empService.getEmployeeByID(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee e) {
        return new ResponseEntity<Employee>(this.empService.updateEmployee(id, e), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        boolean deleted = empService.deleteEmployee(id);
        if (deleted) {
            return new ResponseEntity<>("Employee with ID " + id + " has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
