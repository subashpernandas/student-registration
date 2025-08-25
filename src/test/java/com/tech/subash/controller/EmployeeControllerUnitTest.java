package com.tech.subash.controller;

import com.tech.subash.entity.EmployeeEntity;
import com.tech.subash.enums.EmployeeTypeEnum;
import com.tech.subash.repository.EmployeeRepository;
import com.tech.subash.service.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(EmployeeController.class)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    //@MockBean
    private EmployeeRepository employeeRepository;

    //@MockBean
    private EmployeeService employeeService;

    private static List<EmployeeEntity> employeeEntityList = new ArrayList<>();
    private EmployeeController employeeController;


    @BeforeEach
    void setUpOne(){
        employeeService = mock(EmployeeService.class);
        employeeRepository = mock(EmployeeRepository.class);
        employeeController = new EmployeeController(employeeService, employeeRepository);

    }

    @BeforeAll
    static void setUp() { // must static in junit 5
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(1l);
        employee.setEmployeeName("John");
        employee.setEmployeeType(EmployeeTypeEnum.PERMANENT);
        employee.setSalary(210000);
        employee.setDept("Engineering");
        employeeEntityList.add(employee);
    }

    @Test
    void getAllEmployees_shouldReturnList() throws Exception {
        when(employeeRepository.findAll()).thenReturn(employeeEntityList);
        List<EmployeeEntity> employeeEntities = employeeController.getAllEmployeeFind();
       /* mockMvc.perform(get("/employee/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].employeeName").value("John"));*/
    }

}
