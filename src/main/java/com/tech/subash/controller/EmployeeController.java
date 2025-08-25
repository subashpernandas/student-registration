package com.tech.subash.controller;

import com.tech.subash.entity.EmployeeEntity;
import com.tech.subash.repository.EmployeeRepository;
import com.tech.subash.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
//@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeRepository employeeRepository;

    public  EmployeeController(EmployeeService employeeService, EmployeeRepository
                                employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/get")
    public List<EmployeeEntity> getAllEmployee() {
        return employeeService.getAllEmployee();
    }


    @GetMapping("/getAll")
    public List<EmployeeEntity> getAllEmployeeFind() {
        return employeeRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/store")
    public EmployeeEntity storeEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.updateEmployee(employee);
    }

    @PostMapping("/update/{id}")
    public EmployeeEntity storeEmployee(@RequestBody EmployeeEntity employee,@PathVariable("id") Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        deleteEmployee(id);
    }
}


