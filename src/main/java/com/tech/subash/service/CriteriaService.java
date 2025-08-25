package com.tech.subash.service;

import com.tech.subash.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Scope("prototype")
public class CriteriaService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EmployeeEntity> getListOfEmployee() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> query = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Object[]> getListOfEmployeeUsingMultiSelect() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        Path<String> namePath = root.get("employeeName");
        Path<String> deptPath = root.get("dept");
        query.multiselect(namePath, deptPath);
        return entityManager.createQuery(query).getResultList();
    }

    public List<EmployeeEntity> getListOfEmployeeUsingPredicate(long startId, long endId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> query = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        Predicate id = criteriaBuilder.between(root.get("id"), startId, endId);
        query.select(root).where(id);
        return entityManager.createQuery(query).getResultList();
    }

    public List<EmployeeEntity> getListOfEmployeeUsingDoublePredicate(long startId, long endId, String dept) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> query = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        Predicate idPredicate = criteriaBuilder.between(root.get("id"), startId, endId);
        Predicate deptPredicate = criteriaBuilder.equal(root.get("dept"), dept);
        Predicate combinedPredicate = criteriaBuilder.and(idPredicate, deptPredicate);
        query.select(root).where(combinedPredicate);
        return entityManager.createQuery(query).getResultList();
    }

    public Integer getListOfEmployeeUsingDoublePredicate(String dept) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        Predicate deptPredicate = criteriaBuilder.equal(root.get("dept"), dept);
        Expression<Integer> salary = criteriaBuilder.sum(root.get("salary"));
        query.select(salary).where(deptPredicate);
        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Object[]> getListOfEmployeeUsingGroupByHaving() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        Expression<String> deptExpression = root.get("dept");
        Expression<Integer> salary = criteriaBuilder.sum(root.get("salary"));
        query.multiselect(salary, deptExpression);
        query.groupBy(deptExpression);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Object[]> getListOfEmployeeUsingGroupByAndOrderBy() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        Expression<String> deptExpression = root.get("dept");
        Expression<Integer> salary = criteriaBuilder.sum(root.get("salary"));
        Order deptOrder = criteriaBuilder.asc(root.get("dept"));
        query.multiselect(salary, deptExpression);
        query.groupBy(deptExpression).orderBy(deptOrder);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Object[]> getListOfEmployeeUsingGroupByHaving(int salaryFromReq) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        Expression<String> deptExpression = root.get("dept");
        Expression<Integer> salaryExpression = criteriaBuilder.sum(root.get("salary"));
        query.multiselect(salaryExpression, deptExpression);
        query.groupBy(deptExpression);
        Predicate havingCondition = criteriaBuilder.greaterThanOrEqualTo(salaryExpression, salaryFromReq);
        query.having(havingCondition).orderBy(criteriaBuilder.asc(root.get("dept")));
        return entityManager.createQuery(query).getResultList();
    }

}
