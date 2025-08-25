package com.tech.subash.repository;

import com.tech.subash.entity.jpa.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    @Procedure(name ="Person.countReturn")
    Integer getCountUsingName(@Param("name") String name);

    @Procedure(name ="Person.countByName")
    List<PersonEntity> findByNameViaSp(@Param("name") String name);
}
