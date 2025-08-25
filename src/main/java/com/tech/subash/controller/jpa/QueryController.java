package com.tech.subash.controller.jpa;

import com.tech.subash.entity.jpa.PersonEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/createNativeQuery/{name}")  // Native Query Using table_name and column_name
    public PersonEntity nativeQuery(@PathVariable("name") String name) {
        return (PersonEntity) entityManager.createNativeQuery("select * from person_tbl where person_name=:name", PersonEntity.class)
                .setParameter("name", name).getSingleResult();
    }

    @GetMapping("/createQuery/{name}")  //  Using FieldName and EntityName
    public PersonEntity createQuery(@PathVariable("name") String name) {
        return (PersonEntity) entityManager.createQuery("select e from PersonEntity e where e.name=:name", PersonEntity.class)
                .setParameter("name", name).getSingleResult();
    }

    @GetMapping("/getAll")
    public List<PersonEntity> getNamedQuery() {
        return entityManager.createNamedQuery("getAllPerson", PersonEntity.class).getResultList();
    }

    @GetMapping("/getAll/{id}")
    public PersonEntity getNamedQueryUsingFindBy(@PathVariable("id") int id) {
        return entityManager.createNamedQuery("getPersonById", PersonEntity.class).setParameter("id", id).getSingleResult();
    }

    @GetMapping("/getAllByIdAndName/{id}/{name}")
    public PersonEntity namedQueryUsingFindByIdAndName(@PathVariable("id") int id, @PathVariable("name") String name) {
        return entityManager.createNamedQuery("getPersonByIdAndName", PersonEntity.class)
                .setParameter("id", id).setParameter("name", name).getSingleResult();
    }

    @GetMapping("/getAllByName/{name}")  // Named Native Query
    public PersonEntity namedQueryUsingFindByName(@PathVariable("name") String name) {
        return entityManager.createNamedQuery("nativeGetPersonByName", PersonEntity.class).setParameter("name", name).getSingleResult();
    }
}
