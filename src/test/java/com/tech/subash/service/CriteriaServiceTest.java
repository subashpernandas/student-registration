package com.tech.subash.service;

import com.tech.subash.enums.EmployeeTypeEnum;
import com.tech.subash.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CriteriaServiceTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private CriteriaQuery<Object[]> criteriaQuery;

    @Mock
    private Root<EmployeeEntity> root;

    @Mock
    private TypedQuery<Object[]> typedQuery;

    @InjectMocks
    private CriteriaService criteriaService;

    private static List<EmployeeEntity> listOfEmployees =new ArrayList<>();
    private static List<Object[]> mockResponse = new ArrayList<>();
    /*private final List<Object[]> mockResponse = Arrays.asList(
            new Object[]{"Alice", "HR"},
            new Object[]{"Bob", "IT"}
    );*/

    @BeforeEach
    void setUp() {
        mockResponse = Arrays.asList(
                new Object[]{"Alice", "HR"},
                new Object[]{"Bob", "IT"}
        );
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(1L);
        employee.setEmployeeName("John Doe");
        employee.setEmployeeId("EMP123");
        employee.setDept("Engineering");
        employee.setEmployeeType(EmployeeTypeEnum.PERMANENT);
        employee.setSalary(75);

        EmployeeEntity employee2 = new EmployeeEntity();
        employee2.setId(3L);
        employee2.setEmployeeName("Jane Smith");
        employee2.setEmployeeId("EM234");
        employee2.setDept("Banking");
        employee2.setEmployeeType(EmployeeTypeEnum.TEMPORARY);
        employee2.setSalary(25);
        listOfEmployees.add(employee);
        listOfEmployees.add(employee2);
    }

    @Test
    void testGetListOfEmployeeUsingMultiSelect() {
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Object[].class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(EmployeeEntity.class)).thenReturn(root);
        when(criteriaQuery.multiselect(root.get("employeeName"), root.get("dept"))).thenReturn(criteriaQuery);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockResponse);

        List<Object[]> result = criteriaService.getListOfEmployeeUsingMultiSelect();

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0)[0]);
        assertEquals("HR", result.get(0)[1]);
        assertEquals("Bob", result.get(1)[0]);
        assertEquals("IT", result.get(1)[1]);

        verify(entityManager).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(Object[].class);
        verify(criteriaQuery).from(EmployeeEntity.class);
        verify(criteriaQuery).multiselect(root.get("employeeName"), root.get("dept"));
        verify(entityManager).createQuery(criteriaQuery);
        verify(typedQuery).getResultList();
    }

}
