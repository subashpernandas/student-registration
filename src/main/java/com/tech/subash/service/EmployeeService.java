package com.tech.subash.service;

import com.tech.subash.entity.EmployeeEntity;
import com.tech.subash.repository.EmployeeRepository;
import com.tech.subash.utils.ApplicationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ApplicationUtils applicationUtils;

    public List<EmployeeEntity> getAllEmployee() {
        String utilCalls = ApplicationUtils.getUtilCalls();
        if ("Util-Call".equals(utilCalls) && ApplicationUtils.isValid(utilCalls)) {
          String name = applicationUtils.getUtilCallsWith();
          if("subash.ps".equals(name)) {
              return employeeRepository.findAll();
          }
        } else {
            throw new RuntimeException("exception occured");
        }
        return List.of();
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employee, Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent()) {
            EmployeeEntity employeeEntity1 = employeeEntity.get();
            employeeEntity1.setEmployeeName(employee.getEmployeeName());
            employeeEntity1.setSalary(employee.getSalary());
            return employeeRepository.save(employee);
        } else {
            throw new IllegalArgumentException("No Data Found");
        }
    }

    public void deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        if (!ObjectUtils.isEmpty(employeeEntity)) {
            employeeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No Data Found");
        }
    }
}



