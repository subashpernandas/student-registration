package com.tech.subash.controller.jpa;

import com.tech.subash.entity.jpa.PersonEntity;
import com.tech.subash.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoredProcedureController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/storedProcedure")
    public List<PersonEntity> createTypedQuery() {
        return (List<PersonEntity>) entityManager.createStoredProcedureQuery("fetch_person_details", PersonEntity.class).getResultList();
    }

    @GetMapping("/inParam/{name}")
    public List<PersonEntity> createTypedQuery(@PathVariable("name") String name) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("personDetailsFindById", PersonEntity.class);
        query.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @GetMapping("/outParam")
    public int getCount() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("fecthcount", PersonEntity.class);
        query.registerStoredProcedureParameter("total", Integer.class, ParameterMode.OUT);
        query.execute();
        Integer count = (Integer) query.getOutputParameterValue("total");
        return count;
    }

    @GetMapping("/inOutParam/{name}")
    public int getInOut(@PathVariable("name") String name) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("fetch_count_using_name");
        query.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("total", Integer.class, ParameterMode.OUT);
        query.setParameter("name", name);
        query.execute();
        Integer count = (Integer) query.getOutputParameterValue("total");
        return count;
    }

    @GetMapping("/storedIn/{name}")
    public List<PersonEntity> getCallNamedStored(@PathVariable("name") String name) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("Person.countByName");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @GetMapping("/namedStored/{name}")
    public int namedStoredInAndOut(@PathVariable("name") String name) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("Person.countReturn");
        query.setParameter("name", name);
        query.execute();
        int outputParameterValue = (int) query.getOutputParameterValue("total");
        return outputParameterValue;
    }

    @GetMapping("/procedure/{name}")
    public int storeProcedureCallUsingProecure(@PathVariable("name") String name) {
        return personRepository.getCountUsingName(name);
    }

    @GetMapping("/procedure-call/{name}")
    public List<PersonEntity> procedureCall(@PathVariable("name") String name) {
        return (List<PersonEntity>) personRepository.findByNameViaSp(name);
    }
}
