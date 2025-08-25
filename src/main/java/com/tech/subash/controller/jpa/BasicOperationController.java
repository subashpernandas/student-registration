package com.tech.subash.controller.jpa;

import com.tech.subash.entity.FamilyEntity;
import com.tech.subash.entity.jpa.*;
import com.tech.subash.entity.jpa.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jpa")
@Transactional
public class BasicOperationController {


    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/get")
    public void getMap() {
        CollegeEntity collegeEntity = new CollegeEntity();
        collegeEntity.setCollegeName("KLN CE");
        collegeEntity.setTotalNoOfStudent(2000);

        CollegeEntity collegeEntity1 = new CollegeEntity();
        collegeEntity1.setCollegeName("KLN IT");
        collegeEntity1.setTotalNoOfStudent(2000);

        StudentEntity student = new StudentEntity();
        student.setName("subash.ps");
        student.setDept("It");

        StudentEntity student2 = new StudentEntity();
        student2.setName("ajith.ps");
        student2.setDept("It");

        StudentEntity student3 = new StudentEntity();
        student3.setName("surya.ps");
        student3.setDept("It");

        student.setCollege(List.of(collegeEntity, collegeEntity1));
        student2.setCollege(List.of(collegeEntity));
        student3.setCollege(List.of(collegeEntity1));

        collegeEntity.setStudent(List.of(student, student2));
        collegeEntity1.setStudent(List.of(student3));
        entityManager.persist(collegeEntity);
        entityManager.persist(collegeEntity1);
    }

    @GetMapping("/get1")
    public void getFamily() {
        FamilyEntity collegeEntity = new FamilyEntity();
        collegeEntity.setFamilyName("KLN CE");
        collegeEntity.setNoMembers(2000);
        collegeEntity.setFamilyMemberNames(List.of("subash", "mathan"));
        entityManager.persist(collegeEntity);
    }

    @GetMapping("/get2")
    public void managedReferenceBwOneToManyVsManyToOne() {
        PersonEntity person = new PersonEntity();
        person.setName("subash");

        CarEntity car = new CarEntity();
        car.setName("toyoto");
        car.setPerson(person);

        CarEntity car1 = new CarEntity();
        car1.setName("benz");
        car1.setPerson(person);
        person.setCars(List.of(car, car1));
        entityManager.persist(person);
    }

    @GetMapping("/fetch/{id}")
    public PersonEntity managedReferenceBwOneToManyVsManyToOne(@PathVariable("id") long id) {
        return entityManager.find(PersonEntity.class, id);

    }
}
