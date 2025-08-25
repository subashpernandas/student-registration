package com.tech.subash.controller.criteria;

import com.tech.subash.entity.EmployeeEntity;
import com.tech.subash.service.CriteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2/criteria")
@RequiredArgsConstructor
public class CriteriaController {

    private final CriteriaService criteriaService;

    @GetMapping("/select")
    public List<EmployeeEntity> getListOfEmployee(){
       return criteriaService.getListOfEmployee();
    }

    @GetMapping("/multiselect")
    public List<Object[]> getListOfEmployeeUsingMultiSelect(){
        return criteriaService.getListOfEmployeeUsingMultiSelect();
    }

    @GetMapping("/predicate/{startId}/{endId}")
    public List<EmployeeEntity> getListOfEmployeeUsingPredicate(@PathVariable("startId") long startId,
                                                                @PathVariable("endId") long endId) {

        return criteriaService.getListOfEmployeeUsingPredicate(startId,endId);
    }

    @GetMapping("/doublePredicate/{startId}/{endId}/{dept}")
    public List<EmployeeEntity> getListOfEmployeeUsingDoublePredicate(@PathVariable("startId") long startId,
                                                                @PathVariable("endId") long endId,
                                                                      @PathVariable("dept") String dept) {
        return criteriaService.getListOfEmployeeUsingDoublePredicate(startId,endId,dept);
    }

    @GetMapping("/mathFunction/{dept}")
    public Integer getListOfEmployeeUsingDoublePredicate(@PathVariable("dept") String dept) {
        return criteriaService.getListOfEmployeeUsingDoublePredicate(dept);
    }

    @GetMapping("/groupBy")
    public List<Object[]> getListOfEmployeeUsingGroupBy() {
        return criteriaService.getListOfEmployeeUsingGroupByHaving();
    }

    @GetMapping("/orderBy")
    public List<Object[]> getListOfEmployeeUsingGroupByAndOrderBy() {
        return criteriaService.getListOfEmployeeUsingGroupByAndOrderBy();
    }

    @GetMapping("/groupByHaving/{salary}")
    public List<Object[]> getListOfEmployeeUsingGroupByHaving(@PathVariable("salary") int salaryFromReq) {
        return criteriaService.getListOfEmployeeUsingGroupByHaving(salaryFromReq);
    }


    @GetMapping("/get")
    public String getAsync() {
        CriteriaService criteriaService = criteriaService(); // For Prototype bean set into Singleton Bean
       return String.valueOf(criteriaService.hashCode());
    }

    @Lookup
    public CriteriaService criteriaService(){
        return  null;
    }
}
