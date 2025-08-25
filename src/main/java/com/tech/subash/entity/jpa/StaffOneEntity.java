package com.tech.subash.entity.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff")
@Getter
@Setter
//@ToString(exclude = "subjects")
public class StaffOneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String staffName;

    private int noOfExpeience;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubjectsOneEntity> subjects;
}
