package com.tech.subash.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff_details")
@Data
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String staffName;

    private int noOfExpeience;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @BatchSize(size = 2)  // Child (total No of Records / 2) = > I have 3 /2 => 1.5 == 2
    // @JsonIgnore //Along with LAZY
    //@JsonIgnore
    private List<SubjectsEntity> subjects;
}
