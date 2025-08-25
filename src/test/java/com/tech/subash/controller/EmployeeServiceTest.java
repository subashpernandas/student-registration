package com.tech.subash.controller;

import com.tech.subash.enums.EmployeeTypeEnum;
import com.tech.subash.entity.EmployeeEntity;
import com.tech.subash.repository.EmployeeRepository;
import com.tech.subash.service.EmployeeService;
import com.tech.subash.utils.ApplicationUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ApplicationUtils applicationUtils;

    private static final List<EmployeeEntity> employeeEntityList = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(1l);
        employee.setEmployeeName("subash.perandas");
        employee.setEmployeeType(EmployeeTypeEnum.PERMANENT);
        employee.setSalary(210000);
        employee.setDept("Engineering");
        employeeEntityList.add(employee);
    }

    @Test
    void getAllEmployeeTest() {
        //when(applicationUtils.getUtilCalls()).thenReturn("Util-Call");
        when(applicationUtils.getUtilCallsWith()).thenReturn("subash.ps");
        when(employeeRepository.findAll()).thenReturn(employeeEntityList);

        try (MockedStatic<ApplicationUtils> mockedStatic = mockStatic(ApplicationUtils.class)) {
            mockedStatic.when(() -> ApplicationUtils.getUtilCalls()).thenReturn("Util-Call");
            mockedStatic.when(() -> ApplicationUtils.isValid("Util-Call")).thenReturn(true);
            List<EmployeeEntity> allEmployee = employeeService.getAllEmployee();
            assertAll(
                    () -> assertEquals(employeeEntityList.size(), allEmployee.size()),
                    () -> assertEquals(employeeEntityList.get(0).getEmployeeId(), allEmployee.get(0).getEmployeeId())
            );
        }
    }

    @Test
    void getAllEmployeeTestException() {
        MockedStatic<ApplicationUtils> mockedStatic = mockStatic(ApplicationUtils.class);
        mockedStatic.when(() -> ApplicationUtils.getUtilCalls()).thenReturn("Util-CallOne");
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> employeeService.getAllEmployee());
        assertEquals("exception occured", runtimeException.getMessage());
        verify(employeeRepository, never()).findAll();
    }
}
