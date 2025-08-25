package com.tech.subash.controller;

import com.tech.subash.controller.criteria.CriteriaController;
import com.tech.subash.enums.EmployeeTypeEnum;
import com.tech.subash.entity.EmployeeEntity;
import com.tech.subash.service.CriteriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CriteriaController.class)
class CriteriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CriteriaService criteriaService;

    private final List<EmployeeEntity> listOfEmployees = new ArrayList<>();
    private final List<Object[]> mockResponse = new ArrayList<>();


    @BeforeEach
    void setup() {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(1L);
        employee.setEmployeeName("John Doe");
        employee.setEmployeeId("EMP123");
        employee.setDept("Engineering");
        employee.setEmployeeType(EmployeeTypeEnum.PERMANENT);
        employee.setSalary(75);

        EmployeeEntity employee2 = new EmployeeEntity();
        employee2.setId(3L);
        employee2.setEmployeeName("Doe Doe");
        employee2.setEmployeeId("EM234");
        employee2.setDept("Banking");
        employee2.setEmployeeType(EmployeeTypeEnum.TEMPORARY);
        employee2.setSalary(25);
        listOfEmployees.add(employee);
        listOfEmployees.add(employee2);

        Object[] row = new Object[2];
        row[0] = 75;
        row[1] = "Engineering";

        Object[] row1 = new Object[2];
        row1[0] = 25;
        row1[1] = "Engineering";

        mockResponse.add(row);
        mockResponse.add(row1);
    }

    @Test
    void getListOfEmployee() throws Exception {
        when(criteriaService.getListOfEmployee()).thenReturn(listOfEmployees);
        mockMvc.perform(get("/v2/criteria/select")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dept").value("Engineering"));
    }


    @Test
    void getListOfEmployeeUsingMultiSelect() throws Exception {
        when(criteriaService.getListOfEmployeeUsingMultiSelect()).thenReturn(mockResponse);
        mockMvc.perform(get("/v2/criteria/multiselect")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0][1]").value("Engineering"));
    }

    @Test
    void getListOfEmployeeUsingPredicate() throws Exception {
        when(criteriaService.getListOfEmployeeUsingPredicate(1, 3)).thenReturn(listOfEmployees);
        mockMvc.perform(get("/v2/criteria/predicate/1/3")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dept").value("Engineering"))
                .andExpect(jsonPath("$[1].employeeName").value("Doe Doe"));
    }

    @Test
     void getListOfEmployeeUsingDoublePredicate() throws Exception {
        when(criteriaService.getListOfEmployeeUsingDoublePredicate("Engineering")).thenReturn(75);
        mockMvc.perform(get("/v2/criteria/mathFunction/Engineering"))
                .andExpect(status().isOk()).andExpect(content().string("75"));
    }

    /*@Test
     void getListOfEmployeeUsingGroupBy() throws Exception {
        when(criteriaService.getListOfEmployeeUsingGroupBy()).thenReturn(mockResponse);
        mockMvc.perform(get("/v2/criteria/groupBy")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0][0]").value(75))
                .andExpect(jsonPath("$[1][0]").value(25));
    }*/

    @Test
     void getListOfEmployeeUsingGroupByAndOrderBy() throws Exception {
        when(criteriaService.getListOfEmployeeUsingGroupByAndOrderBy()).thenReturn(mockResponse);
        mockMvc.perform(get("/v2/criteria/orderBy")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0][0]").value(75))
                .andExpect(jsonPath("$[0][1]").value("Engineering"));
    }

    @Test
     void getListOfEmployeeUsingGroupByAndHaving() throws Exception {
        when(criteriaService.getListOfEmployeeUsingGroupByHaving(75)).thenReturn(mockResponse);
        mockMvc.perform(get("/v2/criteria/groupByHaving/75")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0][0]").value(75))
                .andExpect(jsonPath("$[0][1]").value("Engineering"));
    }

}
