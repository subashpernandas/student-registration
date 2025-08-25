package com.tech.subash.controller;

import com.tech.subash.enums.EmployeeTypeEnum;
import com.tech.subash.helper.ApplicationHelper;
import com.tech.subash.entity.EmployeeEntity;
import com.tech.subash.repository.EmployeeRepository;
import com.tech.subash.service.EmployeeServiceNew;
import com.tech.subash.utils.ApplicationUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceForStaticMethodsTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ApplicationUtils applicationUtils;

    @Mock
    private ApplicationHelper applicationHelper;

    @InjectMocks
    private EmployeeServiceNew employeeServiceNew;

    private static List<EmployeeEntity> employeeEntityList = new ArrayList<>();


    @BeforeAll
    static void setUp() { // must static in junit 5
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(1l);
        employee.setEmployeeName("subash.perandas");
        employee.setEmployeeType(EmployeeTypeEnum.PERMANENT);
        employee.setSalary(210000);
        employee.setDept("Engineering");
        employeeEntityList.add(employee);
    }

    @Test
    void getAllEmployee_AllConditionsTrue_ShouldReturnList() {
        when(applicationHelper.getUtilCalls()).thenReturn("Util-Call");
        when(applicationHelper.isValid("Util-Call")).thenReturn(true);
        when(applicationUtils.getUtilCallsWith()).thenReturn("subash.ps");
        when(employeeRepository.findAll()).thenReturn(employeeEntityList);

        List<EmployeeEntity> result = employeeServiceNew.getAllEmployee();

        assertEquals(1, result.size());
        assertEquals("subash.perandas", result.get(0).getEmployeeName());
    }

    @Test
    void getAllEmployee_NameMismatch_ShouldReturnEmpty() {
        when(applicationHelper.getUtilCalls()).thenReturn("Util-Call");
        when(applicationHelper.isValid("Util-Call")).thenReturn(true);
        when(applicationUtils.getUtilCallsWith()).thenReturn("someone.else");

        List<EmployeeEntity> result = employeeServiceNew.getAllEmployee();

        assertTrue(result.isEmpty());
        verify(employeeRepository, never()).findAll();
    }

    @Test
    void getAllEmployee_StaticFail_ShouldThrow() {
        when(applicationHelper.getUtilCalls()).thenReturn("Wrong-Call");
        RuntimeException ex = assertThrows(RuntimeException.class, () -> employeeServiceNew.getAllEmployee());
        assertEquals("exception occured", ex.getMessage());
        verify(employeeRepository, never()).findAll();
    }
}
