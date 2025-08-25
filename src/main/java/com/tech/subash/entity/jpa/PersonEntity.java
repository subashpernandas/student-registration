package com.tech.subash.entity.jpa;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="person_tbl")
@NamedQuery(name = "getAllPerson", query = "select e from PersonEntity e")
@NamedQuery(name = "getPersonById", query = "select e from PersonEntity e where e.id=:id")
@NamedQuery(name = "getPersonByIdAndName", query = "select e from PersonEntity e where e.id=:id and e.name=:name")
@NamedNativeQuery(name ="nativeGetPersonByName",query = "select * from person_tbl where person_name=:name", resultClass = PersonEntity.class)

@NamedStoredProcedureQuery(name = "Person.countByName", procedureName = "personDetailsFindById",
        resultClasses = PersonEntity.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class)
        }
)

@NamedStoredProcedureQuery(name = "Person.countReturn", procedureName = "fetch_count_using_name",
        resultClasses = PersonEntity.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "total", type = int.class)
        }
)
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "person_name")
    private String name;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<CarEntity> cars;
}
